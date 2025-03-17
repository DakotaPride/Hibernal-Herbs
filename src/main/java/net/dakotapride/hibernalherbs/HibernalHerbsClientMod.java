package net.dakotapride.hibernalherbs;

import net.dakotapride.hibernalherbs.client.ModBrushableBlockRenderer;
import net.dakotapride.hibernalherbs.client.MysticalCampfireRenderer;
import net.dakotapride.hibernalherbs.entity.boat.ModBoatEntity;
import net.dakotapride.hibernalherbs.entity.render.ModBoatRenderer;
import net.dakotapride.hibernalherbs.init.*;
import net.dakotapride.hibernalherbs.init.enum_registry.FrozeBlockstates;
import net.dakotapride.hibernalherbs.init.enum_registry.HerbTypes;
import net.dakotapride.hibernalherbs.init.enum_registry.WoodTypes;
import net.dakotapride.hibernalherbs.item.HerbalPadlockItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.particle.SpellParticle;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;

public class HibernalHerbsClientMod implements ClientModInitializer {

    @Environment(EnvType.CLIENT)
    public static boolean hasShiftDown() {
        return Screen.hasShiftDown();
    }

    @Environment(EnvType.CLIENT)
    public static boolean hasAltDown() {
        return Screen.hasAltDown();
    }

    @Override
    public void onInitializeClient() {
        FabricModelPredicateProviderRegistry.register(ItemInit.SORCERER_AGGLOMERATION, HibernalHerbsMod.asResource("is_using_agglomeration"),
                (stack, world, entity, seed) -> Boolean.TRUE.equals(stack.get(DataComponentInit.IS_BEING_USED)) ? 1f : 0f);
        FabricModelPredicateProviderRegistry.register(ItemInit.SORCERER_TOME, HibernalHerbsMod.asResource("is_using_tome"),
                (stack, world, entity, seed) -> Boolean.TRUE.equals(stack.get(DataComponentInit.IS_BEING_USED)) ? 1f : 0f);

        EntityRendererRegistry.register(EntityTypeInit.MOD_BOAT, context -> new ModBoatRenderer<>(context, false));
        EntityRendererRegistry.register(EntityTypeInit.MOD_CHEST_BOAT, context -> new ModBoatRenderer<>(context, true));

        BlockEntityRenderers.register(BlockEntityTypeInit.MOD_SIGN, SignRenderer::new);
        BlockEntityRenderers.register(BlockEntityTypeInit.MYSTICAL_CAMPFIRE, MysticalCampfireRenderer::new);
        BlockEntityRenderers.register(BlockEntityTypeInit.MOD_HANGING_SIGN, HangingSignRenderer::new);
        BlockEntityRenderers.register(BlockEntityTypeInit.BRUSHABLE_BLOCK, ModBrushableBlockRenderer::new);

        Sheets.SIGN_MATERIALS.put(WoodTypes.MYQUESTE.getWoodType(), new Material(Sheets.SIGN_SHEET, HibernalHerbsMod.asResource("entity/signs/" + WoodTypes.MYQUESTE.getWoodType().name())));

        HerbalPadlockItem.clientInit();

        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.INCENSE_PROVIDER, RenderType.cutout());

        for (ModBoatEntity.Type type : ModBoatEntity.Type.values()) {
            EntityModelLayerRegistry.registerModelLayer(new ModelLayerLocation(HibernalHerbsMod.asResource(type.getModelLocation()), "main"), BoatModel::createBodyModel);
            EntityModelLayerRegistry.registerModelLayer(new ModelLayerLocation(HibernalHerbsMod.asResource(type.getChestModelLocation()), "main"), ChestBoatModel::createBodyModel);
        }

        for (FrozeBlockstates states : FrozeBlockstates.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(states.getFrozeTrapdoorState(), RenderType.cutoutMipped());
            BlockRenderLayerMap.INSTANCE.putBlock(states.getFrozeDoorState(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(states.getFrozeGrateState(), RenderType.cutoutMipped());
        }

        for (HerbTypes types : HerbTypes.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(types.getBaseBlock(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(types.getPottedPlantBlock(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(types.getHerbPileBlock(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(types.getLanternBlock(), RenderType.cutout());
        }

        for (WoodTypes types : WoodTypes.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(types.getDoorBlock(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(types.getTrapdoorBlock(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(types.getLeavesBlock(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(types.getSaplingBlock(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(types.getPottedSaplingBlock(), RenderType.cutout());
        }

        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.MYSTICAL_CAMPFIRE, RenderType.cutout());

        ParticleFactoryRegistry.getInstance().register(ParticleTypeInit.SWARMING, SpellParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ParticleTypeInit.INSTABILITY, SpellParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(ParticleTypeInit.SHRIEKING, SpellParticle.Provider::new);
    }
}