package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.init.itemRegistry;
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

public class HerbBlendItem extends Item {
    public HerbBlendItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        ItemStack itemstack = super.finishUsingItem(stack, level, livingEntity);

        return livingEntity instanceof Player && ((Player)livingEntity).getAbilities().instabuild ? itemstack : new ItemStack(Items.BOWL);
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, Player player, @NotNull LivingEntity livingEntity, @NotNull InteractionHand hand) {
        if (player.getMainHandItem().is(itemRegistry.REGENERATIVE_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1));
        } else if (player.getMainHandItem().is(itemRegistry.VIRULENT_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 300, 1));
        } else if (player.getMainHandItem().is(itemRegistry.SEDATING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 1));
        } else if (player.getMainHandItem().is(itemRegistry.HINDERING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 300, 1));
        } else if (player.getMainHandItem().is(itemRegistry.DASHING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1));
        } else if (player.getMainHandItem().is(itemRegistry.ACCELERATION_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1));
        } else if (player.getMainHandItem().is(itemRegistry.DECAYING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 300, 1));
        } else if (player.getMainHandItem().is(itemRegistry.OBSERVING_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 1));
        } else if (player.getMainHandItem().is(itemRegistry.DIMINISHED_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 1));
        } else if (player.getMainHandItem().is(itemRegistry.SHADED_BLEND.get())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 1));
        } else if (player.getMainHandItem().is(itemRegistry.INCINERATING_BLEND.get())) { }

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
            if (attacker.getMainHandItem().is(itemRegistry.REGENERATIVE_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 140, 0));
            } else if (attacker.getMainHandItem().is(itemRegistry.VIRULENT_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.POISON, 140, 0));
            } else if (attacker.getMainHandItem().is(itemRegistry.SEDATING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140, 0));
            } else if (attacker.getMainHandItem().is(itemRegistry.HINDERING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 140, 0));
            } else if (attacker.getMainHandItem().is(itemRegistry.DASHING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 140, 0));
            } else if (attacker.getMainHandItem().is(itemRegistry.ACCELERATION_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 140, 0));
            } else if (attacker.getMainHandItem().is(itemRegistry.DECAYING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.WITHER, 140, 0));
            } else if (attacker.getMainHandItem().is(itemRegistry.OBSERVING_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 140, 0));
            } else if (attacker.getMainHandItem().is(itemRegistry.DIMINISHED_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 140, 0));
            } else if (attacker.getMainHandItem().is(itemRegistry.SHADED_BLEND.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 140, 0));
            } else if (attacker.getMainHandItem().is(itemRegistry.INCINERATING_BLEND.get())) {
                target.setSecondsOnFire(7);
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
        if (stack.getItem().getDefaultInstance().is(itemRegistry.REGENERATIVE_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_regeneration").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.VIRULENT_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_poison").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SEDATING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_slowness").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.HINDERING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_mining_fatigue").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.DASHING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_haste").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.ACCELERATION_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_speed").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.INCINERATING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_fire").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.DECAYING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_wither").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.OBSERVING_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_night_vision").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.DIMINISHED_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_weakness").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem().getDefaultInstance().is(itemRegistry.SHADED_BLEND.get())) {
            tooltip.add(Component.translatable("text.hibernalherbs.blend_blindness").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        }
    }
}
