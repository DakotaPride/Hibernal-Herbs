package net.dakotapride.hibernalherbs.item;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TimeOfDayPotion extends PotionItem {
    Time time;

    public TimeOfDayPotion(Time time, Properties properties) {
        super(properties);
        this.time = time;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);

        list.add(Component.literal(""));

        switch (time) {
            case DAY -> {
                list.add(Component.translatable("text.hibernalherbs.time_of_day_potion.daytime").withStyle(ChatFormatting.GOLD));
            }
            case NIGHT -> {
                list.add(Component.translatable("text.hibernalherbs.time_of_day_potion.nighttime").withStyle(ChatFormatting.DARK_PURPLE));
            }
            default -> {}
        }
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, itemStack);
        }

        //int timeOfDay = (int) level.getDayTime();
        long getTime = level.getDayTime();
        if (!level.isClientSide) {
            for (MobEffectInstance mobEffectInstance : PotionUtils.getMobEffects(itemStack)) {
                switch (time) {
                    case DAY -> {
                        if (getTime >= 1000 && getTime < 13000) {
                            mobEffectInstance.duration = (mobEffectInstance.getDuration() + 2000);
                            mobEffectInstance.amplifier = (mobEffectInstance.getAmplifier() + 2);
                        } else {
                            mobEffectInstance.duration = (int) (mobEffectInstance.getDuration() * 0.5F);
                            if (mobEffectInstance.amplifier != 0) {
                                mobEffectInstance.amplifier = (mobEffectInstance.getAmplifier() - 1);
                            }
                        }

                        if (mobEffectInstance.getEffect().isInstantenous()) {
                            mobEffectInstance.getEffect().applyInstantenousEffect(player, player, livingEntity, mobEffectInstance.getAmplifier(), 1.0);
                        } else {
                            livingEntity.addEffect(mobEffectInstance);
                        }
                    }
                    case NIGHT -> {
                        if (getTime >= 13000 && getTime < 23999) {
                            mobEffectInstance.duration = (mobEffectInstance.getDuration() + 2000);
                            mobEffectInstance.amplifier = (mobEffectInstance.getAmplifier() + 2);
                        } else {
                            mobEffectInstance.duration = (int) (mobEffectInstance.getDuration() * 0.5F);
                            if (mobEffectInstance.amplifier != 0) {
                                mobEffectInstance.amplifier = (mobEffectInstance.getAmplifier() - 1);
                            }
                        }

                        if (mobEffectInstance.getEffect().isInstantenous()) {
                            mobEffectInstance.getEffect().applyInstantenousEffect(player, player, livingEntity, mobEffectInstance.getAmplifier(), 1.0);
                        } else {
                            livingEntity.addEffect(mobEffectInstance);
                        }
                    }
                    default -> {}
                }
            }

        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            itemStack.shrink(1);
        }

        if (player == null || !player.isCreative()) {
            if (itemStack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }

            if (player != null) {
                player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
            }
        }

        livingEntity.gameEvent(GameEvent.DRINK);
        return itemStack;
    }

    public enum Time {
        DAY,
        NIGHT;

        Time() {}
    }
}
