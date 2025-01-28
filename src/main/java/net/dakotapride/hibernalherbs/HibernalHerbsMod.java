package net.dakotapride.hibernalherbs;

import com.mojang.logging.LogUtils;
import net.dakotapride.hibernalherbs.init.*;
import net.dakotapride.hibernalherbs.init.enum_registry.*;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(HibernalHerbsMod.MOD_ID)
public class HibernalHerbsMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "hibernalherbs";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public HibernalHerbsMod(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
        // Resource Pack Registration
        modEventBus.addListener(PackLoader::onAddPackFinders);

        ItemInit.register(modEventBus);
        BlockInit.register(modEventBus);
        BlockEntityTypeInit.register(modEventBus);
        EntityTypeInit.register(modEventBus);
        RecipeInit.register(modEventBus);
        StatusEffectInit.register(modEventBus);
        ItemGroupInit.register(modEventBus);
        EnchantmentKeys.load();
        StructureKeys.load();

        DataComponentInit.load(modEventBus);
        StatsInit.load(modEventBus);
        CriteriaTriggersInit.load(modEventBus);
        PropertiesInit.load();

        // Herb Types - Herb Blocks, Pounded Herbs, Dried Herbs, Herb Lanterns, Herb Barrels, Herb Leaf Piles
        HerbTypes.register();
        // Herbal Blends - Herbal Blends, Smoked Herbal Blends
        HerbalBlendTypes.register();
        // Herbal Padlocks - Unbound Herbal Padlocks, Bound Herbal Padlocks
        PadlockTypes.register();
        // Wood Types - Myqueste
        WoodTypes.register();
        // Stone Types - Idiosyncratic Stone, Necromantic Stone
        StoneTypes.register();
        // Archeology - Metals, Brushes, Suspicious Blocks, Ashes
        Archaeology.register();
        // Metal Utilities - Tools, Armour
        MetalUtilities.register();
        // Fertilizer Types - Herbal Fertilizer, Herb Humus
        FertilizerTypes.register();
        // Herbal Sigils - Blank Herbal Sigil, Cracked Herbal Sigil, Aligned Herbal Sigils
        HerbalSigilTypes.register();
        // Sickles
        Sickles.register();
        // Frozen States
        FrozeBlockstates.register();
        // Armour Tiers
        ModArmourTiers.load(modEventBus);

        // Tags
        Tags.load();

        // Register the item to a creative tab
        //modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static ResourceLocation fromModId(String modId, String id) {
        return ResourceLocation.fromNamespaceAndPath(modId, id);
    }

    public static ResourceLocation asResource(String id) {
        return fromModId(MOD_ID, id);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        //LOGGER.info("HELLO from server starting");
    }
}
