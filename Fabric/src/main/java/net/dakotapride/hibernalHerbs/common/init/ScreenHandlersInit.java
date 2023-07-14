package net.dakotapride.hibernalHerbs.common.init;

import net.dakotapride.hibernalHerbs.common.screen.HerbConjurationAltarScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class ScreenHandlersInit {
    public static ScreenHandlerType<HerbConjurationAltarScreenHandler> CONJURATION_ALTAR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(HerbConjurationAltarScreenHandler::new);

    public static void init() {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(MOD_ID, "conjuration_altar"),
                CONJURATION_ALTAR_SCREEN_HANDLER);
    }
}
