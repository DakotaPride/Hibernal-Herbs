package net.dakotapride.hibernalHerbs.client;

import net.dakotapride.hibernalHerbs.client.render.MyquesteBoatRenderer;
import net.dakotapride.hibernalHerbs.common.entity.MyquesteBoat;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.client.ForgeHooksClient;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class HibernalHerbsForgeClient {

    public static void client() {

        registerLayerDefinitions(ForgeHooksClient::registerLayerDefinition);
    }

    public static void registerLayerDefinitions(final BiConsumer<ModelLayerLocation, Supplier<LayerDefinition>> consumer) {
        for (MyquesteBoat.MyquesteType value : MyquesteBoat.MyquesteType.values()) {
            consumer.accept(MyquesteBoatRenderer.createBoatModelName(value), () -> BoatModel.createBodyModel(false));
            consumer.accept(MyquesteBoatRenderer.createChestBoatModelName(value), () -> BoatModel.createBodyModel(true));
        }
    }
}
