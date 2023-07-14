package net.dakotapride.hibernalHerbs.client;

import net.minecraft.client.resources.metadata.texture.TextureMetadataSection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;

import java.io.IOException;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;


@Mod(MOD_ID)
@Mod.EventBusSubscriber(modid=MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class PackLoader {

    @SubscribeEvent
    public static void onAddPackFinders(AddPackFindersEvent event) {

        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            registerBuiltinResourcePack(event, Component.literal("hibernalherbs/barebones"), "barebones");
            registerBuiltinResourcePack(event, Component.literal("hibernalherbs/modernized"), "modernized");

            if (ModList.get().isLoaded("eatinganimation")) {
                registerBuiltinResourcePack(event, Component.literal("hibernalherbs/eatinganimations"), "eatinganimations");
            }
        }
    }

    private static void registerBuiltinResourcePack(AddPackFindersEvent event, MutableComponent name, String folder) {
        event.addRepositorySource((consumer) -> {
            String path = new ResourceLocation(MOD_ID, folder).toString();
            IModFile file = ModList.get().getModFileById(MOD_ID).getFile();
            try (PathPackResources pack = new PathPackResources(
                    path, true, file.findResource("resourcepacks/" + folder))) {
                consumer.accept(Pack.create(
                        new ResourceLocation(MOD_ID, folder).toString(),
                        name,
                        false,
                        (pack1) -> pack,
                        new Pack.Info(Component.literal("hibernalherbs/" + folder), 15, FeatureFlagSet.of()),
                        PackType.CLIENT_RESOURCES,
                        Pack.Position.TOP,
                        false,
                        PackSource.BUILT_IN));

            }
        });
    }
}