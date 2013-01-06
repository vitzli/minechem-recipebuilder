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

def sorting_order(formula):
    allElemList = [x[0] for x in re.findall(ATOM_REGEX,formula)]
    out = []
    for item in allElemList:
        if item not in out:
            out.append(item)
    return out

def atoms(formula='', debug=False, stack=[], delim=0, \
          atom=ATOMN_REGEX, ldel=LDEL_REGEX, rdel=RDEL_REGEX):

    if formula == "":
        return []

    stack = stack or []

    re_atom = re.search(atom,formula)
    re_ldel = re.search(ldel,formula)
    re_rdel = re.search(rdel,formula)

    swA = True if re.search("[A-Z]",formula[0]) is not None else False
    swL = True if re.search(ldel,formula[0]) is not None else False
    swR = True if re.search(rdel,formula[0]) else False

    if swA:

        tail = formula[len(re_atom.group()):]
        #print("re_atom.group length = ",len(re_atom.group()))
        head = re_atom.group(1)
        num  = int(re_atom.group(3)) if re_atom.group(3) is not "" else 1
        
        if debug:
            print("head=",head, "num=",num, "tail=",tail)

        if len(stack)>0:
            if stack[-1].get(head):              # verbose testing of Hash key
                stack[-1][head] = stack[-1][head] + num                           # increment occurence
            else:
                stack[-1][head] = num
        else:
            stack.append({head:num})

        if debug:
            print("stack=",stack)

    # Left-delimiter "("
    elif swL:
        tail   = formula[formula.find("(")+1:]
        delim += 1

        stack.append({})

        if debug:
            print('left-delimiter tail=', tail)

    # Right-delimiter ")"
    elif swR:
        s = re.search(rdel,formula).group()
        tail   = formula[formula.find(s)+len(s):]
        num    = int(re_rdel.group(1)) if re_rdel.group(1)!="" else 1
        delim -= 1

        if debug:
            print('right-delimiter, multiply by =', num, "tail=",tail, "delim=", delim)

        if delim < 0:
            raise SyntaxError("un-matched right parenthesis in '%s'"%(formula,))

        for k, v in stack.pop().items():
            if debug:
                print("last stack dict, k=",k,"v=",v)
            if len(stack)>0:
                if stack[-1].get(k):
                    stack[-1][k] = stack[-1][k] + v * num
                else:
                    stack[-1][k] = v * num
            else:
                stack.append({k:v * num})

    else:
        raise SyntaxError("'%s' does not match any regex"%(formula,))

    if len(tail) > 0:
        if debug:
            print('recursion, tail=',tail,'stack=',stack,'delim=',delim)
        stack = atoms(tail, debug, stack, delim)
        return stack

    else:
        if delim > 0:
            raise SyntaxError("un-matched left parenthesis in '%s'"%(formula,))
        if debug:
            print("stack[-1]=",stack[-1])
        return stack

def parse_formula(chem_formula):
    elemlist = atoms(chem_formula,debug=False)[0]
    return elemlist

if __name__ == '__main__':
    src = "HO2CCH(NH2)(CH2)4NH2"
    print("\nsrc=",src,"\nresult=",atoms(formula=src,debug=True))
