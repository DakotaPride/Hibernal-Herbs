package net.dakotapride.hibernalHerbs.common.item.curse;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.registry.effectRegistry;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CursedPadlockItem extends Item {
    public CursedPadlockItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (entity instanceof Player player) {
            if (player.getOffhandItem().is(itemRegistry.VEXATION_PADLOCK.get())) {
                player.addEffect(new MobEffectInstance(effectRegistry.SOUR_HERBAL_CURSE.get(), 24000, 1));
            } else if (player.getOffhandItem().is(itemRegistry.PIQUE_PADLOCK.get())) {
                player.addEffect(new MobEffectInstance(effectRegistry.SCENTED_HERBAL_CURSE.get(), 24000, 1));
            } else if (player.getOffhandItem().is(itemRegistry.GOURMANDIZING_PADLOCK.get())) {
                player.addEffect(new MobEffectInstance(effectRegistry.BITTER_HERBAL_CURSE.get(), 24000, 1));
            } else if (player.getOffhandItem().is(itemRegistry.AVARICE_PADLOCK.get())) {
                player.addEffect(new MobEffectInstance(effectRegistry.WARDED_HERBAL_CURSE.get(), 24000, 1));
            }

            if (this.getDefaultInstance().is(HibernalHerbsForge.PADLOCKS_TAG)) {
                if (player.getOffhandItem().is(this.getDefaultInstance().getItem()) && (entity.tickCount % 98) == 0) {
                    stack.hurtAndBreak(1, player, (player1) -> player1.broadcastBreakEvent(player1.getUsedItemHand()));
                }
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player user, InteractionHand hand) {

        boolean prideStack = user.getOffhandItem().is(itemRegistry.SIGIL_PRIDE.get());
        boolean gluttonyStack = user.getOffhandItem().is(itemRegistry.SIGIL_GLUTTONY.get());
        boolean wrathStack = user.getOffhandItem().is(itemRegistry.SIGIL_WRATH.get());
        boolean greedStack = user.getOffhandItem().is(itemRegistry.SIGIL_GREED.get());

        boolean vexationBoundStack = user.getMainHandItem().is(itemRegistry.VEXATION_PADLOCK_BOUND.get());
        boolean piqueBoundStack = user.getMainHandItem().is(itemRegistry.PIQUE_PADLOCK_BOUND.get());
        boolean gourmandizingBoundStack = user.getMainHandItem().is(itemRegistry.GOURMANDIZING_PADLOCK_BOUND.get());
        boolean avariceBoundStack = user.getMainHandItem().is(itemRegistry.AVARICE_PADLOCK_BOUND.get());

        if (user.getMainHandItem().is(HibernalHerbsForge.BOUND_PADLOCKS_TAG)) {
            if (wrathStack && vexationBoundStack) {
                user.getMainHandItem().shrink(1);

                user.addItem(new ItemStack(itemRegistry.VEXATION_PADLOCK.get(), 1));
            } else if (prideStack && piqueBoundStack) {
                user.getMainHandItem().shrink(1);

                user.addItem(new ItemStack(itemRegistry.PIQUE_PADLOCK.get(), 1));
            } else if (gluttonyStack && gourmandizingBoundStack) {
                user.getMainHandItem().shrink(1);

                user.addItem(new ItemStack(itemRegistry.GOURMANDIZING_PADLOCK.get(), 1));
            } else if (greedStack && avariceBoundStack) {
                user.getMainHandItem().shrink(1);

                user.addItem(new ItemStack(itemRegistry.AVARICE_PADLOCK.get(), 1));
            }
        }

        return super.use(level, user, hand);
    }
}