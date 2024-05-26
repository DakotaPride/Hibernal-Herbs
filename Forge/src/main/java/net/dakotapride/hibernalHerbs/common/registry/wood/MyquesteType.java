package net.dakotapride.hibernalHerbs.common.registry.wood;

import net.dakotapride.hibernalHerbs.common.registry.BlockRegistry;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class MyquesteType {

    public static final WoodType MYQUESTE = WoodType.register(new WoodType(MOD_ID + ":myqueste", BlockRegistry.MYQUESTE_SET));

    @OnlyIn(Dist.CLIENT)
    public static void init() {
        Sheets.addWoodType(MYQUESTE);
    }

}
