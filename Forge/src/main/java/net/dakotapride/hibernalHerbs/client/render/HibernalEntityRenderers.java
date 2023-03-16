package net.dakotapride.hibernalHerbs.client.render;

import net.dakotapride.hibernalHerbs.common.entity.HibernalEntities;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HibernalEntityRenderers {

    public static <T extends Entity> void registerRenderers(RegisterStrategy registerStrategy) {
        registerStrategy.registerRender(HibernalEntities.BOAT.get(), (EntityRendererProvider.Context context)
                -> new MyquesteBoatRenderer(context, false));
        registerStrategy.registerRender(HibernalEntities.CHEST_BOAT.get(), (EntityRendererProvider.Context context)
                -> new MyquesteBoatRenderer(context, true));
    }

    @FunctionalInterface
    public interface RegisterStrategy {
        <T extends Entity> void registerRender(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider);
    }

    public static void load() {}

}
