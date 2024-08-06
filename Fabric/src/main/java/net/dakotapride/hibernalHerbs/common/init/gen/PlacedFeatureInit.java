package net.dakotapride.hibernalHerbs.common.init.gen;

import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class PlacedFeatureInit {
    public static final RegistryEntry<PlacedFeature> ROSEMARY_PLACED = PlacedFeatures.register(MOD_ID + ":rosemary_placed",
            ConfiguredFeatureInit.ROSEMARY_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> THYME_PLACED = PlacedFeatures.register(MOD_ID + ":thyme_placed",
            ConfiguredFeatureInit.THYME_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> TARRAGON_PLACED = PlacedFeatures.register(MOD_ID + ":tarragon_placed",
            ConfiguredFeatureInit.TARRAGON_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> CHAMOMILE_PLACED = PlacedFeatures.register(MOD_ID + ":chamomile_placed",
            ConfiguredFeatureInit.CHAMOMILE_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> CHIVES_PLACED = PlacedFeatures.register(MOD_ID + ":chives_placed",
            ConfiguredFeatureInit.CHIVES_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> VERBENA_PLACED = PlacedFeatures.register(MOD_ID + ":verbena_placed",
            ConfiguredFeatureInit.VERBENA_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> SORREL_PLACED = PlacedFeatures.register(MOD_ID + ":sorrel_placed",
            ConfiguredFeatureInit.SORREL_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> MARJORAM_PLACED = PlacedFeatures.register(MOD_ID + ":marjoram_placed",
            ConfiguredFeatureInit.MARJORAM_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> CHERVIL_PLACED = PlacedFeatures.register(MOD_ID + ":chervil_placed",
            ConfiguredFeatureInit.CHERVIL_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> FENNSEL_PLACED = PlacedFeatures.register(MOD_ID + ":fennsel_placed",
            ConfiguredFeatureInit.FENNSEL_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> CEILLIS_PLACED = PlacedFeatures.register(MOD_ID + ":ceillis_placed",
            ConfiguredFeatureInit.CEILLIS_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> PUNUEL_PLACED = PlacedFeatures.register(MOD_ID + ":punuel_placed",
            ConfiguredFeatureInit.PUNUEL_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> ESSITTE_PLACED = PlacedFeatures.register(MOD_ID + ":essitte_placed",
            ConfiguredFeatureInit.ESSITTE_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> CALENDULA_PLACED = PlacedFeatures.register(MOD_ID + ":calendula_placed",
            ConfiguredFeatureInit.CALENDULA_CONFIGURED, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> MYQUESTE_CHECKED = PlacedFeatures.register(MOD_ID + ":myqueste_checked",
            ConfiguredFeatureInit.MYQUESTE_CONFIGURED, List.of(PlacedFeatures.wouldSurvive(BlockInit.MYQUESTE_SAPLING)));

    public static final RegistryEntry<PlacedFeature> MYQUESTE_PLACED =
            PlacedFeatures.register(MOD_ID + ":myqueste_placed", ConfiguredFeatureInit.MYQUESTE_SPAWN,
                    VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 1)));

}
