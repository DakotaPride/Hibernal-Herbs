package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.InventoryUtil;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbHumusItem extends Item {
    public HerbHumusItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();
        PlayerEntity playerEntity = context.getPlayer();
        if (world.getBlockState(blockPos).isOf(Blocks.STRIPPED_SPRUCE_LOG)) {

            addLogNbt(playerEntity, world.getBlockState(blockPos).getBlock());

        }

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.hasNbt()) {
            String getLogType = stack.getNbt().getString("hibernalherbs.getLog");
            tooltip.add(Text.literal(getLogType));
        } else if (!stack.hasNbt()) {
            tooltip.add(Text.literal("No Association Found"));
        }
    }

    public static void addLogNbt(PlayerEntity player, Block block) {
        ItemStack herbHumus = player.getInventory().getStack(InventoryUtil.getFirstInventoryIndex(player, ItemInit.HERB_HUMUS));

        NbtCompound nbtData = new NbtCompound();
        nbtData.putString("hibernalherbs.getLog", "Association Found For " + block.asItem().getName().getString());

        herbHumus.setNbt(nbtData);
    }

}
