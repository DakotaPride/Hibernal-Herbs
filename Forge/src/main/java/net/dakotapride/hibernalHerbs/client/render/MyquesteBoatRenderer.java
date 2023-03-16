package net.dakotapride.hibernalHerbs.client.render;

import com.google.common.collect.ImmutableMap;
import com.ibm.icu.impl.Pair;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteBoat;
import net.dakotapride.hibernalHerbs.platform.ModPlatform;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@OnlyIn(Dist.CLIENT)
public class MyquesteBoatRenderer extends EntityRenderer<MyquesteBoat> {

    private final Map<MyquesteBoat.MyquesteType, Pair<ResourceLocation, BoatModel>> boatResources;

    public MyquesteBoatRenderer(EntityRendererProvider.Context context, boolean hasChest) {
        super(context);
        this.shadowRadius = 0.8F;
        this.boatResources = ModPlatform.INSTANCE.hasLoadErrors() ? new HashMap<>() :
                Stream.of(MyquesteBoat.MyquesteType.values()).collect(ImmutableMap.toImmutableMap((myquesteType) -> myquesteType, (myquesteType) -> Pair.of(HibernalHerbsForge.createLocation(getTextureLocation(myquesteType, hasChest)), this.createBoatModel(context, myquesteType, hasChest))));
    }

    private BoatModel createBoatModel(EntityRendererProvider.Context context, MyquesteBoat.MyquesteType myquesteType, boolean hasChest) {
        ModelLayerLocation modellayerlocation = hasChest ? createChestBoatModelName(myquesteType) : createBoatModelName(myquesteType);
        return new BoatModel(context.bakeLayer(modellayerlocation), hasChest);
    }

    public static ModelLayerLocation createChestBoatModelName(MyquesteBoat.MyquesteType type) {
        return new ModelLayerLocation(HibernalHerbsForge.createLocation("chest_boat/" + type.getName()), "main");
    }

    public static ModelLayerLocation createBoatModelName(MyquesteBoat.MyquesteType type) {
        return new ModelLayerLocation(HibernalHerbsForge.createLocation("boat/" + type.getName()), "main");
    }

    private static String getTextureLocation(MyquesteBoat.MyquesteType myquesteType, boolean hasChest) {
        return hasChest ? "textures/entity/chest_boat/" + myquesteType.getName() + ".png" : "textures/entity/boat/" + myquesteType.getName() + ".png";
    }

    @Override
    public void render(MyquesteBoat boat, float entityYaw, float partialTicks, PoseStack matrixStackIn, @NotNull MultiBufferSource multiBufferSource, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, 0.375D, 0.0D);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        float h = (float) boat.getHurtTime() - partialTicks;
        float j = boat.getDamage() - partialTicks;
        if (j < 0.0F) {
            j = 0.0F;
        }
        if (h > 0.0F) {
            matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(Mth.sin(h) * h * j / 10.0F * (float) boat.getHurtDir()));
        }

        float k = boat.getBubbleAngle(partialTicks);
        if (!Mth.equal(k, 0.0F)) {
            matrixStackIn.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), boat.getBubbleAngle(partialTicks), true));
        }
        Pair<ResourceLocation, BoatModel> pair = this.boatResources.get(boat.getMyquesteBoatType());
        ResourceLocation resourceLocation = pair.first;
        BoatModel boatModel = pair.second;
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        boatModel.setupAnim(boat, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(boatModel.renderType(resourceLocation));
        boatModel.renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!boat.isUnderWater()) {
            VertexConsumer vertexConsumer2 = multiBufferSource.getBuffer(RenderType.waterMask());
            boatModel.waterPatch().render(matrixStackIn, vertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY);
        }
        matrixStackIn.popPose();
        super.render(boat, entityYaw, partialTicks, matrixStackIn, multiBufferSource, packedLightIn);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public @NotNull ResourceLocation getTextureLocation(MyquesteBoat boat) {
        return this.boatResources.get(boat.getBoatType()).first;
    }
}