package net.dakotapride.hibernalherbs.mixin;

import net.minecraft.world.entity.ai.behavior.GiveGiftToHero;
import org.spongepowered.asm.mixin.Mixin;

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
