package net.dakotapride.hibernalHerbs.common;

import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.FeaturesInit;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HibernalHerbsMod implements ModInitializer {
	// v0.5.2


	public static class groupManager {
		public static ItemGroup HIBERNAL_HERBS = FabricItemGroupBuilder.create(
						new Identifier(MOD_ID, "hibernal_herbs"))
				.icon(() -> new ItemStack(BlockInit.MYQUESTE_LOG.asItem()))
				.appendItems(itemStacks -> {
					itemStacks.add(new ItemStack(ItemInit.HERB_FERTILIZER));
					itemStacks.add(new ItemStack(ItemInit.POUCH));
					itemStacks.add(new ItemStack(ItemInit.CANISTER));

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

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_PLANKS.asItem()));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_LOG.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_WOOD.asItem()));

					itemStacks.add(new ItemStack(BlockInit.STRIPPED_MYQUESTE_LOG.asItem()));
					itemStacks.add(new ItemStack(BlockInit.STRIPPED_MYQUESTE_WOOD.asItem()));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_DOOR.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_TRAPDOOR.asItem()));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_FENCE.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_FENCE_GATE.asItem()));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_SLAB.asItem()));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_STAIRS.asItem()));
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
				}).build();

		public static ItemGroup POUNDED_HERBS = FabricItemGroupBuilder.create(
						new Identifier(MOD_ID, "pounded_herbs"))
				.icon(() -> new ItemStack(ItemInit.POUNDED_TARRAGON.asItem()))
				.appendItems(itemStacks -> {
					itemStacks.add(new ItemStack(ItemInit.POUNDED_CEILLIS));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_CHAMOMILE));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_CHERVIL));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_CHIVES));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_ESSITTE));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_FENNSEL));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_MARJORAM));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_PUNUEL));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_ROSEMARY));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_SORREL));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_TARRAGON));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_THYME));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_VERBENA));

					itemStacks.add(new ItemStack(ItemInit.POUNDED_THYOCIELLE));
					itemStacks.add(new ItemStack(ItemInit.POUNDED_FENNKYSTRAL));
				}).build();
	}

	@Override
	public void onInitialize() {
		BlockInit.init();
		ItemInit.init();

		util.utilsInit();

		FeaturesInit.init();


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
