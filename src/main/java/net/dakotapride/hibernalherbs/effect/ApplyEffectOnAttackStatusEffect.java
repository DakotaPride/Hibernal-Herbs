package net.dakotapride.hibernalherbs.effect;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ApplyEffectOnAttackStatusEffect extends BasicStatusEffect {
    Holder<MobEffect> effect;
    public ApplyEffectOnAttackStatusEffect(Holder<MobEffect> applyToTarget, int colour) {
        super(MobEffectCategory.NEUTRAL, colour);
        this.effect = applyToTarget;
    }

    public Holder<MobEffect> getEffect() {
        return effect;
    }
}
