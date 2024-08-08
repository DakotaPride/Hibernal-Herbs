package net.dakotapride.hibernalherbs;

// Utilize Yarn Mappings


import net.dakotapride.hibernalherbs.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HibernalHerbsCommon {

    public static final String MOD_ID = "hibernalherbs";
    public static final String MOD_NAME = "Hibernal Herbs";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        // Write common init code here.

        // HibernalHerbsTabs.init();

        // TypeRegistry.SetType.register();

        BlockRegistry.register();
        ItemRegistry.register();

        // Move to fabric
        //ItemGroupsRegistry.register();

        Utilities.register();

        FeaturesRegistry.register();

        // Move to fabric
        //BlockEntityRegistry.register();

        // Moved to fabric
        //ScreenHandlersRegistry.init();

        RecipeRegistry.register();


        // Thanks to @Xanthian#3020 on Modding By KaupenJoe's Discord Server For Built-In Resource Pack Help!
//        if (FabricLoader.getInstance().isModLoaded("lambdabettergrass")) {
//            FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
//                ResourceManagerHelper.registerBuiltinResourcePack(mc("bettergrass"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
//            });
//        }
//
//        if (FabricLoader.getInstance().isModLoaded("eatinganimationid")) {
//            FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
//                ResourceManagerHelper.registerBuiltinResourcePack(mc("eatinganimations"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
//            });
//        }
//
//        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
//            ResourceManagerHelper.registerBuiltinResourcePack(mc("barebones"), modContainer, ResourcePackActivationType.NORMAL);
//        });
//
//        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
//            ResourceManagerHelper.registerBuiltinResourcePack(mc("modernized"), modContainer, ResourcePackActivationType.NORMAL);
//        });
    }
}
