package net.dakotapride.hibernalherbs.mixin;

import net.dakotapride.hibernalherbs.init.ItemInit;
import net.minecraft.world.inventory.BrewingStandMenu;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrewingStandMenu.PotionSlot.class)
public class PotionSlotMixin {
    @Inject(method = "mayPlaceItem", at = @At("RETURN"), cancellable = true)
    private static void mayPlace(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (itemStack.is(ItemInit.ENIGMATIC_POTION) || itemStack.is(ItemInit.SOLAR_POTION) || itemStack.is(ItemInit.LUNAR_POTION)) {
            cir.setReturnValue(true);
        }
    }
}
