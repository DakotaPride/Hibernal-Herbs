package net.dakotapride.hibernalherbs.forge.registry;

import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.forge.entity.MyquesteBoatEntity;
import net.dakotapride.hibernalherbs.forge.entity.MyquesteChestBoatEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = HibernalHerbsCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityTypeRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HibernalHerbsCommon.MOD_ID);

    public static final RegistryObject<EntityType<MyquesteBoatEntity>> MYQUESTE_BOAT = ENTITY_TYPES.register("boat",
            () -> EntityType.Builder.<MyquesteBoatEntity>create(MyquesteBoatEntity::new,
                            SpawnGroup.MISC).setDimensions(1.375f, 0.5625f).setTrackingRange(10)
                    .build(new Identifier(HibernalHerbsCommon.MOD_ID, "boat").toString()));
    public static final RegistryObject<EntityType<MyquesteChestBoatEntity>> MYQUESTE_CHEST_BOAT = ENTITY_TYPES.register("chest_boat",
            () -> EntityType.Builder.<MyquesteChestBoatEntity>create(MyquesteChestBoatEntity::new,
                            SpawnGroup.MISC).setDimensions(1.375f, 0.5625f).setTrackingRange(10)
                    .build(new Identifier(HibernalHerbsCommon.MOD_ID, "chest_boat").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
