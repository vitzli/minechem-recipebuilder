# -*- coding: UTF-8 -*-

# chemical formula parser
# v2
import re

ATOM_REGEX = r"(A[cglmrstu]|B[aehikr]?|C[adeflmnorsu]?|D[bsy]|"\
                "E[rsu]|F[emr]?|G[ade]|H[efgos]?|I[nr]?|Kr?|L[airu]|"\
                "M[dgnot]|N[abdeiop]?|Os?|P[abdmortu]?|R[abefghnu]|"\
                "S[bcegimnr]?|T[abcehilm]|U(u[hopqst])?|V|W|Xe|Yb?|Z[nr])"

ATOMN_REGEX = ATOM_REGEX + "(\d*)"

LDEL_REGEX= r'\('
RDEL_REGEX= r'\)(\d*)'

class FormulaParser:
    def __init__(self,formula=""):
        self.re_atom = re.compile(ATOMN_REGEX)
        self.re_ldel = re.compile(LDEL_REGEX)
        self.re_rdel = re.compile(RDEL_REGEX)
        if formula!="":
            self.__call__(formula)

    def __call__(self,formula):
        self.reset(formula)
        if self.parse_formula():
            return self.elemdict
        else:
            return {}

    def __getitem__(self,key):
        return self.elemdict[key]

    def __iter__(self):
        return self

    def __next__(self):
        if self.iterpos>=len(self.sorting_order):
            raise StopIteration
        elem = self.sorting_order[self.iterpos]
        amt = self.elemdict[elem]
        self.iterpos += 1
        return (elem, amt)

    def reset(self,formula=""):
        self.formula = re.sub("-|=","",formula)
        self.tail = self.formula
        self.elemstack = [{}]
        self.elemdict = {}
        self.sorting_order = []
        self.pos = 0
        self.iterpos = 0

    def parse_formula(self):
        if self.formula=="":
            return False
        while len(self.tail)>0:
            self.get_mode()
        if len(self.elemstack)!=1:
            raise SyntaxError("Un-matched left parenthesis")
            return False
        self.elemdict = self.elemstack[0]
        return True

    def get_mode(self):
        atom = self.re_atom.search(self.tail)
        ldel = self.re_ldel.search(self.tail)
        rdel = self.re_rdel.search(self.tail)
        # left delimiter "("
        if ldel is not None and ldel.start() == 0:
            # push stack
            self.push()
            return
        # element
        if atom is not None and atom.start() == 0:
            # parse element
            self.parse_element(atom)
            return

        # right delimiter
        if rdel is not None and rdel.start() == 0:
            # pop stack
            self.pop(rdel)
            return 
        raise SyntaxError("Wrong element before element {name} at position {pos}".format(name=atom.group(),pos=self.pos))

    def parse_element(self,atom):
        elem_name = atom.group(1)
        elem_amt = 1 if atom.group(3) is "" else int(atom.group(3))
        self.increase_last(elem_name, elem_amt)
        self.tail = self.tail[len(atom.group()):]
        if elem_name not in self.sorting_order:
            self.sorting_order.append(elem_name)
        self.pos += 1
        return (elem_name,elem_amt)

    def increase_last(self,name,amount):
        if self.elemstack[-1].get(name) is None:
            self.elemstack[-1][name] = amount
        else:
            self.elemstack[-1][name] += amount

    def push(self):
        self.elemstack.append({})
        self.tail = self.tail[1:]
        #self.pos += 1

    def pop(self,rdel):
        elem_amt = 1 if rdel.group(1) is "" else int(rdel.group(1))
        if len(self.elemstack)==1:
            formleft = self.formula[0:self.pos]
            formright = self.formula[self.pos:]
            raise SyntaxError("Un-matched right parethesis in {formleft} > {formright}".\
                format(formleft=formleft,formright=formright))
        lastdict = self.elemstack.pop()
        for key, value in lastdict.items():
            self.increase_last(key,value * elem_amt)
        self.tail = self.tail[len(rdel.group()):]
        return elem_amt
        #self.pos -= 1

if __name__ == '__main__':
    src = "CH3-CH2-H=CN-COOH"
    print('src =',src)
    FP = FormulaParser(src)
    for e, a in FP:
        print(e,a)
    #print('elemstck =',FP.elemstack)
    #print('elemdict =',FP.elemdict)
    #print('sortordr =',FP.sorting_order)
    #print('    tail =',FP.tail)
    #print('     H @ =',FP['H'])
    #print()
