package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.ChatFormatting;
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

public class SmokedHerbBlendItem extends Item implements FoodComponentList {
    public SmokedHerbBlendItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        ItemStack itemstack = super.finishUsingItem(stack, level, livingEntity);

        return livingEntity instanceof Player && ((Player)livingEntity).getAbilities().instabuild ? itemstack : new ItemStack(Items.BOWL);
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, Player player, @NotNull LivingEntity livingEntity, @NotNull InteractionHand hand) {
        if (player.getMainHandItem().is(itemRegistry.SMOKED_REGENERATIVE_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_VIRULENT_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, smokedHealthDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_SEDATING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedSpeedDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_HINDERING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, smokedMiningSpeedDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_DASHING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, smokedMiningSpeedDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_ACCELERATION_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, smokedSpeedDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_DECAYING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, smokedHealthDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_OBSERVING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, smokedVisionDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_DIMINISHED_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, smokedDamageDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_SHADED_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, smokedVisionDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_INCINERATING_BLEND.get())) { }

        else if (player.getMainHandItem().is(itemRegistry.SMOKED_CONFLICTING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration, smokedMultiplier));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedHealthDuration, smokedMultiplier));
        } else if (player.getMainHandItem().is(itemRegistry.SMOKED_CONFLICTING_BLEND.get())) {
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
            if (attacker.getMainHandItem().is(itemRegistry.SMOKED_REGENERATIVE_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_VIRULENT_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.POISON, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_SEDATING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedSpeedDuration - 60, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_HINDERING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, smokedMiningSpeedDuration - 600, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_DASHING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, smokedMiningSpeedDuration - 600, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_ACCELERATION_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, smokedSpeedDuration - 60, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_DECAYING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.WITHER, smokedHealthDuration - 80, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_OBSERVING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, smokedVisionDuration - 100, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_DIMINISHED_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, smokedDamageDuration - 40, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_SHADED_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, smokedVisionDuration - 100, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_INCINERATING_BLEND.get())) {
                target.setSecondsOnFire(smokedSecondsOnFire - 2);
            }

            else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_CONFLICTING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, smokedHealthDuration - 80, smokedMultiplier - 1));
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, smokedSpeedDuration - 60, smokedMultiplier - 1));
            } else if (attacker.getMainHandItem().is(itemRegistry.SMOKED_CONFLICTING_BLEND.get())) {
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
    public void appendHoverText(ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag tooltipFlag) {
        if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_REGENERATIVE_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_regeneration").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_VIRULENT_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_poison").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_SEDATING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_slowness").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_HINDERING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_mining_fatigue").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_DASHING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_haste").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_ACCELERATION_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_speed").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_INCINERATING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_fire").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_DECAYING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_wither").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_OBSERVING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_night_vision").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_DIMINISHED_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_weakness").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_SHADED_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_blindness").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_CONFLICTING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_regen_slow").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SMOKED_ALTERNATIVE_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_regen_speed_weak").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        }

        tooltip.add(Component.translatable("text.hibernalherbs.smoked_blend").withStyle(ChatFormatting.ITALIC));
    }
}
