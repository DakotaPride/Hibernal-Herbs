package net.dakotapride.hibernalHerbs.platform.fabric;


import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.Supplier;

public class ClientPlatformHelperImpl {
    public static <T extends Entity> void registerEntityRenderer(Supplier<EntityType<T>> type, EntityRendererProvider<T> renderProvider) {
        EntityRendererRegistry.register(type.get(), renderProvider);
    }

    public static <T extends BlockEntity> void registerBlockEntityRenderer(Supplier<BlockEntityType<T>> type, BlockEntityRendererProvider<T> renderProvider) {
        BlockEntityRendererRegistry.register(type.get(), renderProvider);
    }

    public static void addWoodType(WoodType woodType) {
        Sheets.SIGN_MATERIALS.put(woodType, new Material(Sheets.SIGN_SHEET, HibernalHerbsCommonMod.asResource("entity/signs/" + woodType.name())));
    }
}