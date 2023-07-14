package net.dakotapride.hibernalHerbs.common.entity.render;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteBoatEntity;
import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteChestBoatEntity;
import net.dakotapride.hibernalHerbs.common.registry.blockRegistry;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

// Boat code credited to Deeper And Darker Devs
@SuppressWarnings("NullableProblems")
public class MyquesteBoatRenderer extends BoatRenderer {
    private final Map<String, Pair<ResourceLocation, ListModel<Boat>>> BOAT_RESOURCES;
    private final boolean HAS_CHEST;

    public MyquesteBoatRenderer(EntityRendererProvider.Context context, boolean hasChest) {
        super(context, hasChest);
        this.BOAT_RESOURCES = ImmutableMap.of(blockRegistry.MYQUESTE_TYPE.name(), Pair.of(new ResourceLocation(MOD_ID, "textures/entity/" + (hasChest ? "chest_boat" : "boat") + "/" + blockRegistry.MYQUESTE_TYPE.name() + ".png"), this.createBoatModel(context, hasChest)));
        this.HAS_CHEST = hasChest;
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, boolean chestBoat) {
        ModelLayerLocation modellayerlocation = chestBoat ?
                new ModelLayerLocation(new ResourceLocation("minecraft", "chest_boat/oak"), "main") :
                new ModelLayerLocation(new ResourceLocation("minecraft", "boat/oak"), "main");
        ModelPart modelpart = context.bakeLayer(modellayerlocation);
        return chestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if(HAS_CHEST) return BOAT_RESOURCES.get(((MyquesteChestBoatEntity) boat).getWoodType());
        return BOAT_RESOURCES.get(((MyquesteBoatEntity) boat).getWoodType());
    }
}