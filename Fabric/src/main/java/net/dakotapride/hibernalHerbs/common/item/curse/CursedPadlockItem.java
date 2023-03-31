package net.dakotapride.hibernalHerbs.common.item.curse;

import net.dakotapride.hibernalHerbs.common.init.EffectInit;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.item.HerbalSigilItem;
import net.dakotapride.hibernalHerbs.common.util;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CursedPadlockItem extends Item {
    public CursedPadlockItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (player.getOffHandStack().isOf(ItemInit.VEXATION_PADLOCK)) {
                player.addStatusEffect(new StatusEffectInstance(EffectInit.SOUR_HERBAL_CURSE, 24000, 1));
            } else if (player.getOffHandStack().isOf(ItemInit.PIQUE_PADLOCK)) {
                player.addStatusEffect(new StatusEffectInstance(EffectInit.SCENTED_HERBAL_CURSE, 24000, 1));
            } else if (player.getOffHandStack().isOf(ItemInit.GOURMANDIZING_PADLOCK)) {
                player.addStatusEffect(new StatusEffectInstance(EffectInit.BITTER_HERBAL_CURSE, 24000, 1));
            } else if (player.getOffHandStack().isOf(ItemInit.AVARICE_PADLOCK)) {
                player.addStatusEffect(new StatusEffectInstance(EffectInit.WARDED_HERBAL_CURSE, 24000, 1));
            }

            if (this.getDefaultStack().isIn(util.PADLOCKS)) {
                if (player.getOffHandStack().isOf(this.getDefaultStack().getItem()) && (entity.age % 98) == 0) {
                    stack.damage(1, player, (player1) -> player1.sendToolBreakStatus(player1.getActiveHand()));
                }
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        boolean prideStack = user.getOffHandStack().isOf(ItemInit.SIGIL_PRIDE);
        boolean gluttonyStack = user.getOffHandStack().isOf(ItemInit.SIGIL_GLUTTONY);
        boolean wrathStack = user.getOffHandStack().isOf(ItemInit.SIGIL_WRATH);
        boolean greedStack = user.getOffHandStack().isOf(ItemInit.SIGIL_GREED);

        boolean vexationBoundStack = user.getMainHandStack().isOf(ItemInit.VEXATION_PADLOCK_BOUND);
        boolean piqueBoundStack = user.getMainHandStack().isOf(ItemInit.PIQUE_PADLOCK_BOUND);
        boolean gourmandizingBoundStack = user.getMainHandStack().isOf(ItemInit.GOURMANDIZING_PADLOCK_BOUND);
        boolean avariceBoundStack = user.getMainHandStack().isOf(ItemInit.AVARICE_PADLOCK_BOUND);

        if (user.getMainHandStack().isIn(util.BOUND_PADLOCKS)) {
            if (wrathStack && vexationBoundStack) {
                user.getMainHandStack().decrement(1);

                user.giveItemStack(new ItemStack(ItemInit.VEXATION_PADLOCK, 1));
            } else if (prideStack && piqueBoundStack) {
                user.getMainHandStack().decrement(1);

                user.giveItemStack(new ItemStack(ItemInit.PIQUE_PADLOCK, 1));
            } else if (gluttonyStack && gourmandizingBoundStack) {
                user.getMainHandStack().decrement(1);

                user.giveItemStack(new ItemStack(ItemInit.GOURMANDIZING_PADLOCK, 1));
            } else if (greedStack && avariceBoundStack) {
                user.getMainHandStack().decrement(1);

                user.giveItemStack(new ItemStack(ItemInit.AVARICE_PADLOCK, 1));
            }
        }

        return super.use(world, user, hand);
    }
}
