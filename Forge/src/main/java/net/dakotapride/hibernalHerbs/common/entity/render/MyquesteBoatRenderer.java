package net.dakotapride.hibernalHerbs.common.entity.render;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

@OnlyIn(Dist.CLIENT)
public class MyquesteBoatRenderer extends BoatRenderer {
    private final Pair<ResourceLocation, ListModel<Boat>> myqueste;

    public MyquesteBoatRenderer(EntityRendererProvider.Context context, boolean hasChest) {
        super(context, hasChest);
        this.myqueste =  Pair.of(this.getTexture(hasChest), new BoatModel(context.bakeLayer(createModelLayerLocation(hasChest))));
    }

    @NotNull
    public static ModelLayerLocation createModelLayerLocation(boolean hasChest) {
        return new ModelLayerLocation(new ResourceLocation(MOD_ID, hasChest ? "chest_boat/myqueste" : "boat/myqueste"), "main");
    }

    public ResourceLocation getTexture(boolean hasChest) {
        if (hasChest) {
            return new ResourceLocation(MOD_ID, "textures/entity/chest_boat/myqueste.png");
        }
        return new ResourceLocation(MOD_ID, "textures/entity/boat/myqueste.png");
    }

    @Override
    public @NotNull Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(@NotNull Boat boat) {
        return this.myqueste;
    }
}