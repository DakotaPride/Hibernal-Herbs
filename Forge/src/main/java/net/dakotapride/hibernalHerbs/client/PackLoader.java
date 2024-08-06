package net.dakotapride.hibernalHerbs.client;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.resource.PathPackResources;

import java.io.IOException;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;


@Mod(MOD_ID)
@Mod.EventBusSubscriber(modid=MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class PackLoader {

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event)
    {
        try
        {
            if (event.getPackType() == PackType.CLIENT_RESOURCES)
            {
                if (ModList.get().isLoaded("eatinganimation")) {
                    var eatingAnimationResourcePath = ModList.get().getModFileById(MOD_ID).getFile().findResource("resourcepacks/eatinganimations");
                    var eatingAnimationPackResources = new PathPackResources(ModList.get().getModFileById(MOD_ID).getFile().getFileName() + ":" + eatingAnimationResourcePath, eatingAnimationResourcePath);
                    var eatingAnimationMetaDataSelection = eatingAnimationPackResources.getMetadataSection(PackMetadataSection.SERIALIZER);
                    if (eatingAnimationMetaDataSelection != null)
                    {
                        event.addRepositorySource((packConsumer, packConstructor) ->
                                packConsumer.accept(packConstructor.create(
                                        "eatinganimation", Component.literal("hibernalherbs/eatinganimations"), false,
                                        () -> eatingAnimationPackResources, eatingAnimationMetaDataSelection, Pack.Position.BOTTOM, PackSource.BUILT_IN, false)));
                    }
                }

                var bareBonesResourcePath = ModList.get().getModFileById(MOD_ID).getFile().findResource("resourcepacks/barebones");
                var bareBonesPackResources = new PathPackResources(ModList.get().getModFileById(MOD_ID).getFile().getFileName() + ":" + bareBonesResourcePath, bareBonesResourcePath);
                var bareBonesMetaDataSelection = bareBonesPackResources.getMetadataSection(PackMetadataSection.SERIALIZER);
                if (bareBonesMetaDataSelection != null)
                {
                    event.addRepositorySource((packConsumer, packConstructor) ->
                            packConsumer.accept(packConstructor.create(
                                    "barebones", Component.literal("hibernalherbs/barebones"), false,
                                    () -> bareBonesPackResources, bareBonesMetaDataSelection, Pack.Position.BOTTOM, PackSource.BUILT_IN, false)));
                }

            }
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}