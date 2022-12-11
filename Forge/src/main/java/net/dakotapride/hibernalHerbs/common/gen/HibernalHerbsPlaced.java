package net.dakotapride.hibernalHerbs.common.gen;

import net.dakotapride.hibernalHerbs.common.Constants;
import net.dakotapride.hibernalHerbs.common.registry.blockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class HibernalHerbsPlaced {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Constants.MOD_ID);

    public static final RegistryObject<PlacedFeature> ROSEMARY_PLACED = PLACED_FEATURES.register("rosemary_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.ROSEMARY.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> THYME_PLACED = PLACED_FEATURES.register("thyme_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.THYME.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> TARRAGON_PLACED = PLACED_FEATURES.register("tarragon_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.TARRAGON.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> CHAMOMILE_PLACED = PLACED_FEATURES.register("chamomile_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.CHAMOMILE.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> CHIVES_PLACED = PLACED_FEATURES.register("chives_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.CHIVES.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> VERBENA_PLACED = PLACED_FEATURES.register("verbena_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.VERBENA.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> SORREL_PLACED = PLACED_FEATURES.register("sorrel_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.SORREL.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> MARJORAM_PLACED = PLACED_FEATURES.register("marjoram_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.MARJORAM.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> CHERVIL_PLACED = PLACED_FEATURES.register("chervil_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.CHERVIL.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> FENNSEL_PLACED = PLACED_FEATURES.register("fennsel_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.FENNSEL.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> CEILLIS_PLACED = PLACED_FEATURES.register("ceillis_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.CEILLIS.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> PUNUEL_PLACED = PLACED_FEATURES.register("punuel_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.PUNUEL.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> ESSITTE_PLACED = PLACED_FEATURES.register("essitte_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.ESSITTE.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(12),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> MYQUESTE_CHECKED = PLACED_FEATURES.register("myqueste_checked",
            () -> new PlacedFeature(HibernalHerbsConfigured.MYQUESTE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(blockRegistry.MYQUESTE_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> MYQUESTE_PLACED = PLACED_FEATURES.register("myqueste_placed",
            () -> new PlacedFeature(HibernalHerbsConfigured.MYQUESTE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 1))));

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }

}
