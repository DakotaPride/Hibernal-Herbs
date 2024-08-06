package net.dakotapride.hibernalHerbs.common.init.gen;

import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class ConfiguredFeatureInit {
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ROSEMARY_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_rosemary_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.ROSEMARY)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> THYME_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_thyme_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.THYME)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> TARRAGON_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_tarragon_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.TARRAGON)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CHAMOMILE_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_chamomile_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.CHAMOMILE)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CHIVES_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_chives_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.CHIVES)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> VERBENA_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_verbena_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.VERBENA)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> SORREL_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_sorrel_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.SORREL)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> MARJORAM_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_marjoram_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.MARJORAM)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CHERVIL_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_chervil_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.CHERVIL)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> FENNSEL_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_fennsel_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.FENNSEL)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CEILLIS_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_ceillis_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.CEILLIS)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PUNUEL_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_punuel_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.PUNUEL)))));
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ESSITTE_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_essitte_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.ESSITTE)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CALENDULA_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":herb_calendula_configured", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.CALENDULA)))));

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> MYQUESTE_CONFIGURED =
            ConfiguredFeatures.register(MOD_ID + ":tree_myqueste_configured", Feature.TREE, (new TreeFeatureConfig.Builder(BlockStateProvider.of
                    (BlockInit.MYQUESTE_LOG), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.of(BlockInit.MYQUESTE_LEAVES),
                    new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2),
                            UniformIntProvider.create(1, 2)), new TwoLayersFeatureSize(2, 0, 2)))
                    .ignoreVines().build());

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> MYQUESTE_SPAWN =
            ConfiguredFeatures.register(MOD_ID + ":myqueste_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(PlacedFeatureInit.MYQUESTE_CHECKED, 0.2f)),
                            PlacedFeatureInit.MYQUESTE_CHECKED));

}
