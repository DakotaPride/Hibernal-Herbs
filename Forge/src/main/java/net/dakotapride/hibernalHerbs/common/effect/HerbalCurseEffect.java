package net.dakotapride.hibernalHerbs.common.effect;

import net.dakotapride.hibernalHerbs.common.registry.effectRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class HerbalCurseEffect extends MobEffect {
    public HerbalCurseEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (this == effectRegistry.SCENTED_HERBAL_CURSE.get()) {
            if (entity.getHealth() < entity.getMaxHealth()) {
                entity.heal(2.0f);
            }
        } else if (this == effectRegistry.BITTER_HERBAL_CURSE.get() && entity instanceof Player) {
            ((Player)entity).causeFoodExhaustion(0.05f * (float)(amplifier + 1.5));
        } else if (this == effectRegistry.SOUR_HERBAL_CURSE.get()) {
            entity.hurt(DamageSource.MAGIC, 1.0f);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        if (this == effectRegistry.SCENTED_HERBAL_CURSE.get()) {
            int i = 50 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            }
            return true;
        }
        if (this == effectRegistry.SOUR_HERBAL_CURSE.get()) {
            int i = 25 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            }
            return true;
        }

        return this == effectRegistry.BITTER_HERBAL_CURSE.get();
    }
}
