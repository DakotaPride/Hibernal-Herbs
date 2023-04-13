package net.dakotapride.hibernalHerbs.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class SinHerbBlock extends FlowerBlock {
    public SinHerbBlock(int effectDuration, Properties properties) {
        super(MobEffects.WITHER, effectDuration, properties);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 1));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 1));
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        for(int i = 0; i < 3; ++i) {
            int j = source.nextInt(2) * 2 - 1;
            int k = source.nextInt(2) * 2 - 1;
            double d0 = (double)pos.getX() + 0.5 + 0.25 * (double)j;
            double d1 = (float)pos.getY() + source.nextFloat();
            double d2 = (double)pos.getZ() + 0.5 + 0.25 * (double)k;
            double d3 = source.nextFloat() * (float)j;
            double d4 = ((double)source.nextFloat() - 0.5) * 0.125;
            double d5 = source.nextFloat() * (float)k;
            level.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
        }

    }
}
