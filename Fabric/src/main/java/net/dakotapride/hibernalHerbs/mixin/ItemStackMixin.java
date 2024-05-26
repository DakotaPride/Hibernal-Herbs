package net.dakotapride.hibernalHerbs.mixin;

import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
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
            ItemStack edibleStack = player.getActiveItem();
            if (!player.getInventory().contains(gluttonousRingStack) && player.getInventory().contains(advancedGluttonousRingStack) && !player.getItemCooldownManager().isCoolingDown(edibleStack.getItem())) {
                cir.setReturnValue(this.consume(edibleStack.copy(), player.getWorld(), player));
                // player.getCooldowns().addCooldown(edibleStack.getItem(), 40);
                // cir.cancel();
            }
        }
    }

    @Unique
    private ItemStack consume(ItemStack stack, World world, LivingEntity entity) {
        if (stack.isFood()) {
            entity.eatFood(world, stack.copy());

            if (!entity.getWorld().isClient() && entity instanceof PlayerEntity player) {
                player.getItemCooldownManager().set(stack.getItem(), 40);
            }
        }

        return stack;
    }

}
