package net.dakotapride.hibernalHerbs.common.gen.saplingGenerator;

import net.dakotapride.hibernalHerbs.common.init.gen.ConfiguredFeatureInit;
import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class MyquesteSaplingGenerator extends LargeTreeSaplingGenerator {
    public MyquesteSaplingGenerator() {
    }

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ConfiguredFeatureInit.MYQUESTE_CONFIGURED;
    }

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
        return getLargeTreeFeature(random);
    }

}
