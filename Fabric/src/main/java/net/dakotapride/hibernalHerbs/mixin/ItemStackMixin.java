package net.dakotapride.hibernalHerbs.mixin;

import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements FoodComponentList {

    @Inject(method = "finishUsing", at = @At("HEAD"))
    private void finishUsing(World world, LivingEntity entity, CallbackInfoReturnable<ItemStack> cir) {
        if (entity.getActiveItem().isOf(ItemInit.INCINERATING_BLEND)) {
            entity.setFireTicks(fireDuration);
        }

        if (entity.getActiveItem().isOf(ItemInit.SMOKED_INCINERATING_BLEND)) {
            entity.setFireTicks(smokedFireDuration);
        }
    }

}
