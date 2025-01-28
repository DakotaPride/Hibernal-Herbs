package net.dakotapride.hibernalherbs.init;

import com.mojang.datafixers.types.Type;
import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.block.ModBrushableBlockEntity;
import net.dakotapride.hibernalherbs.block.ModHangingSignBlockEntity;
import net.dakotapride.hibernalherbs.block.ModSignBlockEntity;
import net.dakotapride.hibernalherbs.block.MysticalCampfireBlockEntity;
import net.dakotapride.hibernalherbs.init.enum_registry.Archaeology;
import net.dakotapride.hibernalherbs.init.enum_registry.WoodTypes;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityTypeInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, HibernalHerbsMod.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MysticalCampfireBlockEntity>> MYSTICAL_CAMPFIRE =
            register("mystical_campfire", () -> BlockEntityType.Builder.of(MysticalCampfireBlockEntity::new, BlockInit.MYSTICAL_CAMPFIRE.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SignBlockEntity>> MOD_SIGN =
            register("sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new,
                    WoodTypes.MYQUESTE.getSignBlock(), WoodTypes.MYQUESTE.getWallSignBlock()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            register("hanging_sign", () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                    WoodTypes.MYQUESTE.getHangingSignBlock(), WoodTypes.MYQUESTE.getWallHangingSignBlock()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModBrushableBlockEntity>> BRUSHABLE_BLOCK =
            register("brushable_block", () -> BlockEntityType.Builder.of(ModBrushableBlockEntity::new,
                    Archaeology.SuspiciousBlocks.END_STONE.getBlock()));

    private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String string, Supplier<BlockEntityType.Builder<T>> builder) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, string);
        return BLOCK_ENTITY_TYPES.register(string, () -> builder.get().build(type));
        //Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, string);
        //return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, HibernalHerbsMod.asResource(string), builder.build(type));
    }

    public static void register(IEventBus bus) {
        BLOCK_ENTITY_TYPES.register(bus);
    }
}
