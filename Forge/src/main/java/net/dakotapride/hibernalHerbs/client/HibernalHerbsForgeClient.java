package net.dakotapride.hibernalHerbs.client;

import net.dakotapride.hibernalHerbs.client.render.HibernalEntityRenderers;
import net.dakotapride.hibernalHerbs.client.render.MyquesteBoatRenderer;
import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteBoat;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.client.ForgeHooksClient;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class HibernalHerbsForgeClient {

    public static void client() {

        HibernalEntityRenderers.load();

    }
}
