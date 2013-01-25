#
# use freeplane mindmap as ruleset for chemical compounds
# class RecipeMap provides access to freeplane mindmap containing compound properties,
# check example/Metallurgy 2.mm
from xml.dom.minidom import parse

FILENAME = "example/Metallurgy 2.mm"
debug = False

class RecipeMap:
    def __init__(self, filename=None):
        self.formuladict = dict()
        if filename is not None:
            self.__call__(filename)

    def __call__(self, filename):
        if filename is not None:
            self.dom = parse(filename)
            self.formuladict = dict()
            self.handleMap(self.dom)


    def handleMap(self,catalogue):
        mapNode = catalogue.documentElement
        self.handleNode(mapNode)
        if debug:
            print(self.formuladict)


    def handleNode(self,node,indent=-1):
        name = node.getAttribute("TEXT")
        isLevel = node.getAttribute("LOCALIZED_STYLE_REF")
        properties = dict()
        txt_indent = ' '*indent
        if debug:
            print(txt_indent, name)
        indent += 1
        for item in node.childNodes:
            if item.nodeName=='node':
                m = self.handleNode(item, indent)
            if item.nodeName=='attribute':
                n,v = self.handleAttr(item,indent)
                properties[n] = v
        if isLevel=="" and name!="":
            self.formuladict[name] = properties
        return properties

    def handleAttr(self,attr, indent):
        name = attr.getAttribute("NAME").lower()
        try:
            value = float(attr.getAttribute("VALUE"))
        except:
            value = attr.getAttribute("VALUE")
        if debug:
            print(' '*indent, name,'=',value)
        return (name, value)

    def __getitem__(self,key):
        return self.formuladict.get(key)
