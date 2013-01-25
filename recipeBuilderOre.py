# -*- coding: UTF-8 -*-

# use:
#   recipeBuilderOre.py MODNAME
# This tool generates java source file for mod, resulting code must 
# be checked and corrected (first 'else's inside each method have no preceding 'if's).
# 
# each recipe file (MODNAME.CATEGORY.recipe) should contain corresponding recipes for each compound.
# there is no need to create them manually, you may use 
# split_log.py to split long 'log' file to several recipe files.
# 
# if MODNAME.CATEGORY.recipe is not present or it doesn't contain formulas - there would be no corresponding java code.
#

import io
import sys
import glob
from string import Template

import create_recipe as CR
import split_log as SL


MODNAME = 'MCRecipes{base}'

def getFilenames(baseName):
    fn = '{filename}.*.recipe'.format(filename=baseName)
    return glob.glob(fn)

def getModName(baseName):
    bn = str(baseName)
    bn = str(bn[0].upper()) + bn[1:]
    return MODNAME.format(base=bn)

# get recipes for each file:
def getFileDict(filenames):
    out = dict()
    for fn in filenames:
        fnl = fn.split('.')
        if len(fnl)==3:
            cat = SL.getCategory(fnl[1])
            out[cat] = open(fn,'rt')
    return out

# close all files
def closeAll(fileDict):
    for fd in fileDict.values():
        fd.close()

def createCodeDict(fileDict,mode):
    out_m = dict()
    out_i = dict()
    HEADER_FMT = "made from '{filename}'"

    for k, f in fileDict.items():
        
        i, m = CR.processRecipe(f,mode, header=HEADER_FMT.format(filename=f.name))
        out_i[k] = i
        out_m[k] = m
    if mode=='i':
        return (out_i, out_m)
    else:
        return ({},out_m)

def processTemplate(template_name, codedict):
    out = io.StringIO()
    for line in open(template_name,'rt'):
        nl = line.strip('\n')
        s = Template(nl).safe_substitute(codedict)
        print(s,file=out)
    return out.getvalue()
   
if __name__=="__main__":
    if len(sys.argv)>1:
        fn = sys.argv[1]

    files = getFilenames(fn)
    fdct = getFileDict(files)
    template_dict = createCodeDict(fdct,'o')
    template_dict[1]['modname'] = getModName(fn)

    javaCode = open(getModName(fn)+str('.java'),'wt')
    print(processTemplate('MCRecipes.template.java',template_dict[1]),file=javaCode)
    javaCode.close()