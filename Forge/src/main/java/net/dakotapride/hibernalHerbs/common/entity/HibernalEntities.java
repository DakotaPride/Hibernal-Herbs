package net.dakotapride.hibernalHerbs.common.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HibernalEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<EntityType<MyquesteBoat>> BOAT = createEntity("boat", EntityType.Builder.<MyquesteBoat>of(MyquesteBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F));
    public static final RegistryObject<EntityType<MyquesteChestBoat>> CHEST_BOAT = createEntity("chest_boat", EntityType.Builder.<MyquesteChestBoat>of(MyquesteChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    public static <E extends Entity> RegistryObject<EntityType<E>> createEntity(String id, EntityType.Builder<E> entityType) {
        return ENTITIES.register(id, () -> entityType.build(MOD_ID + ":" + id));
    }

    public static void loadClass() {}
}
