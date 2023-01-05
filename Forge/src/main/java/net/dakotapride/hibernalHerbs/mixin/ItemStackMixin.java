package net.dakotapride.hibernalHerbs.mixin;

import net.dakotapride.hibernalHerbs.common.food.FoodComponentList;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements FoodComponentList {

    @Inject(method = "finishUsingItem", at = @At("HEAD"))
    private void finishUsingItem(Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> cir) {
        if (livingEntity.getMainHandItem().is(itemRegistry.INCINERATING_BLEND.get())) {
            livingEntity.setSecondsOnFire(secondsOnFire);
        }

        if (livingEntity.getMainHandItem().is(itemRegistry.SMOKED_INCINERATING_BLEND.get())) {
            livingEntity.setSecondsOnFire(smokedSecondsOnFire);
        }
    }

    @Inject(method = "interactLivingEntity", at = @At("HEAD"))
    private void interactLivingEntity(Player player, LivingEntity livingEntity, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        if (player.getMainHandItem().is(itemRegistry.INCINERATING_BLEND.get())) {
            livingEntity.setSecondsOnFire(secondsOnFire);
        }

        if (player.getMainHandItem().is(itemRegistry.SMOKED_INCINERATING_BLEND.get())) {
            livingEntity.setSecondsOnFire(smokedSecondsOnFire);
        }
    }

}
