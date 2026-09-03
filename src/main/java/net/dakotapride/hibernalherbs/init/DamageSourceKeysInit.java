package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class DamageSourceKeysInit {
    public static final ResourceKey<DamageType> AGGLOMERATION_BLOOD_SACRIFICE = ResourceKey.create(Registries.DAMAGE_TYPE, HibernalHerbsMod.asResource("sacrifice/agglomeration"));
    public static final ResourceKey<DamageType> TOME_HUNGER_SACRIFICE = ResourceKey.create(Registries.DAMAGE_TYPE, HibernalHerbsMod.asResource("sacrifice/tome"));
    public static final ResourceKey<DamageType> MIMICRY_REPERCUSSIONS = ResourceKey.create(Registries.DAMAGE_TYPE, HibernalHerbsMod.asResource("mimicry/repercussions"));

    public static DamageSource getDamageSourceFromKey(Level world, ResourceKey<DamageType> key) {
        return new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key));
    }
}
