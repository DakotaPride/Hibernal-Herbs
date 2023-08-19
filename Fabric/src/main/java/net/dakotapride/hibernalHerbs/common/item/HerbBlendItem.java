package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.util;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbBlendItem extends Item implements FoodComponentList, ITooltipProvider {
    public HerbBlendItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.REGENERATION_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.POISON_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, healthDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SLOWNESS_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, speedDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.MINING_FATIGUE_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, miningSpeedDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.HASTE_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, miningSpeedDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SPEED_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, speedDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.FIRE_BLEND)) {
            entity.setFireTicks(fireDuration);
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.WITHER_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, healthDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.NIGHT_VISION_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, visionDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.WEAKNESS_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, damageDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.BLINDNESS_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, visionDuration, baseMultiplier));
        }

        else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.REGENERATION_SLOWNESS_BLEND)) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, visionDuration, baseMultiplier));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration, baseMultiplier));
        } else if (user.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.REGENERATION_SPEED_WEAKNESS_BLEND)) {
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
            if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.REGENERATION_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration - 80, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.POISON_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, healthDuration - 80, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SLOWNESS_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, speedDuration - 60, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.MINING_FATIGUE_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, miningSpeedDuration - 600, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.HASTE_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, miningSpeedDuration - 600, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.SPEED_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, speedDuration - 60, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.FIRE_BLEND)) {
                target.setFireTicks(fireDuration - 40);
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.WITHER_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, healthDuration - 80, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.NIGHT_VISION_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, visionDuration - 100, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.WEAKNESS_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, damageDuration - 40, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.BLINDNESS_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, visionDuration - 100, baseMultiplier - 1));
            }

            else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.REGENERATION_SLOWNESS_BLEND)) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, visionDuration - 100, baseMultiplier - 1));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, healthDuration - 80, baseMultiplier - 1));
            } else if (attacker.getStackInHand(Hand.MAIN_HAND).isOf(ItemInit.REGENERATION_SPEED_WEAKNESS_BLEND)) {
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
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(shiftControlsText).formatted(Formatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            if (!stack.isIn(util.ARTIFICIAL_BLENDS)) {
                callForAbilityTooltip(stack, tooltip);
                tooltip.add(Text.translatable("text.hibernalherbs.blend.provided_effects").formatted(Formatting.GRAY));
                providedEffects(stack, tooltip);

                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable("text.hibernalherbs.blend.ability.help.one").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.blend.ability.help.two").formatted(Formatting.DARK_PURPLE));
            }
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

    public static void callForAbilityTooltip(ItemStack stack, List<Text> tooltip) {
        MutableText callAbility = BlendAbilities.NONE.getAbility();

        if (stack.isOf(ItemInit.REGENERATION_BLEND)) {
            callAbility = BlendAbilities.REGENERATIVE.getAbility();
        }
        if (stack.isOf(ItemInit.POISON_BLEND)) {
            callAbility = BlendAbilities.VIRULENT.getAbility();
        }
        if (stack.isOf(ItemInit.SLOWNESS_BLEND)) {
            callAbility = BlendAbilities.SEDATING.getAbility();
        }
        if (stack.isOf(ItemInit.MINING_FATIGUE_BLEND)) {
            callAbility = BlendAbilities.HINDERING.getAbility();
        }
        if (stack.isOf(ItemInit.HASTE_BLEND)) {
            callAbility = BlendAbilities.DASHING.getAbility();
        }
        if (stack.isOf(ItemInit.SPEED_BLEND)) {
            callAbility = BlendAbilities.ACCELERATION.getAbility();
        }
        if (stack.isOf(ItemInit.FIRE_BLEND)) {
            callAbility = BlendAbilities.INCINERATING.getAbility();
        }
        if (stack.isOf(ItemInit.WITHER_BLEND)) {
            callAbility = BlendAbilities.DECAYING.getAbility();
        }
        if (stack.isOf(ItemInit.NIGHT_VISION_BLEND)) {
            callAbility = BlendAbilities.OBSERVING.getAbility();
        }
        if (stack.isOf(ItemInit.WEAKNESS_BLEND)) {
            callAbility = BlendAbilities.DIMINISHED.getAbility();
        }
        if (stack.isOf(ItemInit.BLINDNESS_BLEND)) {
            callAbility = BlendAbilities.SHADED.getAbility();
        }

        tooltip.add(Text.translatable("text.hibernalherbs.blend.ability", callAbility).formatted(Formatting.GRAY));

    }

    public static void providedEffects(ItemStack stack, List<Text> tooltip) {
        StatusEffect effect = BlendAbilities.NONE.getEffect();

        tooltip.add(Text.translatable("text.hibernalherbs.blend.effect", effect.getName()).formatted(Formatting.DARK_PURPLE));
    }
}
