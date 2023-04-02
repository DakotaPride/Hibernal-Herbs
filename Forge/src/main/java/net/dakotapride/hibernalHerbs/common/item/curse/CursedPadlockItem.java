package net.dakotapride.hibernalHerbs.common.item.curse;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.dakotapride.hibernalHerbs.common.Constants;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;

public class CursedPadlockItem extends Item implements ICurioItem {
    public CursedPadlockItem(Properties properties) {
        super(properties);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (stack.is(itemRegistry.AVARICE_PADLOCK_BOUND.get())) {
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.LUCK, 40, 1));
        } else if (stack.is(itemRegistry.GOURMANDIZING_PADLOCK_BOUND.get())) {
            slotContext.entity().removeEffect(MobEffects.HUNGER);
        } else if (stack.is(itemRegistry.PIQUE_PADLOCK_BOUND.get())) {
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 1));
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> atts = HashMultimap.create();

        if (stack.is(itemRegistry.VEXATION_PADLOCK_BOUND.get())) {
            atts.put(Attributes.MAX_HEALTH, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":wrath_health",
                            2, AttributeModifier.Operation.ADDITION));
            atts.put(Attributes.ATTACK_DAMAGE, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":wrath_damage",
                            4, AttributeModifier.Operation.ADDITION));
        } else if (stack.is(itemRegistry.PIQUE_PADLOCK_BOUND.get())) {
            atts.put(Attributes.MAX_HEALTH, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":pride_health",
                            8, AttributeModifier.Operation.ADDITION));
        } else if (stack.is(itemRegistry.GOURMANDIZING_PADLOCK_BOUND.get())) {
            atts.put(Attributes.MAX_HEALTH, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":gluttony_health",
                            6, AttributeModifier.Operation.ADDITION));
        } else if (stack.is(itemRegistry.AVARICE_PADLOCK_BOUND.get())) {
            atts.put(Attributes.MAX_HEALTH, new AttributeModifier
                    (uuid, Constants.MOD_ID + ":greed_health",
                            12, AttributeModifier.Operation.ADDITION));
        }


        return atts;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag tooltipFlag) {
        if (stack.is(HibernalHerbsForge.PADLOCKS_TAG)) {
            tooltip.add(Component.translatable("text.hibernalherbs.padlocks.unbound").withStyle(ChatFormatting.GRAY));
        } else if (stack.is(HibernalHerbsForge.BOUND_PADLOCKS_TAG)) {
            if (stack.is(itemRegistry.VEXATION_PADLOCK_BOUND.get())) {
                tooltip.add(Component.translatable("text.hibernalherbs.padlocks.bound.wrath").withStyle(ChatFormatting.GRAY));
            } else if (stack.is(itemRegistry.PIQUE_PADLOCK_BOUND.get())) {
                tooltip.add(Component.translatable("text.hibernalherbs.padlocks.bound.pride").withStyle(ChatFormatting.GRAY));
            } else if (stack.is(itemRegistry.GOURMANDIZING_PADLOCK_BOUND.get())) {
                tooltip.add(Component.translatable("text.hibernalherbs.padlocks.bound.gluttony").withStyle(ChatFormatting.GRAY));
            } else if (stack.is(itemRegistry.AVARICE_PADLOCK_BOUND.get())) {
                tooltip.add(Component.translatable("text.hibernalherbs.padlocks.bound.greed").withStyle(ChatFormatting.GRAY));
            }
        }
    }

}