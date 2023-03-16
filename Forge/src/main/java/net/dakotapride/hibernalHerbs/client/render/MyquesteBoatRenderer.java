package net.dakotapride.hibernalHerbs.client.render;

import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MyquesteBoatRenderer extends BoatRenderer {
    public MyquesteBoatRenderer(EntityRendererProvider.Context p_234563_, boolean p_234564_) {
        super(p_234563_, p_234564_);
    }
}