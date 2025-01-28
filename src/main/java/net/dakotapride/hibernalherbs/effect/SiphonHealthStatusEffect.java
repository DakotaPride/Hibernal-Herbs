package net.dakotapride.hibernalherbs.effect;

import net.minecraft.world.effect.MobEffectCategory;

public class SiphonHealthStatusEffect extends BasicStatusEffect {
    float health_m;
    public SiphonHealthStatusEffect(float h, int colour) {
        super(MobEffectCategory.NEUTRAL, colour);
        this.health_m = h;
    }

    public float getHealthMultiplicative() {
        return health_m;
    }
}
