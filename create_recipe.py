# -*- coding: UTF-8 -*-

# row format:
# oreDictElement/itemName [synthesisEnergy] [molecule_with_quantity] [molecule_with_quantity] ... [formula | molecule_with_quantity]
# 
# eg:
# rottenFlesh 500 methane 3 water NH4OH
# will give:
# new Molecule(methane,3), new Molecule(water,1), new Element(N,1), new Element(H,5), new Element(O,1)
# - with synthesis energy of 500J
# 
# or:
# rottenFlesh methane 3 NH4OH
# will give:
# new Molecule(methane,3), new Element(N,1), new Element(H,5), new Element(O,1)
# - with synthesis energy of 50J, default is 50J
#
# or just:
# rottenFlesh (NH4OH)2(CH4)2
#
# new Element(N,2), new Element(H,18), new Element(O,2), new Element(C,2)
# molecule is one of the elements of set MOLSET
# 0th pos - item or ore name
# 1st pos - if number - it's synthesis energy or one of composing elements
# 2nd pos - number of 1st element uses or 2nd element.
#
# !! no number of uses for formula !!


import chemparse
import argparse
import mcmols

# hardcoded inside addUnusedSynthesisRecipes in ljdp.minechem.common.recipe.MinechemRecipes.java
ENERGY_DEFAULT = 100

DECOMP_FMT = "DecomposerRecipe.add(new DecomposerRecipe({srcItem}, {elements} ));"
SYNTH_FMT = "SynthesisRecipe.add(new SynthesisRecipe({srcItem}, false, {energy}, {elements} ));"


ORE_EVENT_FMT = """        else if(event.Name.contains("{srcItem}")) {{
{recipes}
        }}
"""
ITEM_FMT = """            {decomposer}
            {synthesis}
"""

ITEMSTACK_FMT = "            ItemStack {srcItem} = new ItemStack(Item.{srcItem});"

REPR_FMT = """      /**
        item     : {name}
        energy   : {energy}MJ
        recipe   : {recipe}
        molDict  : {molDict}
        elemDict : {elemDict}
        mol_lst  : {mol_lst}
        elem_lst : {elem_lst}
        rec_str  : {recipe_str}
        **/"""

def Element(name,amount=1):
    return "new Element({name}, {amount})".format(name=name, amount=amount)

def Molecule(name,amount=1):
    return "new Molecule({name}, {amount})".format(name=name, amount=amount)

def isMolecule(item):
    return item in mcmols.EnumMolecule

class Recipe:
    def __init__(self, name="", energy=ENERGY_DEFAULT, recipe=[]):
        self.name = name
        self.energy = energy
        self.molDict = dict()
        self.elemDict = dict()
        self.recipe = recipe
        self.mol_lst = ""
        self.elem_lst = ""
        self.element_order = []
        self.processRecipe()
    
    def __repr__(self):
        return REPR_FMT.format(name=self.name, energy=self.energy, \
recipe=self.recipe, molDict=self.molDict, elemDict=self.elemDict, \
mol_lst=self.mol_lst, elem_lst=self.elem_lst, recipe_str=self.recipeString)

    def processRecipe(self):
        lastMol = ""
        for item in self.recipe:
            if isMolecule(item):
                self.molDict[item] = 1
                lastMol = item
                continue
            
            if item.isnumeric():
                self.molDict[lastMol] = int(item)
                continue
            
            # probably it's a formula
            try:
                FP = chemparse.FormulaParser(item)
                new_elems = list(filter(self.isNotPresent,FP.sorting_order))
                self.element_order.extend(new_elems)
                for k, v in FP:
                    #print("k=",k,"v=",v)
                    if self.elemDict.get(k) is not None:
                        self.elemDict[k] = self.elemDict[k] + v
                    else:
                        self.elemDict[k] = v
            except:
                print("exception at item=",item)
        
            lastMol = ""
        
        self.mol_lst = self.writeMolecules()
        self.elem_lst = self.writeElements()

    def isNotPresent(self, new_element):
        return new_element not in self.element_order

    def getMoleculeOrder(self):
        return filter(isMolecule,self.recipe)

    def getElementOrder(self):
        return self.element_order
            
    def writeMolecules(self):
        out = list()
        for item in self.getMoleculeOrder():
            out.append(Molecule(item,self.molDict[item]))
        return out
        
    def writeElements(self):
        out = list()
        for item in self.element_order:
            out.append(Element(item,self.elemDict[item]))
        return out

    @property
    def recipeString(self):
        out = list()
        out.extend(self.mol_lst)
        out.extend(self.elem_lst)
        return ", ".join(out)

def getFQRecipeString(recipeObj, mode):
        if mode=="i":
            return ITEM_FMT.format(decomposer=getDecompRecipe(recipeObj.name, recipeObj.recipeString), synthesis=getSynthesisString(recipeObj, mode))
        else:
            long_recipe = ITEM_FMT.format(decomposer=getDecompRecipe("event.Ore", recipeObj.recipeString), synthesis=getSynthesisString(recipeObj, mode))
            return ORE_EVENT_FMT.format(srcItem=recipeObj.name, recipes=long_recipe)

def getSynthesisString(recipeObj, mode):
        if recipeObj.energy != ENERGY_DEFAULT:
            if mode=="i":
                synthesis = getSynthesisRecipe(itemName=recipeObj.name, recipe_str=recipeObj.recipeString, energy = recipeObj.energy)
            else:
                synthesis = getSynthesisRecipe(itemName="event.Ore", recipe_str=recipeObj.recipeString, energy = recipeObj.energy)
        else:
            synthesis = "// no special synthesis rule"
        return synthesis
    

def getDecompRecipe(itemName, recipe_str):
    return DECOMP_FMT.format(srcItem=itemName, elements=recipe_str)

def getSynthesisRecipe(itemName, recipe_str, energy):
    return SYNTH_FMT.format(srcItem=itemName, elements=recipe_str, energy=energy)

def getItemStackString(itemName):
    return ITEMSTACK_FMT.format(srcItem=itemName)
   
if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='generate MineChem recipe from file')
    parser.add_argument('mode',metavar = 'MODE', type=str, help='[i | o] process file as item list or ore list',choices=('i','o'))
    parser.add_argument('filename',metavar = 'FILENAME', type=str, help='list with associated formulas')
    args = parser.parse_args()
    
    out_recipe = ""
    out_itemstack = ""

    for line in open(args.filename,'rt'):
        nl = line.strip()
        row = nl.split()
        if len(row)<2 or nl[0]=="#":
            continue

        recipeName = row[0]
        if row[1].isnumeric():
            newRecipe = Recipe(name=recipeName,energy=row[1], recipe=row[2:])
        else:
            newRecipe = Recipe(name=recipeName,recipe=row[1:])

        if args.mode=="i":
            out_itemstack = out_itemstack + getItemStackString(recipeName) + "\n"
        
        out_recipe = out_recipe + getFQRecipeString(newRecipe, args.mode) + "\n"
        #print(newRecipe)

    print(out_itemstack)
    print(out_recipe)