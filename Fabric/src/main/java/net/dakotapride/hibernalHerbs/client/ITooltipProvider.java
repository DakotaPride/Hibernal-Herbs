package net.dakotapride.hibernalHerbs.client;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public interface ITooltipProvider {
    String shiftControlsText = "text.hibernalherbs.controls.shift";
    String rightClickControlsText = "text.hibernalherbs.controls.right_click";
    String rightClickInventoryControlsText = "text.hibernalherbs.controls.right_click.inventory";


    enum Associations {
        NONE(Text.translatable("text.hibernalherbs.association.help.none"), 0),
        OAK(Text.translatable("text.hibernalherbs.association.help.oak"), 3),
        DARK_OAK(Text.translatable("text.hibernalherbs.association.help.dark_oak"), 3),
        BIRCH(Text.translatable("text.hibernalherbs.association.help.birch"), 3),
        SPRUCE(Text.translatable("text.hibernalherbs.association.help.spruce"), 4),
        JUNGLE(Text.translatable("text.hibernalherbs.association.help.jungle"), 3),
        ACACIA(Text.translatable("text.hibernalherbs.association.help.acacia"), 2),
        MANGROVE(Text.translatable("text.hibernalherbs.association.help.mangrove"), 3),
        CHERRY(Text.translatable("text.hibernalherbs.association.help.cherry"), 3),
        CRIMSON(Text.translatable("text.hibernalherbs.association.help.crimson"), 2),
        WARPED(Text.translatable("text.hibernalherbs.association.help.warped"), 2),
        MYQUESTE(Text.translatable("text.hibernalherbs.association.help.myqueste"), 4);


        final MutableText mutableText;
        final int productionValue;

        Associations(MutableText string, int value) {
            this.mutableText = string;
            this.productionValue = value;
        }

        public MutableText getTranslatableAssociation() {
            return mutableText;
        }

        public int getProductionValue() {
            return productionValue;
        }
    }

}
