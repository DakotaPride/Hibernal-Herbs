package net.dakotapride.hibernalherbs.forge.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CarpetBlock;
import net.minecraft.sound.BlockSoundGroup;

public class HibernalLeafPileBlock extends CarpetBlock {
    public HibernalLeafPileBlock(AbstractBlock.Settings settings) {
        super(settings.sounds(BlockSoundGroup.GRASS).nonOpaque());
    }
}
