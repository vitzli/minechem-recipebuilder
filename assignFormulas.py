# -*- coding: UTF-8 -*-

#
# assignFormulas.py --mm=MMFILE recipefile.orig > recipefile.new
# where:
#   MMFILE is freeplane mindmap, containing element's formulas and rarity values,
#       see 'examples/metallurgy/Metallurgy 2.mm'
#   recipefile.orig - file containing compound names from oreDictionary
#   recipefile.new - target file
#

import io
import argparse
import urllib.parse as UP

import split_log as SL
import energyFunction as EF
import mmFile


ENERGY_FMT = "e={energy}"
PROB_FMT = "p={prob}"
MULT_FMT = "m={mult}"

def getMultiplier(category):
    if category == 'block':
        return 9
    else:
        return 1
    

def processRecipes(textIO, resourceFile):
    RecipeMap = mmFile.RecipeMap(resourceFile)
    out = io.StringIO()
    for line in textIO:
        energy_txt = ""
        prob_txt = ""
        mult_txt = ""
        formula = ""
        line_out = line.strip("\n")
        l = UP.unquote(line_out)
        txt = l.split('#',1)[0]
        category = SL.getCategory(txt)
        if category!="other":
            substanceName = txt[len(category):]
        else:
            substanceName = txt
        f = EF.RESOURCES[category]
        substanceDict = RecipeMap[substanceName]
        if substanceDict is not None:
            rarity = substanceDict['rarity'] if substanceDict.get('rarity') is not None else 70
            energy_txt = ENERGY_FMT.format(energy=f(rarity))
            mult = getMultiplier(category)
            mult_txt = "" if mult==1 else MULT_FMT.format(mult=mult)
            if category=='ore':
                prob = substanceDict['prob'] if substanceDict.get('prob') is not None else 1
                prob_txt = "" if prob==1 else PROB_FMT.format(prob=prob)
            formula = substanceDict['formula'] if substanceDict.get('formula') is not None else "water"
        print(line_out," ".join([energy_txt, prob_txt, mult_txt, formula]), file=out)
    return out

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Assign recipebuilder parameters to compounds using .mm file')
    parser.add_argument('filename',metavar = 'FILENAME', type=str, help='file with compound names')
    parser.add_argument('--mm',metavar='FREEPLANE FILE',type=str,help='Freeplane file (lookup table)')
    args = parser.parse_args()

    fileObj = open(args.filename,'rt')
    t = processRecipes(fileObj, args.mm)
    print(t.getvalue())
    fileObj.close()