package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.particle.BasicParticleType;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

public class ParticleTypeInit {
    public static final SimpleParticleType SWARMING = register("swarming", false);
    public static final SimpleParticleType INSTABILITY = register("instability", false);
    public static final SimpleParticleType SHRIEKING = register("shrieking", false);

    private static SimpleParticleType register(String string, boolean bl) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, HibernalHerbsMod.asResource(string), new BasicParticleType(bl));
    }

    public static void load() {}
}
