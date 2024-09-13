package net.dakotapride.hibernalHerbs.common;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.RegistrarManager;
import net.dakotapride.hibernalHerbs.common.init.*;
import net.dakotapride.hibernalHerbs.common.init.enum_registry.HerbTypes;
import net.dakotapride.hibernalHerbs.common.init.enum_registry.HerbalBlendTypes;
import net.dakotapride.hibernalHerbs.common.init.enum_registry.PadlockTypes;
import net.dakotapride.hibernalHerbs.common.init.enum_registry.WoodTypes;
import net.dakotapride.hibernalHerbs.common.init.enum_registry.tag.Tags;
import net.dakotapride.hibernalHerbs.platform.CommonPlatformHelper;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class HibernalHerbsCommonMod {

	public static final String MOD_ID = "hibernalherbs";
	public static final String MOD_NAME = "Hibernal Herbs";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));


	public static void init() {
		ItemInit.register();
		BlockInit.register();
		BlockEntityTypeInit.register();
		EntityTypeInit.register();
		RecipeInit.register();

		// Herb Types - Herb Blocks, Pounded Herbs, Dried Herbs, Herb Lanterns, Herb Barrels, Herb Leaf Piles
		HerbTypes.register();
		// Herbal Blends - Herbal Blends, Smoked Herbal Blends
		HerbalBlendTypes.register();
		// Herbal Padlocks - Unbound Herbal Padlocks, Bound Herbal Padlocks
		PadlockTypes.register();
		// Wood Types - Myqueste
		WoodTypes.register();


		// Tags
		Tags.Items.load();
	}

	public static void registerWoodTypes() {
		CommonPlatformHelper.registerWoodType(WoodTypes.MYQUESTE.getWoodType());
	}


	public static ResourceLocation fromModId(String modId, String id) {
		return ResourceLocation.fromNamespaceAndPath(modId, id);
	}

	public static ResourceLocation asResource(String id) {
		return fromModId(MOD_ID, id);
	}
}