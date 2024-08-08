package net.dakotapride.hibernalherbs.fabric.registry;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.registry.BlockRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class BoatTypeRegistry {
    public static TerraformBoatType MYQUESTE_TYPE;
    private static final RegistryKey<TerraformBoatType> MYQUESTE_BOAT_KEY = TerraformBoatTypeRegistry.createKey(new Identifier(HibernalHerbsCommon.MOD_ID, "myqueste"));

    public static void register() {
        var item = TerraformBoatItemHelper.registerBoatItem(new Identifier(HibernalHerbsCommon.MOD_ID, "myqueste_boat"), MYQUESTE_BOAT_KEY, false);
        var chestItem = TerraformBoatItemHelper.registerBoatItem(new Identifier(HibernalHerbsCommon.MOD_ID, "myqueste_chest_boat"), MYQUESTE_BOAT_KEY, true);

        MYQUESTE_TYPE = new TerraformBoatType.Builder()
                .item(item)
                .chestItem(chestItem)
                .planks(BlockRegistry.MYQUESTE_PLANKS.asItem())
                .build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, new Identifier(HibernalHerbsCommon.MOD_ID, "myqueste"), MYQUESTE_TYPE);
    }
}
