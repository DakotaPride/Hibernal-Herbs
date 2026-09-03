package net.dakotapride.hibernalherbs.item;

import net.dakotapride.hibernalherbs.init.ItemInit;
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

public class EnigmaticPotionItem extends PotionItem {
    public EnigmaticPotionItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);

        list.add(Component.literal(""));
        list.add(Component.translatable("text.hibernalherbs.mysterious_potion.no_particles").withStyle(ChatFormatting.GRAY));

        // Modifiers
        list.add(Component.literal(""));
        list.add(Component.translatable("text.hibernalherbs.mysterious_potion.enigmatic_extract.modifiers").withStyle(ChatFormatting.AQUA));
        //list.add(Component.literal(""));
        // Vile Ashes
        list.add(Component.translatable("text.hibernalherbs.mysterious_potion.enigmatic_extract.vile").withStyle(ChatFormatting.LIGHT_PURPLE));
        list.add(Component.translatable("text.hibernalherbs.mysterious_potion.enigmatic_extract.vile.occurrence").withStyle(ChatFormatting.GRAY));
        // Virtuous Ashes
        list.add(Component.translatable("text.hibernalherbs.mysterious_potion.enigmatic_extract.virtuous").withStyle(ChatFormatting.LIGHT_PURPLE));
        list.add(Component.translatable("text.hibernalherbs.mysterious_potion.enigmatic_extract.virtuous.occurrence").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, itemStack);
        }

        if (!level.isClientSide) {
            for (MobEffectInstance mobEffectInstance : PotionUtils.getMobEffects(itemStack)) {
                mobEffectInstance.visible = false;
                // Controlled by Enigmatic Extracts
                // mobEffectInstance.duration = 1;
                // mobEffectInstance.amplifier = 1;

                if (!(player.getCooldowns().isOnCooldown(player.getOffhandItem().getItem()))) {
                    if (player.getOffhandItem().is(ItemInit.VIRTUOUS_ASHES)) {
                        mobEffectInstance.duration = (int)(mobEffectInstance.getDuration() * 1.5F);

                        player.getCooldowns().addCooldown(player.getOffhandItem().getItem(), 1200);
                    } else if (player.getOffhandItem().is(ItemInit.VILE_ASHES)) {
                        mobEffectInstance.amplifier = mobEffectInstance.getAmplifier() + 1;

                        player.getCooldowns().addCooldown(player.getOffhandItem().getItem(), 2400);
                    }

                    if (mobEffectInstance.getEffect().isInstantenous()) {
                        mobEffectInstance.getEffect().applyInstantenousEffect(player, player, livingEntity, mobEffectInstance.getAmplifier(), 1.0);
                    } else {
                        livingEntity.addEffect(mobEffectInstance);
                    }
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
}
