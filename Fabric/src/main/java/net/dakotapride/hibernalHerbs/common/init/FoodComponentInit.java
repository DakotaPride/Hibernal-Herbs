package net.dakotapride.hibernalHerbs.common.init;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponentInit {

    public static final FoodComponent POUNDED_HERB = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.3F).build();

    public static final FoodComponent REGENERATIVE_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 1), 1.0f).build();
    public static final FoodComponent VIRULENT_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 1), 1.0f).build();
    public static final FoodComponent SEDATING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 1), 1.0f).build();
    public static final FoodComponent HINDERING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 300, 1), 1.0f).build();
    public static final FoodComponent DASHING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 300, 1), 1.0f).build();
    public static final FoodComponent ACCELERATION_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 1), 1.0f).build();
    public static final FoodComponent INCINERATING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F).build();
    public static final FoodComponent DECAYING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 1), 1.0f).build();
    public static final FoodComponent OBSERVING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 1), 1.0f).build();
    public static final FoodComponent DIMINISHED_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 1), 1.0f).build();
    public static final FoodComponent SHADED_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 300, 1), 1.0f).build();

    // Resource Depe- Y'know What? This Has Been Typed Too Many Times Already

    public static final FoodComponent CONFLICTING_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 1), 1.0f).build();
    public static final FoodComponent ALTERNATIVE_BLEND = (new FoodComponent.Builder()).alwaysEdible().hunger(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 420, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 420, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 420, 1), 1.0f).build();

}