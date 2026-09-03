package net.dakotapride.hibernalherbs.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class SiphonHealthStatusEffect extends BasicStatusEffect {
    float health_m;
    public SiphonHealthStatusEffect(float h, int colour) {
        super(MobEffectCategory.NEUTRAL, colour);
        this.health_m = h;
    }

    @Override
    public void addAttributeModifiers(LivingEntity livingEntity, AttributeMap attributeMap, int i) {
        super.addAttributeModifiers(livingEntity, attributeMap, i);
        livingEntity.setHealth(livingEntity.getMaxHealth() - (4 * i));
    }

    @Override
    public void removeAttributeModifiers(LivingEntity livingEntity, AttributeMap attributeMap, int i) {
        super.removeAttributeModifiers(livingEntity, attributeMap, i);
        if (livingEntity.getHealth() < livingEntity.getMaxHealth()) {
            livingEntity.setHealth(livingEntity.getMaxHealth());
        }
    }

    public float getHealthMultiplicative() {
        return health_m;
    }
}
