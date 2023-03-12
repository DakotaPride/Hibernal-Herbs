package net.dakotapride.hibernalHerbs.client;

import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteBoatEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class HibernalEntityModelLayers {

    private static EntityModelLayer create(String id, String layer) {
        return new EntityModelLayer(new Identifier("minecraft", id), layer);
    }

    public static EntityModelLayer createBoat(MyquesteBoatEntity.Type type) {
        return create("boat/" + type.getName(), "main");
    }

    public static EntityModelLayer createChestBoat(MyquesteBoatEntity.Type type) {
        return create("chest_boat/" + type.getName(), "main");
    }

}
