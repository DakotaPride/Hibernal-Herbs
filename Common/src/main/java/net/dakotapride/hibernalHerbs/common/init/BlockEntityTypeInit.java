package net.dakotapride.hibernalHerbs.common.init;

import com.mojang.datafixers.types.Type;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsCommonMod;
import net.dakotapride.hibernalHerbs.common.block.ModHangingSignBlockEntity;
import net.dakotapride.hibernalHerbs.common.block.ModSignBlockEntity;
import net.dakotapride.hibernalHerbs.common.block.MysticalCampfireBlockEntity;
import net.dakotapride.hibernalHerbs.common.init.enum_registry.WoodTypes;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;

public class BlockEntityTypeInit {
    public static final BlockEntityType<MysticalCampfireBlockEntity> MYSTICAL_CAMPFIRE =
            register("mystical_campfire", BlockEntityType.Builder.of(MysticalCampfireBlockEntity::new, BlockInit.MYSTICAL_CAMPFIRE.get()));

    public static final BlockEntityType<SignBlockEntity> MOD_SIGN =
            register("sign", BlockEntityType.Builder.of(ModSignBlockEntity::new,
                    WoodTypes.MYQUESTE.getSignBlock().get(), WoodTypes.MYQUESTE.getWallSignBlock().get()));
    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN =
            register("hanging_sign", BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                    WoodTypes.MYQUESTE.getHangingSignBlock().get(), WoodTypes.MYQUESTE.getWallHangingSignBlock().get()));

    private static <T extends BlockEntity> BlockEntityType<T> register(String string, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, string);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, HibernalHerbsCommonMod.asResource(string), builder.build(type));
    }

    public static void register() {}
}
