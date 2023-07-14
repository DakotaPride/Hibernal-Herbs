package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.init.gen.PlacedFeatureInit;
import net.dakotapride.hibernalHerbs.common.util;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class FeaturesInit {

    public static void init() {
        // Load This Class

        BiomeModifications.addFeature(BiomeSelectors.tag(util.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.HERBS_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.tag(util.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.MYQUESTE_PLACED);

    }

}
