package net.dakotapride.hibernalHerbs.common.item.curse;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.registry.effectRegistry;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CursedPadlockItem extends Item {
    public CursedPadlockItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag tooltipFlag) {
        if (stack.is(HibernalHerbsForge.PADLOCKS_TAG)) {
            tooltip.add(Component.translatable("text.hibernalherbs.padlocks.unbound").withStyle(ChatFormatting.GRAY));
        } else if (stack.is(HibernalHerbsForge.BOUND_PADLOCKS_TAG)) {
            if (stack.is(itemRegistry.VEXATION_PADLOCK_BOUND.get())) {
                tooltip.add(Component.translatable("text.hibernalherbs.padlocks.bound.wrath").withStyle(ChatFormatting.GRAY));
            } else if (stack.is(itemRegistry.PIQUE_PADLOCK_BOUND.get())) {
                tooltip.add(Component.translatable("text.hibernalherbs.padlocks.bound.pride").withStyle(ChatFormatting.GRAY));
            } else if (stack.is(itemRegistry.GOURMANDIZING_PADLOCK_BOUND.get())) {
                tooltip.add(Component.translatable("text.hibernalherbs.padlocks.bound.gluttony").withStyle(ChatFormatting.GRAY));
            } else if (stack.is(itemRegistry.AVARICE_PADLOCK_BOUND.get())) {
                tooltip.add(Component.translatable("text.hibernalherbs.padlocks.bound.greed").withStyle(ChatFormatting.GRAY));
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player user, InteractionHand hand) {

        boolean isPrideSigil = user.getOffhandItem().is(itemRegistry.SIGIL_PRIDE.get());
        boolean isGluttonySigil = user.getOffhandItem().is(itemRegistry.SIGIL_GLUTTONY.get());
        boolean isWrathSigil = user.getOffhandItem().is(itemRegistry.SIGIL_WRATH.get());
        boolean isGreedSigil = user.getOffhandItem().is(itemRegistry.SIGIL_GREED.get());

        boolean isBoundVexation = user.getOffhandItem().is(itemRegistry.VEXATION_PADLOCK_BOUND.get());
        boolean isBoundPique = user.getOffhandItem().is(itemRegistry.PIQUE_PADLOCK_BOUND.get());
        boolean isBoundGourmandizing = user.getOffhandItem().is(itemRegistry.GOURMANDIZING_PADLOCK_BOUND.get());
        boolean isBoundAvarice = user.getOffhandItem().is(itemRegistry.AVARICE_PADLOCK_BOUND.get());

        boolean isVexation = user.getMainHandItem().is(itemRegistry.VEXATION_PADLOCK.get());
        boolean isPique = user.getMainHandItem().is(itemRegistry.PIQUE_PADLOCK.get());
        boolean isGourmandizing = user.getMainHandItem().is(itemRegistry.GOURMANDIZING_PADLOCK.get());
        boolean isAvarice = user.getMainHandItem().is(itemRegistry.AVARICE_PADLOCK.get());

        boolean hasSourCurse = user.hasEffect(effectRegistry.SOUR_HERBAL_CURSE.get());
        boolean hasScentedCurse = user.hasEffect(effectRegistry.SCENTED_HERBAL_CURSE.get());
        boolean hasBitterCurse = user.hasEffect(effectRegistry.BITTER_HERBAL_CURSE.get());
        boolean hasWardedCurse = user.hasEffect(effectRegistry.WARDED_HERBAL_CURSE.get());

        if (user.getMainHandItem().is(HibernalHerbsForge.PADLOCKS_TAG)) {
            if (isWrathSigil && isVexation) {
                user.getMainHandItem().shrink(1);

                user.addItem(new ItemStack(itemRegistry.VEXATION_PADLOCK_BOUND.get(), 1));
            } else if (isPrideSigil && isPique) {
                user.getMainHandItem().shrink(1);

                user.addItem(new ItemStack(itemRegistry.PIQUE_PADLOCK_BOUND.get(), 1));
            } else if (isGluttonySigil && isGourmandizing) {
                user.getMainHandItem().shrink(1);

                user.addItem(new ItemStack(itemRegistry.GOURMANDIZING_PADLOCK_BOUND.get(), 1));
            } else if (isGreedSigil && isAvarice) {
                user.getMainHandItem().shrink(1);

                user.addItem(new ItemStack(itemRegistry.AVARICE_PADLOCK_BOUND.get(), 1));
            }
        }

        if (user.getOffhandItem().is(HibernalHerbsForge.BOUND_PADLOCKS_TAG)) {
            if (isBoundVexation) {
                user.addEffect(new MobEffectInstance(effectRegistry.SOUR_HERBAL_CURSE.get(), 24000, 1));
            } else if (isBoundPique) {
                user.addEffect(new MobEffectInstance(effectRegistry.SCENTED_HERBAL_CURSE.get(), 24000, 1));
            } else if (isBoundGourmandizing) {
                user.addEffect(new MobEffectInstance(effectRegistry.BITTER_HERBAL_CURSE.get(), 24000, 1));
            } else if (isBoundAvarice) {
                user.addEffect(new MobEffectInstance(effectRegistry.WARDED_HERBAL_CURSE.get(), 24000, 1));
            }

            user.getOffhandItem().hurtAndBreak(1, user, (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        }

        if (!isBoundVexation && hasSourCurse) {
            user.removeEffect(effectRegistry.SOUR_HERBAL_CURSE.get());
        } else if (!isBoundPique && hasScentedCurse) {
            user.removeEffect(effectRegistry.SCENTED_HERBAL_CURSE.get());
        } else if (!isBoundGourmandizing && hasBitterCurse) {
            user.removeEffect(effectRegistry.BITTER_HERBAL_CURSE.get());
        } else if (!isBoundAvarice && hasWardedCurse) {
            user.removeEffect(effectRegistry.WARDED_HERBAL_CURSE.get());
        }

        if (user.getOffhandItem().is(HibernalHerbsForge.BOUND_PADLOCKS_TAG)) {
            user.getCooldowns().addCooldown(itemRegistry.VEXATION_PADLOCK_BOUND.get(), 24000);
            user.getCooldowns().addCooldown(itemRegistry.PIQUE_PADLOCK_BOUND.get(), 24000);
            user.getCooldowns().addCooldown(itemRegistry.GOURMANDIZING_PADLOCK_BOUND.get(), 24000);
            user.getCooldowns().addCooldown(itemRegistry.AVARICE_PADLOCK_BOUND.get(), 24000);
        }

        return super.use(level, user, hand);
    }
}