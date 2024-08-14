package net.dakotapride.hibernalHerbs.common.item.curse;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.Utilities;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;


public class CursedPadlockItem extends TrinketItem implements ITooltipProvider {
    public CursedPadlockItem(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (stack.isOf(ItemInit.BOUND_GREED_PADLOCK)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 40, 1));
        } else if (stack.isOf(ItemInit.BOUND_GLUTTONY_PADLOCK)) {
            entity.removeStatusEffect(StatusEffects.HUNGER);
        } else if (stack.isOf(ItemInit.BOUND_PRIDE_PADLOCK)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 1));
        } else if (stack.isOf(ItemInit.BOUND_SLOTH_PADLOCK)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 40, 0));
        } else if (stack.isOf(ItemInit.BOUND_LUST_PADLOCK)) {
            if (entity.hasStatusEffect(StatusEffects.POISON)) {
                entity.removeStatusEffect(StatusEffects.POISON);
            } else if (entity.hasStatusEffect(StatusEffects.WITHER)) {
                entity.removeStatusEffect(StatusEffects.WITHER);
            }
        }
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getModifiers(stack, slot, entity, uuid);

        EntityAttributeModifier baseHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:base_health",
                8, EntityAttributeModifier.Operation.ADDITION);
        EntityAttributeModifier baseAttackDamageModifier = new EntityAttributeModifier(uuid, "hibernalherbs:base_attack_damage",
                4, EntityAttributeModifier.Operation.ADDITION);
        // Unused
//        EntityAttributeModifier baseMovementSpeedModifier = new EntityAttributeModifier(uuid, "hibernalherbs:base_movement_speed",
//                0.02, EntityAttributeModifier.Operation.ADDITION);

        EntityAttributeModifier prideHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:pride_health_modifier",
                10, EntityAttributeModifier.Operation.ADDITION);
        EntityAttributeModifier envyHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:envy_health_modifier",
                6, EntityAttributeModifier.Operation.ADDITION);
        EntityAttributeModifier lustHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:lust_health_modifier",
                10, EntityAttributeModifier.Operation.ADDITION);
        EntityAttributeModifier gluttonyMovementSpeedModifier = new EntityAttributeModifier(uuid, "hibernalherbs:gluttony_movement_speed_modifier",
                -0.02, EntityAttributeModifier.Operation.ADDITION);
        EntityAttributeModifier envyMovementSpeedModifier = new EntityAttributeModifier(uuid, "hibernalherbs:envy_movement_speed_modifier",
                0.04, EntityAttributeModifier.Operation.ADDITION);
        EntityAttributeModifier slothMovementSpeedModifier = new EntityAttributeModifier(uuid, "hibernalherbs:sloth_movement_speed_modifier",
                -0.04, EntityAttributeModifier.Operation.ADDITION);

        if (stack.isOf(ItemInit.BOUND_WRATH_PADLOCK)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, baseHealthModifier);
            modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, baseAttackDamageModifier);
        } else if (stack.isOf(ItemInit.BOUND_PRIDE_PADLOCK)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, prideHealthModifier);
        } else if (stack.isOf(ItemInit.BOUND_GLUTTONY_PADLOCK)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, baseHealthModifier);
            modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, gluttonyMovementSpeedModifier);
        } else if (stack.isOf(ItemInit.BOUND_GREED_PADLOCK)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, baseHealthModifier);
        } else if (stack.isOf(ItemInit.BOUND_ENVY_PADLOCK)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, envyHealthModifier);
            modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, envyMovementSpeedModifier);
        } else if (stack.isOf(ItemInit.BOUND_SLOTH_PADLOCK)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, baseHealthModifier);
            modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, slothMovementSpeedModifier);
        } else if (stack.isOf(ItemInit.BOUND_LUST_PADLOCK)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, lustHealthModifier);
        }

        return modifiers;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(shiftControlsText).formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.literal(""));
        } else if (Screen.hasShiftDown()) {
            getBoundPrinceFromTooltip(stack, tooltip);
            tooltip.add(Text.literal(""));

            if (!Screen.hasAltDown()) {
                tooltip.add(Text.translatable(leftAltControlsText).formatted(Formatting.DARK_GRAY));
            } else if (Screen.hasAltDown()) {

                if (stack.isIn(Utilities.BOUND_PADLOCKS)) {
                    tooltip.add(Text.literal(""));
                    getBoundPadlockAssistance(tooltip);
                }

                if (stack.isIn(Utilities.PADLOCKS)) {
                    tooltip.add(Text.literal(""));
                    getUnboundPadlockAssistance(stack, tooltip);
                }
            }

            if (stack.isIn(Utilities.BOUND_PADLOCKS)) {
                tooltip.add(Text.literal(""));
            }

        }
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof ServerPlayerEntity serverPlayer) {
            getUnholyBlessingFromPrince(stack, serverPlayer);
        }
    }

    public static void getUnboundPadlockAssistance(ItemStack stack, List<Text> tooltip) {
        String tt_mod = BoundPrinces.NONE.getPrince();

        if (stack.isOf(ItemInit.BOUND_WRATH_PADLOCK)) {
            tt_mod = BoundPrinces.WRATH.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_PRIDE_PADLOCK)) {
            tt_mod = BoundPrinces.PRIDE.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_GLUTTONY_PADLOCK)) {
            tt_mod = BoundPrinces.GLUTTONY.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_GREED_PADLOCK)) {
            tt_mod = BoundPrinces.GREED.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_ENVY_PADLOCK)) {
            tt_mod = BoundPrinces.ENVY.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_SLOTH_PADLOCK)) {
            tt_mod = BoundPrinces.SLOTH.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_LUST_PADLOCK)) {
            tt_mod = BoundPrinces.LUST.getPrince();
        }

        tooltip.add(Text.translatable("text.hibernalherbs.padlock.unbound.help.one").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.unbound.help.two", Text.translatable(tt_mod)).formatted(Formatting.DARK_PURPLE));
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

    public static void getBoundPrinceFromTooltip(ItemStack stack, List<Text> tooltip) {
        String tt_mod = BoundPrinces.NONE.getPrince();

        if (stack.isOf(ItemInit.BOUND_WRATH_PADLOCK)) {
            tt_mod = BoundPrinces.WRATH.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_PRIDE_PADLOCK)) {
            tt_mod = BoundPrinces.PRIDE.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_GLUTTONY_PADLOCK)) {
            tt_mod = BoundPrinces.GLUTTONY.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_GREED_PADLOCK)) {
            tt_mod = BoundPrinces.GREED.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_ENVY_PADLOCK)) {
            tt_mod = BoundPrinces.ENVY.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_SLOTH_PADLOCK)) {
            tt_mod = BoundPrinces.SLOTH.getPrince();
        } else if (stack.isOf(ItemInit.BOUND_LUST_PADLOCK)) {
            tt_mod = BoundPrinces.LUST.getPrince();
        }

        tooltip.add(Text.translatable("text.hibernalherbs.padlock.get_prince", Text.translatable(tt_mod)).formatted(Formatting.GRAY));
    }

    public static void getUnholyBlessingFromPrince(ItemStack stack, ServerPlayerEntity serverPlayer) {
        String tt_mod = BoundPrinces.NONE.getSinFromPrince();

        if (stack.isOf(ItemInit.BOUND_WRATH_PADLOCK)) {
            tt_mod = BoundPrinces.WRATH.getSinFromPrince();
        } else if (stack.isOf(ItemInit.BOUND_PRIDE_PADLOCK)) {
            tt_mod = BoundPrinces.PRIDE.getSinFromPrince();
        } else if (stack.isOf(ItemInit.BOUND_GLUTTONY_PADLOCK)) {
            tt_mod = BoundPrinces.GLUTTONY.getSinFromPrince();
        } else if (stack.isOf(ItemInit.BOUND_GREED_PADLOCK)) {
            tt_mod = BoundPrinces.GREED.getSinFromPrince();
        } else if (stack.isOf(ItemInit.BOUND_ENVY_PADLOCK)) {
            tt_mod = BoundPrinces.ENVY.getSinFromPrince();
        } else if (stack.isOf(ItemInit.BOUND_SLOTH_PADLOCK)) {
            tt_mod = BoundPrinces.SLOTH.getSinFromPrince();
        } else if (stack.isOf(ItemInit.BOUND_LUST_PADLOCK)) {
            tt_mod = BoundPrinces.LUST.getSinFromPrince();
        }

        serverPlayer.sendMessage(Text.translatable("text.hibernalherbs.padlock.unholy_blessing", Text.translatable(tt_mod)).formatted(Formatting.GRAY).formatted(Formatting.ITALIC), false);
    }
}
