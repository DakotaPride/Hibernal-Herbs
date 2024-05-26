package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.Utilities;
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
            if (!stack.isIn(Utilities.ARTIFICIAL_BLENDS)) {
                effectToAbilityTooltip(stack, tooltip);
                tooltip.add(Text.translatable("text.hibernalherbs.blend.modifier.smoked.false").formatted(Formatting.GRAY));

                if (!Screen.hasAltDown()) {
                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable(leftAltControlsText).formatted(Formatting.DARK_GRAY));
                } else {
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
                    tooltip.add(Text.translatable(rightClickOnPlayerControlsText).formatted(Formatting.DARK_GRAY));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.player_pour.help.one").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.player_pour.help.two").formatted(Formatting.DARK_PURPLE));
                    tooltip.add(Text.translatable("text.hibernalherbs.blend.player_pour.help.three").formatted(Formatting.DARK_PURPLE));
                }

            } else {
                getExceptionTooltip(stack, tooltip);
                tooltip.add(Text.translatable("text.hibernalherbs.blend.modifier.smoked.false").formatted(Formatting.GRAY));

                if (!Screen.hasAltDown()) {
                    tooltip.add(Text.literal(""));
                    tooltip.add(Text.translatable(leftAltControlsText).formatted(Formatting.DARK_GRAY));
                } else {
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
        ItemStack gluttonousRingStack = ItemInit.GLUTTONOUS_RING.getDefaultStack();
        ItemStack advancedGluttonousRingStack = ItemInit.ADV_GLUTTONOUS_RING.getDefaultStack();

        user.applyFoodEffects(stack, world, user);

        if (user instanceof PlayerEntity player) {
            if (player.getInventory().contains(gluttonousRingStack) && !player.getInventory().contains(advancedGluttonousRingStack)) {
                player.getItemCooldownManager().set(this, 40);

                return stack;
            } else {
                return player.getAbilities().creativeMode ? super.finishUsing(stack, world, user) : new ItemStack(Items.BOWL);
            }
        } else {
            return super.finishUsing(stack, world, user);
        }
    }

    public static void effectToAbilityTooltip(ItemStack stack, List<Text> tooltip) {
        StatusEffect effectFromAbility = BlendAbilities.NONE.getEffect();

        if (stack.isOf(ItemInit.REGENERATION_BLEND) || stack.isOf(ItemInit.SMOKED_REGENERATION_BLEND)) {
            effectFromAbility = BlendAbilities.REGENERATIVE.getEffect();
        }
        if (stack.isOf(ItemInit.POISON_BLEND) || stack.isOf(ItemInit.SMOKED_POISON_BLEND)) {
            effectFromAbility = BlendAbilities.VIRULENT.getEffect();
        }
        if (stack.isOf(ItemInit.SLOWNESS_BLEND) || stack.isOf(ItemInit.SMOKED_SLOWNESS_BLEND)) {
            effectFromAbility = BlendAbilities.SEDATING.getEffect();
        }
        if (stack.isOf(ItemInit.MINING_FATIGUE_BLEND) || stack.isOf(ItemInit.SMOKED_MINING_FATIGUE_BLEND)) {
            effectFromAbility = BlendAbilities.HINDERING.getEffect();
        }
        if (stack.isOf(ItemInit.HASTE_BLEND) || stack.isOf(ItemInit.SMOKED_HASTE_BLEND)) {
            effectFromAbility = BlendAbilities.DASHING.getEffect();
        }
        if (stack.isOf(ItemInit.SPEED_BLEND) || stack.isOf(ItemInit.SMOKED_SPEED_BLEND)) {
            effectFromAbility = BlendAbilities.ACCELERATION.getEffect();
        }
        if (stack.isOf(ItemInit.WITHER_BLEND) || stack.isOf(ItemInit.SMOKED_WITHER_BLEND)) {
            effectFromAbility = BlendAbilities.DECAYING.getEffect();
        }
        if (stack.isOf(ItemInit.NIGHT_VISION_BLEND) || stack.isOf(ItemInit.SMOKED_NIGHT_VISION_BLEND)) {
            effectFromAbility = BlendAbilities.OBSERVING.getEffect();
        }
        if (stack.isOf(ItemInit.WEAKNESS_BLEND) || stack.isOf(ItemInit.SMOKED_WEAKNESS_BLEND)) {
            effectFromAbility = BlendAbilities.DIMINISHED.getEffect();
        }
        if (stack.isOf(ItemInit.BLINDNESS_BLEND) || stack.isOf(ItemInit.SMOKED_BLINDNESS_BLEND)) {
            effectFromAbility = BlendAbilities.SHADED.getEffect();
        }

        callForAbility(stack, tooltip);

        if (stack.isOf(ItemInit.FIRE_BLEND) || stack.isOf(ItemInit.SMOKED_FIRE_BLEND)) {
            callFireAbilityFromBlend(stack, tooltip);
        } else {
            tooltip.add(Text.translatable("text.hibernalherbs.blend.provided_effect", effectFromAbility.getName()).formatted(Formatting.GRAY));
        }

    }

    public static void getExceptionTooltip(ItemStack stack, List<Text> tooltip) {
        StatusEffect firstEffect;
        StatusEffect secondaryEffect;
        StatusEffect thirdEffect;

        callForAbility(stack, tooltip);

        if (stack.isOf(ItemInit.REGENERATION_SLOWNESS_BLEND) || stack.isOf(ItemInit.SMOKED_REGENERATION_SLOWNESS_BLEND)) {
            firstEffect = BlendAbilities.CONFLICTING.getEffect();
            secondaryEffect = BlendAbilities.CONFLICTING.getEffect2();

            tooltip.add(Text.translatable("text.hibernalherbs.blend.provided_effects").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.translatable("text.hibernalherbs.blend.provided_effects.first", firstEffect.getName()).formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("text.hibernalherbs.blend.provided_effects.secondary", secondaryEffect.getName()).formatted(Formatting.GRAY));
        } else if (stack.isOf(ItemInit.REGENERATION_SPEED_WEAKNESS_BLEND) || stack.isOf(ItemInit.SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND)) {
            firstEffect = BlendAbilities.ALTERNATIVE.getEffect();
            secondaryEffect = BlendAbilities.ALTERNATIVE.getEffect2();
            thirdEffect = BlendAbilities.ALTERNATIVE.getEffect3();

            tooltip.add(Text.translatable("text.hibernalherbs.blend.provided_effects").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.translatable("text.hibernalherbs.blend.provided_effects.first", firstEffect.getName()).formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("text.hibernalherbs.blend.provided_effects.secondary", secondaryEffect.getName()).formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("text.hibernalherbs.blend.provided_effects.third", thirdEffect.getName()).formatted(Formatting.GRAY));
        }
    }

    private static void callForAbility(ItemStack stack, List<Text> tooltip) {
        MutableText callAbility = BlendAbilities.NONE.getAbility();

        if (stack.isOf(ItemInit.REGENERATION_BLEND) || stack.isOf(ItemInit.SMOKED_REGENERATION_BLEND)) {
            callAbility = BlendAbilities.REGENERATIVE.getAbility();
        }
        if (stack.isOf(ItemInit.POISON_BLEND) || stack.isOf(ItemInit.SMOKED_POISON_BLEND)) {
            callAbility = BlendAbilities.VIRULENT.getAbility();
        }
        if (stack.isOf(ItemInit.SLOWNESS_BLEND) || stack.isOf(ItemInit.SMOKED_SLOWNESS_BLEND)) {
            callAbility = BlendAbilities.SEDATING.getAbility();
        }
        if (stack.isOf(ItemInit.MINING_FATIGUE_BLEND) || stack.isOf(ItemInit.SMOKED_MINING_FATIGUE_BLEND)) {
            callAbility = BlendAbilities.HINDERING.getAbility();
        }
        if (stack.isOf(ItemInit.HASTE_BLEND) || stack.isOf(ItemInit.SMOKED_HASTE_BLEND)) {
            callAbility = BlendAbilities.DASHING.getAbility();
        }
        if (stack.isOf(ItemInit.SPEED_BLEND) || stack.isOf(ItemInit.SMOKED_SPEED_BLEND)) {
            callAbility = BlendAbilities.ACCELERATION.getAbility();
        }
        if (stack.isOf(ItemInit.WITHER_BLEND) || stack.isOf(ItemInit.SMOKED_WITHER_BLEND)) {
            callAbility = BlendAbilities.DECAYING.getAbility();
        }
        if (stack.isOf(ItemInit.FIRE_BLEND) || stack.isOf(ItemInit.SMOKED_FIRE_BLEND)) {
            callAbility = BlendAbilities.INCINERATING.getAbility();
        }
        if (stack.isOf(ItemInit.NIGHT_VISION_BLEND) || stack.isOf(ItemInit.SMOKED_NIGHT_VISION_BLEND)) {
            callAbility = BlendAbilities.OBSERVING.getAbility();
        }
        if (stack.isOf(ItemInit.WEAKNESS_BLEND) || stack.isOf(ItemInit.SMOKED_WEAKNESS_BLEND)) {
            callAbility = BlendAbilities.DIMINISHED.getAbility();
        }
        if (stack.isOf(ItemInit.BLINDNESS_BLEND) || stack.isOf(ItemInit.SMOKED_BLINDNESS_BLEND)) {
            callAbility = BlendAbilities.SHADED.getAbility();
        }
        if (stack.isOf(ItemInit.REGENERATION_SLOWNESS_BLEND) || stack.isOf(ItemInit.SMOKED_REGENERATION_SLOWNESS_BLEND)) {
            callAbility = BlendAbilities.CONFLICTING.getAbility();
        }
        if (stack.isOf(ItemInit.REGENERATION_SPEED_WEAKNESS_BLEND) || stack.isOf(ItemInit.SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND)) {
            callAbility = BlendAbilities.ALTERNATIVE.getAbility();
        }

        tooltip.add(Text.translatable("text.hibernalherbs.blend.ability", callAbility).formatted(Formatting.GRAY));
    }

    private static void callFireAbilityFromBlend(ItemStack stack, List<Text> tooltip) {
        if (stack.isOf(ItemInit.FIRE_BLEND) || stack.isOf(ItemInit.SMOKED_FIRE_BLEND)) {
            tooltip.add(Text.translatable("text.hibernalherbs.blend.provided_effect.fire").formatted(Formatting.GRAY));
        }
    }

}
