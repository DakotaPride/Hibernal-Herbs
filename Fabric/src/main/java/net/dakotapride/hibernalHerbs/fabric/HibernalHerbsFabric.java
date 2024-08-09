package net.dakotapride.hibernalherbs.fabric;

import net.dakotapride.hibernalherbs.fabric.registry.*;
import net.fabricmc.api.ModInitializer;

import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public final class HibernalHerbsFabric implements ModInitializer {
    @Override
    public void onInitialize() {

        HibernalHerbsCommon.LOG.info("[Hibernal Herbs Fabric] If you're seeing this message, stuff has begun to be registered");
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        HibernalHerbsCommon.init();

        // Fabric item register
        ItemRegistry.register();
        // Fabric Block register
        BlockRegistry.register();
        // Fabric Item Group register
        ItemGroupsRegistry.register();
        // Fabric Feature register
        FeaturesRegistry.register();
        // Terraform Boat Type register
        BoatTypeRegistry.register();

        ScreenHandlersRegistry.register();
        BlockEntityRegistry.register();

        // Stripping... Not like that
        StrippableBlockRegistry.register(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_LOG, net.dakotapride.hibernalherbs.registry.BlockRegistry.STRIPPED_MYQUESTE_LOG);
        StrippableBlockRegistry.register(net.dakotapride.hibernalherbs.registry.BlockRegistry.MYQUESTE_WOOD, net.dakotapride.hibernalherbs.registry.BlockRegistry.STRIPPED_MYQUESTE_WOOD);

        // Thanks to @Xanthian#3020 on Modding By KaupenJoe's Discord Server For Built-In Resource Pack Help!
        // Fabric Resource Pack loading
        if (FabricLoader.getInstance().isModLoaded("lambdabettergrass")) {
            FabricLoader.getInstance().getModContainer(HibernalHerbsCommon.MOD_ID).ifPresent(modContainer -> {
                ResourceManagerHelper.registerBuiltinResourcePack(mc("bettergrass"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
            });
        }

        if (FabricLoader.getInstance().isModLoaded("eatinganimationid")) {
            FabricLoader.getInstance().getModContainer(HibernalHerbsCommon.MOD_ID).ifPresent(modContainer -> {
                ResourceManagerHelper.registerBuiltinResourcePack(mc("eatinganimations"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
            });
        }

//        FabricLoader.getInstance().getModContainer(HibernalHerbsCommon.MOD_ID).ifPresent(modContainer -> {
//            ResourceManagerHelper.registerBuiltinResourcePack(mc("barebones"), modContainer, ResourcePackActivationType.NORMAL);
//        });
//
//        FabricLoader.getInstance().getModContainer(HibernalHerbsCommon.MOD_ID).ifPresent(modContainer -> {
//            ResourceManagerHelper.registerBuiltinResourcePack(mc("modernized"), modContainer, ResourcePackActivationType.NORMAL);
//        });

        HibernalHerbsCommon.LOG.info("[Hibernal Herbs Fabric] If you're seeing this message, registration has finished");
    }


    // Credit For method/The LambdaBetterGrass Mod goes to LambdAurora
    public static Identifier mc(@NotNull String path) {
        return new Identifier(HibernalHerbsCommon.MOD_ID, path);
    }
}
