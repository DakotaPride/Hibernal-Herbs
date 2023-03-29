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
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbBlendItem extends Item implements FoodComponentList {
    public HerbBlendItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.REGENERATIVE_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.VIRULENT_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, healthDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SEDATING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, speedDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.HINDERING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, miningSpeedDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.DASHING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, miningSpeedDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.ACCELERATION_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, speedDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.INCINERATING_BLEND)) {
            entity.setFireTicks(fireDuration);
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.DECAYING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, healthDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.OBSERVING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, visionDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.DIMINISHED_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, damageDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SHADED_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, visionDuration, baseMultiplier));
        }

        else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.CONFLICTING_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, visionDuration, baseMultiplier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.ALTERNATIVE_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration + 120, baseMultiplier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, speedDuration + 100, baseMultiplier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, damageDuration + 80, baseMultiplier));
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
            if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.REGENERATIVE_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration - 80, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.VIRULENT_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, healthDuration - 80, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SEDATING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, speedDuration - 60, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.HINDERING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, miningSpeedDuration - 600, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.DASHING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, miningSpeedDuration - 600, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.ACCELERATION_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, speedDuration - 60, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.INCINERATING_BLEND)) {
                target.setFireTicks(fireDuration - 40);
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.DECAYING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, healthDuration - 80, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.OBSERVING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, visionDuration - 100, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.DIMINISHED_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, damageDuration - 40, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SHADED_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, visionDuration - 100, baseMultiplier - 1));
            }

            else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.CONFLICTING_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, visionDuration - 100, baseMultiplier - 1));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration - 80, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.ALTERNATIVE_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, (healthDuration + 120) - 40, baseMultiplier - 1));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, (speedDuration + 100) - 40, baseMultiplier - 1));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, (damageDuration + 80) - 60, baseMultiplier));
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
        if (stack.getItem().getDefaultStack().isOf(ItemInit.REGENERATIVE_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_regeneration").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.VIRULENT_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_poison").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SEDATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_slowness").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.HINDERING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_mining_fatigue").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.DASHING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_haste").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.ACCELERATION_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_speed").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.INCINERATING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_fire").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.DECAYING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_wither").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.OBSERVING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_night_vision").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.DIMINISHED_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_weakness").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.SHADED_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_blindness").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        }

        else if (stack.getItem().getDefaultStack().isOf(ItemInit.CONFLICTING_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_regen_slow").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        } else if (stack.getItem().getDefaultStack().isOf(ItemInit.ALTERNATIVE_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend_regen_speed_weak").formatted(Formatting.ITALIC).formatted(Formatting.GRAY));
        }
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);

        ItemStack gluttonousRingStack = ItemInit.GLUTTONOUS_RING.getDefaultStack();
        ItemStack advancedGluttonousRingStack = ItemInit.ADV_GLUTTONOUS_RING.getDefaultStack();

        if (user instanceof PlayerEntity player) {
            if (player.getInventory().contains(gluttonousRingStack)
                    && !(player.getInventory().contains(advancedGluttonousRingStack))) {
                ((PlayerEntity) user).getItemCooldownManager().set(this, 40);

                return ((PlayerEntity)user).getAbilities().creativeMode
                        ? itemStack : new ItemStack(this.asItem());
            } else {
                return ((PlayerEntity)user).getAbilities().creativeMode
                        ? itemStack : new ItemStack(Items.BOWL);
            }
        }
        return stack;
    }
}
