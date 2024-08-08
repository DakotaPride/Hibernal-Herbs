package net.dakotapride.hibernalherbs.fabric.client;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.fabric.registry.BlockRegistry;
import net.dakotapride.hibernalherbs.fabric.registry.ScreenHandlersRegistry;
import net.dakotapride.hibernalherbs.fabric.screen.HerbConjurationAltarScreen;
import net.dakotapride.hibernalherbs.registry.ItemRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class HibernalHerbsFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.ROSEMARY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYME, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHAMOMILE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHIVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.VERBENA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.SORREL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.MARJORAM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHERVIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNSEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.CEILLIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.PUNUEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.ESSITTE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYOCIELLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNKYSTRAL, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.CALENDULA, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.SAGE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_ROSEMARY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_THYME, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_TARRAGON, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_CHAMOMILE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_CHIVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_VERBENA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_SORREL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_MARJORAM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_CHERVIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_FENNSEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_CEILLIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_PUNUEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_ESSITTE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_THYOCIELLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_FENNKYSTRAL, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_CALENDULA, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_SAGE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.POTTED_MYQUESTE_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.CALENDULA_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.ROSEMARY_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYME_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.TARRAGON_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHAMOMILE_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHIVES_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.VERBENA_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.SORREL_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.MARJORAM_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.CHERVIL_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNSEL_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.CEILLIS_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.PUNUEL_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.ESSITTE_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.THYOCIELLE_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.FENNKYSTRAL_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.SAGE_LANTERN, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.MYQUESTE_LEAF_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ROSEMARY_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.THYME_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.TARRAGON_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.CHAMOMILE_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.CHIVES_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.VERBENA_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.SORREL_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.MARJORAM_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.CHERVIL_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.FENNSEL_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.CEILLIS_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PUNUEL_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.ESSITTE_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.FENNKYSTRAL_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.THYOCIELLE_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.CALENDULA_HERB_PILE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.SAGE_HERB_PILE, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.CONJURATION_ALTAR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.LUST_HERB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.GREED_HERB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.ENVY_HERB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.WRATH_HERB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.GLUTTONY_HERB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.SLOTH_HERB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.dakotapride.hibernalherbs.registry.BlockRegistry.PRIDE_HERB, RenderLayer.getCutout());

        HandledScreens.register(ScreenHandlersRegistry.CONJURATION_ALTAR_SCREEN_HANDLER, HerbConjurationAltarScreen::new);

        // Render Layers (Terraform)
        TerraformBoatClientHelper.registerModelLayers(new Identifier(HibernalHerbsCommon.MOD_ID, "myqueste"), false);
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, BlockRegistry.MYQUESTE_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, BlockRegistry.MYQUESTE_HANGING_SIGN_TEXTURE));


        // Model Predicate Providers

        FabricModelPredicateProviderRegistry.register(ItemRegistry.CANISTER, new Identifier(HibernalHerbsCommon.MOD_ID, "filled"),
                ((stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f));

        FabricModelPredicateProviderRegistry.register(ItemRegistry.IRON_CANISTER, new Identifier(HibernalHerbsCommon.MOD_ID, "filled"),
                ((stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f));
        FabricModelPredicateProviderRegistry.register(ItemRegistry.AMETHYST_CANISTER, new Identifier(HibernalHerbsCommon.MOD_ID, "filled"),
                ((stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f));
        FabricModelPredicateProviderRegistry.register(ItemRegistry.DIAMOND_CANISTER, new Identifier(HibernalHerbsCommon.MOD_ID, "filled"),
                ((stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f));

    }
}
