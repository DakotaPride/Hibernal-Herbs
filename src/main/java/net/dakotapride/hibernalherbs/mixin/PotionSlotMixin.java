package net.dakotapride.hibernalherbs.mixin;

import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.world.inventory.BrewingStandMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrewingStandMenu.PotionSlot.class)
public class PotionSlotMixin {

    @Inject(method = "mayPlaceItem", at = @At("HEAD"), cancellable = true)
    private static void placeItemStack(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(itemStack.getItem() instanceof PotionItem || itemStack.is(Tags.Items.IS_ACCEPTABLE_IN_BREWING_STAND.getTag()));
    }
}
