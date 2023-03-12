package net.dakotapride.hibernalHerbs.common.entity;

import com.google.common.collect.ImmutableSet;
import net.dakotapride.hibernalHerbs.common.entity.boat.MyquesteBoatEntity;
import net.minecraft.block.Block;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class HibernalEntityType<T extends Entity> implements TypeFilter<Entity, T> {


    public static final EntityType<MyquesteBoatEntity> MYQUESTE_BOAT;

    static {
        MYQUESTE_BOAT = register("boat", HibernalEntityType.Builder.create(MyquesteBoatEntity::new, SpawnGroup.MISC).setDimensions(1.375F, 0.5625F).maxTrackingRange(10));
    }

    public HibernalEntityType(EntityFactory<T> factory, SpawnGroup spawnGroup, boolean saveable, boolean summonable, boolean fireImmune, boolean spawnableFarFromPlayer, ImmutableSet<Block> canSpawnInside, EntityDimensions dimensions, int maxTrackingRange, int trackingTickInterval) {}

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return Registry.register(Registry.ENTITY_TYPE, id, type.build(id));
    }

    @Nullable
    @Override
    public T downcast(Entity entity) {
        return entity.getType() == this ? entity : null;
    }

    @Override
    public Class<? extends Entity> getBaseClass() {
        return Entity.class;
    }

    public static class Builder<T extends Entity> {
        private final HibernalEntityType.EntityFactory<T> factory;
        private final SpawnGroup spawnGroup;
        private ImmutableSet<Block> canSpawnInside = ImmutableSet.of();
        private boolean saveable = true;
        private boolean summonable = true;
        private boolean fireImmune;
        private boolean spawnableFarFromPlayer;
        private int maxTrackingRange = 5;
        private int trackingTickInterval = 3;
        private EntityDimensions dimensions = EntityDimensions.changing(0.6F, 1.8F);

        private Builder(HibernalEntityType.EntityFactory<T> factory, SpawnGroup spawnGroup) {
            this.factory = factory;
            this.spawnGroup = spawnGroup;
            this.spawnableFarFromPlayer = spawnGroup == SpawnGroup.CREATURE || spawnGroup == SpawnGroup.MISC;
        }

        public static <T extends Entity> HibernalEntityType.Builder<T> create(HibernalEntityType.EntityFactory<T> factory, SpawnGroup spawnGroup) {
            return new HibernalEntityType.Builder<T>(factory, spawnGroup);
        }

        public static <T extends Entity> HibernalEntityType.Builder<T> create(SpawnGroup spawnGroup) {
            return new HibernalEntityType.Builder<T>((type, world) -> {
                return null;
            }, spawnGroup);
        }

        public HibernalEntityType.Builder<T> setDimensions(float width, float height) {
            this.dimensions = EntityDimensions.changing(width, height);
            return this;
        }

        public HibernalEntityType.Builder<T> disableSummon() {
            this.summonable = false;
            return this;
        }

        public HibernalEntityType.Builder<T> disableSaving() {
            this.saveable = false;
            return this;
        }

        public HibernalEntityType.Builder<T> makeFireImmune() {
            this.fireImmune = true;
            return this;
        }

        public HibernalEntityType.Builder<T> allowSpawningInside(Block... blocks) {
            this.canSpawnInside = ImmutableSet.copyOf(blocks);
            return this;
        }

        public HibernalEntityType.Builder<T> spawnableFarFromPlayer() {
            this.spawnableFarFromPlayer = true;
            return this;
        }

        public HibernalEntityType.Builder<T> maxTrackingRange(int maxTrackingRange) {
            this.maxTrackingRange = maxTrackingRange;
            return this;
        }

        public HibernalEntityType.Builder<T> trackingTickInterval(int trackingTickInterval) {
            this.trackingTickInterval = trackingTickInterval;
            return this;
        }

        public HibernalEntityType<T> build(String id) {
            if (this.saveable) {
                Util.getChoiceType(TypeReferences.ENTITY_TREE, id);
            }

            return new HibernalEntityType<T>(this.factory, this.spawnGroup, this.saveable, this.summonable, this.fireImmune, this.spawnableFarFromPlayer, this.canSpawnInside, this.dimensions, this.maxTrackingRange, this.trackingTickInterval);
        }
    }

    public interface EntityFactory<T extends Entity> {
        T create(HibernalEntityType<T> type, World world);
    }

}
