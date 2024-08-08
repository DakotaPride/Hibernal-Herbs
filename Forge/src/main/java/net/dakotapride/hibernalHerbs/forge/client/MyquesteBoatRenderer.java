package net.dakotapride.hibernalherbs.forge.client;

import com.google.common.collect.ImmutableMap;
import net.dakotapride.hibernalherbs.HibernalHerbsCommon;
import net.dakotapride.hibernalherbs.forge.entity.MyquesteBoatEntity;
import net.dakotapride.hibernalherbs.forge.entity.MyquesteChestBoatEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.ChestBoatEntityModel;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.util.Identifier;
import com.mojang.datafixers.util.Pair;

import javax.swing.*;
import java.util.Map;
import java.util.stream.Stream;

public class MyquesteBoatRenderer extends BoatEntityRenderer {
    private final Map<MyquesteBoatEntity.Type, Pair<Identifier, CompositeEntityModel<BoatEntity>>> boatResources;

    public MyquesteBoatRenderer(EntityRendererFactory.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.boatResources = Stream.of(MyquesteBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap(type -> type,
                type -> Pair.of(new Identifier(HibernalHerbsCommon.MOD_ID, getTextureLocation(type, pChestBoat)), this.createBoatModel(pContext, type, pChestBoat))));
    }

    private static String getTextureLocation(MyquesteBoatEntity.Type pType, boolean pChestBoat) {
        return pChestBoat ? "textures/entity/chest_boat/" + pType.getName() + ".png" : "textures/entity/boat/" + pType.getName() + ".png";
    }

    private CompositeEntityModel<BoatEntity> createBoatModel(EntityRendererFactory.Context pContext, MyquesteBoatEntity.Type pType, boolean pChestBoat) {
        EntityModelLayer modellayerlocation = pChestBoat ? MyquesteBoatRenderer.createChestBoatModelName(pType) : MyquesteBoatRenderer.createBoatModelName(pType);
        ModelPart modelpart = pContext.getModelLoader().getModelPart(modellayerlocation);
        return pChestBoat ? new ChestBoatEntityModel(modelpart) : new BoatEntityModel(modelpart);
    }

    public static EntityModelLayer createBoatModelName(MyquesteBoatEntity.Type pType) {
        return createLocation("boat/" + pType.getName(), "main");
    }

    public static EntityModelLayer createChestBoatModelName(MyquesteBoatEntity.Type pType) {
        return createLocation("chest_boat/" + pType.getName(), "main");
    }

    private static EntityModelLayer createLocation(String pPath, String pModel) {
        return new EntityModelLayer(new Identifier(HibernalHerbsCommon.MOD_ID, pPath), pModel);
    }

    public Pair<Identifier, CompositeEntityModel<BoatEntity>> getModelWithLocation(BoatEntity boat) {
        if(boat instanceof MyquesteBoatEntity modBoat) {
            return this.boatResources.get(modBoat.getVariant());
        } else if(boat instanceof MyquesteChestBoatEntity modChestBoatEntity) {
            return this.boatResources.get(modChestBoatEntity.getVariant());
        } else {
            return null;
        }
    }
}