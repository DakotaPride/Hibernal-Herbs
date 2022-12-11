package net.dakotapride.hibernalHerbs.mixin;

import net.dakotapride.hibernalHerbs.common.init.itemRegistry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(method = "finishUsingItem", at = @At("HEAD"))
    private void finishUsingItem(Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> cir) {
        if (livingEntity.getMainHandItem().is(itemRegistry.INCINERATING_BLEND.get())) {
            livingEntity.setSecondsOnFire(15);
        }
    }

    @Inject(method = "interactLivingEntity", at = @At("HEAD"))
    private void interactLivingEntity(Player player, LivingEntity livingEntity, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        if (player.getMainHandItem().is(itemRegistry.INCINERATING_BLEND.get())) {
            livingEntity.setSecondsOnFire(15);
        }
    }

}