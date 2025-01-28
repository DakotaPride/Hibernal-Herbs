package net.dakotapride.hibernalherbs.mixin;

import net.dakotapride.hibernalherbs.init.enum_registry.Archaeology;
import net.dakotapride.hibernalherbs.init.enum_registry.MetalUtilities;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinAi.class)
public class PiglinAiMixin {

    @Inject(method = "isBarterCurrency", at = @At("HEAD"), cancellable = true)
    private static void isBarterCurrency(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        boolean isSyrum = itemStack.is(Archaeology.Metals.SYRUM.getIngotItem());

        if (isSyrum) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "isWearingGold", at = @At("HEAD"), cancellable = true)
    private static void isWearingGold(LivingEntity livingEntity, CallbackInfoReturnable<Boolean> cir) {
//        for (ItemStack itemStack : livingEntity.getArmorAndBodyArmorSlots()) {
//            Item item = itemStack.getItem();
//            if (item instanceof ArmorItem && ((ArmorItem)item).getMaterial().is(ModArmourTiers.EMBROIDERED_ARKONIUM)) {
//                cir.setReturnValue(true);
//            }
//        }

        ItemStack head = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack body = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack leggings = livingEntity.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack boots = livingEntity.getItemBySlot(EquipmentSlot.FEET);

        Item equipped_helmet = MetalUtilities.Armour.SYRUM.getHelmetItem();
        Item equipped_chestplate = MetalUtilities.Armour.SYRUM.getChestplateItem();
        Item equipped_leggings = MetalUtilities.Armour.SYRUM.getLeggingsItem();
        Item equipped_boots = MetalUtilities.Armour.SYRUM.getBootsItem();

        if (head.is(equipped_helmet) && body.is(equipped_chestplate) && leggings.is(equipped_leggings) && boots.is(equipped_boots)) {
            cir.setReturnValue(true);
        }
    }
}
