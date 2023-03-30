package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.init.EffectInit;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BoundCurseSigilItem extends HerbalSigilItem {
    public BoundCurseSigilItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        boolean prideStack = user.getOffHandStack().isOf(ItemInit.SIGIL_PRIDE);
        boolean gluttonyStack = user.getOffHandStack().isOf(ItemInit.SIGIL_GLUTTONY);
        boolean wrathStack = user.getOffHandStack().isOf(ItemInit.SIGIL_WRATH);
        boolean greedStack = user.getOffHandStack().isOf(ItemInit.SIGIL_GREED);

        if (user.getMainHandStack().isOf(ItemInit.BOUND_CURSE_SIGIL)) {
            if (prideStack) {

                user.addStatusEffect(new StatusEffectInstance(EffectInit.SCENTED_HERBAL_CURSE, 24000, 1));

                user.getMainHandStack().decrement(1);
            } else if (gluttonyStack) {

                user.addStatusEffect(new StatusEffectInstance(EffectInit.BITTER_HERBAL_CURSE, 24000, 1));

                user.getMainHandStack().decrement(1);
            } else if (wrathStack) {

                user.addStatusEffect(new StatusEffectInstance(EffectInit.SOUR_HERBAL_CURSE, 24000, 1));

                user.getMainHandStack().decrement(1);
            } else if (greedStack) {

                user.addStatusEffect(new StatusEffectInstance(EffectInit.WARDED_HERBAL_CURSE, 24000, 1));

                user.getMainHandStack().decrement(1);
            }
        }

        return super.use(world, user, hand);
    }
}
