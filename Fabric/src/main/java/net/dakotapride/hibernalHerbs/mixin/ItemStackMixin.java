package net.dakotapride.hibernalHerbs.mixin;

import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.util;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements FoodComponentList {

    @Shadow public abstract Item getItem();

    @Shadow public abstract int getCount();

    @Inject(method = "finishUsing", at = @At("HEAD"), cancellable = true)
    private void finishUsing(World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (user.getActiveItem().isOf(ItemInit.INCINERATING_BLEND)) {
            user.setFireTicks(fireDuration);
        }

        if (user.getActiveItem().isOf(ItemInit.SMOKED_INCINERATING_BLEND)) {
            user.setFireTicks(smokedFireDuration);
        }

        if (user instanceof PlayerEntity playerEntity && !(playerEntity.getAbilities().creativeMode)) {
            ItemStack advGluttonousRingStack = ItemInit.ADV_GLUTTONOUS_RING.getDefaultStack();

            if (playerEntity.getInventory().contains(advGluttonousRingStack)) {

                if (this.getItem().getDefaultStack().isIn(util.BLENDS)) {
                    cir.setReturnValue(((PlayerEntity)user).getAbilities().creativeMode
                            ? this.getItem().getDefaultStack() : new ItemStack(this.getItem().asItem()));
                }

                if (this.getItem().isFood()) {
                    ((PlayerEntity) user).getHungerManager().add(this.getItem().getFoodComponent().getHunger(),
                            this.getItem().getFoodComponent().getSaturationModifier());
                }

                cir.setReturnValue(((PlayerEntity)user).getAbilities().creativeMode
                        ? this.getItem().getDefaultStack() : new ItemStack(this.getItem().asItem(), this.getCount()));
            }
        }
    }

}
