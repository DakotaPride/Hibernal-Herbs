package net.dakotapride.hibernalherbs.mixin;

import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MaceItem.class)
public class MaceItemMixin {

    @Inject(method = "postHurtEnemy", at = @At("RETURN"))
    private void provideLifeForceFromEnchantment(ItemStack itemStack, LivingEntity livingEntity, LivingEntity livingEntity2, CallbackInfo ci) {
        if (livingEntity2 instanceof Player player) {
            if (player.getOffhandItem().is(Items.GLASS_BOTTLE) && EnchantmentHelper.hasTag(itemStack, Tags.Enchantments.HARVESTS_LIFE_FORCE.getTag())) {
                livingEntity2.getOffhandItem().shrink(1);

                player.addItem(new ItemStack(ItemInit.LIFE_FORCE_BOTTLE, 1));
            }
        }
    }

}
