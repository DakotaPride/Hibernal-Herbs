package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public interface DamageSourceKeysInit {
    ResourceKey<DamageType> AGGLOMERATION_BLOOD_SACRIFICE = ResourceKey.create(Registries.DAMAGE_TYPE, HibernalHerbsMod.asResource("sacrifice/agglomeration"));
    ResourceKey<DamageType> TOME_HUNGER_SACRIFICE = ResourceKey.create(Registries.DAMAGE_TYPE, HibernalHerbsMod.asResource("sacrifice/tome"));
    ResourceKey<DamageType> MIMICRY_REPERCUSSIONS = ResourceKey.create(Registries.DAMAGE_TYPE, HibernalHerbsMod.asResource("mimicry/repercussions"));
}
