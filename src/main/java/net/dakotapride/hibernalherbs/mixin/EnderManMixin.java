package net.dakotapride.hibernalherbs.mixin;

import net.dakotapride.hibernalherbs.init.enum_registry.MetalUtilities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderMan.class)
public abstract class EnderManMixin extends Monster implements NeutralMob {
    public EnderManMixin(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method = "isLookingAtMe", at = @At("HEAD"), cancellable = true)
    private void isLookingAtMe(Player player, CallbackInfoReturnable<Boolean> cir) {

        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack body = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);

        Item equipped_helmet = MetalUtilities.Armour.SYRUM.getHelmetItem();
        Item equipped_chestplate = MetalUtilities.Armour.SYRUM.getChestplateItem();
        Item equipped_leggings = MetalUtilities.Armour.SYRUM.getLeggingsItem();
        Item equipped_boots = MetalUtilities.Armour.SYRUM.getBootsItem();

        if (head.is(equipped_helmet) && body.is(equipped_chestplate) && leggings.is(equipped_leggings) && boots.is(equipped_boots)) {
            cir.setReturnValue(false);
        }
    }

}
