package net.dakotapride.hibernalHerbs.mixin;

import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.registry.ItemRegistry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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

    @Inject(method = "finishUsingItem", at = @At("HEAD"), cancellable = true)
    private void finishUsingItem(Level world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack gluttonousRingStack = ItemRegistry.GLUTTONOUS_RING.get().getDefaultInstance();
        ItemStack advancedGluttonousRingStack = ItemRegistry.ADV_GLUTTONOUS_RING.get().getDefaultInstance();

        if (user.getUseItem().is(ItemRegistry.FIRE_BLEND.get())) {
            user.setRemainingFireTicks(fireDuration);
        }

        if (user.getUseItem().is(ItemRegistry.SMOKED_FIRE_BLEND.get())) {
            user.setRemainingFireTicks(smokedFireDuration);
        }

        if (user instanceof Player player) {
            ItemStack edibleStack = player.getUseItem();
            if (!player.getInventory().contains(gluttonousRingStack) && player.getInventory().contains(advancedGluttonousRingStack) && !player.getCooldowns().isOnCooldown(edibleStack.getItem())) {
                cir.setReturnValue(this.consume(edibleStack.copy(), player.level, player));
                // player.getCooldowns().addCooldown(edibleStack.getItem(), 40);
                // cir.cancel();
            }
        }
    }

    @Unique
    private ItemStack consume(ItemStack stack, Level world, LivingEntity entity) {
        if (stack.isEdible()) {
            entity.eat(world, stack.copy());

            if (!entity.level.isClientSide() && entity instanceof Player player) {
                player.getCooldowns().addCooldown(stack.getItem(), 40);
            }
        }

        return stack;
    }

    @Inject(method = "interactLivingEntity", at = @At("HEAD"))
    private void interactLivingEntity(Player player, LivingEntity livingEntity, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        if (player.getMainHandItem().is(ItemRegistry.FIRE_BLEND.get())) {
            livingEntity.setSecondsOnFire(secondsOnFire);
        }

        if (player.getMainHandItem().is(ItemRegistry.SMOKED_FIRE_BLEND.get())) {
            livingEntity.setSecondsOnFire(smokedSecondsOnFire);
        }
    }

}
