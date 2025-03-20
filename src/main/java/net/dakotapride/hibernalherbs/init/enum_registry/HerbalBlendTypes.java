package net.dakotapride.hibernalherbs.init.enum_registry;

import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.dakotapride.hibernalherbs.item.HerbalBlendItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.Locale;

@SuppressWarnings({"unused"})
public enum HerbalBlendTypes {
    NONE("text.nothing_to_see_here.null_registry"),
    REGENERATION(MobEffects.REGENERATION, 400, 1),
    POISON(MobEffects.POISON, 400, 1),
    SLOWNESS(MobEffects.MOVEMENT_SLOWDOWN, 400, 1),
    MINING_FATIGUE(MobEffects.DIG_SLOWDOWN, 400, 1),
    HASTE(MobEffects.DIG_SPEED, 400, 1),
    SPEED(MobEffects.MOVEMENT_SPEED, 400, 1),
    FIRE(),
    WITHER(MobEffects.WITHER, 400, 1),
    NIGHT_VISION(MobEffects.NIGHT_VISION, 400, 1),
    WEAKNESS(MobEffects.WEAKNESS, 400, 1),
    BLINDNESS(MobEffects.BLINDNESS, 400, 1),;

    public final String herbal_blend_id;

    public Item herbal_blend;
    //public Item smoked_herbal_blend;

    public FoodProperties.Builder food_properties;

    public Holder<MobEffect> effect0;
    public int duration_ticks;
    public int effect_amplifier;

    HerbalBlendTypes(Holder<MobEffect> effect0, int ticks, int amplifier) {
        this.herbal_blend_id = name().toLowerCase(Locale.ROOT);

        this.food_properties = new FoodProperties.Builder()
                .alwaysEdible().nutrition(7).saturationModifier(0.6f);

        this.herbal_blend = ItemInit.register(herbal_blend_id + "_herbal_blend", new HerbalBlendItem(new Item.Properties().stacksTo(1)
                .food(food_properties
                        .effect(new MobEffectInstance(effect0, ticks, amplifier), 1.0f).usingConvertsTo(Items.BOWL).build())));
//        this.smoked_herbal_blend = ItemInit.register("smoked_" + herbal_blend_id + "_herbal_blend", new HerbalBlendItem(new Item.Properties().stacksTo(1)
//                .food(food_properties
//                        .effect(new MobEffectInstance(effect0, (int) (ticks * 1.5f), amplifier + 1), 1.0f).build())));

        this.effect0 = effect0;
        this.duration_ticks = ticks;
        this.effect_amplifier = amplifier;
    }

    HerbalBlendTypes() {
        this.herbal_blend_id = name().toLowerCase(Locale.ROOT);

        this.food_properties = new FoodProperties.Builder()
                // No status effects to provide
                // .effect(new MobEffectInstance(effect0, ticks, amplifier), 1.0f)
                .alwaysEdible().nutrition(7).saturationModifier(0.6f);

        this.herbal_blend = ItemInit.register(herbal_blend_id + "_herbal_blend", new HerbalBlendItem(new Item.Properties().stacksTo(1).food(food_properties.usingConvertsTo(Items.BOWL).build())));
//        this.smoked_herbal_blend = ItemInit.register("smoked_" + herbal_blend_id + "_herbal_blend", new HerbalBlendItem(new Item.Properties().stacksTo(1).food(food_properties.build())));

    }

    HerbalBlendTypes(String nothing) {
        this.herbal_blend_id = name().toLowerCase(Locale.ROOT);

        // Create a default value for each non-registration field to avoid null errors
        this.effect0 = MobEffects.WITHER;
        this.duration_ticks = 2400;
        this.effect_amplifier = 3;

    }

    public Item getHerbalBlend() {
        return herbal_blend;
    }

//    public Item getSmokedHerbalBlend() {
//        return smoked_herbal_blend;
//    }

    public MobEffect getEffect0() {
        return effect0.value();
    }

    public int getDurationTicks() {
        return duration_ticks;
    }

    public int getDurationTicksFromInteraction() {
        return (int) (duration_ticks * 0.75f);
    }

    public int getEffectAmplifier() {
        return effect_amplifier;
    }

    public String getHerbalBlendId() {
        return herbal_blend_id;
    }

    public static void register() {}


    public static boolean checkHerbBlendType(ItemStack stack, HerbalBlendTypes type) {
        return stack.getItem() == type.getHerbalBlend() /*|| stack.getItem() == type.getSmokedHerbalBlend()*/;
    }

    public void checkEffects(LivingEntity entity, int ticks, int amplifier) {
        if (effect0 != null) {
            entity.addEffect(new MobEffectInstance(effect0, ticks, amplifier));
        }
    }

    public static void applyFromConsumption(ItemStack stack, LivingEntity entity, HerbalBlendTypes type) {
        if (HerbalBlendTypes.checkHerbBlendType(stack, type)) {
            type.checkEffects(entity, type.getDurationTicks(), type.getEffectAmplifier());
        }
    }

    public static void applyFromInteraction(ItemStack stack, LivingEntity entity, HerbalBlendTypes type) {
        if (HerbalBlendTypes.checkHerbBlendType(stack, type)) {
            type.checkEffects(entity, type.getDurationTicksFromInteraction(), type.getEffectAmplifier() - 1);
        }
    }


    // Tooltips

    public static void effectFromType(ItemStack stack, List<Component> tooltip, HerbalBlendTypes type) {
        MobEffect effect = MobEffects.REGENERATION.value();
        String ability;

        if (!HerbalBlendTypes.checkHerbBlendType(stack, HerbalBlendTypes.FIRE)) {
            if (HerbalBlendTypes.checkHerbBlendType(stack, type)) {
                effect = type.getEffect0();
            } else if (type == HerbalBlendTypes.NONE) {
                effect = HerbalBlendTypes.NONE.getEffect0();
            } else {
                effect = HerbalBlendTypes.NONE.getEffect0();
            }
        }

        if (HerbalBlendTypes.checkHerbBlendType(stack, type)) {
            ability = type.getHerbalBlendId();
        } else if (type == HerbalBlendTypes.NONE) {
            ability = HerbalBlendTypes.NONE.getHerbalBlendId();
        } else {
            ability = HerbalBlendTypes.NONE.getHerbalBlendId();
        }

        MutableComponent use_ability = Component.translatable("text.hibernalherbs.ability." + ability);

        tooltip.add(Component.translatable("text.hibernalherbs.blend.ability", use_ability).withStyle(ChatFormatting.GRAY));

        if (checkHerbBlendType(stack, HerbalBlendTypes.FIRE)) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend.provided_effect.fire").withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(Component.translatable("text.hibernalherbs.blend.provided_effect", effect.getDisplayName()).withStyle(ChatFormatting.GRAY));
        }
    }

    public static void applyToTooltip(ItemStack stack, List<Component> tooltip) {
        if (checkHerbBlendType(stack, HerbalBlendTypes.REGENERATION)) {
            HerbalBlendTypes.effectFromType(stack, tooltip, HerbalBlendTypes.REGENERATION);
        } else if (checkHerbBlendType(stack, HerbalBlendTypes.POISON)) {
            HerbalBlendTypes.effectFromType(stack, tooltip, HerbalBlendTypes.POISON);
        } else if (checkHerbBlendType(stack, HerbalBlendTypes.SLOWNESS)) {
            HerbalBlendTypes.effectFromType(stack, tooltip, HerbalBlendTypes.SLOWNESS);
        } else if (checkHerbBlendType(stack, HerbalBlendTypes.MINING_FATIGUE)) {
            HerbalBlendTypes.effectFromType(stack, tooltip, HerbalBlendTypes.MINING_FATIGUE);
        } else if (checkHerbBlendType(stack, HerbalBlendTypes.HASTE)) {
            HerbalBlendTypes.effectFromType(stack, tooltip, HerbalBlendTypes.HASTE);
        } else if (checkHerbBlendType(stack, HerbalBlendTypes.SPEED)) {
            HerbalBlendTypes.effectFromType(stack, tooltip, HerbalBlendTypes.SPEED);
        } else if (checkHerbBlendType(stack, HerbalBlendTypes.WITHER)) {
            HerbalBlendTypes.effectFromType(stack, tooltip, HerbalBlendTypes.WITHER);
        } else if (checkHerbBlendType(stack, HerbalBlendTypes.NIGHT_VISION)) {
            HerbalBlendTypes.effectFromType(stack, tooltip, HerbalBlendTypes.NIGHT_VISION);
        } else if (checkHerbBlendType(stack, HerbalBlendTypes.WEAKNESS)) {
            HerbalBlendTypes.effectFromType(stack, tooltip, HerbalBlendTypes.WEAKNESS);
        } else if (checkHerbBlendType(stack, HerbalBlendTypes.BLINDNESS)) {
            HerbalBlendTypes.effectFromType(stack, tooltip, HerbalBlendTypes.BLINDNESS);
        } else if (checkHerbBlendType(stack, HerbalBlendTypes.FIRE)) {
            HerbalBlendTypes.effectFromType(stack, tooltip, HerbalBlendTypes.FIRE);
        }
    }
}
