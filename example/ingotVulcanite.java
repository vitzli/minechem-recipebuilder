
            // name=ingotVulcanite, energy=100MJ, probability=1.00F, multiply all by 2
            // recipe dictionary is ['CuTe']
        else if(event.Name.contentEquals("ingotVulcanite")) {
            DecomposerRecipe.add(new DecomposerRecipe(event.Ore, new Element(Cu, 2), new Element(Te, 2) ));
            SynthesisRecipe.add(new SynthesisRecipe(event.Ore, false, 100, new Element(Cu, 2), new Element(Te, 2) ));

        }


