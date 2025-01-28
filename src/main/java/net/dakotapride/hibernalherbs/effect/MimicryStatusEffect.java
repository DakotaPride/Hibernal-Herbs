package net.dakotapride.hibernalherbs.effect;

import net.dakotapride.hibernalherbs.init.DamageSourceKeysInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class MimicryStatusEffect extends ApplyEffectFromHealthStatusEffect {
    public MimicryStatusEffect() {
        super(MobEffects.DAMAGE_BOOST, 4.0D, 0xAEDB7A);
    }

    @Override
    public void onMobHurt(LivingEntity livingEntity, int i, @NotNull DamageSource damageSource, float f) {
        livingEntity.hurt(livingEntity.damageSources().source(DamageSourceKeysInit.MIMICRY_REPERCUSSIONS), f);
    }
}
