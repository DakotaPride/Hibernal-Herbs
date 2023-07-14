package net.dakotapride.hibernalHerbs.common.registry;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Set;
import java.util.stream.Stream;

public class TypeRegistry {

    public record SetType() {
        private static final Set<BlockSetType> VALUES = new ObjectArraySet<>();
        public static final BlockSetType MYQUESTE;

        public static BlockSetType register(BlockSetType p_273033_) {
            VALUES.add(p_273033_);
            return p_273033_;
        }

        public static Stream<BlockSetType> values() {
            return VALUES.stream();
        }

        static {
            MYQUESTE = register(new BlockSetType("myqueste"));
        }

    }

    public record WoodType() {
        private static final Set<net.minecraft.world.level.block.state.properties.WoodType> VALUES = new ObjectArraySet<>();
        public static final net.minecraft.world.level.block.state.properties.WoodType MYQUESTE;

        public static net.minecraft.world.level.block.state.properties.WoodType register(net.minecraft.world.level.block.state.properties.WoodType p_61845_) {
            VALUES.add(p_61845_);
            return p_61845_;
        }

        public static Stream<net.minecraft.world.level.block.state.properties.WoodType> values() {
            return VALUES.stream();
        }

        static {
            MYQUESTE = register(new net.minecraft.world.level.block.state.properties.WoodType("myqueste", SetType.MYQUESTE));
        }

    }

}
