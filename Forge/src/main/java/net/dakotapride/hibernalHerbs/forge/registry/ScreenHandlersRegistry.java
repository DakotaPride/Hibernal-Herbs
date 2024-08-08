package net.dakotapride.hibernalherbs.forge.registry;

import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.forge.screen.HerbConjurationAltarScreenHandler;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ScreenHandlersRegistry {
    public static final DeferredRegister<ScreenHandlerType<?>> MENUS =
            DeferredRegister.create(RegistryKeys.SCREEN_HANDLER, HibernalHerbsCommon.MOD_ID);

    public static final RegistryObject<ScreenHandlerType<HerbConjurationAltarScreenHandler>> CONJURATION_ALTAR_SCREEN_HANDLER =
            registerMenuType(HerbConjurationAltarScreenHandler::new, "herbal_conjuration_menu");


    private static <T extends ScreenHandler> RegistryObject<ScreenHandlerType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                   String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus bus) {
        MENUS.register(bus);
    }
}
