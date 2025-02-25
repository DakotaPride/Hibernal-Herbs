package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ParticleTypeInit {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, HibernalHerbsMod.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SWARMING = register("swarming", false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> INSTABILITY = register("instability", false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SHRIEKING = register("shrieking", false);

    private static DeferredHolder<ParticleType<?>, SimpleParticleType> register(String key, boolean overrideLimiter) {
        return PARTICLE_TYPES.register(key, () -> new SimpleParticleType(overrideLimiter));
    }

    public static void load(IEventBus bus) {
        PARTICLE_TYPES.register(bus);
    }
}
