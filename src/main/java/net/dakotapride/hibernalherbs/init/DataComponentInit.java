package net.dakotapride.hibernalherbs.init;

import com.mojang.serialization.Codec;
import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;

import java.util.function.UnaryOperator;

public class DataComponentInit {
    public static final DataComponentType<Boolean> IS_BEING_USED = register(
            "is_being_used", builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL)
    );

    private static <T>DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, HibernalHerbsMod.asResource(name),
                builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void load() {}
}
