# -*- coding: UTF-8 -*-

# create_recipe.py [i|o] recipe_file.txt [--debug] > code.java
# MODE: itemstack mode 'i' or ore dictionary mode 'o'.
# using debug parameter '--debug' would produce more comments
# all resulting code will be printed to sys.stdout, so redirecting it would be nice idea

# source file row format:
# [!]compoundName [e=E] [p=P|expression] [m=M][formula]|[molecule [number]] [formula]|[molecule [number]] [formula]|[molecule [number]]
# optional exclamation mark "!" before compoundName means that 
# synthesis rule would be omitted from code
#
# option e : synthesis energy in MJ, eg: e=200 - write it without spaces, default is 100
#
# option p : decomposition probability P in parts of whole,
#            same rule - without spaces, default is 1, evaluation is available, eg: p=0.5 or p=1/3
#
# option m : multiplier, all numbers everywhere in recipe will be multiplied by M
#
# [molecule [number]] molecule name with optional amount eg: "sucrose tnt pyrite" (without quotes) which means:
#       sucrose - 1 molecule
#       tnt     - 1 molecule
#       pyrite  - 1 moleculte
#   or "sucrose 2 tnt pyrite 12":
#       sucrose - 2 molecules
#       tnt     - 1 molecule
#       pyrite  - 12 molecules
#
# [formula] is just a chemical formula. Let's use hexane:
#               you may use molecular formula C6H14
#               or structural formula CH3CH2CH2CH2CH2CH3
#               signs '-' or '=' are allowed inside formula and act as visual delimiters
#                (they have no purpose for parser and will be dropped during chemparse.parse_formula()),
#                   eg: CH3-CH2-CH2-CH2-CH2-CH3
#
#
# example:
# dustBasalt p=0.5 e=100 calcite 3 siliconDioxide 8 Mg2Fe2SiO4C4
# would result in following code:
#         else if(event.Name.contentEquals("dustBasalt")) {
#           DecomposerRecipe.add(new DecomposerRecipeChance(event.Ore, 0.50F, new Molecule(calcite, 3), new Molecule(siliconDioxide, 8), new Element(Mg, 2), new Element(Fe, 2), new Element(Si, 1), new Element(O, 4), new Element(C, 4)));
#           SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 100, new Molecule(calcite, 3), new Molecule(siliconDioxide, 8), new Element(Mg, 2), new Element(Fe, 2), new Element(Si, 1), new Element(O, 4), new Element(C, 4) ));
#         }
#
# or:
# !dustEnderPearl BeK4N5Cl6 e=1000 p=1/100 m=2
#        else if(event.Name.contentEquals("dustEnderPearl")) {
#           DecomposerRecipe.add(new DecomposerRecipeChance(event.Ore, 0.01F, new Element(Be, 2), new Element(K, 8), new Element(N, 10), new Element(Cl, 12)));
#           //no synth rule
#
#        }
# 
# note that all elements were multiplied by 2 (m=2), 
# there is synthesis energy e=1000, but because of "!" there is no synthesis rule

import io
import argparse
import urllib.parse as up # for spaces in the ore names

import mcmols
import chemparse

ENERGY_DEFAULT = 100

DECOMP_FMT = "DecomposerRecipe.add(new DecomposerRecipe({srcItem}, {elements} ));"
SYNTH_FMT = "SynthesisRecipe.add(new SynthesisRecipe({srcItem}, false, {energy}, {elements} ));"
DECOMP_PROB_FMT = "DecomposerRecipe.add(new DecomposerRecipeChance({srcItem}, {prob}, {elements}));"

COMMENT_FMT = "name={name}, energy={energy}MJ, probability={prob}, multiply all by {mult}"


ORE_EVENT_FMT = """        else if(event.Name.contentEquals("{srcItem}")) {{
{recipes}
        }}
"""
ITEM_FMT = """            {decomposer}
            {synthesis}
"""

ITEMSTACK_FMT = "            ItemStack {srcItem} = new ItemStack(Item.{srcItem});"

REPR_FMT = """            /**
                item            : {name}
                energy          : {energy}MJ
                prob            : {prob}
                recipe          : {recipe}
                molDict         : {molDict}
                elemDict        : {elemDict}
                mol_lst         : {mol_lst}
                elem_lst        : {elem_lst}
                java elem code  : {recipe_str}
            **/
"""

def Element(name,amount=1):
    return "new Element({name}, {amount})".format(name=name, amount=amount)

def Molecule(name,amount=1):
    return "new Molecule({name}, {amount})".format(name=name, amount=amount)

def isMolecule(item):
    return item in mcmols.EnumMolecule

class Recipe:
    def __init__(self, name="", energy=ENERGY_DEFAULT, prob="1.0F", recipe=[],isSynthesis=True, mode="i", multiplier=1):
        self.name = name
        self.energy = energy
        self.prob = prob
        self.molDict = dict()
        self.elemDict = dict()
        self.recipe = recipe
        self.mol_lst = ""
        self.elem_lst = ""
        self.element_order = []
        self.isSynthesis = isSynthesis
        self.mode = mode
        self.mult = int(multiplier) if int(multiplier)>1 else 1
        self.processRecipe()
    
    def __repr__(self):
        return REPR_FMT.format(name=self.name, energy=self.energy, \
                recipe=self.recipe, molDict=self.molDict, elemDict=self.elemDict, \
                mol_lst=self.mol_lst, elem_lst=self.elem_lst, recipe_str=self.recipeString, \
                prob=self.prob)

    def processRecipe(self):
        lastMol = ""
        for item in self.recipe:
            if isMolecule(item):
                self.molDict[item] = 1
                lastMol = item
                continue

            # not a single molecule            
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
                print("recipe:",self.name," - exception at item=",item, Exception)
        
            lastMol = ""

        # multiply all numbers in recipe by m which is 'm=...'
        if self.mult!=1:
            self.multiplyAll()

        self.mol_lst = self.writeMolecules()
        self.elem_lst = self.writeElements()

    def multiplyAll(self):
        for k,v in self.molDict.items():
            self.molDict[k] = v * self.mult

        for k,v in self.elemDict.items():
            self.elemDict[k] = v * self.mult

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

    @property
    def decomCode(self):
        fmt_str = ""
        srcItem = ""
        if self.prob!="1.00F":
            fmt_str = DECOMP_PROB_FMT
        else:
            fmt_str = DECOMP_FMT

        if self.mode=='i':
            srcItem = self.name
        else:
            srcItem = 'event.Ore'

        return fmt_str.format(srcItem=srcItem, prob=self.prob, elements=self.recipeString)
    
    @property
    def synthCode(self):
        fmt_str = ""
        srcItem = ""

        if self.isSynthesis:
            if self.mode=='i':
                srcItem = self.name
            else:
                srcItem = 'event.Ore'
            
            return SYNTH_FMT.format(srcItem=srcItem, energy = self.energy, elements=self.recipeString)

        return "//no synthesis rule"

    @property
    def itemstackCode(self):
        if self.mode=='i':
            return ITEMSTACK_FMT.format(srcItem=self.name)

    @property
    def mainCode(self):
        rec = ITEM_FMT.format(decomposer=self.decomCode, synthesis=self.synthCode)
        if self.mode=='i':
            return rec
        else:
            return ORE_EVENT_FMT.format(srcItem=self.name, recipes=rec)

def getEnergy(listname):
    i = 0
    while i<len(listname):
        if 'e=' in listname[i] and listname[i][0]=='e':
            ni = listname.pop(i)
            return ni.split('=')[1]
        i += 1
    return ENERGY_DEFAULT

def getProb(listname):
    i = 0
    while i<len(listname):
        if 'p=' in listname[i] and listname[i][0]=='p':
            ni = listname.pop(i)
            probValue = eval(ni.split('=')[1], {}, {})
            pV = 1.0 if 0.98<probValue<1.02 else probValue
            probValue_str = "{0:.2f}F".format(probValue)
            return probValue_str
        i += 1
    return "1.00F"

def getMult(listname):
    i = 0
    while i<len(listname):
        if 'm=' in listname[i] and listname[i][0]=='m':
            ni = listname.pop(i)
            multValue = int(ni.split('=')[1])
            return multValue
        i += 1
    return 1

def processRecipe(recipeObject,mode,debug=False, header=""):
    mainrecipe = io.StringIO()
    itemstack = io.StringIO()

    print(file=mainrecipe)
    print('        //','--- start of auto-generated code, {header} ---\n'.format(header=header),file=mainrecipe)

    for line in recipeObject:

        nl = line.strip()

        row = nl.split('#', 1)[0]
        row = row.split()

        if len(row)<2 or nl[0]=="#":
            continue

        recipeName = up.unquote(row[0])
        if recipeName[0]=="!":
            recipeName = recipeName[1:]
            row[0] = recipeName
            isSynth = False
        else:
            isSynth = True

        e = getEnergy(row)
        p = getProb(row)
        m = getMult(row)

        newRecipe = Recipe(name = recipeName,\
                           energy=e,\
                           prob=p,\
                           isSynthesis=isSynth,\
                           recipe=row[1:],\
                           mode=mode,\
                           multiplier=m)

        if debug:
            print('        //','--'*30,file=mainrecipe)
            print('        //',COMMENT_FMT.format(name=newRecipe.name, \
                                        energy=newRecipe.energy,\
                                        prob=newRecipe.prob, mult=newRecipe.mult), file=mainrecipe)
            print('        // recipe dictionary is',newRecipe.recipe, file=mainrecipe)
            print(newRecipe,file=mainrecipe)
        else:
            print('        //',COMMENT_FMT.format(name=newRecipe.name, \
                                        energy=newRecipe.energy,\
                                        prob=newRecipe.prob, mult=newRecipe.mult), file=mainrecipe)
            print('        // recipe dictionary is',newRecipe.recipe, file=mainrecipe)

        if newRecipe.itemstackCode is not None:
            print(newRecipe.itemstackCode,file=itemstack)

        print(newRecipe.mainCode,file=mainrecipe)
        if debug:
            print('        //','--'*30,file=mainrecipe)
            print(file=mainrecipe)
    
    print('        //','--- end of auto-generated code ---',file=mainrecipe)

    return (itemstack.getvalue(), mainrecipe.getvalue())
   
if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='generate MineChem recipe from file')
    parser.add_argument('mode',metavar = 'MODE', type=str, help='[i | o] process file as item list or ore list',choices=('i','o'))
    parser.add_argument('filename',metavar = 'FILENAME', type=str, help='list with associated formulas')
    parser.add_argument('--debug',action='store_true',help='debug mode',default=False)

    args = parser.parse_args()
    
    fileObject = open(args.filename,'rt')

    i, m = processRecipe(fileObject,args.mode)

    print(i)
    print(m)
