package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.effect.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.stats.StatType;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@SuppressWarnings({"unused"})
public class StatusEffectInit {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, HibernalHerbsMod.MOD_ID);
    //public static MobEffect SANGUINE = register("sanguine", new SanguineStatusEffect());

    public static final DeferredHolder<MobEffect, MobEffect> SANGUINE = register("sanguine", () -> new SiphonHealthStatusEffect(0.76F, 0xE05974)
            .addAttributeModifier(Attributes.MAX_HEALTH, HibernalHerbsMod.asResource("effect.sanguine.max_health"), -4.0D, AttributeModifier.Operation.ADD_VALUE));
    public static final DeferredHolder<MobEffect, MobEffect> LETHARGY = register("lethargy", () -> new ApplyEffectOnAttackStatusEffect(MobEffects.MOVEMENT_SLOWDOWN, 0x92C8D1)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, HibernalHerbsMod.asResource("effect.lethargy.movement_speed"), -0.15F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    public static final DeferredHolder<MobEffect, MobEffect> BARBARIC = register("barbaric", () -> new BasicStatusEffect(MobEffectCategory.NEUTRAL, 0xD69489)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, HibernalHerbsMod.asResource("effect.barbaric.movement_speed"), 0.05F, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ATTACK_DAMAGE, HibernalHerbsMod.asResource("effect.barbaric.attack_damage"), 0.15F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    public static final DeferredHolder<MobEffect, MobEffect> DEVOTION = register("devotion", () -> new BasicStatusEffect(MobEffectCategory.NEUTRAL, 0xC095D6)
            .addAttributeModifier(Attributes.MAX_HEALTH, HibernalHerbsMod.asResource("effect.devotion.max_health"), 4.0D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    public static final DeferredHolder<MobEffect, MobEffect> RAPACITY = register("rapacity", () -> new BasicStatusEffect(MobEffectCategory.NEUTRAL, 0xAEDB7A));
    public static final DeferredHolder<MobEffect, MobEffect> ESURIENT = register("esurient", () -> new BasicStatusEffect(MobEffectCategory.NEUTRAL, 0xAEDB7A)
            .addAttributeModifier(Attributes.SNEAKING_SPEED, HibernalHerbsMod.asResource("effect.esurient.sneaking_speed"), -0.15F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    public static final DeferredHolder<MobEffect, MobEffect> MIMICRY = register("mimicry", MimicryStatusEffect::new);

    public static final DeferredHolder<MobEffect, MobEffect> FROST_RESISTANCE = register("frost_resistance", () -> new BasicStatusEffect(MobEffectCategory.BENEFICIAL, 0xAEC9E5));

    public static final DeferredHolder<MobEffect, MobEffect> SWARMING = register("swarming", () -> new SwarmingStatusEffect(MobEffectCategory.HARMFUL,
            0xEDC343, 0.40F, randomSource -> Mth.randomBetweenInclusive(randomSource, 1, 2)));
    public static final DeferredHolder<MobEffect, MobEffect> INSTABILITY = register("instability", () -> new InstabilityStatusEffect(MobEffectCategory.HARMFUL,
            0xDB88F7));
    public static final DeferredHolder<MobEffect, MobEffect> SHRIEKING = register("shrieking", () -> new ShriekingStatusEffect(MobEffectCategory.HARMFUL,
            0x111B21, 0.01F));

    // Collective Registration
    public static void register(IEventBus bus) {
        EFFECTS.register(bus);
    }

    private static DeferredHolder<MobEffect, MobEffect> register(String string, Supplier<MobEffect> mobEffect) {
        return EFFECTS.register(string, mobEffect);
        //return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, HibernalHerbsMod.asResource(string), mobEffect);
    }

//    public static MobEffect register(String name, MobEffect item) {
//        return Registry.register(BuiltInRegistries.MOB_EFFECT, HibernalHerbsMod.asResource(name), item);
//    }
}
