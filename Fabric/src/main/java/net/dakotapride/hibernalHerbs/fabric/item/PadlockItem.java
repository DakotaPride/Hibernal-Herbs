package net.dakotapride.hibernalherbs.fabric.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.dakotapride.hibernalherbs.client.ITooltipProvider;
import net.dakotapride.hibernalherbs.item.curse.Sins;
import net.dakotapride.hibernalherbs.registry.Utilities;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class PadlockItem extends TrinketItem implements ITooltipProvider {
    public Sins sin;

    public PadlockItem(Sins sin, Settings settings) {
        super(settings);
        this.sin = sin;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        // Utilize enum instead of hard-coded values
        // Function with Arch API

        switch (sin) {
            //case WRATH -> {}
            case PRIDE -> {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 1));
            }
            case LUST -> {
                if (entity.hasStatusEffect(StatusEffects.POISON)) {
                    entity.removeStatusEffect(StatusEffects.POISON);
                } else if (entity.hasStatusEffect(StatusEffects.WITHER)) {
                    entity.removeStatusEffect(StatusEffects.WITHER);
                }
            }
            case GLUTTONY -> {
                entity.removeStatusEffect(StatusEffects.HUNGER);
            }
            case GREED -> {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 40, 1));
            }
            //case ENVY -> {}
            case SLOTH -> {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 40, 0));
            }
        }

    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getModifiers(stack, slot, entity, uuid);

        EntityAttributeModifier wrath_health = Sins.createHealthAttribute(uuid, Sins.WRATH.getName(),
                3.0F, EntityAttributeModifier.Operation.ADDITION);
        EntityAttributeModifier wrath_damage = Sins.createDamageAttribute(uuid, Sins.WRATH.getName(),
                4.0F, EntityAttributeModifier.Operation.ADDITION);

        EntityAttributeModifier pride_health = Sins.createHealthAttribute(uuid, Sins.PRIDE.getName(),
                5.0F, EntityAttributeModifier.Operation.ADDITION);

        EntityAttributeModifier gluttony_health = Sins.createHealthAttribute(uuid, Sins.GLUTTONY.getName(),
                7.0F, EntityAttributeModifier.Operation.ADDITION);

        EntityAttributeModifier greed_health = Sins.createHealthAttribute(uuid, Sins.GREED.getName(),
                9.0F, EntityAttributeModifier.Operation.ADDITION);

        EntityAttributeModifier envy_health = Sins.createHealthAttribute(uuid, Sins.ENVY.getName(),
                11.0F, EntityAttributeModifier.Operation.ADDITION);
        EntityAttributeModifier envy_movement = Sins.createMovementAttribute(uuid, Sins.ENVY.getName(),
                0.04F, EntityAttributeModifier.Operation.ADDITION);

        EntityAttributeModifier sloth_health = Sins.createHealthAttribute(uuid, Sins.SLOTH.getName(),
                2.0F, EntityAttributeModifier.Operation.ADDITION);
        EntityAttributeModifier sloth_movement = Sins.createMovementAttribute(uuid, Sins.SLOTH.getName(),
                -0.02F, EntityAttributeModifier.Operation.ADDITION);

        EntityAttributeModifier lust_health = Sins.createHealthAttribute(uuid, Sins.LUST.getName(),
                11F, EntityAttributeModifier.Operation.ADDITION);

        switch (sin) {
            case WRATH -> {
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, wrath_health);
                modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, wrath_damage);
            }
            case PRIDE -> {
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, pride_health);
            }
            case LUST -> {
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, lust_health);
            }
            case GLUTTONY -> {
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, gluttony_health);
            }
            case GREED -> {
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, greed_health);
            }
            case ENVY -> {
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, envy_health);
                modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, envy_movement);
            }
            case SLOTH -> {
                modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, sloth_health);
                modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, sloth_movement);
            }
        }

        return modifiers;
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof ServerPlayerEntity serverPlayer) {
            getUnholyBlessingFromPrince(sin, serverPlayer);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(shiftControlsText).formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.literal(""));
        } else if (Screen.hasShiftDown()) {
            getBoundPrinceFromTooltip(sin, tooltip);
            tooltip.add(Text.literal(""));

            if (!Screen.hasAltDown()) {
                tooltip.add(Text.translatable(leftAltControlsText).formatted(Formatting.DARK_GRAY));
            } else if (Screen.hasAltDown()) {

                if (stack.isIn(Utilities.BOUND_PADLOCKS_ITEM_TAG)) {
                    tooltip.add(Text.literal(""));
                    getBoundPadlockAssistance(tooltip);
                }

                if (stack.isIn(Utilities.PADLOCKS_ITEM_TAG)) {
                    tooltip.add(Text.literal(""));
                    getUnboundPadlockAssistance(sin, tooltip);
                }
            }

            if (stack.isIn(Utilities.BOUND_PADLOCKS_ITEM_TAG)) {
                tooltip.add(Text.literal(""));
            }

        }
    }

    public static void getUnboundPadlockAssistance(Sins sins, List<Text> tooltip) {
        // To avoid tooltip errors if a prince is (for some reason) not present
        String prince = "none";

        switch (sins) {
            case WRATH -> {
                prince = Sins.WRATH.getName();
            }
            case PRIDE -> {
                prince = Sins.PRIDE.getName();
            }
            case LUST -> {
                prince = Sins.LUST.getName();
            }
            case GLUTTONY -> {
                prince = Sins.GLUTTONY.getName();
            }
            case GREED -> {
                prince = Sins.GREED.getName();
            }
            case ENVY -> {
                prince = Sins.ENVY.getName();
            }
            case SLOTH -> {
                prince = Sins.SLOTH.getName();
            }
        }

        tooltip.add(Text.translatable("text.hibernalherbs.padlock.unbound.help.one").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.unbound.help.two", Text.translatable(prince)).formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.unbound.help.three").formatted(Formatting.DARK_PURPLE));
    }

    public static void getBoundPadlockAssistance(List<Text> tooltip) {

        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.help.one").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.help.two").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.help.three").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.help.four").formatted(Formatting.DARK_PURPLE));

        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.abilities.help.one").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.abilities.help.two").formatted(Formatting.DARK_PURPLE));
    }

    private static String createTooltipText(String base, String sin) {
        return "text.hibernalherbs.padlock." + base + "." + sin;
    }

    private static String prince(String sin) {
        return createTooltipText("prince", sin);
    }

    private static String sin(String sin) {
        return createTooltipText("sin", sin);
    }

    public static void getBoundPrinceFromTooltip(Sins sins, List<Text> tooltip) {
        // To avoid tooltip errors if a prince is (for some reason) not present
        String prince = prince("none");

        switch (sins) {
            case WRATH -> {
                prince = prince(Sins.WRATH.getName());
            }
            case PRIDE -> {
                prince = prince(Sins.PRIDE.getName());
            }
            case LUST -> {
                prince = prince(Sins.LUST.getName());
            }
            case GLUTTONY -> {
                prince = prince(Sins.GLUTTONY.getName());
            }
            case GREED -> {
                prince = prince(Sins.GREED.getName());
            }
            case ENVY -> {
                prince = prince(Sins.ENVY.getName());
            }
            case SLOTH -> {
                prince = prince(Sins.SLOTH.getName());
            }
        }

        tooltip.add(Text.translatable("text.hibernalherbs.padlock.get_prince", Text.translatable(prince)).formatted(Formatting.GRAY));
    }

    public static void getUnholyBlessingFromPrince(Sins sins, ServerPlayerEntity serverPlayer) {
        // To avoid tooltip errors if a prince is (for some reason) not present
        String sin_text = sin("none");

        switch (sins) {
            case WRATH -> {
                sin_text = sin(Sins.WRATH.getName());
            }
            case PRIDE -> {
                sin_text = sin(Sins.PRIDE.getName());
            }
            case LUST -> {
                sin_text = sin(Sins.LUST.getName());
            }
            case GLUTTONY -> {
                sin_text = sin(Sins.GLUTTONY.getName());
            }
            case GREED -> {
                sin_text = sin(Sins.GREED.getName());
            }
            case ENVY -> {
                sin_text = sin(Sins.ENVY.getName());
            }
            case SLOTH -> {
                sin_text = sin(Sins.SLOTH.getName());
            }
        }

        serverPlayer.sendMessage(Text.translatable("text.hibernalherbs.padlock.unholy_blessing", Text.translatable(sin_text)).formatted(Formatting.GRAY).formatted(Formatting.ITALIC), false);
    }
}
