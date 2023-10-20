package net.dakotapride.hibernalHerbs.mixin;

import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.util;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements FoodComponentList {

    @Shadow public abstract Item getItem();

    @Shadow public abstract int getCount();

    @Inject(method = "finishUsing", at = @At("HEAD"), cancellable = true)
    private void finishUsing(World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack gluttonousRingStack = ItemInit.GLUTTONOUS_RING.getDefaultStack();
        ItemStack advancedGluttonousRingStack = ItemInit.ADV_GLUTTONOUS_RING.getDefaultStack();

        if (user.getActiveItem().isOf(ItemInit.FIRE_BLEND)) {
            user.setFireTicks(fireDuration);
        }

        if (user.getActiveItem().isOf(ItemInit.SMOKED_FIRE_BLEND)) {
            user.setFireTicks(smokedFireDuration);
        }

        if (user instanceof PlayerEntity player) {
            if (!player.getInventory().contains(gluttonousRingStack) && player.getInventory().contains(advancedGluttonousRingStack)) {
                player.getItemCooldownManager().set(player.getActiveItem().getItem(), 40);

                user.applyFoodEffects(user.getActiveItem(), world, user);

                cir.setReturnValue(player.getActiveItem());
            }
        }
    }

}
