package net.dakotapride.hibernalHerbs.client;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.dakotapride.hibernalHerbs.common.entity.boat.ModBoatEntity;
import net.dakotapride.hibernalHerbs.common.init.BlockEntityTypeInit;
import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.enum_registry.HerbTypes;
import net.dakotapride.hibernalHerbs.common.init.enum_registry.WoodTypes;
import net.dakotapride.hibernalHerbs.common.item.HerbalPadlockItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;

public class HibernalHerbsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HerbalPadlockItem.clientInit();

        HibernalHerbsClientMod.clientInit();
        HibernalHerbsClientMod.addWoodTypes();

        for (ModBoatEntity.Type type : ModBoatEntity.Type.values()) {
            EntityModelLayerRegistry.registerModelLayer(new ModelLayerLocation(HibernalHerbsCommonMod.asResource(type.getModelLocation()), "main"), BoatModel::createBodyModel);
            EntityModelLayerRegistry.registerModelLayer(new ModelLayerLocation(HibernalHerbsCommonMod.asResource(type.getChestModelLocation()), "main"), ChestBoatModel::createBodyModel);
        }
        BlockEntityRenderers.register(BlockEntityTypeInit.MOD_HANGING_SIGN, HangingSignRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.ROSEMARY.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.THYME.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.TARRAGON.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.CHAMOMILE.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.CHIVES.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.VERBENA.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.SORREL.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.MARJORAM.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.CHERVIL.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.FENNSEL.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.CEILLIS.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.PUNUEL.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.ESSITTE.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.THYOCIELLE.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.FENNKYSTRAL.getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.CALENDULA .getBaseBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.SAGE.getBaseBlock().get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.ROSEMARY.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.THYME.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.TARRAGON.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.CHAMOMILE.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.CHIVES.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.VERBENA.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.SORREL.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.MARJORAM.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.CHERVIL.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.FENNSEL.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.CEILLIS.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.PUNUEL.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.ESSITTE.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.THYOCIELLE.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.FENNKYSTRAL.getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.CALENDULA .getPottedPlantBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HerbTypes.SAGE.getPottedPlantBlock().get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.MYSTICAL_CAMPFIRE.get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(WoodTypes.MYQUESTE.getDoorBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodTypes.MYQUESTE.getTrapdoorBlock().get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WoodTypes.MYQUESTE.getLeavesBlock().get(), RenderType.cutout());
    }
}
