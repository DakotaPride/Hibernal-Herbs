package net.dakotapride.hibernalherbs.mixin;

import net.dakotapride.hibernalherbs.init.StatusEffectInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Villager.class)
public abstract class VillagerMixin extends AbstractVillager {
    public VillagerMixin(EntityType<? extends AbstractVillager> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "updateSpecialPrices", at = @At("RETURN"))
    private void updateSpecialPrices(Player player, CallbackInfo ci) {
        if (player.hasEffect(StatusEffectInit.RAPACITY)) {
            MobEffectInstance mobEffectInstance = player.getEffect(StatusEffectInit.RAPACITY);
            int j = mobEffectInstance.getAmplifier();

            for (MerchantOffer merchantOffer2 : this.getOffers()) {
                double d = 0.15 + 0.0625 * (double) j;
                int k = (int) Math.floor(d * (double) merchantOffer2.getBaseCostA().getCount());
                merchantOffer2.addToSpecialPriceDiff(-Math.max(k, 1));
            }
        }
    }

}
