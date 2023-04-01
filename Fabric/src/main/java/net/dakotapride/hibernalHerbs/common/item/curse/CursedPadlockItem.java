package net.dakotapride.hibernalHerbs.common.item.curse;

import net.dakotapride.hibernalHerbs.common.init.EffectInit;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.item.HerbalSigilItem;
import net.dakotapride.hibernalHerbs.common.util;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CursedPadlockItem extends Item {
    public CursedPadlockItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.isIn(util.BOUND_PADLOCKS)) {
            tooltip.add(Text.translatable("text.hibernalherbs.padlocks.bound").formatted(Formatting.GRAY));
        } else if (stack.isIn(util.PADLOCKS)) {
            if (stack.isOf(ItemInit.VEXATION_PADLOCK)) {
                tooltip.add(Text.translatable("text.hibernalherbs.padlocks.unbound.wrath").formatted(Formatting.GRAY));
            } else if (stack.isOf(ItemInit.PIQUE_PADLOCK)) {
                tooltip.add(Text.translatable("text.hibernalherbs.padlocks.unbound.pride").formatted(Formatting.GRAY));
            } else if (stack.isOf(ItemInit.GOURMANDIZING_PADLOCK)) {
                tooltip.add(Text.translatable("text.hibernalherbs.padlocks.unbound.gluttony").formatted(Formatting.GRAY));
            } else if (stack.isOf(ItemInit.AVARICE_PADLOCK)) {
                tooltip.add(Text.translatable("text.hibernalherbs.padlocks.unbound.greed").formatted(Formatting.GRAY));
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        boolean isPrideSigil = user.getOffHandStack().isOf(ItemInit.SIGIL_PRIDE);
        boolean isGluttonySigil = user.getOffHandStack().isOf(ItemInit.SIGIL_GLUTTONY);
        boolean isWrathSigil = user.getOffHandStack().isOf(ItemInit.SIGIL_WRATH);
        boolean isGreedSigil = user.getOffHandStack().isOf(ItemInit.SIGIL_GREED);

        boolean isBoundVexation = user.getMainHandStack().isOf(ItemInit.VEXATION_PADLOCK_BOUND);
        boolean isBoundPique = user.getMainHandStack().isOf(ItemInit.PIQUE_PADLOCK_BOUND);
        boolean isBoundGourmandizing = user.getMainHandStack().isOf(ItemInit.GOURMANDIZING_PADLOCK_BOUND);
        boolean isBoundAvarice = user.getMainHandStack().isOf(ItemInit.AVARICE_PADLOCK_BOUND);

        boolean isVexation = user.getOffHandStack().isOf(ItemInit.VEXATION_PADLOCK);
        boolean isPique = user.getOffHandStack().isOf(ItemInit.PIQUE_PADLOCK);
        boolean isGourmandizing = user.getOffHandStack().isOf(ItemInit.GOURMANDIZING_PADLOCK);
        boolean isAvarice = user.getOffHandStack().isOf(ItemInit.AVARICE_PADLOCK);

        boolean hasSourCurse = user.hasStatusEffect(EffectInit.SOUR_HERBAL_CURSE);
        boolean hasScentedCurse = user.hasStatusEffect(EffectInit.SCENTED_HERBAL_CURSE);
        boolean hasBitterCurse = user.hasStatusEffect(EffectInit.BITTER_HERBAL_CURSE);
        boolean hasWardedCurse = user.hasStatusEffect(EffectInit.WARDED_HERBAL_CURSE);

        if (user.getMainHandStack().isIn(util.BOUND_PADLOCKS)) {
            if (isWrathSigil && isBoundVexation) {
                user.getMainHandStack().decrement(1);

                user.giveItemStack(new ItemStack(ItemInit.VEXATION_PADLOCK, 1));
            } else if (isPrideSigil && isBoundPique) {
                user.getMainHandStack().decrement(1);

                user.giveItemStack(new ItemStack(ItemInit.PIQUE_PADLOCK, 1));
            } else if (isGluttonySigil && isBoundGourmandizing) {
                user.getMainHandStack().decrement(1);

                user.giveItemStack(new ItemStack(ItemInit.GOURMANDIZING_PADLOCK, 1));
            } else if (isGreedSigil && isBoundAvarice) {
                user.getMainHandStack().decrement(1);

                user.giveItemStack(new ItemStack(ItemInit.AVARICE_PADLOCK, 1));
            }
        }

        if (user.getOffHandStack().isIn(util.PADLOCKS)) {
            if (isVexation) {
                user.addStatusEffect(new StatusEffectInstance(EffectInit.SOUR_HERBAL_CURSE, 24000, 1));
            } else if (isPique) {
                user.addStatusEffect(new StatusEffectInstance(EffectInit.SCENTED_HERBAL_CURSE, 24000, 1));
            } else if (isGourmandizing) {
                user.addStatusEffect(new StatusEffectInstance(EffectInit.BITTER_HERBAL_CURSE, 24000, 1));
            } else if (isAvarice) {
                user.addStatusEffect(new StatusEffectInstance(EffectInit.WARDED_HERBAL_CURSE, 24000, 1));
            }

            if (!isVexation && hasSourCurse) {
                user.removeStatusEffect(EffectInit.SOUR_HERBAL_CURSE);
            } else if (!isPique && hasScentedCurse) {
                user.removeStatusEffect(EffectInit.SCENTED_HERBAL_CURSE);
            } else if (!isGourmandizing && hasBitterCurse) {
                user.removeStatusEffect(EffectInit.BITTER_HERBAL_CURSE);
            } else if (!isAvarice && hasWardedCurse) {
                user.removeStatusEffect(EffectInit.WARDED_HERBAL_CURSE);
            }

            if (user.getOffHandStack().isOf(this.getDefaultStack().getItem())) {
                user.getItemCooldownManager().set(ItemInit.VEXATION_PADLOCK, 24000);
                user.getItemCooldownManager().set(ItemInit.PIQUE_PADLOCK, 24000);
                user.getItemCooldownManager().set(ItemInit.GOURMANDIZING_PADLOCK, 24000);
                user.getItemCooldownManager().set(ItemInit.AVARICE_PADLOCK, 24000);

                user.getOffHandStack().damage(1, user, (player) -> player.sendToolBreakStatus(player.getActiveHand()));
            }
        }

        return super.use(world, user, hand);
    }
}
