package net.dakotapride.hibernalHerbs.common.init;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsMod;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HibernalHerbsBoatTypes {
    public static TerraformBoatType myqueste;
    private static final RegistryKey<TerraformBoatType> MYQUESTE_BOAT_KEY = TerraformBoatTypeRegistry.createKey(HibernalHerbsMod.MYQUESTE_ID);

    public static void init() {
        var item = TerraformBoatItemHelper.registerBoatItem(new Identifier(MOD_ID, "myqueste_boat"), MYQUESTE_BOAT_KEY, false);
        var chestItem = TerraformBoatItemHelper.registerBoatItem(new Identifier(MOD_ID, "myqueste_chest_boat"), MYQUESTE_BOAT_KEY, true);

        myqueste = new TerraformBoatType.Builder()
                .item(item)
                .chestItem(chestItem)
                .planks(BlockInit.MYQUESTE_PLANKS.asItem())
                .build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, new Identifier(MOD_ID, "myqueste"), myqueste);
    }
}
