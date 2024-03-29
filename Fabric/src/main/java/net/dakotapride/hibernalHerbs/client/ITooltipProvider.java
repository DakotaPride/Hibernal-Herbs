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
    String inInventoryPassiveText = "text.hibernalherbs.controls.passive.inventory";


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
        NONE(Text.translatable("text.hibernalherbs.sigil.alignment.none")),
        PRIDE(Text.translatable("text.hibernalherbs.sigil.alignment.pride")),
        ENVY(Text.translatable("text.hibernalherbs.sigil.alignment.envy")),
        SLOTH(Text.translatable("text.hibernalherbs.sigil.alignment.sloth")),
        WRATH(Text.translatable("text.hibernalherbs.sigil.alignment.wrath")),
        GREED(Text.translatable("text.hibernalherbs.sigil.alignment.greed")),
        LUST(Text.translatable("text.hibernalherbs.sigil.alignment.lust")),
        GLUTTONY(Text.translatable("text.hibernalherbs.sigil.alignment.gluttony")),
        MASTERY(Text.translatable("text.hibernalherbs.sigil.alignment.mastery")),
        ADVANCED_MASTERY(Text.translatable("text.hibernalherbs.sigil.alignment.advanced_mastery")),
        CONFIGURATION(Text.translatable("text.hibernalherbs.sigil.alignment.configuration")),
        ADVANCED_CONFIGURATION(Text.translatable("text.hibernalherbs.sigil.alignment.advanced_configuration"));

        final MutableText text;

        SigilAlignments(MutableText alignment) {
            text = alignment;
        }

        public MutableText getAlignment() {
            return text;
        }
    }

    enum BoundPrinces {
        NONE("text.hibernalherbs.padlock.prince.none", "text.hibernalherbs.padlock.sin.none"),
        PRIDE("text.hibernalherbs.padlock.prince.pride", "text.hibernalherbs.padlock.sin.pride"),
        ENVY("text.hibernalherbs.padlock.prince.envy", "text.hibernalherbs.padlock.sin.envy"),
        SLOTH("text.hibernalherbs.padlock.prince.sloth", "text.hibernalherbs.padlock.sin.sloth"),
        WRATH("text.hibernalherbs.padlock.prince.wrath", "text.hibernalherbs.padlock.sin.wrath"),
        GREED("text.hibernalherbs.padlock.prince.greed", "text.hibernalherbs.padlock.sin.greed"),
        LUST("text.hibernalherbs.padlock.prince.lust", "text.hibernalherbs.padlock.sin.lust"),
        GLUTTONY("text.hibernalherbs.padlock.prince.gluttony", "text.hibernalherbs.padlock.sin.gluttony");

        final String princeBound;
        final String sinFromPrince;

        BoundPrinces(String prince, String sin) {
            princeBound = prince;
            sinFromPrince = sin;
        }

        public String getPrince() {
            return princeBound;
        }

        public String getSinFromPrince() {
            return sinFromPrince;
        }
    }

}
