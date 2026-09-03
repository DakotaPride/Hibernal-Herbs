package net.dakotapride.hibernalherbs.effect;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class ApplyEffectFromHealthStatusEffect extends BasicStatusEffect {
    MobEffect effect;
    double str;
    public ApplyEffectFromHealthStatusEffect(MobEffect effect, double str, int colour) {
        super(MobEffectCategory.NEUTRAL, colour);
        this.effect = effect;
        this.str = str;
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int i) {
        if (livingEntity.getHealth() < (livingEntity.getMaxHealth() * 0.75) && livingEntity.getHealth() > (livingEntity.getMaxHealth() * 0.50)) {
            //this.addAttributeModifier(attribute, HibernalHerbsMod.asResource("effect." + this.getDescriptionId() + ".health_modifier"), str, AttributeModifier.Operation.ADD_VALUE);

            livingEntity.addEffect(new MobEffectInstance(effect, (20 * 2), i));
        }
        if (livingEntity.getHealth() < (livingEntity.getMaxHealth() * 0.50) && livingEntity.getHealth() > (livingEntity.getMaxHealth() * 0.25)) {
            //this.addAttributeModifier(attribute, HibernalHerbsMod.asResource("effect." + this.getDescriptionId() + ".health_modifier"), str * 1.5, AttributeModifier.Operation.ADD_VALUE);

            livingEntity.addEffect(new MobEffectInstance(effect, (20 * 2), i + 1));
        }
        if (livingEntity.getHealth() < (livingEntity.getMaxHealth() * 0.25)) {
            //this.addAttributeModifier(attribute, HibernalHerbsMod.asResource("effect." + this.getDescriptionId() + ".health_modifier"), str * 2.0, AttributeModifier.Operation.ADD_VALUE);

            livingEntity.addEffect(new MobEffectInstance(effect, (20 * 2), i + 2));
        }
    }
}
