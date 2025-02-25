package net.dakotapride.hibernalherbs;

import com.mojang.logging.LogUtils;
import net.dakotapride.hibernalherbs.init.*;
import net.dakotapride.hibernalherbs.init.enum_registry.*;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

import java.util.List;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(HibernalHerbsMod.MOD_ID)
public class HibernalHerbsMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "hibernalherbs";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

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
        PotionsInit.register(modEventBus);
        ItemGroupInit.register(modEventBus);
        EnchantmentKeys.load();
        StructureKeys.load();

        ParticleTypeInit.load(modEventBus);
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

//    @SubscribeEvent
//    public void lootTableEvents(LootTableLoadEvent event) {
////        if (event.getTable().getLootTableId().equals(BuiltInLootTables.SPAWNER_TRIAL_ITEMS_TO_DROP_WHEN_OMINOUS)) {
////            LootPool swarming_potion = LootPool.lootPool()
////                    .setRolls(ConstantValue.exactly(1))
////                    .when(LootItemRandomChanceCondition.randomChance(1.00F))//0.15
////                    .add(
////                            LootItem.lootTableItem(Items.LINGERING_POTION)
////                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
////                                    .apply(SetPotionFunction.setPotion(PotionsInit.SWARMING))
////                    )
////                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).build();
////            LootPool instability_potion = LootPool.lootPool()
////                    .setRolls(ConstantValue.exactly(1))
////                    .when(LootItemRandomChanceCondition.randomChance(0.05F))//0.05
////                    .add(
////                            LootItem.lootTableItem(Items.LINGERING_POTION)
////                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
////                                    .apply(SetPotionFunction.setPotion(PotionsInit.INSTABILITY))
////                    )
////                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).build();
////            LootPool shrieking_potion = LootPool.lootPool()
////                    .setRolls(ConstantValue.exactly(1))
////                    .when(LootItemRandomChanceCondition.randomChance(0.35F))//0.35
////                    .add(
////                            LootItem.lootTableItem(Items.LINGERING_POTION)
////                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
////                                    .apply(SetPotionFunction.setPotion(PotionsInit.SHRIEKING))
////                    )
////                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).build();
////
////            event.setTable((LootTable) List.of(swarming_potion, instability_potion, shrieking_potion));
////        }
//
////        if (event.getTable().getLootTableId().equals(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE)) {
////                LootPool herbal_sigils = LootPool.lootPool()
////                        .setRolls(ConstantValue.exactly(1))
////                        .when(LootItemRandomChanceCondition.randomChance(0.35F))//35%
////                        .add(
////                                LootItem.lootTableItem(HerbalSigilTypes.PRIDE.getHerbalSigilItem())
////                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
////                        )
////                        .add(
////                                LootItem.lootTableItem(HerbalSigilTypes.ENVY.getHerbalSigilItem())
////                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
////                        )
////                        .add(
////                                LootItem.lootTableItem(HerbalSigilTypes.WRATH.getHerbalSigilItem())
////                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
////                        )
////                        .add(
////                                LootItem.lootTableItem(HerbalSigilTypes.GREED.getHerbalSigilItem())
////                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
////                        )
////                        .add(
////                                LootItem.lootTableItem(HerbalSigilTypes.GLUTTONY.getHerbalSigilItem())
////                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
////                        )
////                        .add(
////                                LootItem.lootTableItem(HerbalSigilTypes.SLOTH.getHerbalSigilItem())
////                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
////                        )
////                        .add(
////                                LootItem.lootTableItem(HerbalSigilTypes.LUST.getHerbalSigilItem())
////                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
////                        )
////                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).build();
////
////                event.setTable((LootTable) List.of(herbal_sigils));
////            }
//    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        //LOGGER.info("HELLO from server starting");
    }

    @SubscribeEvent
    public void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addContainer(ItemInit.ENIGMATIC_POTION.asItem());
        builder.addContainer(ItemInit.SOLAR_POTION.asItem());
        builder.addContainer(ItemInit.LUNAR_POTION.asItem());

        builder.addMix(Potions.AWKWARD, HerbTypes.SAGE.getDriedHerb(), PotionsInit.FROST_RESISTANCE);

        builder.addMix(Potions.AWKWARD, Items.BEE_NEST, PotionsInit.SWARMING);
        builder.addMix(Potions.AWKWARD, Items.END_ROD, PotionsInit.INSTABILITY);
        builder.addMix(Potions.AWKWARD, Items.SCULK_SHRIEKER, PotionsInit.SHRIEKING);

        builder.addContainerRecipe(Items.POTION, ItemInit.MYSTICAL_ASHES.get(), ItemInit.ENIGMATIC_POTION.get());
        builder.addContainerRecipe(Items.POTION, Items.CLOCK, ItemInit.SOLAR_POTION.get());
        builder.addContainerRecipe(ItemInit.SOLAR_POTION.get(), Items.SCULK, ItemInit.LUNAR_POTION.get());

        HibernalHerbsMod.LOGGER.info("[Hibernal Herbs Dev Environment] POTION RECIPES REGISTRAR");
    }
}
