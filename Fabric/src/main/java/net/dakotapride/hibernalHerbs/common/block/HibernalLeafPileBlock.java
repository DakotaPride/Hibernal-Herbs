package net.dakotapride.hibernalHerbs.common.block;

import com.terraformersmc.terraform.leaves.block.LeafPileBlock;
import net.dakotapride.hibernalHerbs.common.init.BlockInit;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HibernalLeafPileBlock extends LeafPileBlock {
    private static String string;
    private static final Formatting formattingColour = Formatting.GRAY;

    public HibernalLeafPileBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {

        if (Screen.hasShiftDown()) {
            if (stack.isOf(BlockInit.ROSEMARY_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.rosemary";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.THYME_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.thyme";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.TARRAGON_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.tarragon";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.CHAMOMILE_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.chamomile";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.CEILLIS_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.ceillis";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.CHIVES_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.chives";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.VERBENA_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.verbena";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.MARJORAM_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.marjoram";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.CHERVIL_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.chervil";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.FENNSEL_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.fennsel";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.PUNUEL_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.punuel";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.ESSITTE_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.essitte";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.SORREL_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.sorrel";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.FENNKYSTRAL_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.fennkystral";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.THYOCIELLE_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.thyocielle";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
            if (stack.isOf(BlockInit.CALENDULA_HERB_PILE.asItem())) {
                string = "text.hibernalherbs.pile.calendula";

                tooltip.add(Text.translatable(string).formatted(formattingColour));
            }
        }
    }
}
