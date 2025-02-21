package net.dakotapride.hibernalherbs.effect;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class BasicStatusEffect extends MobEffect {
    public BasicStatusEffect(MobEffectCategory category, int colour) {
        super(category, colour);
    }

    public BasicStatusEffect(MobEffectCategory category, int colour, ParticleOptions particleOptions) {
        super(category, colour, particleOptions);
    }


}
