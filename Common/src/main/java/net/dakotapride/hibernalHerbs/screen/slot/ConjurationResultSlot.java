package net.dakotapride.hibernalherbs.screen.slot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.NotNull;

public class ConjurationResultSlot extends Slot {
    private int amount;

    public ConjurationResultSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    public boolean canInsert(@NotNull ItemStack stack) {
        return false;
    }

    public @NotNull ItemStack takeStack(int k) {
        if (this.hasStack()) {
            this.amount += Math.min(k, this.getStack().getCount());
        }

        return super.takeStack(k);
    }

    public void onTakeItem(PlayerEntity player, ItemStack stack) {
        // this.onCrafted(stack);
        super.onTakeItem(player, stack);
    }

    protected void onCrafted(ItemStack stack, int amount) {
        this.amount += amount;
        // this.onCrafted(stack);
    }
}
