package net.dakotapride.hibernalherbs;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;

import static net.dakotapride.hibernalherbs.HibernalHerbsMod.MOD_ID;
import static net.dakotapride.hibernalherbs.HibernalHerbsMod.asResource;

//@Mod(MOD_ID)
@EventBusSubscriber(modid=MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PackLoader {

    @SubscribeEvent
    public static void onAddPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            registerBuiltinResourcePack(event, "stripped_planks");
            registerBuiltinResourcePack(event, "visual_frozen_states");
        }
    }

    private static void registerBuiltinResourcePack(AddPackFindersEvent event, String folder) {
        event.addPackFinders(
                asResource("resourcepacks/" + folder),
                PackType.CLIENT_RESOURCES,
                Component.literal("hibernalherbs/" + folder),
                PackSource.BUILT_IN,
                false,
                Pack.Position.TOP);
    }
}