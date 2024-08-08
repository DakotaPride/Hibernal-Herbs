package net.dakotapride.hibernalherbs.fabric.registry;

import net.dakotapride.hibernalherbs.registry.Utilities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class FeaturesRegistry {

    public static void register() {
        // Load This Class

        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS_BIOME_TAG),
                GenerationStep.Feature.VEGETAL_DECORATION, net.dakotapride.hibernalherbs.registry.FeaturesRegistry.HERBS_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS_BIOME_TAG),
                GenerationStep.Feature.VEGETAL_DECORATION, net.dakotapride.hibernalherbs.registry.FeaturesRegistry.MYQUESTE_PLACED);

    }

}
