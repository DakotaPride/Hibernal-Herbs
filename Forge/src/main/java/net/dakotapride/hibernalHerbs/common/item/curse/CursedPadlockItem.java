package net.dakotapride.hibernalHerbs.common.item.curse;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.Constants;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.registry.ItemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;

public class CursedPadlockItem extends Item implements ICurioItem, ITooltipProvider {
    public CursedPadlockItem(Properties properties) {
        super(properties);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (stack.is(ItemRegistry.AVARICE_PADLOCK_BOUND.get())) {
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.LUCK, 40, 1));
        } else if (stack.is(ItemRegistry.GOURMANDIZING_PADLOCK_BOUND.get())) {
            slotContext.entity().removeEffect(MobEffects.HUNGER);
        } else if (stack.is(ItemRegistry.PIQUE_PADLOCK_BOUND.get())) {
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 1));
        } else if (stack.is(ItemRegistry.APATHY_PADLOCK_BOUND.get())) {
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 0));
        } else if (stack.is(ItemRegistry.SALACIOUS_PADLOCK_BOUND.get())) {
            if (slotContext.entity().hasEffect(MobEffects.POISON)) {
                slotContext.entity().removeEffect(MobEffects.POISON);
            } else if (slotContext.entity().hasEffect(MobEffects.WITHER)) {
                slotContext.entity().removeEffect(MobEffects.WITHER);
            }
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> atts = HashMultimap.create();

        if (stack.is(ItemRegistry.VEXATION_PADLOCK_BOUND.get())) {
            atts.put(Attributes.MAX_HEALTH, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":wrath_health",
                            3, AttributeModifier.Operation.ADDITION));
            atts.put(Attributes.ATTACK_DAMAGE, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":wrath_damage",
                            4, AttributeModifier.Operation.ADDITION));
        } else if (stack.is(ItemRegistry.PIQUE_PADLOCK_BOUND.get())) {
            atts.put(Attributes.MAX_HEALTH, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":pride_health",
                            5, AttributeModifier.Operation.ADDITION));
        } else if (stack.is(ItemRegistry.GOURMANDIZING_PADLOCK_BOUND.get())) {
            atts.put(Attributes.MAX_HEALTH, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":gluttony_health",
                            7, AttributeModifier.Operation.ADDITION));
        } else if (stack.is(ItemRegistry.AVARICE_PADLOCK_BOUND.get())) {
            atts.put(Attributes.MAX_HEALTH, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":greed_health",
                            9, AttributeModifier.Operation.ADDITION));
        } else if (stack.is(ItemRegistry.SPITEFUL_PADLOCK_BOUND.get())) {
            atts.put(Attributes.MAX_HEALTH, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":envy_health",
                            11, AttributeModifier.Operation.ADDITION));
            atts.put(Attributes.MOVEMENT_SPEED, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":envy_movement",
                            0.04, AttributeModifier.Operation.ADDITION));
        } else if (stack.is(ItemRegistry.APATHY_PADLOCK_BOUND.get())) {
            atts.put(Attributes.MAX_HEALTH, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":sloth_health",
                            2, AttributeModifier.Operation.ADDITION));
            atts.put(Attributes.MOVEMENT_SPEED, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":sloth_movement",
                            -0.02, AttributeModifier.Operation.ADDITION));
        } else if (stack.is(ItemRegistry.SALACIOUS_PADLOCK_BOUND.get())) {
            atts.put(Attributes.MAX_HEALTH, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":lust_health",
                            11, AttributeModifier.Operation.ADDITION));
        }


        return atts;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag tooltipFlag) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Component.translatable(shiftControlsText).withStyle(ChatFormatting.DARK_GRAY));
            tooltip.add(Component.literal(""));
        } else if (Screen.hasShiftDown()) {
            getBoundPrinceFromTooltip(stack, tooltip);
            tooltip.add(Component.literal(""));

            if (!Screen.hasAltDown()) {
                tooltip.add(Component.translatable(leftAltControlsText).withStyle(ChatFormatting.DARK_GRAY));
            } else if (Screen.hasAltDown()) {

                if (stack.is(HibernalHerbsForge.BOUND_PADLOCKS_TAG)) {
                    tooltip.add(Component.literal(""));
                    getBoundPadlockAssistance(stack, tooltip);
                }

                if (stack.is(HibernalHerbsForge.PADLOCKS_TAG)) {
                    tooltip.add(Component.literal(""));
                    getUnboundPadlockAssistance(stack, tooltip);
                }
            }

            if (stack.is(HibernalHerbsForge.BOUND_PADLOCKS_TAG)) {
                tooltip.add(Component.literal(""));
            }

        }
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        if (slotContext.entity() instanceof ServerPlayer serverPlayer) {
            getUnholyBlessingFromPrince(stack, serverPlayer);
        }
    }

    public static void getUnboundPadlockAssistance(ItemStack stack, List<Component> tooltip) {
        String getPrince = BoundPrinces.NONE.getPrince();

        if (stack.is(ItemRegistry.VEXATION_PADLOCK.get())) {
            getPrince = BoundPrinces.WRATH.getPrince();
        } else if (stack.is(ItemRegistry.PIQUE_PADLOCK.get())) {
            getPrince = BoundPrinces.PRIDE.getPrince();
        } else if (stack.is(ItemRegistry.GOURMANDIZING_PADLOCK.get())) {
            getPrince = BoundPrinces.GLUTTONY.getPrince();
        } else if (stack.is(ItemRegistry.AVARICE_PADLOCK.get())) {
            getPrince = BoundPrinces.GREED.getPrince();
        } else if (stack.is(ItemRegistry.SPITEFUL_PADLOCK.get())) {
            getPrince = BoundPrinces.ENVY.getPrince();
        } else if (stack.is(ItemRegistry.APATHY_PADLOCK.get())) {
            getPrince = BoundPrinces.SLOTH.getPrince();
        } else if (stack.is(ItemRegistry.SALACIOUS_PADLOCK.get())) {
            getPrince = BoundPrinces.LUST.getPrince();
        }

        tooltip.add(Component.translatable("text.hibernalherbs.padlock.unbound.help.one").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.unbound.help.two", Component.translatable(getPrince)).withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.unbound.help.three").withStyle(ChatFormatting.DARK_PURPLE));
    }

    public static void getBoundPadlockAssistance(ItemStack stack, List<Component> tooltip) {

        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.help.one").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.help.two").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.help.three").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.help.four").withStyle(ChatFormatting.DARK_PURPLE));

        tooltip.add(Component.literal(""));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.abilities.help.one").withStyle(ChatFormatting.DARK_PURPLE));
        tooltip.add(Component.translatable("text.hibernalherbs.padlock.bound.abilities.help.two").withStyle(ChatFormatting.DARK_PURPLE));
    }

    public static void getBoundPrinceFromTooltip(ItemStack stack, List<Component> tooltip) {
        String boundPrince = BoundPrinces.NONE.getPrince();

        if (stack.is(ItemRegistry.VEXATION_PADLOCK_BOUND.get())) {
            boundPrince = BoundPrinces.WRATH.getPrince();
        } else if (stack.is(ItemRegistry.PIQUE_PADLOCK_BOUND.get())) {
            boundPrince = BoundPrinces.PRIDE.getPrince();
        } else if (stack.is(ItemRegistry.GOURMANDIZING_PADLOCK_BOUND.get())) {
            boundPrince = BoundPrinces.GLUTTONY.getPrince();
        } else if (stack.is(ItemRegistry.AVARICE_PADLOCK_BOUND.get())) {
            boundPrince = BoundPrinces.GREED.getPrince();
        } else if (stack.is(ItemRegistry.SPITEFUL_PADLOCK_BOUND.get())) {
            boundPrince = BoundPrinces.ENVY.getPrince();
        } else if (stack.is(ItemRegistry.APATHY_PADLOCK_BOUND.get())) {
            boundPrince = BoundPrinces.SLOTH.getPrince();
        } else if (stack.is(ItemRegistry.SALACIOUS_PADLOCK_BOUND.get())) {
            boundPrince = BoundPrinces.LUST.getPrince();
        }

        tooltip.add(Component.translatable("text.hibernalherbs.padlock.get_prince", Component.translatable(boundPrince)).withStyle(ChatFormatting.GRAY));
    }

    public static void getUnholyBlessingFromPrince(ItemStack stack, ServerPlayer serverPlayer) {
        String unholyBlessing = BoundPrinces.NONE.getSinFromPrince();

        if (stack.is(ItemRegistry.VEXATION_PADLOCK_BOUND.get())) {
            unholyBlessing = BoundPrinces.WRATH.getSinFromPrince();
        } else if (stack.is(ItemRegistry.PIQUE_PADLOCK_BOUND.get())) {
            unholyBlessing = BoundPrinces.PRIDE.getSinFromPrince();
        } else if (stack.is(ItemRegistry.GOURMANDIZING_PADLOCK_BOUND.get())) {
            unholyBlessing = BoundPrinces.GLUTTONY.getSinFromPrince();
        } else if (stack.is(ItemRegistry.AVARICE_PADLOCK_BOUND.get())) {
            unholyBlessing = BoundPrinces.GREED.getSinFromPrince();
        } else if (stack.is(ItemRegistry.SPITEFUL_PADLOCK_BOUND.get())) {
            unholyBlessing = BoundPrinces.ENVY.getSinFromPrince();
        } else if (stack.is(ItemRegistry.APATHY_PADLOCK_BOUND.get())) {
            unholyBlessing = BoundPrinces.SLOTH.getSinFromPrince();
        } else if (stack.is(ItemRegistry.SALACIOUS_PADLOCK_BOUND.get())) {
            unholyBlessing = BoundPrinces.LUST.getSinFromPrince();
        }

        serverPlayer.displayClientMessage(Component.translatable("text.hibernalherbs.padlock.unholy_blessing", Component.translatable(unholyBlessing)).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC), false);
    }
}