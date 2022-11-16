package net.dakotapride.hibernalHerbs.common;

import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.dakotapride.hibernalHerbs.common.init.FeaturesInit;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class HibernalHerbsMod implements ModInitializer {
	public static final String HIBERNAL_HERBS_ID = "hibernalherbs";

	public static class groupManager {
		public static ItemGroup HIBERNAL_HERBS = FabricItemGroupBuilder.create(
						new Identifier(HIBERNAL_HERBS_ID, "hibernal_herbs"))
				.icon(() -> new ItemStack(BlockInit.MYQUESTE_LOG.asItem()))
				.appendItems(itemStacks -> {
					itemStacks.add(new ItemStack(ItemInit.HERB_FERTILIZER));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_SAPLING));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_LEAVES));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_PLANKS));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_LOG));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_WOOD));

					itemStacks.add(new ItemStack(BlockInit.STRIPPED_MYQUESTE_LOG));
					itemStacks.add(new ItemStack(BlockInit.STRIPPED_MYQUESTE_WOOD));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_DOOR));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_TRAPDOOR));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_FENCE));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_FENCE_GATE));

					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_SLAB));
					itemStacks.add(new ItemStack(BlockInit.MYQUESTE_STAIRS));
				}).build();

		public static ItemGroup HERBS = FabricItemGroupBuilder.create(
						new Identifier(HIBERNAL_HERBS_ID, "herbs"))
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
				}).build();

		public static ItemGroup POUNDED_HERBS = FabricItemGroupBuilder.create(
						new Identifier(HIBERNAL_HERBS_ID, "pounded_herbs"))
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
				}).build();
	}

	@Override
	public void onInitialize() {
		BlockInit.init();
		ItemInit.init();

		util.utilsInit();

		FeaturesInit.init();


		if (FabricLoader.getInstance().isModLoaded("lambdabettergrass")) {
			// Thanks to @Xanthian#3020 on Modding By KaupenJoe's Discord Server For Built-In Resource Pack Help!
			FabricLoader.getInstance().getModContainer(HIBERNAL_HERBS_ID).ifPresent(modContainer -> {
				ResourceManagerHelper.registerBuiltinResourcePack(mc("bettergrass"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
			});
		}
	}

	// Credit For method/The LambdaBetterGrass Mod goes to LambdAurora
	public static Identifier mc(@NotNull String path) {
		return new Identifier(HIBERNAL_HERBS_ID, path);
	}

}
