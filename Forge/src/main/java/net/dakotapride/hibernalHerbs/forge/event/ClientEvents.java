package net.dakotapride.hibernalherbs.forge.event;

import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.forge.client.MyquesteBoatRenderer;
import net.dakotapride.hibernalherbs.forge.registry.BlockEntityRegistry;
import net.dakotapride.hibernalherbs.forge.registry.EntityTypeRegistry;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//@Mod.EventBusSubscriber(modid = HibernalHerbsCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    //@SubscribeEvent
    public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityTypeRegistry.MYQUESTE_BOAT.get(), context -> new MyquesteBoatRenderer(context, false));
        event.registerEntityRenderer(EntityTypeRegistry.MYQUESTE_CHEST_BOAT.get(), context -> new MyquesteBoatRenderer(context, true));
        event.registerBlockEntityRenderer(BlockEntityRegistry.MYQUESTE_SIGN.get(), SignBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.MYQUESTE_HANGING_SIGN.get(), HangingSignBlockEntityRenderer::new);
    }

    //@SubscribeEvent
    public static void registerEntityModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(new EntityModelLayer(new Identifier(HibernalHerbsCommon.MOD_ID, "boat/myqueste"), "main"), BoatEntityModel::getTexturedModelData);
        event.registerLayerDefinition(new EntityModelLayer(new Identifier(HibernalHerbsCommon.MOD_ID, "chest_boat/myqueste"), "main"), BoatEntityModel::getTexturedModelData);
    }
}
