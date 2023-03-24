package net.dakotapride.hibernalHerbs.common.block.leaf.hibernal;

import net.dakotapride.hibernalHerbs.common.block.leaf.LeafPileBlock;
import net.dakotapride.hibernalHerbs.common.registry.blockRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HibernalLeafPileBlock extends LeafPileBlock {
    private static String string;
    private static final ChatFormatting formattingColour = ChatFormatting.GRAY;

    public HibernalLeafPileBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag options) {

        if (Screen.hasShiftDown()) {
            if (stack.is(blockRegistry.ROSEMARY_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.rosemary";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.THYME_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.thyme";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.TARRAGON_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.tarragon";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.CHAMOMILE_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.chamomile";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.CEILLIS_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.ceillis";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.CHIVES_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.chives";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.VERBENA_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.verbena";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.MARJORAM_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.marjoram";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.CHERVIL_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.chervil";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.FENNSEL_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.fennsel";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.PUNUEL_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.punuel";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.ESSITTE_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.essitte";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.SORREL_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.sorrel";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.FENNKYSTRAL_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.fennkystral";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.THYOCIELLE_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.thyocielle";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
            if (stack.is(blockRegistry.CALENDULA_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.calendula";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }

            if (stack.is(blockRegistry.BLOFORIA_HERB_PILE.get().asItem())) {
                string = "text.hibernalherbs.pile.bloforia";

                tooltip.add(Component.translatable(string).withStyle(formattingColour));
            }
        }
    }
}
