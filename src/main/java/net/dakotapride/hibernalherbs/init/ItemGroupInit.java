package net.dakotapride.hibernalherbs.init;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.enum_registry.Sickles;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemGroupInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HibernalHerbsMod.MOD_ID);

    public static final Supplier<CreativeModeTab> HIBERNAL_HERBS_TAB = CREATIVE_MODE_TABS.register("hibernal_herbs",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Sickles.ARKONIUM.getSickleItem()))
                    .title(Component.translatable("creativetab.hibernalherbs.hibernal_herbs"))
                    .displayItems((itemDisplayParameters, output) -> {
                        for (DeferredHolder<Item, ? extends Item> items : ItemInit.ITEMS.getEntries()) {
                            output.accept(items.get());
                        }
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
