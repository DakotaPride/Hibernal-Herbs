package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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

public class SmokedHerbBlendItem extends Item implements FoodComponentList, ITooltipProvider {
    public SmokedHerbBlendItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
        ItemStack gluttonousRingStack = itemRegistry.GLUTTONOUS_RING.get().getDefaultInstance();
        ItemStack advancedGluttonousRingStack = itemRegistry.ADV_GLUTTONOUS_RING.get().getDefaultInstance();

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
        if (player.getMainHandItem().is(itemRegistry.SMOKED_REGENERATION_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_POISON_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, smokedHealthDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_SLOWNESS_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedSpeedDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_MINING_FATIGUE_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, smokedMiningSpeedDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_HASTE_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, smokedMiningSpeedDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_SPEED_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, smokedSpeedDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_WITHER_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, smokedHealthDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_NIGHT_VISION_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, smokedVisionDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_WEAKNESS_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, smokedDamageDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_BLINDNESS_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, smokedVisionDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_FIRE_BLEND.get())) { }

        else if (player.getMainHandItem().is(itemRegistry.SMOKED_GLOWING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, smokedGlowingDuration, smokedMultiplier));
        }

        else if (player.getMainHandItem().is(itemRegistry.SMOKED_REGENERATION_SLOWNESS_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration, smokedMultiplier));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedHealthDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_REGENERATION_SLOWNESS_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration + 120, smokedMultiplier));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, smokedSpeedDuration + 100, smokedMultiplier));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, smokedDamageDuration + 80, smokedMultiplier));
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
            if (attacker.getMainHandItem().is(itemRegistry.SMOKED_REGENERATION_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_POISON_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.POISON, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_SLOWNESS_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedSpeedDuration - 60, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_MINING_FATIGUE_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, smokedMiningSpeedDuration - 600, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_HASTE_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, smokedMiningSpeedDuration - 600, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_SPEED_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, smokedSpeedDuration - 60, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_WITHER_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.WITHER, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_NIGHT_VISION_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, smokedVisionDuration - 100, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_WEAKNESS_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, smokedDamageDuration - 40, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_BLINDNESS_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, smokedVisionDuration - 100, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_FIRE_BLEND.get())) {
                target.setSecondsOnFire(smokedSecondsOnFire - 2);
            }

            else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_GLOWING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.GLOWING, smokedGlowingDuration - 60, smokedMultiplier - 1));
            }

            else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_REGENERATION_SLOWNESS_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration - 80, smokedMultiplier - 1));
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedSpeedDuration - 60, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_REGENERATION_SLOWNESS_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (smokedHealthDuration + 120) - 40, smokedMultiplier - 1));
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (smokedSpeedDuration + 100) - 40, smokedMultiplier - 1));
                target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (smokedDamageDuration + 80) - 60, smokedMultiplier));
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
    public void appendHoverText(ItemStack stack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag tooltipFlag) {
        if (!Screen.hasShiftDown()) {
            components.add(Component.translatable(shiftControlsText).withStyle(ChatFormatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            if (!stack.is(HibernalHerbsForge.ARTIFICIAL_BLENDS_TAG)) {
                HerbBlendItem.effectToAbilityTooltip(stack, components);
                components.add(Component.translatable("text.hibernalherbs.blend.modifier.smoked.true").withStyle(ChatFormatting.GRAY));

                if (!Screen.hasAltDown()) {
                    components.add(Component.literal(""));
                    components.add(Component.translatable(leftAltControlsText).withStyle(ChatFormatting.DARK_GRAY));
                } else {
                    components.add(Component.literal(""));
                    components.add(Component.translatable("text.hibernalherbs.modifier.blend.smoked.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.modifier.blend.smoked.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.modifier.blend.smoked.help.three").withStyle(ChatFormatting.DARK_PURPLE));

                    components.add(Component.literal(""));
                    components.add(Component.translatable("text.hibernalherbs.blend.ability.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.ability.help.two").withStyle(ChatFormatting.DARK_PURPLE));

                    components.add(Component.literal(""));
                    components.add(Component.translatable("text.hibernalherbs.blend.effect.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.effect.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.effect.help.three").withStyle(ChatFormatting.DARK_PURPLE));

                    components.add(Component.literal(""));
                    components.add(Component.translatable(leftClickOnPlayerControlsText).withStyle(ChatFormatting.DARK_GRAY));
                    components.add(Component.translatable("text.hibernalherbs.blend.attacking.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.attacking.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.attacking.help.three").withStyle(ChatFormatting.DARK_PURPLE));

                    components.add(Component.literal(""));
                    components.add(Component.translatable("text.hibernalherbs.blend.attacking.help.fire.one").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.attacking.help.fire.two").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.attacking.help.fire.three").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.attacking.help.fire.four").withStyle(ChatFormatting.DARK_PURPLE));

                    components.add(Component.literal(""));
                    components.add(Component.translatable(rightClickOnPlayerControlsText).withStyle(ChatFormatting.DARK_GRAY));
                    components.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.three").withStyle(ChatFormatting.DARK_PURPLE));
                }

            } else {
                HerbBlendItem.getExceptionTooltip(stack, components);
                components.add(Component.translatable("text.hibernalherbs.blend.modifier.smoked.false").withStyle(ChatFormatting.GRAY));

                if (!Screen.hasAltDown()) {
                    components.add(Component.translatable(leftAltControlsText).withStyle(ChatFormatting.DARK_GRAY));
                } else {
                    components.add(Component.literal(""));
                    components.add(Component.translatable("text.hibernalherbs.modifier.blend.smoked.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.modifier.blend.smoked.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.modifier.blend.smoked.help.three").withStyle(ChatFormatting.DARK_PURPLE));

                    components.add(Component.literal(""));
                    components.add(Component.translatable("text.hibernalherbs.blend.exception.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.exception.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.exception.help.three").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.exception.help.four").withStyle(ChatFormatting.DARK_PURPLE));

                    components.add(Component.literal(""));
                    components.add(Component.translatable(leftClickOnPlayerControlsText).withStyle(ChatFormatting.DARK_GRAY));
                    components.add(Component.translatable("text.hibernalherbs.blend.attacking.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.attacking.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.attacking.help.three").withStyle(ChatFormatting.DARK_PURPLE));

                    components.add(Component.literal(""));
                    components.add(Component.translatable(rightClickOnPlayerControlsText).withStyle(ChatFormatting.DARK_GRAY));
                    components.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                    components.add(Component.translatable("text.hibernalherbs.blend.player_pour.help.three").withStyle(ChatFormatting.DARK_PURPLE));
                }

            }

        }
    }
}
