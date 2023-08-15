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
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
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
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {}

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
            if (stack.isOf(ItemInit.VEXATION_PADLOCK_BOUND)) {
                serverPlayerEntity.sendMessage(Text.translatable("text.hibernalherbs.wrath.unholy_blessing").formatted(Formatting.ITALIC), false);
            } else if (stack.isOf(ItemInit.PIQUE_PADLOCK_BOUND)) {
                serverPlayerEntity.sendMessage(Text.translatable("text.hibernalherbs.pride.unholy_blessing").formatted(Formatting.ITALIC), false);
            } else if (stack.isOf(ItemInit.GOURMANDIZING_PADLOCK_BOUND)) {
                serverPlayerEntity.sendMessage(Text.translatable("text.hibernalherbs.gluttony.unholy_blessing").formatted(Formatting.ITALIC), false);
            } else if (stack.isOf(ItemInit.AVARICE_PADLOCK_BOUND)) {
                serverPlayerEntity.sendMessage(Text.translatable("text.hibernalherbs.greed.unholy_blessing").formatted(Formatting.ITALIC), false);
            } else if (stack.isOf(ItemInit.SPITEFUL_PADLOCK_BOUND)) {
                serverPlayerEntity.sendMessage(Text.translatable("text.hibernalherbs.envy.unholy_blessing").formatted(Formatting.ITALIC), false);
            } else if (stack.isOf(ItemInit.APATHY_PADLOCK_BOUND)) {
                serverPlayerEntity.sendMessage(Text.translatable("text.hibernalherbs.sloth.unholy_blessing").formatted(Formatting.ITALIC), false);
            } else if (stack.isOf(ItemInit.SALACIOUS_PADLOCK_BOUND)) {
                serverPlayerEntity.sendMessage(Text.translatable("text.hibernalherbs.lust.unholy_blessing").formatted(Formatting.ITALIC), false);
            }
        }
    }
}
