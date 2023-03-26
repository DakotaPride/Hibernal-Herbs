package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.screen.HerbConjurationAltarScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ScreenHandlersInit {
    public static ScreenHandlerType<HerbConjurationAltarScreenHandler> CONJURATION_ALTAR_SCREEN_HANDLER;

    public static void init() {
        CONJURATION_ALTAR_SCREEN_HANDLER = new ScreenHandlerType<>(HerbConjurationAltarScreenHandler::new);
    }
}
