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

def create_dict():
    """ Create StringIO dictionary for elements separation """
    d = dict()
    for item in PROCESS:
        d[item] = io.StringIO()
    d["other"] = io.StringIO() # here goes everything else
    return d

def get_category(s):
    """get category from element"""
    for item in PROCESS:
        if s.startswith(item):
            return item
    return "other"

def dumptofile(filename,content):
    """put all CONTENT to FILENAME"""
    f = open(filename,'wt')
    print('#',filename,file=f)
    f.write(content.getvalue())
    f.close()

def write_files(base_name,dictionary):
    """put every value of DICTIONARY to file BASE_NAME.key.recipe"""
    for k, io_obj in dictionary.items():
        content = io_obj.getvalue()
        fn = "{base}.{cls}.recipe".format(base=base_name,cls=k)
        if len(content)!=0:
            dumptofile(fn,io_obj)

dct = create_dict()

fn = sys.argv[1]

fn_name = path.splitext(fn)

logFile = open(fn,"rt")
for line in logFile:
    nl = line.strip('\n')
    nl = nl.strip()
    nl = up.quote(nl)
    print(nl,'->', get_category(nl))
    print(nl,file=dct[get_category(nl)])
    
write_files(fn_name[0],dct)