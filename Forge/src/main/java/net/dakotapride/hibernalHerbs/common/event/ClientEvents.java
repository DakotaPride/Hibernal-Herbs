package net.dakotapride.hibernalHerbs.common.event;

import net.dakotapride.hibernalHerbs.common.entity.HibernalBlockEntities;
import net.dakotapride.hibernalHerbs.common.entity.HibernalEntityTypes;
import net.dakotapride.hibernalHerbs.common.entity.render.MyquesteBoatRenderer;
import net.dakotapride.hibernalHerbs.common.registry.ItemRegistry;
import net.dakotapride.hibernalHerbs.common.screen.HerbalConjurationScreen;
import net.dakotapride.hibernalHerbs.common.screen.menu.HibernalHerbsMenues;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.resource.ResourcePackLoader;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(HibernalEntityTypes.MYQUESTE_BOAT.get(), context -> new MyquesteBoatRenderer(context, false));
        event.registerEntityRenderer(HibernalEntityTypes.MYQUESTE_CHEST_BOAT.get(), context -> new MyquesteBoatRenderer(context, true));
        event.registerBlockEntityRenderer(HibernalBlockEntities.MYQUESTE_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(HibernalBlockEntities.MYQUESTE_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(MOD_ID, "boat/myqueste"), "main"), BoatModel::createBodyModel);
        event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(MOD_ID, "chest_boat/myqueste"), "main"), BoatModel::createBodyModel);
    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        ItemProperties.register(ItemRegistry.CANISTER.get(), new ResourceLocation(MOD_ID, "filled"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));
        ItemProperties.register(ItemRegistry.IRON_CANISTER.get(), new ResourceLocation(MOD_ID, "filled"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));
        ItemProperties.register(ItemRegistry.AMETHYST_CANISTER.get(), new ResourceLocation(MOD_ID, "filled"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));
        ItemProperties.register(ItemRegistry.DIAMOND_CANISTER.get(), new ResourceLocation(MOD_ID, "filled"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));

        MenuScreens.register(HibernalHerbsMenues.CONJURATION_ALTAR_MENU.get(), HerbalConjurationScreen::new);

        EntityRenderers.register(HibernalEntityTypes.MYQUESTE_BOAT.get(), (context) -> new MyquesteBoatRenderer(context, false));
        EntityRenderers.register(HibernalEntityTypes.MYQUESTE_CHEST_BOAT.get(), (context) -> new MyquesteBoatRenderer(context, true));
    }
}
