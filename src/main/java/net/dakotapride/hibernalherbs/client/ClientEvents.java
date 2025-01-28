package net.dakotapride.hibernalherbs.client;

import com.google.common.collect.Maps;
import net.dakotapride.hibernalherbs.entity.render.ModBoatRenderer;
import net.dakotapride.hibernalherbs.init.BlockEntityTypeInit;
import net.dakotapride.hibernalherbs.init.EntityTypeInit;
import net.dakotapride.hibernalherbs.init.enum_registry.FrozeBlockstates;
import net.dakotapride.hibernalherbs.init.enum_registry.WoodTypes;
import net.dakotapride.hibernalherbs.item.HerbalPadlockItem;
import net.minecraft.Util;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.Map;

import static net.dakotapride.hibernalherbs.HibernalHerbsMod.MOD_ID;
import static net.dakotapride.hibernalherbs.HibernalHerbsMod.asResource;

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityTypeInit.MOD_BOAT.get(), context -> new ModBoatRenderer<>(context, false));
        event.registerEntityRenderer(EntityTypeInit.MOD_CHEST_BOAT.get(), context -> new ModBoatRenderer<>(context, true));
        event.registerBlockEntityRenderer(BlockEntityTypeInit.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityTypeInit.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityTypeInit.BRUSHABLE_BLOCK.get(), ModBrushableBlockRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityTypeInit.MYSTICAL_CAMPFIRE.get(), MysticalCampfireRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(new ModelLayerLocation(asResource("boat/myqueste"), "main"), BoatModel::createBodyModel);
        event.registerLayerDefinition(new ModelLayerLocation(asResource("chest_boat/myqueste"), "main"), ChestBoatModel::createBodyModel);
    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
//        ItemProperties.register(ItemRegistry.CANISTER.get(), new ResourceLocation(MOD_ID, "filled"),
//                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));
//        ItemProperties.register(ItemRegistry.IRON_CANISTER.get(), new ResourceLocation(MOD_ID, "filled"),
//                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));
//        ItemProperties.register(ItemRegistry.AMETHYST_CANISTER.get(), new ResourceLocation(MOD_ID, "filled"),
//                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));
//        ItemProperties.register(ItemRegistry.DIAMOND_CANISTER.get(), new ResourceLocation(MOD_ID, "filled"),
//                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));

//        for (FrozeBlockstates frozeBlockstates : FrozeBlockstates.values()) {
//            ItemBlockRenderTypes.setRenderLayer(frozeBlockstates.getDoorBlock(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(frozeBlockstates.getTrapdoorBlock(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(frozeBlockstates.getGrateBlock(), RenderType.cutout());
//        }

        for (WoodTypes types : WoodTypes.values()) {
            Sheets.addWoodType(types.getWoodType());
        }

        HerbalPadlockItem.clientInit();

        HerbalPadlockItem.clientInit();
    }
}
