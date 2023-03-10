package net.dakotapride.hibernalHerbs.common.gen;

import net.dakotapride.hibernalHerbs.common.Constants;
import net.dakotapride.hibernalHerbs.common.registry.blockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class HibernalHerbsConfigured {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Constants.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> ROSEMARY = CONFIGURED_FEATURES.register("flower_rosemary_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.ROSEMARY.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> THYME = CONFIGURED_FEATURES.register("flower_thyme_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.THYME.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TARRAGON = CONFIGURED_FEATURES.register("flower_tarragon_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.TARRAGON.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHAMOMILE = CONFIGURED_FEATURES.register("flower_chamomile_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.CHAMOMILE.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHIVES = CONFIGURED_FEATURES.register("flower_chives_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.CHIVES.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> VERBENA = CONFIGURED_FEATURES.register("flower_verbena_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.VERBENA.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SORREL = CONFIGURED_FEATURES.register("flower_sorrel_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.SORREL.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MARJORAM = CONFIGURED_FEATURES.register("flower_marjoram_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.MARJORAM.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERVIL = CONFIGURED_FEATURES.register("flower_chervil_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.CHERVIL.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> FENNSEL = CONFIGURED_FEATURES.register("flower_fennsel_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.FENNSEL.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CEILLIS = CONFIGURED_FEATURES.register("flower_ceillis_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.CEILLIS.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PUNUEL = CONFIGURED_FEATURES.register("flower_punuel_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.PUNUEL.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ESSITTE = CONFIGURED_FEATURES.register("flower_essitte_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.ESSITTE.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CALENDULA = CONFIGURED_FEATURES.register("flower_calendula_configured",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(blockRegistry.CALENDULA.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MYQUESTE =
            CONFIGURED_FEATURES.register("tree_myqueste_configured", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(blockRegistry.MYQUESTE_LOG.get()),
                            new StraightTrunkPlacer(5, 2, 1),
                            BlockStateProvider.simple(blockRegistry.MYQUESTE_LEAVES.get()),
                            new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MYQUESTE_SPAWN =
            CONFIGURED_FEATURES.register("tree_myqueste_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            HibernalHerbsPlaced.MYQUESTE_CHECKED.getHolder().get(),
                            0.2F)), HibernalHerbsPlaced.MYQUESTE_CHECKED.getHolder().get())));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }

}
