package net.dakotapride.hibernalHerbs.client;

import net.dakotapride.hibernalHerbs.common.Constants;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.resource.PathPackResources;

import java.nio.file.Path;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;


// Code Belongs To SkyJay1 (From MMD Discord/Community) - Thank You For Providing This!
public class PackLoader {
    public static void onAddPackFinders(final AddPackFindersEvent event) {
        if(event.getPackType() == PackType.CLIENT_RESOURCES) {
            if(ModList.get().isLoaded("eatinganimation")) {
                Constants.LOG.info("Eating Animations [Forge] Present, Now Compatible As Of v0.4.3!");
                registerResources(event, "eatinganimation");
            }

            registerResources(event, "barebones");
        }
    }

    private static void registerResources(final AddPackFindersEvent event, final String packName) {
        event.addRepositorySource((packConsumer, constructor) -> {
            Pack pack = Pack.create(MOD_ID + ":" + packName, true, () -> {
                Path path = ModList.get().getModFileById(MOD_ID).getFile().findResource("/" + packName);
                return new PathPackResources(packName, path);
            }, constructor, Pack.Position.TOP, PackSource.DEFAULT);

            if (pack != null) {
                packConsumer.accept(pack);
            }
        });
    }
}
