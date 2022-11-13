package net.dakotapride.hibernalHerbs.common.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

import static net.dakotapride.hibernalHerbs.common.HibernalHerbsMod.HIBERNAL_HERBS_ID;

public class FeaturesInit {

    // Configured

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ROSEMARY_CONFIGURED =
            ConfiguredFeatures.register(HIBERNAL_HERBS_ID + ":herb_rosemary_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.ROSEMARY)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> THYME_CONFIGURED =
            ConfiguredFeatures.register(HIBERNAL_HERBS_ID + ":herb_thyme_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.THYME)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> TARRAGON_CONFIGURED =
            ConfiguredFeatures.register(HIBERNAL_HERBS_ID + ":herb_tarragon_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.TARRAGON)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CHAMOMILE_CONFIGURED =
            ConfiguredFeatures.register(HIBERNAL_HERBS_ID + ":herb_chamomile_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.CHAMOMILE)))));

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> MYQUESTE_CONFIGURED =
            ConfiguredFeatures.register(HIBERNAL_HERBS_ID + ":tree_myqueste_configured", Feature.TREE, (new TreeFeatureConfig.Builder(BlockStateProvider.of
                    (BlockInit.MYQUESTE_LOG), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.of(BlockInit.MYQUESTE_LEAVES),
                    new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2),
                            UniformIntProvider.create(1, 2)), new TwoLayersFeatureSize(2, 0, 2)))
                    .ignoreVines().build());

    // Misc

    public static final RegistryEntry<PlacedFeature> MYQUESTE_CHECKED = PlacedFeatures.register(HIBERNAL_HERBS_ID + ":myqueste_checked",
            MYQUESTE_CONFIGURED, List.of(PlacedFeatures.wouldSurvive(BlockInit.MYQUESTE_SAPLING)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> MYQUESTE_SPAWN =
            ConfiguredFeatures.register(HIBERNAL_HERBS_ID + ":myqueste_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(MYQUESTE_CHECKED, 0.5f)),
                            MYQUESTE_CHECKED));

    // Placed

    public static final RegistryEntry<PlacedFeature> ROSEMARY_PLACED = PlacedFeatures.register(HIBERNAL_HERBS_ID + ":rosemary_placed",
            ROSEMARY_CONFIGURED, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> THYME_PLACED = PlacedFeatures.register(HIBERNAL_HERBS_ID + ":thyme_placed",
            THYME_CONFIGURED, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> TARRAGON_PLACED = PlacedFeatures.register(HIBERNAL_HERBS_ID + ":tarragon_placed",
            TARRAGON_CONFIGURED, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> CHAMOMILE_PLACED = PlacedFeatures.register(HIBERNAL_HERBS_ID + ":chamomile_placed",
            CHAMOMILE_CONFIGURED, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> MYQUESTE_PLACED =
            PlacedFeatures.register(HIBERNAL_HERBS_ID + ":myqueste_placed", MYQUESTE_SPAWN,
                    VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));

    public static void init() {
        // Load This Class

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.VILLAGE_SNOWY_HAS_STRUCTURE),
                GenerationStep.Feature.VEGETAL_DECORATION, ROSEMARY_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.VILLAGE_SNOWY_HAS_STRUCTURE),
                GenerationStep.Feature.VEGETAL_DECORATION, THYME_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.VILLAGE_SNOWY_HAS_STRUCTURE),
                GenerationStep.Feature.VEGETAL_DECORATION, TARRAGON_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.VILLAGE_SNOWY_HAS_STRUCTURE),
                GenerationStep.Feature.VEGETAL_DECORATION, CHAMOMILE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.VILLAGE_SNOWY_HAS_STRUCTURE),
                GenerationStep.Feature.VEGETAL_DECORATION, MYQUESTE_PLACED.getKey().get());

    }

}
