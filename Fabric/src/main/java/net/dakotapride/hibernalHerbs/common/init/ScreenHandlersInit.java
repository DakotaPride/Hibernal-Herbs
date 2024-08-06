package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.screen.HerbConjurationAltarScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class ScreenHandlersInit {
    public static ScreenHandlerType<HerbConjurationAltarScreenHandler> CONJURATION_ALTAR_SCREEN_HANDLER;

    public static void init() {
        CONJURATION_ALTAR_SCREEN_HANDLER = new ScreenHandlerType<>(HerbConjurationAltarScreenHandler::new);
    }
}
