package net.dakotapride.hibernalherbs.forge.entity;

import net.dakotapride.hibernalherbs.forge.registry.EntityTypeRegistry;
import net.dakotapride.hibernalherbs.forge.registry.ItemRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

@SuppressWarnings("NullableProblems")
public class MyquesteChestBoatEntity extends ChestBoatEntity {
    private static final TrackedData<String> WOOD_TYPE = DataTracker.registerData(MyquesteBoatEntity.class, TrackedDataHandlerRegistry.STRING);

    public MyquesteChestBoatEntity(EntityType<? extends BoatEntity> pEntityType, World pLevel) {
        super(pEntityType, pLevel);
    }

    public MyquesteChestBoatEntity(World level, double x, double y, double z, String woodType) {
        this(EntityTypeRegistry.MYQUESTE_CHEST_BOAT.get(), level);
        this.setPos(x, y, z);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
        this.dataTracker.set(WOOD_TYPE, woodType);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.set(WOOD_TYPE, "myqueste");
    }

    @Override
    public Item asItem() {
        return ItemRegistry.MYQUESTE_CHEST_BOAT.get();
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound pCompound) {
        super.writeCustomDataToNbt(pCompound);
        pCompound.putString("Type", this.getWoodType());
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound pCompound) {
        super.readCustomDataFromNbt(pCompound);
        this.setWoodType(pCompound.getString("Type"));
    }

    public String getWoodType() {
        return this.dataTracker.get(WOOD_TYPE);
    }

    public void setWoodType(String woodType) {
        this.dataTracker.set(WOOD_TYPE, woodType);
    }

    @Override
    public ItemStack getPickBlockStack() {
        return new ItemStack(this.asItem());
    }
}