package net.dakotapride.hibernalHerbs.common.item.curse;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.util;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemStackSet;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.MutableText;
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
        if (stack.isOf(ItemInit.AVARICE_PADLOCK_BOUND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 40, 1));
        } else if (stack.isOf(ItemInit.GOURMANDIZING_PADLOCK_BOUND)) {
            entity.removeStatusEffect(StatusEffects.HUNGER);
        } else if (stack.isOf(ItemInit.PIQUE_PADLOCK_BOUND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 1));
        } else if (stack.isOf(ItemInit.APATHY_PADLOCK_BOUND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 40, 0));
        } else if (stack.isOf(ItemInit.SALACIOUS_PADLOCK_BOUND)) {
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

        EntityAttributeModifier wrathHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:wrath_health",
                0.15, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        EntityAttributeModifier wrathAttackDamageModifier = new EntityAttributeModifier(uuid, "hibernalherbs:wrath_damage",
                0.25, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        EntityAttributeModifier prideHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:pride_health",
                0.25, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        EntityAttributeModifier gluttonyHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:gluttony_health",
                0.35, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        EntityAttributeModifier greedHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:greed_health",
                0.45, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        EntityAttributeModifier envyHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:envy_health",
                0.55, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        EntityAttributeModifier envyMovementModifier = new EntityAttributeModifier(uuid, "hibernalherbs:envy_movement",
                0.04, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        EntityAttributeModifier slothHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:sloth_health",
                0.1, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        EntityAttributeModifier slothMovementModifier = new EntityAttributeModifier(uuid, "hibernalherbs:sloth_movement",
                -0.02, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        EntityAttributeModifier lustHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:lust_health",
                0.55, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        if (stack.isOf(ItemInit.VEXATION_PADLOCK_BOUND)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, wrathHealthModifier);
            modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, wrathAttackDamageModifier);
        } else if (stack.isOf(ItemInit.PIQUE_PADLOCK_BOUND)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, prideHealthModifier);
        } else if (stack.isOf(ItemInit.GOURMANDIZING_PADLOCK_BOUND)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, gluttonyHealthModifier);
        } else if (stack.isOf(ItemInit.AVARICE_PADLOCK_BOUND)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, greedHealthModifier);
        } else if (stack.isOf(ItemInit.SPITEFUL_PADLOCK_BOUND)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, envyHealthModifier);
            modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, envyMovementModifier);
        } else if (stack.isOf(ItemInit.APATHY_PADLOCK_BOUND)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, slothHealthModifier);
            modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, slothMovementModifier);
        } else if (stack.isOf(ItemInit.SALACIOUS_PADLOCK_BOUND)) {
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

                if (stack.isIn(util.BOUND_PADLOCKS)) {
                    tooltip.add(Text.literal(""));
                    getBoundPadlockAssistance(stack, tooltip);
                }

                if (stack.isIn(util.PADLOCKS)) {
                    tooltip.add(Text.literal(""));
                    getUnboundPadlockAssistance(stack, tooltip);
                }
            }

            if (stack.isIn(util.BOUND_PADLOCKS)) {
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
        String getPrince = BoundPrinces.NONE.getPrince();

        if (stack.isOf(ItemInit.VEXATION_PADLOCK)) {
            getPrince = BoundPrinces.WRATH.getPrince();
        } else if (stack.isOf(ItemInit.PIQUE_PADLOCK)) {
            getPrince = BoundPrinces.PRIDE.getPrince();
        } else if (stack.isOf(ItemInit.GOURMANDIZING_PADLOCK)) {
            getPrince = BoundPrinces.GLUTTONY.getPrince();
        } else if (stack.isOf(ItemInit.AVARICE_PADLOCK)) {
            getPrince = BoundPrinces.GREED.getPrince();
        } else if (stack.isOf(ItemInit.SPITEFUL_PADLOCK)) {
            getPrince = BoundPrinces.ENVY.getPrince();
        } else if (stack.isOf(ItemInit.APATHY_PADLOCK)) {
            getPrince = BoundPrinces.SLOTH.getPrince();
        } else if (stack.isOf(ItemInit.SALACIOUS_PADLOCK)) {
            getPrince = BoundPrinces.LUST.getPrince();
        }

        tooltip.add(Text.translatable("text.hibernalherbs.padlock.unbound.help.one").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.unbound.help.two", Text.translatable(getPrince)).formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.unbound.help.three").formatted(Formatting.DARK_PURPLE));
    }

    public static void getBoundPadlockAssistance(ItemStack stack, List<Text> tooltip) {

        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.help.one").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.help.two").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.help.three").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.help.four").formatted(Formatting.DARK_PURPLE));

        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.abilities.help.one").formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.translatable("text.hibernalherbs.padlock.bound.abilities.help.two").formatted(Formatting.DARK_PURPLE));
    }

    public static void getBoundPrinceFromTooltip(ItemStack stack, List<Text> tooltip) {
        String boundPrince = BoundPrinces.NONE.getPrince();

        if (stack.isOf(ItemInit.VEXATION_PADLOCK_BOUND)) {
            boundPrince = BoundPrinces.WRATH.getPrince();
        } else if (stack.isOf(ItemInit.PIQUE_PADLOCK_BOUND)) {
            boundPrince = BoundPrinces.PRIDE.getPrince();
        } else if (stack.isOf(ItemInit.GOURMANDIZING_PADLOCK_BOUND)) {
            boundPrince = BoundPrinces.GLUTTONY.getPrince();
        } else if (stack.isOf(ItemInit.AVARICE_PADLOCK_BOUND)) {
            boundPrince = BoundPrinces.GREED.getPrince();
        } else if (stack.isOf(ItemInit.SPITEFUL_PADLOCK_BOUND)) {
            boundPrince = BoundPrinces.ENVY.getPrince();
        } else if (stack.isOf(ItemInit.APATHY_PADLOCK_BOUND)) {
            boundPrince = BoundPrinces.SLOTH.getPrince();
        } else if (stack.isOf(ItemInit.SALACIOUS_PADLOCK_BOUND)) {
            boundPrince = BoundPrinces.LUST.getPrince();
        }

        tooltip.add(Text.translatable("text.hibernalherbs.padlock.get_prince", Text.translatable(boundPrince)).formatted(Formatting.GRAY));
    }

    public static void getUnholyBlessingFromPrince(ItemStack stack, ServerPlayerEntity serverPlayer) {
        String unholyBlessing = BoundPrinces.NONE.getSinFromPrince();

        if (stack.isOf(ItemInit.VEXATION_PADLOCK_BOUND)) {
            unholyBlessing = BoundPrinces.WRATH.getSinFromPrince();
        } else if (stack.isOf(ItemInit.PIQUE_PADLOCK_BOUND)) {
            unholyBlessing = BoundPrinces.PRIDE.getSinFromPrince();
        } else if (stack.isOf(ItemInit.GOURMANDIZING_PADLOCK_BOUND)) {
            unholyBlessing = BoundPrinces.GLUTTONY.getSinFromPrince();
        } else if (stack.isOf(ItemInit.AVARICE_PADLOCK_BOUND)) {
            unholyBlessing = BoundPrinces.GREED.getSinFromPrince();
        } else if (stack.isOf(ItemInit.SPITEFUL_PADLOCK_BOUND)) {
            unholyBlessing = BoundPrinces.ENVY.getSinFromPrince();
        } else if (stack.isOf(ItemInit.APATHY_PADLOCK_BOUND)) {
            unholyBlessing = BoundPrinces.SLOTH.getSinFromPrince();
        } else if (stack.isOf(ItemInit.SALACIOUS_PADLOCK_BOUND)) {
            unholyBlessing = BoundPrinces.LUST.getSinFromPrince();
        }

        serverPlayer.sendMessage(Text.translatable("text.hibernalherbs.padlock.unholy_blessing", Text.translatable(unholyBlessing)).formatted(Formatting.GRAY).formatted(Formatting.ITALIC), false);
    }
}
