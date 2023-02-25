package net.dakotapride.hibernalHerbs.common.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class HerbFertilizerItem extends Item {
    public HerbFertilizerItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {

        stack.setNbt(new NbtCompound().getCompound("hibernalherbs.getLog"));

        super.onCraft(stack, world, player);
    }
}
