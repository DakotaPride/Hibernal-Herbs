package net.dakotapride.hibernalHerbs.common.event;

import net.dakotapride.hibernalHerbs.common.entity.HibernalBlockEntities;
import net.dakotapride.hibernalHerbs.common.entity.HibernalEntityTypes;
import net.dakotapride.hibernalHerbs.common.entity.render.MyquesteBoatRenderer;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(HibernalEntityTypes.MYQUESTE_BOAT.get(), context -> new MyquesteBoatRenderer(context, false));
        event.registerEntityRenderer(HibernalEntityTypes.MYQUESTE_CHEST_BOAT.get(), context -> new MyquesteBoatRenderer(context, true));
        event.registerBlockEntityRenderer(HibernalBlockEntities.MYQUESTE_SIGN.get(), SignRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(MOD_ID, "boat/myqueste"), "main"), () -> BoatModel.createBodyModel(false));
        event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(MOD_ID, "chest_boat/myqueste"), "main"), () -> BoatModel.createBodyModel(true));
    }
}
