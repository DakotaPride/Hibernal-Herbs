package net.dakotapride.hibernalHerbs.client.render;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.dakotapride.hibernalHerbs.client.HibernalEntityModelLayers;
import net.dakotapride.hibernalHerbs.client.model.MyquesteBoatEntityModel;
import net.dakotapride.hibernalHerbs.common.Constants;
import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteBoatEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;

import java.util.Map;
import java.util.stream.Stream;

@Environment(EnvType.CLIENT)
public class MyquesteBoatRenderer extends EntityRenderer<MyquesteBoatEntity> {
    private final Map texturesAndModels;

    public MyquesteBoatRenderer(EntityRendererFactory.Context ctx, boolean chest) {
        super(ctx);
        this.shadowRadius = 0.8F;
        this.texturesAndModels = Stream.of(MyquesteBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap((type)
                -> type, (type) -> Pair.of(new Identifier(getTexture(type, chest)), this.createModel(ctx, type, chest))));
    }

    private MyquesteBoatEntityModel createModel(EntityRendererFactory.Context ctx, MyquesteBoatEntity.Type type, boolean chest) {
        EntityModelLayer entityModelLayer = chest ? HibernalEntityModelLayers.createChestBoat(type) : HibernalEntityModelLayers.createBoat(type);
        return new MyquesteBoatEntityModel(ctx.getPart(entityModelLayer), chest);
    }

    private static String getTexture(MyquesteBoatEntity.Type type, boolean chest) {
        return chest ? Constants.MOD_ID + "textures/entity/chest_boat/" + type.getName() + ".png" : Constants.MOD_ID + "textures/entity/boat/" + type.getName() + ".png";
    }

    public void render(MyquesteBoatEntity boatEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.translate(0.0D, 0.375D, 0.0D);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180.0F - f));
        float h = (float)boatEntity.getDamageWobbleTicks() - g;
        float j = boatEntity.getDamageWobbleStrength() - g;
        if (j < 0.0F) {
            j = 0.0F;
        }

        if (h > 0.0F) {
            matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(MathHelper.sin(h) * h * j / 10.0F * (float)boatEntity.getDamageWobbleSide()));
        }

        float k = boatEntity.interpolateBubbleWobble(g);
        if (!MathHelper.approximatelyEquals(k, 0.0F)) {
            matrixStack.multiply(new Quaternion(new Vec3f(1.0F, 0.0F, 1.0F), boatEntity.interpolateBubbleWobble(g), true));
        }

        Pair<Identifier, MyquesteBoatEntityModel> pair = (Pair)this.texturesAndModels.get(boatEntity.getBoatType());
        Identifier identifier = (Identifier)pair.getFirst();
        MyquesteBoatEntityModel boatEntityModel = (MyquesteBoatEntityModel)pair.getSecond();
        matrixStack.scale(-1.0F, -1.0F, 1.0F);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90.0F));
        boatEntityModel.setAngles(boatEntity, g, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(boatEntityModel.getLayer(identifier));
        boatEntityModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!boatEntity.isSubmergedInWater()) {
            VertexConsumer vertexConsumer2 = vertexConsumerProvider.getBuffer(RenderLayer.getWaterMask());
            boatEntityModel.getWaterPatch().render(matrixStack, vertexConsumer2, i, OverlayTexture.DEFAULT_UV);
        }

        matrixStack.pop();
        super.render(boatEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(MyquesteBoatEntity boatEntity) {
        return (Identifier)((Pair)this.texturesAndModels.get(boatEntity.getBoatType())).getFirst();
    }
}

