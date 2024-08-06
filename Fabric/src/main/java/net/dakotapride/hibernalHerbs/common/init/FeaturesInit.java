package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.init.gen.PlacedFeatureInit;
import net.dakotapride.hibernalHerbs.common.Utilities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class FeaturesInit {

    public static void init() {
        // Load This Class

        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.ROSEMARY_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.THYME_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.TARRAGON_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.CHAMOMILE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.CHIVES_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.VERBENA_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.SORREL_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.MARJORAM_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.CHERVIL_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.FENNSEL_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.CEILLIS_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.PUNUEL_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.ESSITTE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.CALENDULA_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.tag(Utilities.HAS_HERBS),
                GenerationStep.Feature.VEGETAL_DECORATION, PlacedFeatureInit.MYQUESTE_PLACED.getKey().get());

    }

}
