package net.dakotapride.hibernalHerbs.common.screen.slot;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class ConjurationResultSlotHandler extends SlotItemHandler {
    private int removeCount;

    public ConjurationResultSlotHandler(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }


    public boolean mayPlace(@NotNull ItemStack stack) {
        return false;
    }

    public @NotNull ItemStack remove(int k) {
        if (this.hasItem()) {
            this.removeCount += Math.min(k, this.getItem().getCount());
        }

        return super.remove(k);
    }

    public void onTake(@NotNull Player player, @NotNull ItemStack stack) {
        // this.checkTakeAchievements(stack);
        super.onTake(player, stack);
    }

    protected void onQuickCraft(@NotNull ItemStack stack, int k) {
        this.removeCount += k;
        // this.checkTakeAchievements(stack);
    }
}
