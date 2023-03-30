package net.dakotapride.hibernalHerbs.common.effect;

import net.dakotapride.hibernalHerbs.common.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class HerbalCurseEffect extends StatusEffect {
    public HerbalCurseEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (this == EffectInit.SCENTED_HERBAL_CURSE) {
            if (entity.getHealth() < entity.getMaxHealth()) {
                entity.heal(2.0f);
            }
        } else if (this == EffectInit.BITTER_HERBAL_CURSE && entity instanceof PlayerEntity) {
            ((PlayerEntity)entity).addExhaustion(0.05f * (float)(amplifier + 1.5));
        } else if (this == EffectInit.SOUR_HERBAL_CURSE) {
            entity.damage(DamageSource.MAGIC, 1.0f);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (this == EffectInit.SCENTED_HERBAL_CURSE) {
            int i = 50 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            }
            return true;
        }
        if (this == EffectInit.SOUR_HERBAL_CURSE) {
            int i = 25 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            }
            return true;
        }

        return this == EffectInit.BITTER_HERBAL_CURSE;
    }
}
