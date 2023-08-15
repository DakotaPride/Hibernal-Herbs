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
    public HibernalLeafPileBlock(Settings settings) {
        super(settings);
    }
}
