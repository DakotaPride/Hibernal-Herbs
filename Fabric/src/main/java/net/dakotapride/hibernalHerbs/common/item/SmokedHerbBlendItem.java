package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
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

public class SmokedHerbBlendItem extends Item implements FoodComponentList {
    public SmokedHerbBlendItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_REGENERATIVE_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_VIRULENT_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, smokedHealthDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_SEDATING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, smokedSpeedDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_HINDERING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, smokedMiningSpeedDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_DASHING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, smokedMiningSpeedDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_ACCELERATION_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, smokedSpeedDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_INCINERATING_BLEND)) {
            entity.setFireTicks(smokedFireDuration);
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_DECAYING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, smokedHealthDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_OBSERVING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, smokedVisionDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_DIMINISHED_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, smokedDamageDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_SHADED_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, smokedVisionDuration, smokedMultiplier));
        }

        else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_CONFLICTING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, smokedVisionDuration, smokedMultiplier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration, smokedMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_ALTERNATIVE_BLEND)) {
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
            if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_REGENERATIVE_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_VIRULENT_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_SEDATING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, smokedSpeedDuration - 60, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_HINDERING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, smokedMiningSpeedDuration - 600, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_DASHING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, smokedMiningSpeedDuration - 600, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_ACCELERATION_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, smokedSpeedDuration - 60, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_INCINERATING_BLEND)) {
                target.setFireTicks(smokedFireDuration - 40);
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_DECAYING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_OBSERVING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, smokedVisionDuration - 100, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_DIMINISHED_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, smokedDamageDuration - 40, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_SHADED_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, smokedVisionDuration - 100, smokedMultiplier - 1));
            }

            else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_CONFLICTING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, smokedVisionDuration - 100, smokedMultiplier - 1));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SMOKED_ALTERNATIVE_BLEND)) {
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
        if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_REGENERATIVE_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_regeneration").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_VIRULENT_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_poison").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_SEDATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_slowness").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_HINDERING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_mining_fatigue").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_DASHING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_haste").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_ACCELERATION_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_speed").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_INCINERATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_fire").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_DECAYING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_wither").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_OBSERVING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_night_vision").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_DIMINISHED_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_weakness").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_SHADED_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_blindness").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        }

        else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_CONFLICTING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_regen_slow").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SMOKED_ALTERNATIVE_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_regen_speed_weak").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        }

        tooltip.add(Text.translatable("text.hibernalherbs.smoked_blend").formatted(Formatting.ITALIC));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);

        return user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode
                ? itemStack : new ItemStack(Items.BOWL);
    }
}
