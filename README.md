minechem-recipebuilder
======================

Automated code generation tool for minechem recipes

written with Python 3.2, chemparse.py is chemical formula parser, it can parse formulas like 'HO2CCH(NH2)(CH2)4NH2' to [{'H': 14, 'C': 6, 'O': 2, 'N': 2}]

Minechem-recipebuilder provides following tools:
* split_log.py - to split long dump of forge ore dictionary elements FILE.NAME to several files depending on element name ('block' goes to FILE.block.recipe, 'ingot' respectively to FILE.ingot.recipe, everything that does not start from text in PROCESS variable goes to FILE.other.recipe);
* create_recipe.py - recipe builder tool, takes row from provided file and parses it to corresponding java code;
* assignFormulas.py - assign formulas to recipes from freeplane mindmap;
* recipeBuilderOre.py - generate target java code file using MCRecipes.template.java template;

Other files are auxiliary python packages required for recipebuilder's tools:
* mmFile.py - provides access to freeplane mindmap, see 'example/metallurgy/Metallurgy 2.mm';
* chemparse.py - chemical formula parser;
* mcmols.py - molecules from Minechem's API;

## Use:
1. Using *split_log.py* split log file of oreDictionary elements to several recipe files;
2. Assign formulas from freeplane's mindmaps to compounds using *assignFormulas.py* for each recipe file;
   _or_
   Write recipes manually
3. Create MCRecipesMODNAME.java file using *recipeBuilderOre.py* (only for oreDictionary elements);
4. Correct MCRecipesMODNAME.java for proper mod- and package name;
5. Recompile, reobfuscate and pack files into jar.
6. Put jar-file into 'mods' folder.

## Examples:

    split_log.py metallurgy.ore.log

gives files:

    metallurgy.ore.block.recipe
    metallurgy.ore.dust.recipe
    metallurgy.ore.gem.recipe
    metallurgy.ore.ingot.recipe
    metallurgy.ore.item.recipe
    metallurgy.ore.ore.recipe
    metallurgy.ore.other.recipe

let's say that ingotVulcanite is defined by formula CuTe and has multiplier of 2:

    ingotVulcanite CuTe m=2

running create_recipe.py in ore processing mode:
    
    create_recipe.py o ingotVulcanite.recipe

would produce the following code:

        // name=ingotVulcanite, energy=100MJ, probability=1.00F, multiply all by 2
        // recipe dictionary is ['CuTe']
        else if(event.Name.contentEquals("ingotVulcanite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Cu, 2), new Element(Te, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 100, new Element(Cu, 2), new Element(Te, 2) ));

        }

## License
Public domain, see LICENSE
