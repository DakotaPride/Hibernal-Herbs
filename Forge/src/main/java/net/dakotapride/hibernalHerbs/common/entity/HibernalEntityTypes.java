package net.dakotapride.hibernalHerbs.common.entity;

import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteBoatEntity;
import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteChestBoatEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HibernalEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<EntityType<MyquesteBoatEntity>> MYQUESTE_BOAT = ENTITIES.register("myqueste_boat",
            () -> EntityType.Builder.<MyquesteBoatEntity>of(MyquesteBoatEntity::new,
                    MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10)
                    .build(new ResourceLocation(MOD_ID, "myqueste_boat").toString()));
    public static final RegistryObject<EntityType<MyquesteChestBoatEntity>> MYQUESTE_CHEST_BOAT = ENTITIES.register("myqueste_chest_boat",
            () -> EntityType.Builder.<MyquesteChestBoatEntity>of(MyquesteChestBoatEntity::new,
                    MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10)
                    .build(new ResourceLocation(MOD_ID, "myqueste_chest_boat").toString()));

}
