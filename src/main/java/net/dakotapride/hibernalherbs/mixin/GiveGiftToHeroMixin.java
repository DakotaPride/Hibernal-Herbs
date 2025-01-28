package net.dakotapride.hibernalherbs.mixin;

import net.dakotapride.hibernalherbs.init.StatusEffectInit;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.behavior.GiveGiftToHero;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GiveGiftToHero.class, remap = false)
public class GiveGiftToHeroMixin {
//    @Inject(method = "isHero", at = @At("RETURN"), cancellable = true)
//    private void isHero(Player player, CallbackInfoReturnable<Boolean> cir) {
////        if (player.hasEffect(StatusEffectInit.RAPACITY)) {
////            cir.setReturnValue(true);
////        }
//
//        cir.setReturnValue(player.hasEffect(StatusEffectInit.RAPACITY) || player.hasEffect(MobEffects.HERO_OF_THE_VILLAGE));
//    }
}
