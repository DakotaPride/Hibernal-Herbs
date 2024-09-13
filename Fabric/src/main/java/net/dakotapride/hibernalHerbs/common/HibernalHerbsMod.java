package net.dakotapride.hibernalHerbs.common;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod.MOD_ID;

public class HibernalHerbsMod implements ModInitializer {

	@Override
	public void onInitialize() {
		HibernalHerbsCommonMod.init();

		HibernalHerbsCommonMod.registerWoodTypes();

		// Thanks to @Xanthian#3020 on Modding By KaupenJoe's Discord Server For Built-In Resource Pack Help!
//		if (FabricLoader.getInstance().isModLoaded("lambdabettergrass")) {
//			FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
//				ResourceManagerHelper.registerBuiltinResourcePack(mc("bettergrass"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
//			});
//		}
//
//		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
//			ResourceManagerHelper.registerBuiltinResourcePack(mc("stripped_planks"), modContainer, ResourcePackActivationType.NORMAL);
//		});

	}

	// Credit For method/The LambdaBetterGrass Mod goes to LambdAurora
	public static ResourceLocation mc(@NotNull String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

}
