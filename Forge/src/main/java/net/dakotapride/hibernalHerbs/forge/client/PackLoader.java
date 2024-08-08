package net.dakotapride.hibernalherbs.forge.client;

import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourcePackSource;
import net.minecraft.resource.ResourceType;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;


@Mod(HibernalHerbsCommon.MOD_ID)
@Mod.EventBusSubscriber(modid=HibernalHerbsCommon.MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class PackLoader {

    @SubscribeEvent
    public static void onAddPackFinders(AddPackFindersEvent event) {

        if (event.getPackType() == ResourceType.CLIENT_RESOURCES) {
            registerBuiltinResourcePack(event, Text.literal("hibernalherbs/barebones"), "barebones");
            registerBuiltinResourcePack(event, Text.literal("hibernalherbs/modernized"), "modernized");

            if (ModList.get().isLoaded("eatinganimation")) {
                registerBuiltinResourcePack(event, Text.literal("hibernalherbs/eatinganimations"), "eatinganimations");
            }
        }
    }

    private static void registerBuiltinResourcePack(AddPackFindersEvent event, MutableText name, String folder) {
        event.addRepositorySource((consumer) -> {
            String path = new Identifier(HibernalHerbsCommon.MOD_ID, folder).toString();
            IModFile file = ModList.get().getModFileById(HibernalHerbsCommon.MOD_ID).getFile();
            try (PathPackResources pack = new PathPackResources(
                    path, true, file.findResource("resourcepacks/" + folder))) {
                consumer.accept(ResourcePackProfile.of(
                        new Identifier(HibernalHerbsCommon.MOD_ID, folder).toString(),
                        name,
                        false,
                        (pack1) -> pack,
                        new ResourcePackProfile.Metadata(Text.literal("hibernalherbs/" + folder), 15, FeatureSet.empty()),
                        ResourceType.CLIENT_RESOURCES,
                        ResourcePackProfile.InsertionPosition.TOP,
                        false,
                        ResourcePackSource.BUILTIN));

            }
        });
    }
}