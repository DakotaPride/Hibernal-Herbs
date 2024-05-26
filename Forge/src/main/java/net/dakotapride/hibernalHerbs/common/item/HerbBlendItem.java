package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.registry.ItemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbBlendItem extends Item implements FoodComponentList, ITooltipProvider {
    public HerbBlendItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
        ItemStack gluttonousRingStack = ItemRegistry.GLUTTONOUS_RING.get().getDefaultInstance();
        ItemStack advancedGluttonousRingStack = ItemRegistry.ADV_GLUTTONOUS_RING.get().getDefaultInstance();

        entity.addEatEffect(stack, level, entity);

        if (entity instanceof Player player) {
            if (player.getInventory().contains(gluttonousRingStack) && !player.getInventory().contains(advancedGluttonousRingStack)) {
                player.getCooldowns().addCooldown(this, 40);

                return stack;
            } else {
                return player.getAbilities().instabuild ? super.finishUsingItem(stack, level, entity) : new ItemStack(Items.BOWL);
            }
        } else {
            return super.finishUsingItem(stack, level, entity);
        }
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, Player player, @NotNull LivingEntity livingEntity, @NotNull InteractionHand hand) {
        if (player.getMainHandItem().is(ItemRegistry.REGENERATION_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, healthDuration, baseMultiplier));
        } else if (player.getMainHandItem().is(ItemRegistry.POISON_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, healthDuration, baseMultiplier));
        } else if (player.getMainHandItem().is(ItemRegistry.SLOWNESS_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, speedDuration, baseMultiplier));
        } else if (player.getMainHandItem().is(ItemRegistry.MINING_FATIGUE_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, miningSpeedDuration, baseMultiplier));
        } else if (player.getMainHandItem().is(ItemRegistry.HASTE_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, miningSpeedDuration, baseMultiplier));
        } else if (player.getMainHandItem().is(ItemRegistry.SPEED_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, speedDuration, baseMultiplier));
        } else if (player.getMainHandItem().is(ItemRegistry.WITHER_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, healthDuration, baseMultiplier));
        } else if (player.getMainHandItem().is(ItemRegistry.NIGHT_VISION_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, visionDuration, baseMultiplier));
        } else if (player.getMainHandItem().is(ItemRegistry.WEAKNESS_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, damageDuration, baseMultiplier));
        } else if (player.getMainHandItem().is(ItemRegistry.BLINDNESS_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, visionDuration, baseMultiplier));
        } else if (player.getMainHandItem().is(ItemRegistry.FIRE_BLEND.get())) { }

        else if (player.getMainHandItem().is(ItemRegistry.GLOWING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, glowingDuration, baseMultiplier));
        }

        else if (player.getMainHandItem().is(ItemRegistry.REGENERATION_SLOWNESS_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, healthDuration, baseMultiplier));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, healthDuration, baseMultiplier));
        } else if (player.getMainHandItem().is(ItemRegistry.REGENERATION_SLOWNESS_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, healthDuration + 120, baseMultiplier));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, speedDuration + 100, baseMultiplier));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, damageDuration + 80, baseMultiplier));
        }

        if (!player.isCreative()) {
            stack.shrink(1);
            player.addItem(new ItemStack(Items.BOWL, 1));
        }
        
        
        return super.interactLivingEntity(stack, player, livingEntity, hand);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, LivingEntity target, @NotNull LivingEntity attacker) {

        Player player = (Player) target.getLastHurtByMob();
        if (attacker instanceof Player) {
            if (attacker.getMainHandItem().is(ItemRegistry.REGENERATION_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, healthDuration - 80, baseMultiplier - 1));
            } else if (attacker.getMainHandItem().is(ItemRegistry.POISON_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.POISON, healthDuration - 80, baseMultiplier - 1));
            } else if (attacker.getMainHandItem().is(ItemRegistry.SLOWNESS_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, speedDuration - 60, baseMultiplier - 1));
            } else if (attacker.getMainHandItem().is(ItemRegistry.MINING_FATIGUE_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, miningSpeedDuration - 600, baseMultiplier - 1));
            } else if (attacker.getMainHandItem().is(ItemRegistry.HASTE_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, miningSpeedDuration - 600, baseMultiplier - 1));
            } else if (attacker.getMainHandItem().is(ItemRegistry.SPEED_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, speedDuration - 60, baseMultiplier - 1));
            } else if (attacker.getMainHandItem().is(ItemRegistry.WITHER_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.WITHER, healthDuration - 80, baseMultiplier - 1));
            } else if (attacker.getMainHandItem().is(ItemRegistry.NIGHT_VISION_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, visionDuration - 100, baseMultiplier - 1));
            } else if (attacker.getMainHandItem().is(ItemRegistry.WEAKNESS_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, damageDuration - 40, baseMultiplier - 1));
            } else if (attacker.getMainHandItem().is(ItemRegistry.BLINDNESS_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, visionDuration - 100, baseMultiplier - 1));
            } else if (attacker.getMainHandItem().is(ItemRegistry.FIRE_BLEND.get())) {
                target.setSecondsOnFire(secondsOnFire - 2);
            }

            else if (attacker.getMainHandItem().is(ItemRegistry.GLOWING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.GLOWING, glowingDuration - 60, baseMultiplier - 1));
            }

            else if (attacker.getMainHandItem().is(ItemRegistry.REGENERATION_SLOWNESS_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, healthDuration - 80, baseMultiplier - 1));
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, speedDuration - 60, baseMultiplier - 1));
            } else if (attacker.getMainHandItem().is(ItemRegistry.REGENERATION_SLOWNESS_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (healthDuration + 120) - 40, baseMultiplier - 1));
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (speedDuration + 100) - 40, baseMultiplier - 1));
                target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (damageDuration + 80) - 60, baseMultiplier));
            }

            assert player != null;
            if (!player.isCreative()) {
                stack.shrink(1);
                player.addItem(new ItemStack(Items.BOWL, 1));
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag tooltipFlag) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Component.translatable(shiftControlsText).withStyle(ChatFormatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            if (!stack.is(HibernalHerbsForge.ARTIFICIAL_BLENDS_TAG)) {
                effectToAbilityTooltip(stack, tooltip);
                tooltip.add(Component.translatable("text.hibernalherbs.blend.modifier.smoked.false").withStyle(ChatFormatting.GRAY));

                if (!Screen.hasAltDown()) {
                    tooltip.add(Component.literal(""));
                    tooltip.add(Component.translatable(leftAltControlsText).withStyle(ChatFormatting.DARK_GRAY));
                } else {
                    tooltip.add(Component.literal(""));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.ability.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.ability.help.two").withStyle(ChatFormatting.DARK_PURPLE));

                    tooltip.add(Component.literal(""));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.effect.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.effect.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.effect.help.three").withStyle(ChatFormatting.DARK_PURPLE));

                    tooltip.add(Component.literal(""));
                    tooltip.add(Component.translatable(leftClickOnPlayerControlsText).withStyle(ChatFormatting.DARK_GRAY));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.attacking.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.attacking.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.attacking.help.three").withStyle(ChatFormatting.DARK_PURPLE));

                    tooltip.add(Component.literal(""));
                    tooltip.add(Component.translatable(rightClickOnPlayerControlsText).withStyle(ChatFormatting.DARK_GRAY));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.three").withStyle(ChatFormatting.DARK_PURPLE));
                }

            } else {
                getExceptionTooltip(stack, tooltip);
                tooltip.add(Component.translatable("text.hibernalherbs.blend.modifier.smoked.false").withStyle(ChatFormatting.GRAY));

                if (!Screen.hasAltDown()) {
                    tooltip.add(Component.literal(""));
                    tooltip.add(Component.translatable(leftAltControlsText).withStyle(ChatFormatting.DARK_GRAY));
                } else {
                    tooltip.add(Component.literal(""));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.exception.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.exception.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.exception.help.three").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.exception.help.four").withStyle(ChatFormatting.DARK_PURPLE));

                    tooltip.add(Component.literal(""));
                    tooltip.add(Component.translatable(leftClickOnPlayerControlsText).withStyle(ChatFormatting.DARK_GRAY));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.attacking.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.attacking.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.attacking.help.three").withStyle(ChatFormatting.DARK_PURPLE));

                    tooltip.add(Component.literal(""));
                    tooltip.add(Component.translatable(rightClickOnPlayerControlsText).withStyle(ChatFormatting.DARK_GRAY));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    tooltip.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.three").withStyle(ChatFormatting.DARK_PURPLE));
                }

            }
        }
    }

    public static void effectToAbilityTooltip(ItemStack stack, List<Component> tooltip) {
        MobEffect effectFromAbility = BlendAbilities.NONE.getEffect();

        if (stack.is(ItemRegistry.REGENERATION_BLEND.get()) || stack.is(ItemRegistry.SMOKED_REGENERATION_BLEND.get())) {
            effectFromAbility = BlendAbilities.REGENERATIVE.getEffect();
        }
        if (stack.is(ItemRegistry.POISON_BLEND.get()) || stack.is(ItemRegistry.SMOKED_POISON_BLEND.get())) {
            effectFromAbility = BlendAbilities.VIRULENT.getEffect();
        }
        if (stack.is(ItemRegistry.SLOWNESS_BLEND.get()) || stack.is(ItemRegistry.SMOKED_SLOWNESS_BLEND.get())) {
            effectFromAbility = BlendAbilities.SEDATING.getEffect();
        }
        if (stack.is(ItemRegistry.MINING_FATIGUE_BLEND.get()) || stack.is(ItemRegistry.SMOKED_MINING_FATIGUE_BLEND.get())) {
            effectFromAbility = BlendAbilities.HINDERING.getEffect();
        }
        if (stack.is(ItemRegistry.HASTE_BLEND.get()) || stack.is(ItemRegistry.SMOKED_HASTE_BLEND.get())) {
            effectFromAbility = BlendAbilities.DASHING.getEffect();
        }
        if (stack.is(ItemRegistry.SPEED_BLEND.get()) || stack.is(ItemRegistry.SMOKED_SPEED_BLEND.get())) {
            effectFromAbility = BlendAbilities.ACCELERATION.getEffect();
        }
        if (stack.is(ItemRegistry.WITHER_BLEND.get()) || stack.is(ItemRegistry.SMOKED_WITHER_BLEND.get())) {
            effectFromAbility = BlendAbilities.DECAYING.getEffect();
        }
        if (stack.is(ItemRegistry.NIGHT_VISION_BLEND.get()) || stack.is(ItemRegistry.SMOKED_NIGHT_VISION_BLEND.get())) {
            effectFromAbility = BlendAbilities.OBSERVING.getEffect();
        }
        if (stack.is(ItemRegistry.WEAKNESS_BLEND.get()) || stack.is(ItemRegistry.SMOKED_WEAKNESS_BLEND.get())) {
            effectFromAbility = BlendAbilities.DIMINISHED.getEffect();
        }
        if (stack.is(ItemRegistry.BLINDNESS_BLEND.get()) || stack.is(ItemRegistry.SMOKED_BLINDNESS_BLEND.get())) {
            effectFromAbility = BlendAbilities.SHADED.getEffect();
        }

        callForAbility(stack, tooltip);

        if (stack.is(ItemRegistry.FIRE_BLEND.get()) || stack.is(ItemRegistry.SMOKED_FIRE_BLEND.get())) {
            callFireAbilityFromBlend(stack, tooltip);
        } else {
            tooltip.add(Component.translatable("text.hibernalherbs.blend.provided_effect", effectFromAbility.getDisplayName()).withStyle(ChatFormatting.GRAY));
        }

    }

    public static void getExceptionTooltip(ItemStack stack, List<Component> tooltip) {
        MobEffect firstEffect;
        MobEffect secondaryEffect;
        MobEffect thirdEffect;

        callForAbility(stack, tooltip);

        if (stack.is(ItemRegistry.REGENERATION_SLOWNESS_BLEND.get()) || stack.is(ItemRegistry.SMOKED_REGENERATION_SLOWNESS_BLEND.get())) {
            firstEffect = BlendAbilities.CONFLICTING.getEffect();
            secondaryEffect = BlendAbilities.CONFLICTING.getEffect2();

            tooltip.add(Component.translatable("text.hibernalherbs.blend.provided_effects").withStyle(ChatFormatting.DARK_GRAY));
            tooltip.add(Component.translatable("text.hibernalherbs.blend.provided_effects.first", firstEffect.getDisplayName()).withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("text.hibernalherbs.blend.provided_effects.secondary", secondaryEffect.getDisplayName()).withStyle(ChatFormatting.GRAY));
        } else if (stack.is(ItemRegistry.REGENERATION_SPEED_WEAKNESS_BLEND.get()) || stack.is(ItemRegistry.SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND.get())) {
            firstEffect = BlendAbilities.ALTERNATIVE.getEffect();
            secondaryEffect = BlendAbilities.ALTERNATIVE.getEffect2();
            thirdEffect = BlendAbilities.ALTERNATIVE.getEffect3();

            tooltip.add(Component.translatable("text.hibernalherbs.blend.provided_effects").withStyle(ChatFormatting.DARK_GRAY));
            tooltip.add(Component.translatable("text.hibernalherbs.blend.provided_effects.first", firstEffect.getDisplayName()).withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("text.hibernalherbs.blend.provided_effects.secondary", secondaryEffect.getDisplayName()).withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("text.hibernalherbs.blend.provided_effects.third", thirdEffect.getDisplayName()).withStyle(ChatFormatting.GRAY));
        }
    }

    private static void callForAbility(ItemStack stack, List<Component> tooltip) {
        MutableComponent callAbility = BlendAbilities.NONE.getAbility();

        if (stack.is(ItemRegistry.REGENERATION_BLEND.get()) || stack.is(ItemRegistry.SMOKED_REGENERATION_BLEND.get())) {
            callAbility = BlendAbilities.REGENERATIVE.getAbility();
        }
        if (stack.is(ItemRegistry.POISON_BLEND.get()) || stack.is(ItemRegistry.SMOKED_POISON_BLEND.get())) {
            callAbility = BlendAbilities.VIRULENT.getAbility();
        }
        if (stack.is(ItemRegistry.SLOWNESS_BLEND.get()) || stack.is(ItemRegistry.SMOKED_SLOWNESS_BLEND.get())) {
            callAbility = BlendAbilities.SEDATING.getAbility();
        }
        if (stack.is(ItemRegistry.MINING_FATIGUE_BLEND.get()) || stack.is(ItemRegistry.SMOKED_MINING_FATIGUE_BLEND.get())) {
            callAbility = BlendAbilities.HINDERING.getAbility();
        }
        if (stack.is(ItemRegistry.HASTE_BLEND.get()) || stack.is(ItemRegistry.SMOKED_HASTE_BLEND.get())) {
            callAbility = BlendAbilities.DASHING.getAbility();
        }
        if (stack.is(ItemRegistry.SPEED_BLEND.get()) || stack.is(ItemRegistry.SMOKED_SPEED_BLEND.get())) {
            callAbility = BlendAbilities.ACCELERATION.getAbility();
        }
        if (stack.is(ItemRegistry.WITHER_BLEND.get()) || stack.is(ItemRegistry.SMOKED_WITHER_BLEND.get())) {
            callAbility = BlendAbilities.DECAYING.getAbility();
        }
        if (stack.is(ItemRegistry.FIRE_BLEND.get()) || stack.is(ItemRegistry.SMOKED_FIRE_BLEND.get())) {
            callAbility = BlendAbilities.INCINERATING.getAbility();
        }
        if (stack.is(ItemRegistry.NIGHT_VISION_BLEND.get()) || stack.is(ItemRegistry.SMOKED_NIGHT_VISION_BLEND.get())) {
            callAbility = BlendAbilities.OBSERVING.getAbility();
        }
        if (stack.is(ItemRegistry.WEAKNESS_BLEND.get()) || stack.is(ItemRegistry.SMOKED_WEAKNESS_BLEND.get())) {
            callAbility = BlendAbilities.DIMINISHED.getAbility();
        }
        if (stack.is(ItemRegistry.BLINDNESS_BLEND.get()) || stack.is(ItemRegistry.SMOKED_BLINDNESS_BLEND.get())) {
            callAbility = BlendAbilities.SHADED.getAbility();
        }
        if (stack.is(ItemRegistry.REGENERATION_SLOWNESS_BLEND.get()) || stack.is(ItemRegistry.SMOKED_REGENERATION_SLOWNESS_BLEND.get())) {
            callAbility = BlendAbilities.CONFLICTING.getAbility();
        }
        if (stack.is(ItemRegistry.REGENERATION_SPEED_WEAKNESS_BLEND.get()) || stack.is(ItemRegistry.SMOKED_REGENERATION_SPEED_WEAKNESS_BLEND.get())) {
            callAbility = BlendAbilities.ALTERNATIVE.getAbility();
        }

        tooltip.add(Component.translatable("text.hibernalherbs.blend.ability", callAbility).withStyle(ChatFormatting.GRAY));
    }

    private static void callFireAbilityFromBlend(ItemStack stack, List<Component> tooltip) {
        if (stack.is(ItemRegistry.FIRE_BLEND.get()) || stack.is(ItemRegistry.SMOKED_FIRE_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend.provided_effect.fire").withStyle(ChatFormatting.GRAY));
        }
    }
}
