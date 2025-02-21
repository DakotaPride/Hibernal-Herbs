package net.dakotapride.hibernalherbs;

import net.dakotapride.hibernalherbs.init.*;
import net.dakotapride.hibernalherbs.init.enum_registry.*;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.dakotapride.hibernalherbs.mixin.WoodTypeAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HibernalHerbsMod implements ModInitializer {
	public static final String MOD_ID = "hibernalherbs";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ItemInit.register();
		BlockInit.register();
		BlockEntityTypeInit.register();
		EntityTypeInit.register();
		RecipeInit.register();
		StatusEffectInit.register();
		PotionsInit.register();
		ItemGroupInit.register();
		EnchantmentKeys.load();
		StructureKeys.load();

		ParticleTypeInit.load();
		DataComponentInit.load();
		StatsInit.load();
		CriteriaTriggersInit.load();
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

		// Resource Packs
		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(asResource("stripped_planks"), modContainer, ResourcePackActivationType.NORMAL);
			ResourceManagerHelper.registerBuiltinResourcePack(asResource("visual_frozen_states"), modContainer, ResourcePackActivationType.NORMAL);
		});

		// Tags
		Tags.load();

		// Worldgen
		BiomeModifications.addFeature(BiomeSelectors.tag(Tags.Biomes.HAS_HERBS.getTag()),
				GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, asResource("herbs")));
		BiomeModifications.addFeature(BiomeSelectors.tag(Tags.Biomes.HAS_HERBS.getTag()),
				GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, asResource("myqueste")));

		WoodTypeAccessor.invokeRegister(WoodTypes.MYQUESTE.getWoodType());

		LOGGER.info("Running Hibernal Herbs v1.4 on Minecraft version 1.21");

		LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) ->
				{
					if (key.equals(BuiltInLootTables.SPAWNER_TRIAL_ITEMS_TO_DROP_WHEN_OMINOUS)) {
						LootPool swarming_potion = LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.when(LootItemRandomChanceCondition.randomChance(0.15F))//0.05
								.add(
										LootItem.lootTableItem(Items.LINGERING_POTION)
												.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
												.apply(SetPotionFunction.setPotion(PotionsInit.SWARMING))
								)
								.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).build();
						LootPool instability_potion = LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.when(LootItemRandomChanceCondition.randomChance(0.05F))//0.05
								.add(
										LootItem.lootTableItem(Items.LINGERING_POTION)
												.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
												.apply(SetPotionFunction.setPotion(PotionsInit.INSTABILITY))
								)
								.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).build();
						LootPool shrieking_potion = LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.when(LootItemRandomChanceCondition.randomChance(0.35F))//0.001
								.add(
										LootItem.lootTableItem(Items.LINGERING_POTION)
												.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
												.apply(SetPotionFunction.setPotion(PotionsInit.SHRIEKING))
								)
								.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).build();

						tableBuilder.pools(List.of(swarming_potion, instability_potion, shrieking_potion));
					}

					if (key.equals(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE)) {
						LootPool herbal_sigils = LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.when(LootItemRandomChanceCondition.randomChance(0.35F))//35%
								.add(
										LootItem.lootTableItem(HerbalSigilTypes.PRIDE.getHerbalSigilItem())
												.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
								)
								.add(
										LootItem.lootTableItem(HerbalSigilTypes.ENVY.getHerbalSigilItem())
												.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
								)
								.add(
										LootItem.lootTableItem(HerbalSigilTypes.WRATH.getHerbalSigilItem())
												.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
								)
								.add(
										LootItem.lootTableItem(HerbalSigilTypes.GREED.getHerbalSigilItem())
												.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
								)
								.add(
										LootItem.lootTableItem(HerbalSigilTypes.GLUTTONY.getHerbalSigilItem())
												.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
								)
								.add(
										LootItem.lootTableItem(HerbalSigilTypes.SLOTH.getHerbalSigilItem())
												.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
								)
								.add(
										LootItem.lootTableItem(HerbalSigilTypes.LUST.getHerbalSigilItem())
												.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
								)
								.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).build();

						tableBuilder.pools(List.of(herbal_sigils));
					}
				}));
	}

	public static ResourceLocation fromModId(String modId, String id) {
		return ResourceLocation.fromNamespaceAndPath(modId, id);
	}

	public static ResourceLocation asResource(String id) {
		return fromModId(MOD_ID, id);
	}
}