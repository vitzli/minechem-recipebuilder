# -*- coding: UTF-8 -*-

# get synthesis energy function from OreDictionary category

import math


def getRarityFunction(Emax,Emin, mult=1):
    # A * exp(-r)=Emax, A * exp(-100 * r)=Emin
    # r: 1..100 - item rarity
    r = math.log(Emax/Emin) / 99
    A = Emax/math.exp(-r)
    out = lambda rarity: int(mult * round( A * math.exp( -rarity * r),-1))
    return out

def createRarityFunctions(dct):
    out = dict()
    for key, value in dct.items():
        out[key] = getRarityFunction(*value)
    return out

RESOURCES = createRarityFunctions({
"block":        ( 800, 300, 9*0.85),
"dustSmall":    ( 400, 150, 0.25),
"dust":         ( 400, 150, 1), 
"gem":          (1000, 500, 1),
"ingot":        ( 800, 300, 1),
"item":         ( 600, 400, 1),
"molecule":     ( 600, 400, 1),
"nugget":       ( 800, 300, 0.25),
"oreNether":    ( 100,  50, 1),
"ore":          ( 100,  50, 1),
"reduced":      ( 50,  30, 1),
"cleanGravel":  ( 50,  30, 1),
"crystalline":  ( 50,  30, 1),
"dirtyGravel":  ( 50,  30, 1),
"drop":         ( 100,  50, 1),
"other":        ( 100,  50, 1),
})

if __name__=="__main__":
    print(RESOURCES['ingot'](40))