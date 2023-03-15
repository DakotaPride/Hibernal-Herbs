package net.dakotapride.hibernalHerbs.common.init;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HibernalHerbsBoatTypes {
    public static TerraformBoatType myqueste;

    public static void register() {
        var item = TerraformBoatItemHelper.registerBoatItem(new Identifier(MOD_ID, "myqueste_boat"), () -> myqueste, false);
        var chestItem = TerraformBoatItemHelper.registerBoatItem(new Identifier(MOD_ID, "myqueste_chest_boat"), () -> myqueste, true);

        myqueste = new TerraformBoatType.Builder()
                .item(item)
                .chestItem(chestItem)
                .planks(BlockInit.MYQUESTE_PLANKS.asItem())
                .build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, new Identifier(MOD_ID, "myqueste"), myqueste);
    }
}
