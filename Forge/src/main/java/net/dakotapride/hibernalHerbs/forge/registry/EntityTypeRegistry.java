package net.dakotapride.hibernalherbs.forge.registry;

import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.forge.entity.MyquesteBoatEntity;
import net.dakotapride.hibernalherbs.forge.entity.MyquesteChestBoatEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = HibernalHerbsCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityTypeRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HibernalHerbsCommon.MOD_ID);

    public static final RegistryObject<EntityType<MyquesteBoatEntity>> MYQUESTE_BOAT = ENTITIES.register("myqueste_boat",
            () -> EntityType.Builder.<MyquesteBoatEntity>create(MyquesteBoatEntity::new,
                    SpawnGroup.MISC).setDimensions(1.375f, 0.5625f).setTrackingRange(10)
                    .build(new Identifier(HibernalHerbsCommon.MOD_ID, "myqueste_boat").toString()));
    public static final RegistryObject<EntityType<MyquesteChestBoatEntity>> MYQUESTE_CHEST_BOAT = ENTITIES.register("myqueste_chest_boat",
            () -> EntityType.Builder.<MyquesteChestBoatEntity>create(MyquesteChestBoatEntity::new,
                    SpawnGroup.MISC).setDimensions(1.375f, 0.5625f).setTrackingRange(10)
                    .build(new Identifier(HibernalHerbsCommon.MOD_ID, "myqueste_chest_boat").toString()));

}
