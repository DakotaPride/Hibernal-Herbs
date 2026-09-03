package net.dakotapride.hibernalherbs.grower;

import net.dakotapride.hibernalherbs.init.FeaturesInit;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class MyquesteTreeGrower extends AbstractTreeGrower {
    @Override
    protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean bl) {
        return FeaturesInit.MYQUESTE_CONFIGURED;
    }
}
