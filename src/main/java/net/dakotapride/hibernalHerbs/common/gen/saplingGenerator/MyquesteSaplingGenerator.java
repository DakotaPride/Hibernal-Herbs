package net.dakotapride.hibernalHerbs.common.gen.saplingGenerator;

import net.dakotapride.hibernalHerbs.common.init.FeaturesInit;
import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class MyquesteSaplingGenerator extends LargeTreeSaplingGenerator {
    public MyquesteSaplingGenerator() {
    }

    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
        return FeaturesInit.MYQUESTE_CONFIGURED;
    }

    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return getLargeTreeFeature(random);
    }
}
