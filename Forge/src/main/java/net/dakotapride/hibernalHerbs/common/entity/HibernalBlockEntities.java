package net.dakotapride.hibernalHerbs.common.entity;

import net.dakotapride.hibernalHerbs.common.entity.block.ConjurationAltarBlockEntity;
import net.dakotapride.hibernalHerbs.common.entity.block.MyquesteSignBlockEntity;
import net.dakotapride.hibernalHerbs.common.registry.BlockRegistry;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HibernalBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<BlockEntityType<ConjurationAltarBlockEntity>> CONJURATION_ALTAR =
            BLOCK_ENTITIES.register("conjuration_altar", () ->
                    BlockEntityType.Builder.of(ConjurationAltarBlockEntity::new,
                            BlockRegistry.CONJURATION_ALTAR.get()).build(null));

    public static final RegistryObject<BlockEntityType<MyquesteSignBlockEntity>> MYQUESTE_SIGN =
            BLOCK_ENTITIES.register("myqueste_sign", () -> BlockEntityType.Builder.of(MyquesteSignBlockEntity::new,
                    BlockRegistry.MYQUESTE_SIGN.get(), BlockRegistry.MYQUESTE_WALL_SIGN.get()).build(null));

}
