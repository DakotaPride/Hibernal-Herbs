package net.dakotapride.hibernalherbs.mixin;

import net.dakotapride.hibernalherbs.effect.ApplyEffectOnAttackStatusEffect;
import net.dakotapride.hibernalherbs.effect.SiphonHealthStatusEffect;
import net.dakotapride.hibernalherbs.init.StatusEffectInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Unique
    LivingEntity livingEntity = (LivingEntity)(Object)this;
    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "hurt", at = @At("RETURN"), cancellable = true)
    private void hurt(DamageSource source, float f, CallbackInfoReturnable<Boolean> cir) {
        ApplyEffectOnAttackStatusEffect effect = (ApplyEffectOnAttackStatusEffect) StatusEffectInit.LETHARGY.value();
        SiphonHealthStatusEffect effect1 = (SiphonHealthStatusEffect) StatusEffectInit.SANGUINE.value();

        if (source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker) {
            if (attacker.hasEffect(StatusEffectInit.LETHARGY)) {
                livingEntity.addEffect(new MobEffectInstance(effect.getEffect(), 100, 4), this);
                //if (attacker instanceof Player player) player.sendSystemMessage(Component.translatable("testing.hibernalherbs.lethargy"));
            }
            if (attacker.hasEffect(StatusEffectInit.SANGUINE)) {
                // 6 * 0.54 =
                attacker.heal(f * effect1.getHealthMultiplicative());
                //if (attacker instanceof Player player) player.sendSystemMessage(Component.translatable("testing.hibernalherbs.sanguine"));
            }
        }
    }

    @Inject(method = "canFreeze", at = @At("RETURN"), cancellable = true)
    private void canFreeze(CallbackInfoReturnable<Boolean> cir) {
        // Frost Resistance
        if (livingEntity.hasEffect(StatusEffectInit.FROST_RESISTANCE)) {
            cir.setReturnValue(false);
        }
    }

}
