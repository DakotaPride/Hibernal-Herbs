package net.dakotapride.hibernalherbs.effect;

import net.dakotapride.hibernalherbs.init.ParticleTypeInit;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class InstabilityStatusEffect extends BasicStatusEffect {
    public InstabilityStatusEffect(MobEffectCategory category, int colour) {
        super(category, colour);
    }

    @Override
    public @NotNull ParticleOptions createParticleOptions(@NotNull MobEffectInstance effect) {
        return ParticleTypeInit.INSTABILITY.get();
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int j) {
        Level level = livingEntity.level();

        if (!level.isClientSide) {
            for (int i = 0; i < 16; i++) {
                double d = livingEntity.getX() + (livingEntity.getRandom().nextDouble() - 0.5) * 16.0;
                double e = Mth.clamp(
                        livingEntity.getY() + (double)(livingEntity.getRandom().nextInt(16) - 8),
                        level.getMinBuildHeight(),
                        (level.getMinBuildHeight() + ((ServerLevel)level).getLogicalHeight() - 1)
                );
                double f = livingEntity.getZ() + (livingEntity.getRandom().nextDouble() - 0.5) * 16.0;
                if (livingEntity.isPassenger()) {
                    livingEntity.stopRiding();
                }

                Vec3 vec3 = livingEntity.position();
                if (livingEntity.randomTeleport(d, e, f, true)) {
                    level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(livingEntity));
                    SoundSource soundSource;
                    SoundEvent soundEvent;
                    if (livingEntity instanceof Fox) {
                        soundEvent = SoundEvents.FOX_TELEPORT;
                        soundSource = SoundSource.NEUTRAL;
                    } else {
                        soundEvent = SoundEvents.CHORUS_FRUIT_TELEPORT;
                        soundSource = SoundSource.PLAYERS;
                    }

                    level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), soundEvent, soundSource);
                    livingEntity.resetFallDistance();
                    break;
                }
            }
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int i, int j) {
        int k = 50 >> j;
        return k > 0 ? i % k == 0 : true;
    }
}
