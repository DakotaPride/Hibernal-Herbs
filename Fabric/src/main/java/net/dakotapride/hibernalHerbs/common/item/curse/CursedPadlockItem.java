package net.dakotapride.hibernalHerbs.common.item.curse;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.util;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class CursedPadlockItem extends TrinketItem {
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
        }
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getModifiers(stack, slot, entity, uuid);

        EntityAttributeModifier wrathHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:wrath_health",
                0.1, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        EntityAttributeModifier wrathAttackDamageModifier = new EntityAttributeModifier(uuid, "hibernalherbs:wrath_damage",
                0.4, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        EntityAttributeModifier prideHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:pride_health",
                0.4, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        EntityAttributeModifier gluttonyHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:gluttony_health",
                0.3, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        EntityAttributeModifier greedHealthModifier = new EntityAttributeModifier(uuid, "hibernalherbs:greed_health",
                0.6, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        if (stack.isOf(ItemInit.VEXATION_PADLOCK_BOUND)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, wrathHealthModifier);
            modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, wrathAttackDamageModifier);
        } else if (stack.isOf(ItemInit.PIQUE_PADLOCK_BOUND)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, prideHealthModifier);
        } else if (stack.isOf(ItemInit.GOURMANDIZING_PADLOCK_BOUND)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, gluttonyHealthModifier);
        } else if (stack.isOf(ItemInit.AVARICE_PADLOCK_BOUND)) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, greedHealthModifier);
        }

        return modifiers;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.isIn(util.PADLOCKS)) {
            tooltip.add(Text.translatable("text.hibernalherbs.padlocks.unbound").formatted(Formatting.GRAY));
        } else if (stack.isIn(util.BOUND_PADLOCKS)) {
            if (stack.isOf(ItemInit.VEXATION_PADLOCK_BOUND)) {
                tooltip.add(Text.translatable("text.hibernalherbs.padlocks.bound.wrath").formatted(Formatting.GRAY));
            } else if (stack.isOf(ItemInit.PIQUE_PADLOCK_BOUND)) {
                tooltip.add(Text.translatable("text.hibernalherbs.padlocks.bound.pride").formatted(Formatting.GRAY));
            } else if (stack.isOf(ItemInit.GOURMANDIZING_PADLOCK_BOUND)) {
                tooltip.add(Text.translatable("text.hibernalherbs.padlocks.bound.gluttony").formatted(Formatting.GRAY));
            } else if (stack.isOf(ItemInit.AVARICE_PADLOCK_BOUND)) {
                tooltip.add(Text.translatable("text.hibernalherbs.padlocks.bound.greed").formatted(Formatting.GRAY));
            }
        }
    }

}
