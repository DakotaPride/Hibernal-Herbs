package net.dakotapride.hibernalherbs.fabric.registry;

import net.dakotapride.hibernalherbs.fabric.block.entity.HerbConjurationAltarEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalherbs.HibernalHerbsCommon.MOD_ID;

public class BlockEntityRegistry {
    public static BlockEntityType<HerbConjurationAltarEntity> HERB_CONJURATION_ALTAR_ENTITY;

    public static void register() {
        HERB_CONJURATION_ALTAR_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "conjuration_altar"),
                BlockEntityType.Builder.create(HerbConjurationAltarEntity::new, BlockRegistry.CONJURATION_ALTAR).build(null));
    }
}
