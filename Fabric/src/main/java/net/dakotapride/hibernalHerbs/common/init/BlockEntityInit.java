package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.block.entity.HerbConjurationAltarEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class BlockEntityInit {
    public static BlockEntityType<HerbConjurationAltarEntity> HERB_CONJURATION_ALTAR_ENTITY;

    public static void init() {
        HERB_CONJURATION_ALTAR_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(MOD_ID, "conjuration_altar"),
                FabricBlockEntityTypeBuilder.create(HerbConjurationAltarEntity::new,
                        BlockInit.CONJURATION_ALTAR).build(null));
    }
}
