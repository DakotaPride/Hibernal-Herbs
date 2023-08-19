package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.util;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SmokedHerbBlendItem extends Item implements FoodComponentList, ITooltipProvider {
    public SmokedHerbBlendItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_REGENERATION_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_POISON_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, smokedHealthDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_SLOWNESS_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, smokedSpeedDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_MINING_FATIGUE_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, smokedMiningSpeedDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_HASTE_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, smokedMiningSpeedDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_SPEED_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, smokedSpeedDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_FIRE_BLEND)) {
            entity.setFireTicks(smokedFireDuration);
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_WITHER_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, smokedHealthDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_NIGHT_VISION_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, smokedVisionDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_WEAKNESS_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, smokedDamageDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_BLINDNESS_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, smokedVisionDuration, smokedMultiplier));
        }

        else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_REGENERATION_SLOWNESS_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, smokedVisionDuration, smokedMultiplier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration + 120, smokedMultiplier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, smokedSpeedDuration + 100, smokedMultiplier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, smokedDamageDuration + 80, smokedMultiplier));
        }

        if (!user.isCreative()) {
            stack.decrement(1);
            user.giveItemStack(new ItemStack(Items.BOWL, 1));
        }

        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity player = (PlayerEntity) target.getAttacker();
        if (attacker instanceof PlayerEntity playerEntity) {
            if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_REGENERATION_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_POISON_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_SLOWNESS_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, smokedSpeedDuration - 60, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_MINING_FATIGUE_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, smokedMiningSpeedDuration - 600, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_HASTE_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, smokedMiningSpeedDuration - 600, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_SPEED_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, smokedSpeedDuration - 60, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_FIRE_BLEND)) {
                target.setFireTicks(smokedFireDuration - 40);
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_WITHER_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_NIGHT_VISION_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, smokedVisionDuration - 100, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_WEAKNESS_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, smokedDamageDuration - 40, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_BLINDNESS_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, smokedVisionDuration - 100, smokedMultiplier - 1));
            }

            else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_REGENERATION_SLOWNESS_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, smokedVisionDuration - 100, smokedMultiplier - 1));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, (smokedHealthDuration + 120) - 40, smokedMultiplier - 1));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, (smokedSpeedDuration + 100) - 40, smokedMultiplier - 1));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, (smokedDamageDuration + 80) - 60, smokedMultiplier));
            }

            if (!player.isCreative()) {
                stack.decrement(1);
                player.giveItemStack(new ItemStack(Items.BOWL, 1));
            }
        }

        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(shiftControlsText).formatted(Formatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            if (!stack.isIn(util.ARTIFICIAL_BLENDS)) {
                HerbBlendItem.effectToAbilityTooltip(stack, tooltip);
                tooltip.add(Text.translatable("text.hibernalherbs.blend.modifier.smoked.true").formatted(Formatting.GRAY));

                if (!Screen.hasAltDown()) {
                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable(leftAltControlsText).formatted(Formatting.DARK_GRAY));
                } else {
                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable("text.hibernalherbs.modifier.blend.smoked.help.one").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.modifier.blend.smoked.help.two").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.modifier.blend.smoked.help.three").formatted(Formatting.DARK_PURPLE));

                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.ability.help.one").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.ability.help.two").formatted(Formatting.DARK_PURPLE));

                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.effect.help.one").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.effect.help.two").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.effect.help.three").formatted(Formatting.DARK_PURPLE));

                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable(leftClickOnPlayerControlsText).formatted(Formatting.DARK_GRAY));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.attacking.help.one").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.attacking.help.two").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.attacking.help.three").formatted(Formatting.DARK_PURPLE));

                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.attacking.help.fire.one").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.attacking.help.fire.two").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.attacking.help.fire.three").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.attacking.help.fire.four").formatted(Formatting.DARK_PURPLE));

                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable(rightClickOnPlayerControlsText).formatted(Formatting.DARK_GRAY));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.player_pour.help.one").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.player_pour.help.two").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.player_pour.help.three").formatted(Formatting.DARK_PURPLE));
                }

            } else {
                HerbBlendItem.getExceptionTooltip(stack, tooltip);
                tooltip.add(Text.translatable("text.hibernalherbs.modifier.blend.smoked.false").formatted(Formatting.GRAY));

                if (!Screen.hasAltDown()) {
                    tooltip.add(Text.translatable(leftAltControlsText).formatted(Formatting.DARK_GRAY));
                } else {
                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable("text.hibernalherbs.modifier.blend.smoked.help.one").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.modifier.blend.smoked.help.two").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.modifier.blend.smoked.help.three").formatted(Formatting.DARK_PURPLE));

                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.exception.help.one").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.exception.help.two").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.exception.help.three").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.exception.help.four").formatted(Formatting.DARK_PURPLE));

                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable(leftClickOnPlayerControlsText).formatted(Formatting.DARK_GRAY));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.attacking.help.one").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.attacking.help.two").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.attacking.help.three").formatted(Formatting.DARK_PURPLE));

                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable(rightClickOnPlayerControlsText).formatted(Formatting.DARK_GRAY));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.player_pour.help.one").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.player_pour.help.two").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.player_pour.help.three").formatted(Formatting.DARK_PURPLE));
                }

            }

        }
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);

        return user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode
                ? itemStack : new ItemStack(Items.BOWL);
    }
}
