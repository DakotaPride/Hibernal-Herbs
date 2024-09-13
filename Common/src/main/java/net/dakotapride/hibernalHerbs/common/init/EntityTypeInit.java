package net.dakotapride.hibernalHerbs.common.init;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.dakotapride.hibernalHerbs.common.entity.boat.ModBoatEntity;
import net.dakotapride.hibernalHerbs.common.entity.boat.ModChestBoatEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class EntityTypeInit {
    public static Registrar<EntityType<?>> entities = HibernalHerbsCommonMod.MANAGER.get().get(Registries.ENTITY_TYPE);

    // WIP
    public static RegistrySupplier<EntityType<ModBoatEntity>> MOD_BOAT = register("boat",
            EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10)
                    .build(HibernalHerbsCommonMod.asResource("boat").toString()));
    public static RegistrySupplier<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT = register("chest_boat",
            EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10)
                    .build(HibernalHerbsCommonMod.asResource("chest_boat").toString()));

    // Collective Registration
    public static void register() {}

    public static <T extends Entity> RegistrySupplier<EntityType<T>> register(String name, EntityType<T> entityType) {
        return entities.register(HibernalHerbsCommonMod.asResource(name), () -> entityType);
    }
}
