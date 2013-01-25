package com.vitzli.addrecipes;

/**
 *              BEWARE! processBLABLA only use dictionary elements that starts with BLABLA,
 *              except processOther which uses everything else !!!
 *          
 */

import static ljdp.minechem.api.core.EnumElement.*;
import static ljdp.minechem.api.core.EnumMolecule.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import ljdp.minechem.api.core.Chemical;
import ljdp.minechem.api.core.Element;
import ljdp.minechem.api.core.EnumElement;
import ljdp.minechem.api.core.EnumMolecule;
import ljdp.minechem.api.core.Molecule;
import ljdp.minechem.api.recipe.DecomposerRecipe;
import ljdp.minechem.api.recipe.DecomposerRecipeChance;
import ljdp.minechem.api.recipe.DecomposerRecipeSelect;
import ljdp.minechem.api.recipe.SynthesisRecipe;
import ljdp.minechem.api.util.Util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;

enum dictClass { BLOCK, DUST, DUSTSMALL, GEM, INGOT, ITEM, MOLECULE,
    NUGGET, ORE, ORENETHER, REDUCED, CLEANGRAVEL, CRYSTALLINE,
    DIRTYGRAVEL, DROP , OTHER};

public class MCRecipesMetallurgy {
    private static final MCRecipesMetallurgy instance = new MCRecipesMetallurgy();
    

    public static MCRecipesMetallurgy getInstance() {
        return instance;
    }

    public void RegisterRecipes() {
        
        // --- automatically generated code ---
        // ${itemstack}
        // ${istackcode}
        // --- end of automatically generated code --- 
        
    }
    
    @ForgeSubscribe
    public void oreEvent(OreRegisterEvent event) {  
        switch(getDictClass(event.Name)) {
            case BLOCK: processBlock(event); break;
            case DUST: processDust(event); break;
            case DUSTSMALL: processDustSmall(event); break;
            case GEM: processGem(event); break;
            case INGOT: processIngot(event); break;
            case ITEM: processItem(event); break;
            case MOLECULE: processMolecule(event); break;
            case NUGGET: processNugget(event); break;
            case ORE: processOre(event); break;
            case ORENETHER: processOreNether(event); break;
            case REDUCED: processReduced(event); break;
            case CLEANGRAVEL: processCleanGravel(event); break;
            case CRYSTALLINE: processCrystalline(event); break;
            case DIRTYGRAVEL: processDirtyGravel(event); break;
            case DROP: processDrop(event); break;
            case OTHER: processOther(event); break;
        }
    }

    // --- the following recipes were auto-generated using minechem-recipebuilder ---

    private void processBlock(OreRegisterEvent event) {

        // processBlock part
        // 
        // --- start of auto-generated code, made from 'metallurgy.block.recipe' ---

        // name=blockAdamantine, energy=5967MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Cn-Co(BrO3)2', 'water', '6']
        else if(event.Name.contentEquals("blockAdamantine")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Molecule(water, 54), new Element(Cn, 9), new Element(Co, 9), new Element(Br, 18), new Element(O, 54) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5967, new Molecule(water, 54), new Element(Cn, 9), new Element(Co, 9), new Element(Br, 18), new Element(O, 54) ));

        }

        // name=blockAdluorite, energy=5508MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['ZrO2']
        else if(event.Name.contentEquals("blockAdluorite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Zr, 9), new Element(O, 18) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5508, new Element(Zr, 9), new Element(O, 18) ));

        }

        // name=blockAmordrine, energy=3060MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Pt-BN']
        else if(event.Name.contentEquals("blockAmordrine")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pt, 9), new Element(B, 9), new Element(N, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3060, new Element(Pt, 9), new Element(B, 9), new Element(N, 9) ));

        }

        // name=blockAngmallen, energy=3060MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['(FeAu)2']
        else if(event.Name.contentEquals("blockAngmallen")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 18), new Element(Au, 18) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3060, new Element(Fe, 18), new Element(Au, 18) ));

        }

        // name=blockAredrite, energy=5508MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['CCeRu']
        else if(event.Name.contentEquals("blockAredrite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(C, 9), new Element(Ce, 9), new Element(Ru, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5508, new Element(C, 9), new Element(Ce, 9), new Element(Ru, 9) ));

        }

        // name=blockAstral Silver, energy=5661MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Ag-Ni-PdTe']
        else if(event.Name.contentEquals("blockAstral Silver")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ag, 9), new Element(Ni, 9), new Element(Pd, 9), new Element(Te, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5661, new Element(Ag, 9), new Element(Ni, 9), new Element(Pd, 9), new Element(Te, 9) ));

        }

        // name=blockAtlarus, energy=5967MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['W3C']
        else if(event.Name.contentEquals("blockAtlarus")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(W, 27), new Element(C, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5967, new Element(W, 27), new Element(C, 9) ));

        }

        // name=blockBlack Steel, energy=3060MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Fe4C-MnZnThO3']
        else if(event.Name.contentEquals("blockBlack Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 36), new Element(C, 9), new Element(Mn, 9), new Element(Zn, 9), new Element(Th, 9), new Element(O, 27) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3060, new Element(Fe, 36), new Element(C, 9), new Element(Mn, 9), new Element(Zn, 9), new Element(Th, 9), new Element(O, 27) ));

        }

        // name=blockCarmot, energy=5661MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Ni-ReCl3']
        else if(event.Name.contentEquals("blockCarmot")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ni, 9), new Element(Re, 9), new Element(Cl, 27) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5661, new Element(Ni, 9), new Element(Re, 9), new Element(Cl, 27) ));

        }

        // name=blockCelenegil, energy=3060MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['PtReB2']
        else if(event.Name.contentEquals("blockCelenegil")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pt, 9), new Element(Re, 9), new Element(B, 18) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3060, new Element(Pt, 9), new Element(Re, 9), new Element(B, 18) ));

        }

        // name=blockCeruclase, energy=5278MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Os3(CO)12']
        else if(event.Name.contentEquals("blockCeruclase")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Os, 27), new Element(C, 108), new Element(O, 108) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5278, new Element(Os, 27), new Element(C, 108), new Element(O, 108) ));

        }

        // name=blockDamascus Steel, energy=3060MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Cu3Fe2Sn']
        else if(event.Name.contentEquals("blockDamascus Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Cu, 27), new Element(Fe, 18), new Element(Sn, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3060, new Element(Cu, 27), new Element(Fe, 18), new Element(Sn, 9) ));

        }

        // name=blockDeep Iron, energy=5049MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['MnFeZnCO3']
        else if(event.Name.contentEquals("blockDeep Iron")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Mn, 9), new Element(Fe, 9), new Element(Zn, 9), new Element(C, 9), new Element(O, 27) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5049, new Element(Mn, 9), new Element(Fe, 9), new Element(Zn, 9), new Element(C, 9), new Element(O, 27) ));

        }

        // name=blockDesichalkos, energy=3060MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Pd3TiUO2(NO3)2']
        else if(event.Name.contentEquals("blockDesichalkos")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 27), new Element(Ti, 9), new Element(U, 9), new Element(O, 72), new Element(N, 18) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3060, new Element(Pd, 27), new Element(Ti, 9), new Element(U, 9), new Element(O, 72), new Element(N, 18) ));

        }

        // name=blockEximite, energy=4896MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Pd3Ti']
        else if(event.Name.contentEquals("blockEximite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 27), new Element(Ti, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 4896, new Element(Pd, 27), new Element(Ti, 9) ));

        }

        // name=blockHaderoth, energy=3060MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Pd-NbC=RuTe2']
        else if(event.Name.contentEquals("blockHaderoth")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 9), new Element(Nb, 9), new Element(C, 9), new Element(Ru, 9), new Element(Te, 18) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3060, new Element(Pd, 9), new Element(Nb, 9), new Element(C, 9), new Element(Ru, 9), new Element(Te, 18) ));

        }

        // name=blockHepatizon, energy=3060MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Au2Cu3Sn']
        else if(event.Name.contentEquals("blockHepatizon")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Au, 18), new Element(Cu, 27), new Element(Sn, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3060, new Element(Au, 18), new Element(Cu, 27), new Element(Sn, 9) ));

        }

        // name=blockIgnatius, energy=3595MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['O3PdSi']
        else if(event.Name.contentEquals("blockIgnatius")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(O, 27), new Element(Pd, 9), new Element(Si, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3595, new Element(O, 27), new Element(Pd, 9), new Element(Si, 9) ));

        }

        // name=blockInfuscolium, energy=5355MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Fe3Th']
        else if(event.Name.contentEquals("blockInfuscolium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 27), new Element(Th, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5355, new Element(Fe, 27), new Element(Th, 9) ));

        }

        // name=blockInolashite, energy=3060MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Os3(CO)12-ZrO2']
        else if(event.Name.contentEquals("blockInolashite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Os, 27), new Element(C, 108), new Element(O, 126), new Element(Zr, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3060, new Element(Os, 27), new Element(C, 108), new Element(O, 126), new Element(Zr, 9) ));

        }

        // name=blockKalendrite, energy=5508MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['BN']
        else if(event.Name.contentEquals("blockKalendrite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(B, 9), new Element(N, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5508, new Element(B, 9), new Element(N, 9) ));

        }

        // name=blockLemurite, energy=4360MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['LiC2H5O']
        else if(event.Name.contentEquals("blockLemurite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Li, 9), new Element(C, 18), new Element(H, 45), new Element(O, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 4360, new Element(Li, 9), new Element(C, 18), new Element(H, 45), new Element(O, 9) ));

        }

        // name=blockMeutoite, energy=5661MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Es(NO3)3']
        else if(event.Name.contentEquals("blockMeutoite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Es, 9), new Element(N, 27), new Element(O, 81) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5661, new Element(Es, 9), new Element(N, 27), new Element(O, 81) ));

        }

        // name=blockMidasium, energy=4590MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Au3Cn']
        else if(event.Name.contentEquals("blockMidasium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Au, 27), new Element(Cn, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 4590, new Element(Au, 27), new Element(Cn, 9) ));

        }

        // name=blockMithril, energy=5661MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Pd-NbC']
        else if(event.Name.contentEquals("blockMithril")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 9), new Element(Nb, 9), new Element(C, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5661, new Element(Pd, 9), new Element(Nb, 9), new Element(C, 9) ));

        }

        // name=blockOrichalcum, energy=5737MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['ReB2']
        else if(event.Name.contentEquals("blockOrichalcum")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Re, 9), new Element(B, 18) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5737, new Element(Re, 9), new Element(B, 18) ));

        }

        // name=blockOureclase, energy=5508MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['HgTeO3']
        else if(event.Name.contentEquals("blockOureclase")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Hg, 9), new Element(Te, 9), new Element(O, 27) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5508, new Element(Hg, 9), new Element(Te, 9), new Element(O, 27) ));

        }

        // name=blockPrometheum, energy=4590MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['CeFeZn']
        else if(event.Name.contentEquals("blockPrometheum")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ce, 9), new Element(Fe, 9), new Element(Zn, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 4590, new Element(Ce, 9), new Element(Fe, 9), new Element(Zn, 9) ));

        }

        // name=blockRubracium, energy=5814MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['RuTe2']
        else if(event.Name.contentEquals("blockRubracium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ru, 9), new Element(Te, 18) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5814, new Element(Ru, 9), new Element(Te, 18) ));

        }

        // name=blockSanguinite, energy=5814MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['TiVFeC-Co(NO3)2']
        else if(event.Name.contentEquals("blockSanguinite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ti, 9), new Element(V, 9), new Element(Fe, 9), new Element(C, 9), new Element(Co, 9), new Element(N, 18), new Element(O, 54) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5814, new Element(Ti, 9), new Element(V, 9), new Element(Fe, 9), new Element(C, 9), new Element(Co, 9), new Element(N, 18), new Element(O, 54) ));

        }

        // name=blockShadow Iron, energy=4054MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Fe4NiS4']
        else if(event.Name.contentEquals("blockShadow Iron")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 36), new Element(Ni, 9), new Element(S, 36) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 4054, new Element(Fe, 36), new Element(Ni, 9), new Element(S, 36) ));

        }

        // name=blockShadow Steel, energy=3060MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['LiC2H5O-Fe4NiS4']
        else if(event.Name.contentEquals("blockShadow Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Li, 9), new Element(C, 18), new Element(H, 45), new Element(O, 9), new Element(Fe, 36), new Element(Ni, 9), new Element(S, 36) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3060, new Element(Li, 9), new Element(C, 18), new Element(H, 45), new Element(O, 9), new Element(Fe, 36), new Element(Ni, 9), new Element(S, 36) ));

        }

        // name=blockTartarite, energy=3060MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['W3C-Cn-Co(BrO3)2', 'water', '6']
        else if(event.Name.contentEquals("blockTartarite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Molecule(water, 54), new Element(W, 27), new Element(C, 9), new Element(Cn, 9), new Element(Co, 9), new Element(Br, 18), new Element(O, 54) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 3060, new Molecule(water, 54), new Element(W, 27), new Element(C, 9), new Element(Cn, 9), new Element(Co, 9), new Element(Br, 18), new Element(O, 54) ));

        }

        // name=blockVulcanite, energy=5814MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['Al-Cr2O3']
        else if(event.Name.contentEquals("blockVulcanite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Al, 9), new Element(Cr, 18), new Element(O, 27) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 5814, new Element(Al, 9), new Element(Cr, 18), new Element(O, 27) ));

        }

        // name=blockVyroxeres, energy=4666MJ, probability=1.00F, multiply all by 9
        // recipe dictionary is ['ZnWO4']
        else if(event.Name.contentEquals("blockVyroxeres")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Zn, 9), new Element(W, 9), new Element(O, 36) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 4666, new Element(Zn, 9), new Element(W, 9), new Element(O, 36) ));

        }

        // --- end of auto-generated code ---


    }


    private void processDustSmall(OreRegisterEvent event) {

        // processDustSmall part
        // ${dustSmall}
        
    }


    private void processDust(OreRegisterEvent event) {

        // processDust part
        // 
        // --- start of auto-generated code, made from 'metallurgy.dust.recipe' ---

        // name=dustAdamantine, energy=390MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Cn-Co(BrO3)2', 'water', '6']
        else if(event.Name.contentEquals("dustAdamantine")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Molecule(water, 6), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 390, new Molecule(water, 6), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));

        }

        // name=dustAdluorite, energy=360MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ZrO2']
        else if(event.Name.contentEquals("dustAdluorite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Zr, 1), new Element(O, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 360, new Element(Zr, 1), new Element(O, 2) ));

        }

        // name=dustAmordrine, energy=200MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pt-BN']
        else if(event.Name.contentEquals("dustAmordrine")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pt, 1), new Element(B, 1), new Element(N, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 200, new Element(Pt, 1), new Element(B, 1), new Element(N, 1) ));

        }

        // name=dustAngmallen, energy=200MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['(FeAu)2']
        else if(event.Name.contentEquals("dustAngmallen")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 2), new Element(Au, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 200, new Element(Fe, 2), new Element(Au, 2) ));

        }

        // name=dustAredrite, energy=360MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['CCeRu']
        else if(event.Name.contentEquals("dustAredrite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(C, 1), new Element(Ce, 1), new Element(Ru, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 360, new Element(C, 1), new Element(Ce, 1), new Element(Ru, 1) ));

        }

        // name=dustAstral Silver, energy=370MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Ag-Ni-PdTe']
        else if(event.Name.contentEquals("dustAstral Silver")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ag, 1), new Element(Ni, 1), new Element(Pd, 1), new Element(Te, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 370, new Element(Ag, 1), new Element(Ni, 1), new Element(Pd, 1), new Element(Te, 1) ));

        }

        // name=dustAtlarus, energy=390MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['W3C']
        else if(event.Name.contentEquals("dustAtlarus")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(W, 3), new Element(C, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 390, new Element(W, 3), new Element(C, 1) ));

        }

        // name=dustBlack Steel, energy=200MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Fe4C-MnZnThO3']
        else if(event.Name.contentEquals("dustBlack Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 4), new Element(C, 1), new Element(Mn, 1), new Element(Zn, 1), new Element(Th, 1), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 200, new Element(Fe, 4), new Element(C, 1), new Element(Mn, 1), new Element(Zn, 1), new Element(Th, 1), new Element(O, 3) ));

        }

        // name=dustCarmot, energy=370MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Ni-ReCl3']
        else if(event.Name.contentEquals("dustCarmot")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ni, 1), new Element(Re, 1), new Element(Cl, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 370, new Element(Ni, 1), new Element(Re, 1), new Element(Cl, 3) ));

        }

        // name=dustCelenegil, energy=200MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['PtReB2']
        else if(event.Name.contentEquals("dustCelenegil")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pt, 1), new Element(Re, 1), new Element(B, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 200, new Element(Pt, 1), new Element(Re, 1), new Element(B, 2) ));

        }

        // name=dustCeruclase, energy=340MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Os3(CO)12']
        else if(event.Name.contentEquals("dustCeruclase")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Os, 3), new Element(C, 12), new Element(O, 12) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 340, new Element(Os, 3), new Element(C, 12), new Element(O, 12) ));

        }

        // name=dustDamascus Steel, energy=200MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Cu3Fe2Sn']
        else if(event.Name.contentEquals("dustDamascus Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Cu, 3), new Element(Fe, 2), new Element(Sn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 200, new Element(Cu, 3), new Element(Fe, 2), new Element(Sn, 1) ));

        }

        // name=dustDeep Iron, energy=330MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['MnFeZnCO3']
        else if(event.Name.contentEquals("dustDeep Iron")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Mn, 1), new Element(Fe, 1), new Element(Zn, 1), new Element(C, 1), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 330, new Element(Mn, 1), new Element(Fe, 1), new Element(Zn, 1), new Element(C, 1), new Element(O, 3) ));

        }

        // name=dustDesichalkos, energy=200MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd3TiUO2(NO3)2']
        else if(event.Name.contentEquals("dustDesichalkos")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 3), new Element(Ti, 1), new Element(U, 1), new Element(O, 8), new Element(N, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 200, new Element(Pd, 3), new Element(Ti, 1), new Element(U, 1), new Element(O, 8), new Element(N, 2) ));

        }

        // name=dustEximite, energy=320MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd3Ti']
        else if(event.Name.contentEquals("dustEximite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 3), new Element(Ti, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 320, new Element(Pd, 3), new Element(Ti, 1) ));

        }

        // name=dustHaderoth, energy=200MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd-NbC=RuTe2']
        else if(event.Name.contentEquals("dustHaderoth")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1), new Element(Ru, 1), new Element(Te, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 200, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1), new Element(Ru, 1), new Element(Te, 2) ));

        }

        // name=dustHepatizon, energy=200MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Au2Cu3Sn']
        else if(event.Name.contentEquals("dustHepatizon")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Au, 2), new Element(Cu, 3), new Element(Sn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 200, new Element(Au, 2), new Element(Cu, 3), new Element(Sn, 1) ));

        }

        // name=dustIgnatius, energy=240MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['O3PdSi']
        else if(event.Name.contentEquals("dustIgnatius")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(O, 3), new Element(Pd, 1), new Element(Si, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 240, new Element(O, 3), new Element(Pd, 1), new Element(Si, 1) ));

        }

        // name=dustInfuscolium, energy=350MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Fe3Th']
        else if(event.Name.contentEquals("dustInfuscolium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 3), new Element(Th, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 350, new Element(Fe, 3), new Element(Th, 1) ));

        }

        // name=dustInolashite, energy=200MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Os3(CO)12-ZrO2']
        else if(event.Name.contentEquals("dustInolashite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Os, 3), new Element(C, 12), new Element(O, 14), new Element(Zr, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 200, new Element(Os, 3), new Element(C, 12), new Element(O, 14), new Element(Zr, 1) ));

        }

        // name=dustKalendrite, energy=360MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['BN']
        else if(event.Name.contentEquals("dustKalendrite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(B, 1), new Element(N, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 360, new Element(B, 1), new Element(N, 1) ));

        }

        // name=dustLemurite, energy=280MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['LiC2H5O']
        else if(event.Name.contentEquals("dustLemurite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 280, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1) ));

        }

        // name=dustMeutoite, energy=370MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Es(NO3)3']
        else if(event.Name.contentEquals("dustMeutoite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Es, 1), new Element(N, 3), new Element(O, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 370, new Element(Es, 1), new Element(N, 3), new Element(O, 9) ));

        }

        // name=dustMidasium, energy=300MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Au3Cn']
        else if(event.Name.contentEquals("dustMidasium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Au, 3), new Element(Cn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 300, new Element(Au, 3), new Element(Cn, 1) ));

        }

        // name=dustMithril, energy=370MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd-NbC']
        else if(event.Name.contentEquals("dustMithril")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 370, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1) ));

        }

        // name=dustOrichalcum, energy=370MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ReB2']
        else if(event.Name.contentEquals("dustOrichalcum")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Re, 1), new Element(B, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 370, new Element(Re, 1), new Element(B, 2) ));

        }

        // name=dustOureclase, energy=360MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['HgTeO3']
        else if(event.Name.contentEquals("dustOureclase")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Hg, 1), new Element(Te, 1), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 360, new Element(Hg, 1), new Element(Te, 1), new Element(O, 3) ));

        }

        // name=dustPrometheum, energy=300MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['CeFeZn']
        else if(event.Name.contentEquals("dustPrometheum")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ce, 1), new Element(Fe, 1), new Element(Zn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 300, new Element(Ce, 1), new Element(Fe, 1), new Element(Zn, 1) ));

        }

        // name=dustRubracium, energy=380MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['RuTe2']
        else if(event.Name.contentEquals("dustRubracium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ru, 1), new Element(Te, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 380, new Element(Ru, 1), new Element(Te, 2) ));

        }

        // name=dustSanguinite, energy=380MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['TiVFeC-Co(NO3)2']
        else if(event.Name.contentEquals("dustSanguinite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ti, 1), new Element(V, 1), new Element(Fe, 1), new Element(C, 1), new Element(Co, 1), new Element(N, 2), new Element(O, 6) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 380, new Element(Ti, 1), new Element(V, 1), new Element(Fe, 1), new Element(C, 1), new Element(Co, 1), new Element(N, 2), new Element(O, 6) ));

        }

        // name=dustShadow Iron, energy=270MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Fe4NiS4']
        else if(event.Name.contentEquals("dustShadow Iron")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 270, new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));

        }

        // name=dustShadow Steel, energy=200MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['LiC2H5O-Fe4NiS4']
        else if(event.Name.contentEquals("dustShadow Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1), new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 200, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1), new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));

        }

        // name=dustTartarite, energy=200MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['W3C-Cn-Co(BrO3)2', 'water', '6']
        else if(event.Name.contentEquals("dustTartarite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Molecule(water, 6), new Element(W, 3), new Element(C, 1), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 200, new Molecule(water, 6), new Element(W, 3), new Element(C, 1), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));

        }

        // name=dustVulcanite, energy=380MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Al-Cr2O3']
        else if(event.Name.contentEquals("dustVulcanite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Al, 1), new Element(Cr, 2), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 380, new Element(Al, 1), new Element(Cr, 2), new Element(O, 3) ));

        }

        // name=dustVyroxeres, energy=310MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ZnWO4']
        else if(event.Name.contentEquals("dustVyroxeres")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Zn, 1), new Element(W, 1), new Element(O, 4) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 310, new Element(Zn, 1), new Element(W, 1), new Element(O, 4) ));

        }

        // --- end of auto-generated code ---


    }

    private void processGem(OreRegisterEvent event) {

        // processGem part
        // 
        // --- start of auto-generated code, made from 'metallurgy.gem.recipe' ---

        // name=gemAdamantine, energy=980MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Cn-Co(BrO3)2', 'water', '6']
        else if(event.Name.contentEquals("gemAdamantine")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Molecule(water, 6), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 980, new Molecule(water, 6), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));

        }

        // name=gemAdluorite, energy=930MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ZrO2']
        else if(event.Name.contentEquals("gemAdluorite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Zr, 1), new Element(O, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 930, new Element(Zr, 1), new Element(O, 2) ));

        }

        // name=gemAmordrine, energy=620MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pt-BN']
        else if(event.Name.contentEquals("gemAmordrine")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pt, 1), new Element(B, 1), new Element(N, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 620, new Element(Pt, 1), new Element(B, 1), new Element(N, 1) ));

        }

        // name=gemAngmallen, energy=620MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['(FeAu)2']
        else if(event.Name.contentEquals("gemAngmallen")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 2), new Element(Au, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 620, new Element(Fe, 2), new Element(Au, 2) ));

        }

        // name=gemAredrite, energy=930MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['CCeRu']
        else if(event.Name.contentEquals("gemAredrite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(C, 1), new Element(Ce, 1), new Element(Ru, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 930, new Element(C, 1), new Element(Ce, 1), new Element(Ru, 1) ));

        }

        // name=gemAstral Silver, energy=950MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Ag-Ni-PdTe']
        else if(event.Name.contentEquals("gemAstral Silver")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ag, 1), new Element(Ni, 1), new Element(Pd, 1), new Element(Te, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 950, new Element(Ag, 1), new Element(Ni, 1), new Element(Pd, 1), new Element(Te, 1) ));

        }

        // name=gemAtlarus, energy=990MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['W3C']
        else if(event.Name.contentEquals("gemAtlarus")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(W, 3), new Element(C, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 990, new Element(W, 3), new Element(C, 1) ));

        }

        // name=gemBlack Steel, energy=620MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Fe4C-MnZnThO3']
        else if(event.Name.contentEquals("gemBlack Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 4), new Element(C, 1), new Element(Mn, 1), new Element(Zn, 1), new Element(Th, 1), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 620, new Element(Fe, 4), new Element(C, 1), new Element(Mn, 1), new Element(Zn, 1), new Element(Th, 1), new Element(O, 3) ));

        }

        // name=gemCarmot, energy=950MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Ni-ReCl3']
        else if(event.Name.contentEquals("gemCarmot")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ni, 1), new Element(Re, 1), new Element(Cl, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 950, new Element(Ni, 1), new Element(Re, 1), new Element(Cl, 3) ));

        }

        // name=gemCelenegil, energy=620MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['PtReB2']
        else if(event.Name.contentEquals("gemCelenegil")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pt, 1), new Element(Re, 1), new Element(B, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 620, new Element(Pt, 1), new Element(Re, 1), new Element(B, 2) ));

        }

        // name=gemCeruclase, energy=900MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Os3(CO)12']
        else if(event.Name.contentEquals("gemCeruclase")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Os, 3), new Element(C, 12), new Element(O, 12) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 900, new Element(Os, 3), new Element(C, 12), new Element(O, 12) ));

        }

        // name=gemDamascus Steel, energy=620MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Cu3Fe2Sn']
        else if(event.Name.contentEquals("gemDamascus Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Cu, 3), new Element(Fe, 2), new Element(Sn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 620, new Element(Cu, 3), new Element(Fe, 2), new Element(Sn, 1) ));

        }

        // name=gemDeep Iron, energy=880MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['MnFeZnCO3']
        else if(event.Name.contentEquals("gemDeep Iron")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Mn, 1), new Element(Fe, 1), new Element(Zn, 1), new Element(C, 1), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 880, new Element(Mn, 1), new Element(Fe, 1), new Element(Zn, 1), new Element(C, 1), new Element(O, 3) ));

        }

        // name=gemDesichalkos, energy=620MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd3TiUO2(NO3)2']
        else if(event.Name.contentEquals("gemDesichalkos")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 3), new Element(Ti, 1), new Element(U, 1), new Element(O, 8), new Element(N, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 620, new Element(Pd, 3), new Element(Ti, 1), new Element(U, 1), new Element(O, 8), new Element(N, 2) ));

        }

        // name=gemEximite, energy=850MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd3Ti']
        else if(event.Name.contentEquals("gemEximite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 3), new Element(Ti, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 850, new Element(Pd, 3), new Element(Ti, 1) ));

        }

        // name=gemHaderoth, energy=620MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd-NbC=RuTe2']
        else if(event.Name.contentEquals("gemHaderoth")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1), new Element(Ru, 1), new Element(Te, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 620, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1), new Element(Ru, 1), new Element(Te, 2) ));

        }

        // name=gemHepatizon, energy=620MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Au2Cu3Sn']
        else if(event.Name.contentEquals("gemHepatizon")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Au, 2), new Element(Cu, 3), new Element(Sn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 620, new Element(Au, 2), new Element(Cu, 3), new Element(Sn, 1) ));

        }

        // name=gemIgnatius, energy=690MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['O3PdSi']
        else if(event.Name.contentEquals("gemIgnatius")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(O, 3), new Element(Pd, 1), new Element(Si, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 690, new Element(O, 3), new Element(Pd, 1), new Element(Si, 1) ));

        }

        // name=gemInfuscolium, energy=910MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Fe3Th']
        else if(event.Name.contentEquals("gemInfuscolium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 3), new Element(Th, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 910, new Element(Fe, 3), new Element(Th, 1) ));

        }

        // name=gemInolashite, energy=620MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Os3(CO)12-ZrO2']
        else if(event.Name.contentEquals("gemInolashite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Os, 3), new Element(C, 12), new Element(O, 14), new Element(Zr, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 620, new Element(Os, 3), new Element(C, 12), new Element(O, 14), new Element(Zr, 1) ));

        }

        // name=gemKalendrite, energy=930MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['BN']
        else if(event.Name.contentEquals("gemKalendrite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(B, 1), new Element(N, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 930, new Element(B, 1), new Element(N, 1) ));

        }

        // name=gemLemurite, energy=780MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['LiC2H5O']
        else if(event.Name.contentEquals("gemLemurite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 780, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1) ));

        }

        // name=gemMeutoite, energy=950MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Es(NO3)3']
        else if(event.Name.contentEquals("gemMeutoite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Es, 1), new Element(N, 3), new Element(O, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 950, new Element(Es, 1), new Element(N, 3), new Element(O, 9) ));

        }

        // name=gemMidasium, energy=820MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Au3Cn']
        else if(event.Name.contentEquals("gemMidasium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Au, 3), new Element(Cn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 820, new Element(Au, 3), new Element(Cn, 1) ));

        }

        // name=gemMithril, energy=950MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd-NbC']
        else if(event.Name.contentEquals("gemMithril")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 950, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1) ));

        }

        // name=gemOrichalcum, energy=950MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ReB2']
        else if(event.Name.contentEquals("gemOrichalcum")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Re, 1), new Element(B, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 950, new Element(Re, 1), new Element(B, 2) ));

        }

        // name=gemOureclase, energy=930MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['HgTeO3']
        else if(event.Name.contentEquals("gemOureclase")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Hg, 1), new Element(Te, 1), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 930, new Element(Hg, 1), new Element(Te, 1), new Element(O, 3) ));

        }

        // name=gemPrometheum, energy=820MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['CeFeZn']
        else if(event.Name.contentEquals("gemPrometheum")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ce, 1), new Element(Fe, 1), new Element(Zn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 820, new Element(Ce, 1), new Element(Fe, 1), new Element(Zn, 1) ));

        }

        // name=gemRubracium, energy=970MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['RuTe2']
        else if(event.Name.contentEquals("gemRubracium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ru, 1), new Element(Te, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 970, new Element(Ru, 1), new Element(Te, 2) ));

        }

        // name=gemSanguinite, energy=970MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['TiVFeC-Co(NO3)2']
        else if(event.Name.contentEquals("gemSanguinite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ti, 1), new Element(V, 1), new Element(Fe, 1), new Element(C, 1), new Element(Co, 1), new Element(N, 2), new Element(O, 6) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 970, new Element(Ti, 1), new Element(V, 1), new Element(Fe, 1), new Element(C, 1), new Element(Co, 1), new Element(N, 2), new Element(O, 6) ));

        }

        // name=gemShadow Iron, energy=750MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Fe4NiS4']
        else if(event.Name.contentEquals("gemShadow Iron")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 750, new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));

        }

        // name=gemShadow Steel, energy=620MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['LiC2H5O-Fe4NiS4']
        else if(event.Name.contentEquals("gemShadow Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1), new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 620, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1), new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));

        }

        // name=gemTartarite, energy=620MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['W3C-Cn-Co(BrO3)2', 'water', '6']
        else if(event.Name.contentEquals("gemTartarite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Molecule(water, 6), new Element(W, 3), new Element(C, 1), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 620, new Molecule(water, 6), new Element(W, 3), new Element(C, 1), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));

        }

        // name=gemVulcanite, energy=970MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Al-Cr2O3']
        else if(event.Name.contentEquals("gemVulcanite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Al, 1), new Element(Cr, 2), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 970, new Element(Al, 1), new Element(Cr, 2), new Element(O, 3) ));

        }

        // name=gemVyroxeres, energy=830MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ZnWO4']
        else if(event.Name.contentEquals("gemVyroxeres")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Zn, 1), new Element(W, 1), new Element(O, 4) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 830, new Element(Zn, 1), new Element(W, 1), new Element(O, 4) ));

        }

        // --- end of auto-generated code ---


    }

    private void processIngot(OreRegisterEvent event) {

        // processIngot part
        // 
        // --- start of auto-generated code, made from 'metallurgy.ingot.recipe' ---

        // name=ingotAdamantine, energy=780MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Cn-Co(BrO3)2', 'water', '6']
        else if(event.Name.contentEquals("ingotAdamantine")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Molecule(water, 6), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 780, new Molecule(water, 6), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));

        }

        // name=ingotAdluorite, energy=720MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ZrO2']
        else if(event.Name.contentEquals("ingotAdluorite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Zr, 1), new Element(O, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 720, new Element(Zr, 1), new Element(O, 2) ));

        }

        // name=ingotAmordrine, energy=400MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pt-BN']
        else if(event.Name.contentEquals("ingotAmordrine")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pt, 1), new Element(B, 1), new Element(N, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 400, new Element(Pt, 1), new Element(B, 1), new Element(N, 1) ));

        }

        // name=ingotAngmallen, energy=400MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['(FeAu)2']
        else if(event.Name.contentEquals("ingotAngmallen")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 2), new Element(Au, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 400, new Element(Fe, 2), new Element(Au, 2) ));

        }

        // name=ingotAredrite, energy=720MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['CCeRu']
        else if(event.Name.contentEquals("ingotAredrite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(C, 1), new Element(Ce, 1), new Element(Ru, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 720, new Element(C, 1), new Element(Ce, 1), new Element(Ru, 1) ));

        }

        // name=ingotAstral Silver, energy=740MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Ag-Ni-PdTe']
        else if(event.Name.contentEquals("ingotAstral Silver")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ag, 1), new Element(Ni, 1), new Element(Pd, 1), new Element(Te, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 740, new Element(Ag, 1), new Element(Ni, 1), new Element(Pd, 1), new Element(Te, 1) ));

        }

        // name=ingotAtlarus, energy=780MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['W3C']
        else if(event.Name.contentEquals("ingotAtlarus")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(W, 3), new Element(C, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 780, new Element(W, 3), new Element(C, 1) ));

        }

        // name=ingotBlack Steel, energy=400MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Fe4C-MnZnThO3']
        else if(event.Name.contentEquals("ingotBlack Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 4), new Element(C, 1), new Element(Mn, 1), new Element(Zn, 1), new Element(Th, 1), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 400, new Element(Fe, 4), new Element(C, 1), new Element(Mn, 1), new Element(Zn, 1), new Element(Th, 1), new Element(O, 3) ));

        }

        // name=ingotCarmot, energy=740MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Ni-ReCl3']
        else if(event.Name.contentEquals("ingotCarmot")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ni, 1), new Element(Re, 1), new Element(Cl, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 740, new Element(Ni, 1), new Element(Re, 1), new Element(Cl, 3) ));

        }

        // name=ingotCelenegil, energy=400MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['PtReB2']
        else if(event.Name.contentEquals("ingotCelenegil")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pt, 1), new Element(Re, 1), new Element(B, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 400, new Element(Pt, 1), new Element(Re, 1), new Element(B, 2) ));

        }

        // name=ingotCeruclase, energy=690MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Os3(CO)12']
        else if(event.Name.contentEquals("ingotCeruclase")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Os, 3), new Element(C, 12), new Element(O, 12) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 690, new Element(Os, 3), new Element(C, 12), new Element(O, 12) ));

        }

        // name=ingotDamascus Steel, energy=400MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Cu3Fe2Sn']
        else if(event.Name.contentEquals("ingotDamascus Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Cu, 3), new Element(Fe, 2), new Element(Sn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 400, new Element(Cu, 3), new Element(Fe, 2), new Element(Sn, 1) ));

        }

        // name=ingotDeep Iron, energy=660MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['MnFeZnCO3']
        else if(event.Name.contentEquals("ingotDeep Iron")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Mn, 1), new Element(Fe, 1), new Element(Zn, 1), new Element(C, 1), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 660, new Element(Mn, 1), new Element(Fe, 1), new Element(Zn, 1), new Element(C, 1), new Element(O, 3) ));

        }

        // name=ingotDesichalkos, energy=400MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd3TiUO2(NO3)2']
        else if(event.Name.contentEquals("ingotDesichalkos")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 3), new Element(Ti, 1), new Element(U, 1), new Element(O, 8), new Element(N, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 400, new Element(Pd, 3), new Element(Ti, 1), new Element(U, 1), new Element(O, 8), new Element(N, 2) ));

        }

        // name=ingotEximite, energy=640MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd3Ti']
        else if(event.Name.contentEquals("ingotEximite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 3), new Element(Ti, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 640, new Element(Pd, 3), new Element(Ti, 1) ));

        }

        // name=ingotHaderoth, energy=400MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd-NbC=RuTe2']
        else if(event.Name.contentEquals("ingotHaderoth")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1), new Element(Ru, 1), new Element(Te, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 400, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1), new Element(Ru, 1), new Element(Te, 2) ));

        }

        // name=ingotHepatizon, energy=400MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Au2Cu3Sn']
        else if(event.Name.contentEquals("ingotHepatizon")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Au, 2), new Element(Cu, 3), new Element(Sn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 400, new Element(Au, 2), new Element(Cu, 3), new Element(Sn, 1) ));

        }

        // name=ingotIgnatius, energy=470MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['O3PdSi']
        else if(event.Name.contentEquals("ingotIgnatius")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(O, 3), new Element(Pd, 1), new Element(Si, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 470, new Element(O, 3), new Element(Pd, 1), new Element(Si, 1) ));

        }

        // name=ingotInfuscolium, energy=700MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Fe3Th']
        else if(event.Name.contentEquals("ingotInfuscolium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 3), new Element(Th, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 700, new Element(Fe, 3), new Element(Th, 1) ));

        }

        // name=ingotInolashite, energy=400MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Os3(CO)12-ZrO2']
        else if(event.Name.contentEquals("ingotInolashite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Os, 3), new Element(C, 12), new Element(O, 14), new Element(Zr, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 400, new Element(Os, 3), new Element(C, 12), new Element(O, 14), new Element(Zr, 1) ));

        }

        // name=ingotKalendrite, energy=720MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['BN']
        else if(event.Name.contentEquals("ingotKalendrite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(B, 1), new Element(N, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 720, new Element(B, 1), new Element(N, 1) ));

        }

        // name=ingotLemurite, energy=570MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['LiC2H5O']
        else if(event.Name.contentEquals("ingotLemurite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 570, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1) ));

        }

        // name=ingotMeutoite, energy=740MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Es(NO3)3']
        else if(event.Name.contentEquals("ingotMeutoite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Es, 1), new Element(N, 3), new Element(O, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 740, new Element(Es, 1), new Element(N, 3), new Element(O, 9) ));

        }

        // name=ingotMidasium, energy=600MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Au3Cn']
        else if(event.Name.contentEquals("ingotMidasium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Au, 3), new Element(Cn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 600, new Element(Au, 3), new Element(Cn, 1) ));

        }

        // name=ingotMithril, energy=740MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd-NbC']
        else if(event.Name.contentEquals("ingotMithril")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 740, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1) ));

        }

        // name=ingotOrichalcum, energy=750MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ReB2']
        else if(event.Name.contentEquals("ingotOrichalcum")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Re, 1), new Element(B, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 750, new Element(Re, 1), new Element(B, 2) ));

        }

        // name=ingotOureclase, energy=720MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['HgTeO3']
        else if(event.Name.contentEquals("ingotOureclase")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Hg, 1), new Element(Te, 1), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 720, new Element(Hg, 1), new Element(Te, 1), new Element(O, 3) ));

        }

        // name=ingotPrometheum, energy=600MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['CeFeZn']
        else if(event.Name.contentEquals("ingotPrometheum")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ce, 1), new Element(Fe, 1), new Element(Zn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 600, new Element(Ce, 1), new Element(Fe, 1), new Element(Zn, 1) ));

        }

        // name=ingotRubracium, energy=760MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['RuTe2']
        else if(event.Name.contentEquals("ingotRubracium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ru, 1), new Element(Te, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 760, new Element(Ru, 1), new Element(Te, 2) ));

        }

        // name=ingotSanguinite, energy=760MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['TiVFeC-Co(NO3)2']
        else if(event.Name.contentEquals("ingotSanguinite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ti, 1), new Element(V, 1), new Element(Fe, 1), new Element(C, 1), new Element(Co, 1), new Element(N, 2), new Element(O, 6) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 760, new Element(Ti, 1), new Element(V, 1), new Element(Fe, 1), new Element(C, 1), new Element(Co, 1), new Element(N, 2), new Element(O, 6) ));

        }

        // name=ingotShadow Iron, energy=530MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Fe4NiS4']
        else if(event.Name.contentEquals("ingotShadow Iron")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 530, new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));

        }

        // name=ingotShadow Steel, energy=400MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['LiC2H5O-Fe4NiS4']
        else if(event.Name.contentEquals("ingotShadow Steel")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1), new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 400, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1), new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));

        }

        // name=ingotTartarite, energy=400MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['W3C-Cn-Co(BrO3)2', 'water', '6']
        else if(event.Name.contentEquals("ingotTartarite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Molecule(water, 6), new Element(W, 3), new Element(C, 1), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 400, new Molecule(water, 6), new Element(W, 3), new Element(C, 1), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));

        }

        // name=ingotVulcanite, energy=760MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Al-Cr2O3']
        else if(event.Name.contentEquals("ingotVulcanite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Al, 1), new Element(Cr, 2), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 760, new Element(Al, 1), new Element(Cr, 2), new Element(O, 3) ));

        }

        // name=ingotVyroxeres, energy=610MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ZnWO4']
        else if(event.Name.contentEquals("ingotVyroxeres")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Zn, 1), new Element(W, 1), new Element(O, 4) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 610, new Element(Zn, 1), new Element(W, 1), new Element(O, 4) ));

        }

        // --- end of auto-generated code ---

        
    }

    private void processItem(OreRegisterEvent event) {

        // processItem part
        // 
        // --- start of auto-generated code, made from 'metallurgy.item.recipe' ---

        // --- end of auto-generated code ---

        
    }

    private void processMolecule(OreRegisterEvent event) {

        // processMolecule part
        // ${molecule}
        
    }

    private void processNugget(OreRegisterEvent event) {

        // processNugget part
        // ${nugget}
    
    }

    private void processOreNether(OreRegisterEvent event) {

        // processOreNether part
        // ${oreNether}
        
    }

    private void processOre(OreRegisterEvent event) {

        // processOre part
        // 
        // --- start of auto-generated code, made from 'metallurgy.ore.recipe' ---

        // name=oreAdamantine, energy=100MJ, probability=0.50F, multiply all by 1
        // recipe dictionary is ['Cn-Co(BrO3)2', 'water', '6']
        else if(event.Name.contentEquals("oreAdamantine")) {
            DecomposerRecipe.add(new DecomposerRecipeChance(event.Ore, 0.50F, new Molecule(water, 6), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6)));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 100, new Molecule(water, 6), new Element(Cn, 1), new Element(Co, 1), new Element(Br, 2), new Element(O, 6) ));

        }

        // name=oreAdluorite, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ZrO2']
        else if(event.Name.contentEquals("oreAdluorite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Zr, 1), new Element(O, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(Zr, 1), new Element(O, 2) ));

        }

        // name=oreAredrite, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['CCeRu']
        else if(event.Name.contentEquals("oreAredrite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(C, 1), new Element(Ce, 1), new Element(Ru, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(C, 1), new Element(Ce, 1), new Element(Ru, 1) ));

        }

        // name=oreAstral Silver, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Ag-Ni-PdTe']
        else if(event.Name.contentEquals("oreAstral Silver")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ag, 1), new Element(Ni, 1), new Element(Pd, 1), new Element(Te, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(Ag, 1), new Element(Ni, 1), new Element(Pd, 1), new Element(Te, 1) ));

        }

        // name=oreAtlarus, energy=100MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['W3C']
        else if(event.Name.contentEquals("oreAtlarus")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(W, 3), new Element(C, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 100, new Element(W, 3), new Element(C, 1) ));

        }

        // name=oreCarmot, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Ni-ReCl3']
        else if(event.Name.contentEquals("oreCarmot")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ni, 1), new Element(Re, 1), new Element(Cl, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(Ni, 1), new Element(Re, 1), new Element(Cl, 3) ));

        }

        // name=oreCeruclase, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Os3(CO)12']
        else if(event.Name.contentEquals("oreCeruclase")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Os, 3), new Element(C, 12), new Element(O, 12) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(Os, 3), new Element(C, 12), new Element(O, 12) ));

        }

        // name=oreDeep Iron, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['MnFeZnCO3']
        else if(event.Name.contentEquals("oreDeep Iron")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Mn, 1), new Element(Fe, 1), new Element(Zn, 1), new Element(C, 1), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(Mn, 1), new Element(Fe, 1), new Element(Zn, 1), new Element(C, 1), new Element(O, 3) ));

        }

        // name=oreEximite, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd3Ti']
        else if(event.Name.contentEquals("oreEximite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 3), new Element(Ti, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(Pd, 3), new Element(Ti, 1) ));

        }

        // name=oreIgnatius, energy=70MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['O3PdSi']
        else if(event.Name.contentEquals("oreIgnatius")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(O, 3), new Element(Pd, 1), new Element(Si, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 70, new Element(O, 3), new Element(Pd, 1), new Element(Si, 1) ));

        }

        // name=oreInfuscolium, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Fe3Th']
        else if(event.Name.contentEquals("oreInfuscolium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 3), new Element(Th, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(Fe, 3), new Element(Th, 1) ));

        }

        // name=oreKalendrite, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['BN']
        else if(event.Name.contentEquals("oreKalendrite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(B, 1), new Element(N, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(B, 1), new Element(N, 1) ));

        }

        // name=oreLemurite, energy=80MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['LiC2H5O']
        else if(event.Name.contentEquals("oreLemurite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 80, new Element(Li, 1), new Element(C, 2), new Element(H, 5), new Element(O, 1) ));

        }

        // name=oreMeutoite, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Es(NO3)3']
        else if(event.Name.contentEquals("oreMeutoite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Es, 1), new Element(N, 3), new Element(O, 9) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(Es, 1), new Element(N, 3), new Element(O, 9) ));

        }

        // name=oreMidasium, energy=80MJ, probability=0.10F, multiply all by 1
        // recipe dictionary is ['Au3Cn']
        else if(event.Name.contentEquals("oreMidasium")) {
            DecomposerRecipe.add(new DecomposerRecipeChance(event.Ore, 0.10F, new Element(Au, 3), new Element(Cn, 1)));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 80, new Element(Au, 3), new Element(Cn, 1) ));

        }

        // name=oreMithril, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Pd-NbC']
        else if(event.Name.contentEquals("oreMithril")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(Pd, 1), new Element(Nb, 1), new Element(C, 1) ));

        }

        // name=oreOrichalcum, energy=100MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ReB2']
        else if(event.Name.contentEquals("oreOrichalcum")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Re, 1), new Element(B, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 100, new Element(Re, 1), new Element(B, 2) ));

        }

        // name=oreOureclase, energy=90MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['HgTeO3']
        else if(event.Name.contentEquals("oreOureclase")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Hg, 1), new Element(Te, 1), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 90, new Element(Hg, 1), new Element(Te, 1), new Element(O, 3) ));

        }

        // name=orePrometheum, energy=80MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['CeFeZn']
        else if(event.Name.contentEquals("orePrometheum")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ce, 1), new Element(Fe, 1), new Element(Zn, 1) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 80, new Element(Ce, 1), new Element(Fe, 1), new Element(Zn, 1) ));

        }

        // name=oreRubracium, energy=100MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['RuTe2']
        else if(event.Name.contentEquals("oreRubracium")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ru, 1), new Element(Te, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 100, new Element(Ru, 1), new Element(Te, 2) ));

        }

        // name=oreSanguinite, energy=100MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['TiVFeC-Co(NO3)2']
        else if(event.Name.contentEquals("oreSanguinite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Ti, 1), new Element(V, 1), new Element(Fe, 1), new Element(C, 1), new Element(Co, 1), new Element(N, 2), new Element(O, 6) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 100, new Element(Ti, 1), new Element(V, 1), new Element(Fe, 1), new Element(C, 1), new Element(Co, 1), new Element(N, 2), new Element(O, 6) ));

        }

        // name=oreShadow Iron, energy=80MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Fe4NiS4']
        else if(event.Name.contentEquals("oreShadow Iron")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 80, new Element(Fe, 4), new Element(Ni, 1), new Element(S, 4) ));

        }

        // name=oreVulcanite, energy=100MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['Al-Cr2O3']
        else if(event.Name.contentEquals("oreVulcanite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Al, 1), new Element(Cr, 2), new Element(O, 3) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 100, new Element(Al, 1), new Element(Cr, 2), new Element(O, 3) ));

        }

        // name=oreVyroxeres, energy=80MJ, probability=1.00F, multiply all by 1
        // recipe dictionary is ['ZnWO4']
        else if(event.Name.contentEquals("oreVyroxeres")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Zn, 1), new Element(W, 1), new Element(O, 4) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 80, new Element(Zn, 1), new Element(W, 1), new Element(O, 4) ));

        }

        // --- end of auto-generated code ---

        
    }

    private void processReduced(OreRegisterEvent event) {

        // processReduced part
        // ${reduced}
        
    }

    private void processCleanGravel(OreRegisterEvent event) {

        // processCleanGravel part
        // ${cleanGravel}

    }

    private void processCrystalline(OreRegisterEvent event) {

        // processCrystalline part
        // ${crystalline}
        
    }

    private void processDirtyGravel(OreRegisterEvent event) {

        // processDirtyGravel part
        // ${dirtyGravel}
        
    }

    private void processDrop(OreRegisterEvent event) {

        // processDrop part
        // ${drop}
        
    }
    
    private void processOther(OreRegisterEvent event) {

        // processOther part
        // 
        // --- start of auto-generated code, made from 'metallurgy.other.recipe' ---

        // --- end of auto-generated code ---

        
    }

    // --- end of auto-generated code ---
    
    private dictClass getDictClass(String eventName){
        // block
        if (eventName.startsWith("block")){
            return dictClass.BLOCK;
        }
        
        //dusts
        if (eventName.startsWith("dust")) {
            if (eventName.startsWith("dustSmall")) {
                return dictClass.DUSTSMALL;
            } else {
                return dictClass.DUST;
            }
        }
        
        //gems
        if (eventName.startsWith("gem")) {
            return dictClass.GEM;
        }
        
        //ingots
        if (eventName.startsWith("ingot")) {
            return dictClass.INGOT;
        }
        
        if (eventName.startsWith("item")) {
            return dictClass.ITEM;
        }
        
        if (eventName.startsWith("molecule")) {
            return dictClass.MOLECULE;
        }
        
        if (eventName.startsWith("nugget")) {
            return dictClass.NUGGET;
        }
        if (eventName.startsWith("ore")) {
            if (eventName.startsWith("oreNether")) {
                return dictClass.ORENETHER;
            } else {
                return dictClass.ORE;
            }
        }
        
        if (eventName.startsWith("reduced")) {
            return dictClass.REDUCED;
        }
        
        if (eventName.startsWith("cleanGravel")) {
            return dictClass.CLEANGRAVEL;
        }
        
        if (eventName.startsWith("crystalline")) {
            return dictClass.CRYSTALLINE;
        }
        
        if (eventName.startsWith("dirtyGravel")) {
            return dictClass.DIRTYGRAVEL;
        }
        
        if (eventName.startsWith("drop")) {
            return dictClass.DROP;
        }
        return dictClass.OTHER;
    };
}

