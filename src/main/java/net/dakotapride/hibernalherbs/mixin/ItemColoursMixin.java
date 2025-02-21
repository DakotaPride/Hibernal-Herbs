package net.dakotapride.hibernalherbs.mixin;

import net.dakotapride.hibernalherbs.init.ItemInit;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.alchemy.PotionContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemColors.class)
public class ItemColoursMixin {

	@Inject(method = "createDefault", at = @At("RETURN"))
	private static void getItemColourProviders(BlockColors blockColors, CallbackInfoReturnable<ItemColors> cir) {
		cir.getReturnValue().register(
				(itemStack, i) -> i > 0 ? -1 : FastColor.ARGB32.opaque(itemStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).getColor()),
				ItemInit.ENIGMATIC_POTION, ItemInit.SOLAR_POTION, ItemInit.LUNAR_POTION
		);
	}
}
