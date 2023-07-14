package net.dakotapride.hibernalHerbs.client;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.resource.PathPackResources;

import java.io.IOException;
import java.nio.file.Path;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;


@Mod(MOD_ID)
@Mod.EventBusSubscriber(modid=MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class PackLoader {

    @SubscribeEvent
    public static void onAddPackFinders(final AddPackFindersEvent event) {
        if(event.getPackType() == PackType.SERVER_DATA) {
            // register Quark data pack
            if(ModList.get().isLoaded("eatinganimation")) {
                registerPack(event, "hibernalherbs/eatinganimations");
            }

            registerPack(event, "hibernalherbs/barebones");
            registerPack(event, "hibernalherbs/modernized");

        }
    }

    private static void registerPack(final AddPackFindersEvent event, final String packName) {
        event.addRepositorySource(packConsumer -> {
            // create pack data
            final String packId = MOD_ID + ":" + packName;
            final Component packTitle = Component.literal(packName);
            final Path path = ModList.get().getModFileById(MOD_ID).getFile().findResource("/" + packName);
            final Pack.Info info = new Pack.Info(packTitle, SharedConstants.RESOURCE_PACK_FORMAT, FeatureFlagSet.of());
            // create the pack
            Pack pack = Pack.create(packId, packTitle, true, s -> new PathPackResources(packName, false, path), info,
                    PackType.SERVER_DATA, Pack.Position.TOP, true, PackSource.DEFAULT);
            // consume the pack
            packConsumer.accept(pack);
        });
    }
}
