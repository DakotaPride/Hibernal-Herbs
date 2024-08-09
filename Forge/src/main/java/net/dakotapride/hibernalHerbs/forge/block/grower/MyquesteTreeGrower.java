package net.dakotapride.hibernalherbs.forge.block.grower;

import net.dakotapride.hibernalherbs.registry.FeaturesRegistry;
import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class MyquesteTreeGrower extends LargeTreeSaplingGenerator {

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return FeaturesRegistry.MYQUESTE_CONFIGURED;
    }

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
        return null;
    }
}
