# -*- coding: UTF-8 -*-

# Tool to split one long log file to several recipe files, so all elements
# starting with 'block' go to filename.block.recipe, starting with 'ingot' goes to
# filename.ingot.recipe and so on.
# Elements that don't present in PROCESS tuple go to filename.other.recipe

import io
import sys
import os.path as path
import urllib.parse as up # for spaces in ore names

PROCESS = (
"block",
"dustSmall",
"dust",
"gem",
"ingot",
"item",
"molecule",
"nugget",
"oreNether",
"ore",
"reduced",
"cleanGravel",
"crystalline",
"dirtyGravel",
"drop",
)

def createDict():
    """ Create StringIO dictionary for elements separation """
    d = dict()
    for item in PROCESS:
        d[item] = io.StringIO()
    d["other"] = io.StringIO() # here goes everything else
    return d

def getCategory(s):
    """get category from element"""
    for item in PROCESS:
        if s.startswith(item):
            return item
    return "other"

def dumpToFile(filename,content):
    """put all CONTENT to FILENAME"""
    f = open(filename,'wt')
    print('#',filename,file=f)
    f.write(content.getvalue())
    f.close()

def writeFiles(base_name,dictionary):
    """put every value of DICTIONARY to file BASE_NAME.key.recipe"""
    for k, io_obj in dictionary.items():
        content = io_obj.getvalue()
        fn = "{base}.{cls}.recipe".format(base=base_name,cls=k)
        if len(content)!=0:
            dumpToFile(fn,io_obj)

def processLog(logObject):
    dct = createDict()
    for line in logObject:
        nl = line.strip('\n')
        nl = nl.strip()
        nl = up.quote(nl)
        print(nl,'->', getCategory(nl))
        print(nl,file=dct[getCategory(nl)])
    return dct

if __name__ == '__main__':
    fn = sys.argv[1]
    fn_name = path.splitext(fn)
    logFile = open(fn,"rt")
    log_dict = processLog(logFile)
    writeFiles(fn_name[0],dct)
    logFile.close()