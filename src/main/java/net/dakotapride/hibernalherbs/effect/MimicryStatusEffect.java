package net.dakotapride.hibernalherbs.effect;

import net.minecraft.world.effect.MobEffects;

public class MimicryStatusEffect extends ApplyEffectFromHealthStatusEffect {
    public MimicryStatusEffect() {
        super(MobEffects.DAMAGE_BOOST, 4.0D, 0xAEDB7A);
    }

}
