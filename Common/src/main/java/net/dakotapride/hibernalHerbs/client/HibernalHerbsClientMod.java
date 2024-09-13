package net.dakotapride.hibernalHerbs.client;

import net.dakotapride.hibernalHerbs.common.entity.render.ModBoatRenderer;
import net.dakotapride.hibernalHerbs.common.init.BlockEntityTypeInit;
import net.dakotapride.hibernalHerbs.common.init.EntityTypeInit;
import net.dakotapride.hibernalHerbs.common.init.enum_registry.WoodTypes;
import net.dakotapride.hibernalHerbs.platform.ClientPlatformHelper;
import net.minecraft.client.renderer.blockentity.SignRenderer;

public class HibernalHerbsClientMod {

    public static void clientInit() {
        ClientPlatformHelper.registerEntityRenderer(EntityTypeInit.MOD_BOAT, context -> new ModBoatRenderer<>(context, false));
        ClientPlatformHelper.registerEntityRenderer(EntityTypeInit.MOD_CHEST_BOAT, context -> new ModBoatRenderer<>(context, true));

        ClientPlatformHelper.registerBlockEntityRenderer(() -> BlockEntityTypeInit.MOD_SIGN, SignRenderer::new);
        ClientPlatformHelper.registerBlockEntityRenderer(() -> BlockEntityTypeInit.MYSTICAL_CAMPFIRE, MysticalCampfireRenderer::new);
    }

    public static void addWoodTypes() {
        ClientPlatformHelper.addWoodType(WoodTypes.MYQUESTE.getWoodType());
    }
}