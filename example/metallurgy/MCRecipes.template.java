package com.vitzli.mcaddons.${modname};

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

public class ${modname} {
    private static final ${modname} instance = new ${modname}();
    

    public static ${modname} getInstance() {
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
        // ${block}

    }


    private void processDustSmall(OreRegisterEvent event) {

        // processDustSmall part
        // ${dustSmall}
        
    }


    private void processDust(OreRegisterEvent event) {

        // processDust part
        // ${dust}

    }

    private void processGem(OreRegisterEvent event) {

        // processGem part
        // ${gem}

    }

    private void processIngot(OreRegisterEvent event) {

        // processIngot part
        // ${ingot}
        
    }

    private void processItem(OreRegisterEvent event) {

        // processItem part
        // ${item}
        
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
        // ${ore}
        
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
        // ${other}
        
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
