package net.dakotapride.hibernalHerbs.client.render;

import net.dakotapride.hibernalHerbs.common.entity.HibernalEntities;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class EntityRenderers {

    public static <T extends Entity> void register(RegisterStrategy registerStrategy) {
        registerStrategy.register(HibernalEntities.BOAT.get(), (EntityRendererProvider.Context context)
                -> new MyquesteBoatRenderer(context, false));
        registerStrategy.register(HibernalEntities.CHEST_BOAT.get(), (EntityRendererProvider.Context context)
                -> new MyquesteBoatRenderer(context, true));
    }

    @FunctionalInterface
    public interface RegisterStrategy {
        <T extends Entity> void register(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider);
    }

}
