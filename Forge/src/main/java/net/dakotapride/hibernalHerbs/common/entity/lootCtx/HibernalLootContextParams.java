package net.dakotapride.hibernalHerbs.common.entity.lootCtx;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.entity.MyquesteBoat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;

import static net.dakotapride.hibernalHerbs.common.Constants.MOD_ID;

public class HibernalLootContextParams {
    public static final LootContextParam<MyquesteBoat.MyquesteType> BOAT_TYPE = create("boat_type");

    private static <T> LootContextParam<T> create(String name) {
        return new LootContextParam<>(HibernalHerbsForge.createLocation(name));
    }
}
