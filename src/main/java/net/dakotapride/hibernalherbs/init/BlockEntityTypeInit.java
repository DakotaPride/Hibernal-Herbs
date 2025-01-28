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
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;

public class BlockEntityTypeInit {
    public static final BlockEntityType<MysticalCampfireBlockEntity> MYSTICAL_CAMPFIRE =
            register("mystical_campfire", BlockEntityType.Builder.of(MysticalCampfireBlockEntity::new, BlockInit.MYSTICAL_CAMPFIRE));

    public static final BlockEntityType<SignBlockEntity> MOD_SIGN =
            register("sign", BlockEntityType.Builder.of(ModSignBlockEntity::new,
                    WoodTypes.MYQUESTE.getSignBlock(), WoodTypes.MYQUESTE.getWallSignBlock()));
    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN =
            register("hanging_sign", BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                    WoodTypes.MYQUESTE.getHangingSignBlock(), WoodTypes.MYQUESTE.getWallHangingSignBlock()));

    public static final BlockEntityType<ModBrushableBlockEntity> BRUSHABLE_BLOCK =
            register("brushable_block", BlockEntityType.Builder.of(ModBrushableBlockEntity::new,
                    Archaeology.SuspiciousBlocks.END_STONE.getBlock()));

    private static <T extends BlockEntity> BlockEntityType<T> register(String string, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, string);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, HibernalHerbsMod.asResource(string), builder.build(type));
    }

    public static void register() {}
}
