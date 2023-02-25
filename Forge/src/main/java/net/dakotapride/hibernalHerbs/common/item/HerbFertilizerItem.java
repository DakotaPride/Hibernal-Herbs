package net.dakotapride.hibernalHerbs.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbFertilizerItem extends Item {
    public HerbFertilizerItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        if(stack.hasTag()) {
            String getLogType = stack.getTag().getString("hibernalherbs.getLog");
            list.add(Component.literal(getLogType));
        } else if (!stack.hasTag()) {
            list.add(Component.literal("No Association Found"));
        }
    }

}
