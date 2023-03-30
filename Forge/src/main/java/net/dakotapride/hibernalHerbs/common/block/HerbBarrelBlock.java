package net.dakotapride.hibernalHerbs.common.block;

import net.dakotapride.hibernalHerbs.common.registry.blockRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HerbBarrelBlock extends Block {
    private static String string;
    private static final ChatFormatting formattingColour = ChatFormatting.GRAY;

    public HerbBarrelBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter getter, List<Component> tooltip, TooltipFlag flag) {

        if (Screen.hasShiftDown()) {
            if (stack.is(blockRegistry.ROSEMARY_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.rosemary";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.THYME_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.thyme";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.TARRAGON_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.tarragon";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.CHAMOMILE_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.chamomile";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.CEILLIS_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.ceillis";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.CHIVES_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.chives";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.VERBENA_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.verbena";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.MARJORAM_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.marjoram";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.CHERVIL_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.chervil";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.FENNSEL_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.fennsel";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.PUNUEL_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.punuel";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.ESSITTE_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.essitte";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.SORREL_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.sorrel";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.FENNKYSTRAL_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.fennkystral";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.THYOCIELLE_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.thyocielle";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.CALENDULA_BARREL.get().asItem())) {
                string = "text.hibernalherbs.pile.calendula";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
        }
    }
}
