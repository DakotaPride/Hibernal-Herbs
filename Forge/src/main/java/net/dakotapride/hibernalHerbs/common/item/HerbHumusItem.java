package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.InventoryUtil;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbHumusItem extends Item {
    public HerbHumusItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        BlockPos blockPos = context.getClickedPos();
        Level level = context.getLevel();
        Player player = context.getPlayer();
        if (level.getBlockState(blockPos).is(Blocks.STRIPPED_SPRUCE_LOG)) {

            addLogNbt(player, level.getBlockState(blockPos).getBlock());

        }

        return super.useOn(context);
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

    public static void addLogNbt(Player player, Block block) {
        ItemStack herbHumus = player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, itemRegistry.HERB_HUMUS.get()));

        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("hibernalherbs.getLog", "Association Found For " + block.asItem().getName(block.asItem().getDefaultInstance()).getString());

        herbHumus.setTag(compoundTag);
    }
}
