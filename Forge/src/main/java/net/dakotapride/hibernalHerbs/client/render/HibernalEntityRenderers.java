package net.dakotapride.hibernalHerbs.client.render;

import net.dakotapride.hibernalHerbs.common.entity.HibernalEntities;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class HibernalEntityRenderers {

    private static <T extends Entity> void registerRenderer(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider) {}

    public static void load() {
        registerRenderer(HibernalEntities.BOAT.get(), (EntityRendererProvider.Context context)
                -> new MyquesteBoatRenderer(context, false));
        registerRenderer(HibernalEntities.CHEST_BOAT.get(), (EntityRendererProvider.Context context)
                -> new MyquesteBoatRenderer(context, true));
    }

}
