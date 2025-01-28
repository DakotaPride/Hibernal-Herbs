package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.entity.boat.ModBoatEntity;
import net.dakotapride.hibernalherbs.entity.boat.ModChestBoatEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class EntityTypeInit {
    // WIP
    public static EntityType<ModBoatEntity> MOD_BOAT = register("boat",
            EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10)
                    .build(HibernalHerbsMod.asResource("boat").toString()));
    public static EntityType<ModChestBoatEntity> MOD_CHEST_BOAT = register("chest_boat",
            EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10)
                    .build(HibernalHerbsMod.asResource("chest_boat").toString()));

    // Collective Registration
    public static void register() {}

    public static <T extends Entity> EntityType<T> register(String name, EntityType<T> entityType) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, HibernalHerbsMod.asResource(name), entityType);
    }
}
