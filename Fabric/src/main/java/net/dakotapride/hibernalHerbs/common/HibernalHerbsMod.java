package net.dakotapride.hibernalHerbs.common;

import net.dakotapride.hibernalHerbs.common.init.*;
import net.dakotapride.hibernalHerbs.common.item.HibernalItemTabs;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HibernalHerbsMod implements ModInitializer {
	public static Identifier MYQUESTE_ID = new Identifier(MOD_ID, "myqueste");


	// v0.5.2

	@Override
	public void onInitialize() {
		HibernalItemTabs.init();

		TypeInit.SetType.init();

		BlockInit.init();
		ItemInit.init();

		HibernalHerbsBoatTypes.init();

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

		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(mc("modernized"), modContainer, ResourcePackActivationType.NORMAL);
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
