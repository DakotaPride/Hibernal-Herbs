package net.dakotapride.hibernalherbs.registry;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.BlockSetType;

import java.util.Set;

public class TypeRegistry {

    public record SetType() {

        private static final Set<BlockSetType> VALUES = new ObjectArraySet<>();
        public static BlockSetType MYQUESTE;

        private static BlockSetType register(BlockSetType setType) {
            VALUES.add(setType);
            return setType;
        }

        static  {
            MYQUESTE = register(new BlockSetType("myqueste"));
        }

    }

    public record WoodType() {
        private static final Set<net.minecraft.block.WoodType> VALUES = new ObjectArraySet<>();
        public static final net.minecraft.block.WoodType MYQUESTE;

        private static net.minecraft.block.WoodType register(net.minecraft.block.WoodType type) {
            VALUES.add(type);
            return type;
        }

        static {
            MYQUESTE = register(new net.minecraft.block.WoodType("myqueste", SetType.MYQUESTE));
        }

    }

}
