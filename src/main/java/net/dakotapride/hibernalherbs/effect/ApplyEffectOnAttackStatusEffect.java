package net.dakotapride.hibernalherbs.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ApplyEffectOnAttackStatusEffect extends BasicStatusEffect {
    MobEffect effect;
    public ApplyEffectOnAttackStatusEffect(MobEffect applyToTarget, int colour) {
        super(MobEffectCategory.NEUTRAL, colour);
        this.effect = applyToTarget;
    }

    public MobEffect getEffect() {
        return effect;
    }
}
