package net.dakotapride.hibernalHerbs.client;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public interface ITooltipProvider {
    String shiftControlsText = "text.hibernalherbs.controls.shift";
    String leftAltControlsText = "text.hibernalherbs.controls.left_alt";
    String rightClickControlsText = "text.hibernalherbs.controls.right_click";
    String leftClickControlsText = "text.hibernalherbs.controls.left_click";
    String rightClickInventoryControlsText = "text.hibernalherbs.controls.right_click.inventory";
    String leftClickInventoryControlsText = "text.hibernalherbs.controls.left_click.inventory";
    String rightClickOnPlayerControlsText = "text.hibernalherbs.controls.right_click.player";
    String leftClickOnPlayerControlsText = "text.hibernalherbs.controls.left_click.player";


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

    enum BlendAbilities {
        NONE(StatusEffects.SATURATION, Text.translatable("text.hibernalherbs.ability.none")),
        REGENERATIVE(StatusEffects.REGENERATION, Text.translatable("text.hibernalherbs.ability.regeneration")),
        VIRULENT(StatusEffects.POISON, Text.translatable("text.hibernalherbs.ability.poison")),
        SEDATING(StatusEffects.SLOWNESS, Text.translatable("text.hibernalherbs.ability.slowness")),
        HINDERING(StatusEffects.MINING_FATIGUE, Text.translatable("text.hibernalherbs.ability.mining_fatigue")),
        DASHING(StatusEffects.HASTE, Text.translatable("text.hibernalherbs.ability.haste")),
        ACCELERATION(StatusEffects.SPEED, Text.translatable("text.hibernalherbs.ability.speed")),
        INCINERATING(Text.translatable("text.hibernalherbs.ability.fire")),
        DECAYING(StatusEffects.WITHER, Text.translatable("text.hibernalherbs.ability.wither")),
        OBSERVING(StatusEffects.NIGHT_VISION, Text.translatable("text.hibernalherbs.ability.night_vision")),
        DIMINISHED(StatusEffects.WEAKNESS, Text.translatable("text.hibernalherbs.ability.weakness")),
        SHADED(StatusEffects.BLINDNESS, Text.translatable("text.hibernalherbs.ability.blindness")),
        CONFLICTING(StatusEffects.REGENERATION, StatusEffects.SLOWNESS, Text.translatable("text.hibernalherbs.ability.regeneration_slowness")),
        ALTERNATIVE(StatusEffects.REGENERATION, StatusEffects.SPEED, StatusEffects.WEAKNESS, Text.translatable("text.hibernalherbs.ability.regeneration_speed_weakness"));

        final MutableText ability;

        StatusEffect effect;
        StatusEffect effect2;
        StatusEffect effect3;


        BlendAbilities(StatusEffect firstEffect, StatusEffect secondEffect, MutableText callAbility) {
            effect = firstEffect;
            effect2 = secondEffect;
            ability = callAbility;
        }

        BlendAbilities(StatusEffect firstEffect, StatusEffect secondEffect, StatusEffect thirdEffect, MutableText callAbility) {
            effect = firstEffect;
            effect2 = secondEffect;
            effect3 = thirdEffect;
            ability = callAbility;
        }

        BlendAbilities(StatusEffect abilityForEffect, MutableText callAbility) {
            effect = abilityForEffect;
            ability = callAbility;
        }

        BlendAbilities(MutableText callAbility) {
            ability = callAbility;
        }

        public MutableText getAbility() {
            return ability;
        }

        public StatusEffect getEffect() {
            return effect;
        }

        public StatusEffect getEffect2() {
            return effect2;
        }

        public StatusEffect getEffect3() {
            return effect3;
        }
    }

    enum SigilAlignments {
        NONE(Text.translatable("none")),
        PRIDE(Text.translatable("pride")),
        ENVY(Text.translatable("envy")),
        SLOTH(Text.translatable("sloth")),
        WRATH(Text.translatable("wrath")),
        GREED(Text.translatable("greed")),
        LUST(Text.translatable("lust")),
        GLUTTONY(Text.translatable("gluttony")),
        MASTERY(Text.translatable("mastery")),
        ADVANCED_MASTERY(Text.translatable("advanced_mastery")),
        CONFIGURATION(Text.translatable("configuration")),
        ADVANCED_CONFIGURATION(Text.translatable("advanced_configuration"));

        final MutableText text;

        SigilAlignments(MutableText alignment) {
            text = alignment;
        }

        public MutableText getAlignment() {
            return text;
        }
    }

}
