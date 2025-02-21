package net.dakotapride.hibernalherbs.effect;

import net.dakotapride.hibernalherbs.init.ParticleTypeInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.SpawnUtil;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public class ShriekingStatusEffect extends BasicStatusEffect {
    private final float chanceToSpawn;

    public ShriekingStatusEffect(MobEffectCategory mobEffectCategory, int i, float f) {
        super(mobEffectCategory, i, ParticleTypeInit.SHRIEKING);
        this.chanceToSpawn = f;
    }

    @Override
    public void onMobHurt(LivingEntity livingEntity, int i, DamageSource damageSource, float f) {
        if (livingEntity.getRandom().nextFloat() <= this.chanceToSpawn) {
            this.spawnWarden(
                    livingEntity.level(), livingEntity, livingEntity.getX(), livingEntity.getY() + (double)livingEntity.getBbHeight() / 2.0, livingEntity.getZ()
            );
        }
    }

    private void spawnWarden(Level level, LivingEntity livingEntity, double d, double e, double f) {
        Warden warden = EntityType.WARDEN.create(level);
        if (warden != null) {
            //warden.setAggressive(true);
            //warden.setTarget(livingEntity);
            //SpawnUtil.trySpawnMob(EntityType.WARDEN, MobSpawnType.TRIGGERED, serverLevel, this.getBlockPos(), 20, 5, 6, SpawnUtil.Strategy.ON_TOP_OF_COLLIDER)
            RandomSource randomSource = livingEntity.getRandom();
            float g = (float) (Math.PI / 2);
            float h = Mth.randomBetween(randomSource, (float) (-Math.PI / 2), (float) (Math.PI / 2));
            Vector3f vector3f = livingEntity.getLookAngle().toVector3f().mul(0.3F).mul(1.0F, 1.5F, 1.0F).rotateY(h);
            warden.moveTo(d, e, f, level.getRandom().nextFloat() * 360.0F, 0.0F);
            warden.setDeltaMovement(new Vec3(vector3f));
            //level.addFreshEntity(warden);
            if (level instanceof ServerLevel serverLevel)
                SpawnUtil.trySpawnMob(EntityType.WARDEN, MobSpawnType.TRIGGERED, serverLevel, livingEntity.blockPosition(), 20, 5, 6, SpawnUtil.Strategy.ON_TOP_OF_COLLIDER);
            warden.playSound(SoundEvents.WARDEN_HURT);
        }
    }
}
