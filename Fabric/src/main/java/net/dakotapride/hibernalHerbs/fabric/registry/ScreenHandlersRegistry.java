package net.dakotapride.hibernalherbs.fabric.registry;

import net.dakotapride.hibernalherbs.fabric.screen.HerbConjurationAltarScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static net.dakotapride.hibernalherbs.HibernalHerbsCommon.MOD_ID;

public class ScreenHandlersRegistry {
    public static ScreenHandlerType<HerbConjurationAltarScreenHandler> CONJURATION_ALTAR_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(HerbConjurationAltarScreenHandler::new);

    public static void register() {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(MOD_ID, "conjuration_altar"),
                CONJURATION_ALTAR_SCREEN_HANDLER);
    }
}
