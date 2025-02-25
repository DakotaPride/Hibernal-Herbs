package net.dakotapride.hibernalherbs.effect;

import net.dakotapride.hibernalherbs.init.ParticleTypeInit;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.function.ToIntFunction;

public class SwarmingStatusEffect extends BasicStatusEffect {
    private final float chanceToSpawn;
    private final ToIntFunction<RandomSource> spawnedCount;

    public SwarmingStatusEffect(MobEffectCategory mobEffectCategory, int i, float f, ToIntFunction<RandomSource> toIntFunction) {
        super(mobEffectCategory, i);
        this.chanceToSpawn = f;
        this.spawnedCount = toIntFunction;
    }

    @Override
    public @NotNull ParticleOptions createParticleOptions(@NotNull MobEffectInstance effect) {
        return ParticleTypeInit.SWARMING.get();
    }

    @Override
    public void onMobHurt(LivingEntity livingEntity, int i, DamageSource damageSource, float f) {
        if (livingEntity.getRandom().nextFloat() <= this.chanceToSpawn) {
            int j = this.spawnedCount.applyAsInt(livingEntity.getRandom());

            for (int k = 0; k < j; k++) {
                this.spawnBees(
                        livingEntity.level(), livingEntity, livingEntity.getX(), livingEntity.getY() + (double)livingEntity.getBbHeight() / 2.0, livingEntity.getZ()
                );
            }
        }
    }

    private void spawnBees(Level level, LivingEntity livingEntity, double d, double e, double f) {
        Bee bee = EntityType.BEE.create(level);
        if (bee != null) {
            bee.setAggressive(true);
            bee.setTarget(livingEntity);
            RandomSource randomSource = livingEntity.getRandom();
            float g = (float) (Math.PI / 2);
            float h = Mth.randomBetween(randomSource, (float) (-Math.PI / 2), (float) (Math.PI / 2));
            Vector3f vector3f = livingEntity.getLookAngle().toVector3f().mul(0.3F).mul(1.0F, 1.5F, 1.0F).rotateY(h);
            bee.moveTo(d, e, f, level.getRandom().nextFloat() * 360.0F, 0.0F);
            bee.setDeltaMovement(new Vec3(vector3f));
            level.addFreshEntity(bee);
            bee.playSound(SoundEvents.BEE_HURT);
        }
    }
}