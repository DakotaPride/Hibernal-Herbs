package net.dakotapride.hibernalherbs.init;

import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class PropertiesInit {
    public static final BooleanProperty FED = BooleanProperty.create("fed");

    public static final BooleanProperty RARE = BooleanProperty.create("rare_loot");
    public static final BooleanProperty SEALED = BooleanProperty.create("is_sealed");

    public static void load() {}
}
