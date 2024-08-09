package net.dakotapride.hibernalherbs.forge.registry;

import net.dakotapride.hibernalherbs.forge.block.entity.HerbConjurationAltarEntity;
import net.minecraft.block.SignBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.dakotapride.hibernalherbs.HibernalHerbsCommon.MOD_ID;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<BlockEntityType<HerbConjurationAltarEntity>> HERB_CONJURATION_ALTAR_ENTITY =
            BLOCK_ENTITIES.register("conjuration_altar", () ->
                    BlockEntityType.Builder.create(HerbConjurationAltarEntity::new,
                            BlockRegistry.CONJURATION_ALTAR.get()).build(null));

    public static final RegistryObject<BlockEntityType<SignBlockEntity>> MYQUESTE_SIGN =
            BLOCK_ENTITIES.register("myqueste_sign", () -> BlockEntityType.Builder.create(SignBlockEntity::new,
                    BlockRegistry.MYQUESTE_SIGN.get(), BlockRegistry.MYQUESTE_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<HangingSignBlockEntity>> MYQUESTE_HANGING_SIGN =
            BLOCK_ENTITIES.register("myqueste_hanging_sign", () -> BlockEntityType.Builder.create(HangingSignBlockEntity::new,
                    BlockRegistry.MYQUESTE_HANGING_SIGN.get(), BlockRegistry.MYQUESTE_WALL_HANGING_SIGN.get()).build(null));

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
