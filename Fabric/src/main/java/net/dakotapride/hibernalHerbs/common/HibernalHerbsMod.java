package net.dakotapride.hibernalHerbs.common;

import net.dakotapride.hibernalHerbs.common.init.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.BiConsumer;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HibernalHerbsMod implements ModInitializer {
	public static Identifier MYQUESTE_ID = new Identifier(MOD_ID, "myqueste");


	// v0.5.2


	public static class groupManager {
		public static ItemGroup HIBERNAL_HERBS = FabricItemGroupBuilder.create(
						new Identifier(MOD_ID, "hibernal_herbs"))
				.icon(() -> new ItemStack(BlockInit.MYQUESTE_LOG.asItem()))
				.appendItems(itemStacks -> {
					itemStacks.add(new ItemStack(ItemInit.HERB_FERTILIZER));
					itemStacks.add(new ItemStack(ItemInit.HERB_HUMUS));

					itemStacks.add(new ItemStack(ItemInit.SCRATCHED_POUCH));

					itemStacks.add(new ItemStack(ItemInit.IRON_CANISTER));
					itemStacks.add(new ItemStack(ItemInit.AMETHYST_CANISTER));
					itemStacks.add(new ItemStack(ItemInit.DIAMOND_CANISTER));

					itemStacks.add(new ItemStack(ItemInit.SIGIL));
					itemStacks.add(new ItemStack(ItemInit.CRACKED_SIGIL));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_PRIDE));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_WRATH));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_GLUTTONY));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_SLOTH));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_LUST));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_ENVY));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_GREED));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_CONFIGURATION));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_CONFIGURATION_ADVANCED));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_MASTERY));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_MASTERY_ADVANCED));

					itemStacks.add(new ItemStack(ItemInit.RING));
					itemStacks.add(new ItemStack(ItemInit.GLUTTONOUS_RING));
					itemStacks.add(new ItemStack(ItemInit.ADV_GLUTTONOUS_RING));

					itemStacks.add(new ItemStack(ItemInit.VEXATION_PADLOCK));
					itemStacks.add(new ItemStack(ItemInit.VEXATION_PADLOCK_BOUND));
					itemStacks.add(new ItemStack(ItemInit.PIQUE_PADLOCK));
					itemStacks.add(new ItemStack(ItemInit.PIQUE_PADLOCK_BOUND));
					itemStacks.add(new ItemStack(ItemInit.GOURMANDIZING_PADLOCK));
					itemStacks.add(new ItemStack(ItemInit.GOURMANDIZING_PADLOCK_BOUND));
					itemStacks.add(new ItemStack(ItemInit.AVARICE_PADLOCK));
					itemStacks.add(new ItemStack(ItemInit.AVARICE_PADLOCK_BOUND));

					itemStacks.add(new ItemStack(ItemInit.HERBAL_GRIMOIRE));
					itemStacks.add(new ItemStack(ItemInit.SINGED_GRIMOIRE));

					itemStacks.add(new ItemStack(ItemInit.SILIPTIUM_PETAL));
					itemStacks.add(new ItemStack(ItemInit.LUMBINETRIK_PETAL));

					itemStacks.add(new ItemStack(BlockInit.CONJURATION_ALTAR.asItem()));

					itemStacks.add(new ItemStack(BlockInit.CALENDULA_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CEILLIS_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHAMOMILE_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHERVIL_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHIVES_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.ESSITTE_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.FENNSEL_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MARJORAM_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.PUNUEL_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.ROSEMARY_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.SORREL_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.TARRAGON_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.THYME_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.VERBENA_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.THYOCIELLE_LANTERN.asItem()));
					itemStacks.add(new ItemStack(BlockInit.FENNKYSTRAL_LANTERN.asItem()));

					itemStacks.add(new ItemStack(BlockInit.CALENDULA_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CEILLIS_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHAMOMILE_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHERVIL_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHIVES_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.ESSITTE_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.FENNSEL_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MARJORAM_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.PUNUEL_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.ROSEMARY_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.SORREL_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.TARRAGON_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.THYME_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.VERBENA_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.THYOCIELLE_HERB_BARREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.FENNKYSTRAL_HERB_BARREL.asItem()));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_LEAF_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CALENDULA_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CEILLIS_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHAMOMILE_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHERVIL_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHIVES_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.ESSITTE_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.FENNSEL_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MARJORAM_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.PUNUEL_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.ROSEMARY_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.SORREL_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.TARRAGON_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.THYME_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.VERBENA_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.THYOCIELLE_HERB_PILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.FENNKYSTRAL_HERB_PILE.asItem()));

					itemStacks.add(new ItemStack(ItemInit.RING));
					itemStacks.add(new ItemStack(ItemInit.GLUTTONOUS_RING));
					itemStacks.add(new ItemStack(ItemInit.ADV_GLUTTONOUS_RING));

					itemStacks.add(new ItemStack(ItemInit.SIGIL));
					itemStacks.add(new ItemStack(ItemInit.CRACKED_SIGIL));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_PRIDE));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_SLOTH));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_LUST));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_GLUTTONY));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_WRATH));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_GREED));
					itemStacks.add(new ItemStack(ItemInit.SIGIL_ENVY));

					itemStacks.add(new ItemStack(ItemInit.REGENERATIVE_BLEND));
					itemStacks.add(new ItemStack(ItemInit.VIRULENT_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SEDATING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.HINDERING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.DASHING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.ACCELERATION_BLEND));
					itemStacks.add(new ItemStack(ItemInit.INCINERATING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.DECAYING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.OBSERVING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.DIMINISHED_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SHADED_BLEND));

					itemStacks.add(new ItemStack(ItemInit.CONFLICTING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.ALTERNATIVE_BLEND));

					// Smoked
					itemStacks.add(new ItemStack(ItemInit.SMOKED_REGENERATIVE_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SMOKED_VIRULENT_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SMOKED_SEDATING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SMOKED_HINDERING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SMOKED_DASHING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SMOKED_ACCELERATION_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SMOKED_INCINERATING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SMOKED_DECAYING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SMOKED_OBSERVING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SMOKED_DIMINISHED_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SMOKED_SHADED_BLEND));

					itemStacks.add(new ItemStack(ItemInit.SMOKED_CONFLICTING_BLEND));
					itemStacks.add(new ItemStack(ItemInit.SMOKED_ALTERNATIVE_BLEND));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_SAPLING.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_LEAVES.asItem()));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_LOG.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_WOOD.asItem()));

					itemStacks.add(new ItemStack(BlockInit.STRIPPED_MYQUESTE_LOG.asItem()));
					itemStacks.add(new ItemStack(BlockInit.STRIPPED_MYQUESTE_WOOD.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_PLANKS.asItem()));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_DOOR.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_TRAPDOOR.asItem()));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_FENCE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_FENCE_GATE.asItem()));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_SLAB.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_STAIRS.asItem()));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_BUTTON.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_PRESSURE_PLATE.asItem()));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_SIGN.asItem()));

					itemStacks.add(new ItemStack(HibernalHerbsBoatTypes.myqueste.getItem()));
					itemStacks.add(new ItemStack(HibernalHerbsBoatTypes.myqueste.getChestItem()));
				}).build();

		public static ItemGroup HERBS = FabricItemGroupBuilder.create(
						new Identifier(MOD_ID, "herbs"))
				.icon(() -> new ItemStack(BlockInit.TARRAGON.asItem()))
				.appendItems(itemStacks -> {
					itemStacks.add(new ItemStack(BlockInit.CEILLIS.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHAMOMILE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHERVIL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.CHIVES.asItem()));
					itemStacks.add(new ItemStack(BlockInit.ESSITTE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.FENNSEL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MARJORAM.asItem()));
					itemStacks.add(new ItemStack(BlockInit.PUNUEL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.ROSEMARY.asItem()));
					itemStacks.add(new ItemStack(BlockInit.SORREL.asItem()));
					itemStacks.add(new ItemStack(BlockInit.TARRAGON.asItem()));
					itemStacks.add(new ItemStack(BlockInit.THYME.asItem()));
					itemStacks.add(new ItemStack(BlockInit.VERBENA.asItem()));

					itemStacks.add(new ItemStack(BlockInit.THYOCIELLE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.FENNKYSTRAL.asItem()));

					itemStacks.add(new ItemStack(BlockInit.CALENDULA.asItem()));
				}).build();

		public static ItemGroup POUNDED_HERBS = FabricItemGroupBuilder.create(
						new Identifier(MOD_ID, "pounded_herbs"))
				.icon(() -> new ItemStack(ItemInit.POUNDED_TARRAGON.asItem()))
				.appendItems(itemStacks -> {
					itemStacks.add(new ItemStack(ItemInit.POUNDED_CEILLIS));
					itemStacks.add(new ItemStack(ItemInit.DRIED_CEILLIS));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_CHAMOMILE));
					itemStacks.add(new ItemStack(ItemInit.DRIED_CHAMOMILE));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_CHERVIL));
					itemStacks.add(new ItemStack(ItemInit.DRIED_CHERVIL));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_CHIVES));
					itemStacks.add(new ItemStack(ItemInit.DRIED_CHIVES));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_ESSITTE));
					itemStacks.add(new ItemStack(ItemInit.DRIED_ESSITTE));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_FENNSEL));
					itemStacks.add(new ItemStack(ItemInit.DRIED_FENNSEL));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_MARJORAM));
					itemStacks.add(new ItemStack(ItemInit.DRIED_MARJORAM));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_PUNUEL));
					itemStacks.add(new ItemStack(ItemInit.DRIED_PUNUEL));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_ROSEMARY));
					itemStacks.add(new ItemStack(ItemInit.DRIED_ROSEMARY));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_SORREL));
					itemStacks.add(new ItemStack(ItemInit.DRIED_SORREL));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_TARRAGON));
					itemStacks.add(new ItemStack(ItemInit.DRIED_TARRAGON));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_THYME));
					itemStacks.add(new ItemStack(ItemInit.DRIED_THYME));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_VERBENA));
					itemStacks.add(new ItemStack(ItemInit.DRIED_VERBENA));

					itemStacks.add(new ItemStack(ItemInit.POUNDED_THYOCIELLE));
					itemStacks.add(new ItemStack(ItemInit.DRIED_THYOCIELLE));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_FENNKYSTRAL));
					itemStacks.add(new ItemStack(ItemInit.DRIED_FENNKYSTRAL));

					itemStacks.add(new ItemStack(ItemInit.POUNDED_CALENDULA));
					itemStacks.add(new ItemStack(ItemInit.DRIED_CALENDULA));
				}).build();
	}

	private static <T> BiConsumer<T, Identifier> bind(Registry<? super T> registry) {
		return (t, id) -> Registry.register(registry, id, t);
	}

	@Override
	public void onInitialize() {

		BlockInit.init();
		ItemInit.init();

		HibernalHerbsBoatTypes.register();

		util.utilsInit();

		FeaturesInit.init();

		BlockEntityInit.init();
		ScreenHandlersInit.init();
		RecipeInit.init();


		// Thanks to @Xanthian#3020 on Modding By KaupenJoe's Discord Server For Built-In Resource Pack Help!
		if (FabricLoader.getInstance().isModLoaded("lambdabettergrass")) {
			FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
				ResourceManagerHelper.registerBuiltinResourcePack(mc("bettergrass"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
			});
		}

		if (FabricLoader.getInstance().isModLoaded("eatinganimationid")) {
			FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
				ResourceManagerHelper.registerBuiltinResourcePack(mc("eatinganimations"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
			});
		}

		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(mc("barebones"), modContainer, ResourcePackActivationType.NORMAL);
		});

	}

	// Credit For method/The LambdaBetterGrass Mod goes to LambdAurora
	public static Identifier mc(@NotNull String path) {
		return new Identifier(MOD_ID, path);
	}

	// This method serves as a hook to modify item tooltips. The vanilla game
	// has no mechanism to load tooltip listeners so this must be registered
	// by a mod loader like Forge or Fabric.
	public static void onItemTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip) {

		if (!stack.isEmpty()) {

			final FoodComponent food = stack.getItem().getFoodComponent();

			if (food != null) {
				tooltip.add(Text.literal("Saturation: " + food.getSaturationModifier()));
			}
		}
	}

}
