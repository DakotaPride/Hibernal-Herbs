package net.dakotapride.hibernalHerbs.common;

import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class util {

    public static void utilsInit() {
        StrippableBlockRegistry.register(BlockInit.MYQUESTE_LOG, BlockInit.STRIPPED_MYQUESTE_LOG);
        StrippableBlockRegistry.register(BlockInit.MYQUESTE_WOOD, BlockInit.STRIPPED_MYQUESTE_WOOD);
    }

}
