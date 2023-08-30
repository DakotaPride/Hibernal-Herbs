package net.dakotapride.hibernalHerbs.client;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

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
        NONE(Component.translatable("text.hibernalherbs.association.help.none"), 0),
        OAK(Component.translatable("text.hibernalherbs.association.help.oak"), 3),
        DARK_OAK(Component.translatable("text.hibernalherbs.association.help.dark_oak"), 3),
        BIRCH(Component.translatable("text.hibernalherbs.association.help.birch"), 3),
        SPRUCE(Component.translatable("text.hibernalherbs.association.help.spruce"), 4),
        JUNGLE(Component.translatable("text.hibernalherbs.association.help.jungle"), 3),
        ACACIA(Component.translatable("text.hibernalherbs.association.help.acacia"), 2),
        MANGROVE(Component.translatable("text.hibernalherbs.association.help.mangrove"), 3),
        CHERRY(Component.translatable("text.hibernalherbs.association.help.cherry"), 3),
        CRIMSON(Component.translatable("text.hibernalherbs.association.help.crimson"), 2),
        WARPED(Component.translatable("text.hibernalherbs.association.help.warped"), 2),
        MYQUESTE(Component.translatable("text.hibernalherbs.association.help.myqueste"), 4);


        final MutableComponent mutableText;
        final int productionValue;

        Associations(MutableComponent string, int value) {
            this.mutableText = string;
            this.productionValue = value;
        }

        public MutableComponent getTranslatableAssociation() {
            return mutableText;
        }

        public int getProductionValue() {
            return productionValue;
        }
    }

    enum BlendAbilities {
        NONE(MobEffects.SATURATION, Component.translatable("text.hibernalherbs.ability.none")),
        REGENERATIVE(MobEffects.REGENERATION, Component.translatable("text.hibernalherbs.ability.regeneration")),
        VIRULENT(MobEffects.POISON, Component.translatable("text.hibernalherbs.ability.poison")),
        SEDATING(MobEffects.MOVEMENT_SLOWDOWN, Component.translatable("text.hibernalherbs.ability.slowness")),
        HINDERING(MobEffects.DIG_SLOWDOWN, Component.translatable("text.hibernalherbs.ability.mining_fatigue")),
        DASHING(MobEffects.DIG_SPEED, Component.translatable("text.hibernalherbs.ability.haste")),
        ACCELERATION(MobEffects.MOVEMENT_SPEED, Component.translatable("text.hibernalherbs.ability.speed")),
        INCINERATING(Component.translatable("text.hibernalherbs.ability.fire")),
        DECAYING(MobEffects.WITHER, Component.translatable("text.hibernalherbs.ability.wither")),
        OBSERVING(MobEffects.NIGHT_VISION, Component.translatable("text.hibernalherbs.ability.night_vision")),
        DIMINISHED(MobEffects.WEAKNESS, Component.translatable("text.hibernalherbs.ability.weakness")),
        SHADED(MobEffects.BLINDNESS, Component.translatable("text.hibernalherbs.ability.blindness")),
        CONFLICTING(MobEffects.REGENERATION, MobEffects.MOVEMENT_SLOWDOWN, Component.translatable("text.hibernalherbs.ability.regeneration_slowness")),
        ALTERNATIVE(MobEffects.REGENERATION, MobEffects.MOVEMENT_SPEED, MobEffects.WEAKNESS, Component.translatable("text.hibernalherbs.ability.regeneration_speed_weakness"));

        final MutableComponent ability;

        MobEffect effect;
        MobEffect effect2;
        MobEffect effect3;


        BlendAbilities(MobEffect firstEffect, MobEffect secondEffect, MutableComponent callAbility) {
            effect = firstEffect;
            effect2 = secondEffect;
            ability = callAbility;
        }

        BlendAbilities(MobEffect firstEffect, MobEffect secondEffect, MobEffect thirdEffect, MutableComponent callAbility) {
            effect = firstEffect;
            effect2 = secondEffect;
            effect3 = thirdEffect;
            ability = callAbility;
        }

        BlendAbilities(MobEffect abilityForEffect, MutableComponent callAbility) {
            effect = abilityForEffect;
            ability = callAbility;
        }

        BlendAbilities(MutableComponent callAbility) {
            ability = callAbility;
        }

        public MutableComponent getAbility() {
            return ability;
        }

        public MobEffect getEffect() {
            return effect;
        }

        public MobEffect getEffect2() {
            return effect2;
        }

        public MobEffect getEffect3() {
            return effect3;
        }
    }

    enum SigilAlignments {
        NONE(Component.translatable("text.hibernalherbs.sigil.alignment.none")),
        PRIDE(Component.translatable("text.hibernalherbs.sigil.alignment.pride")),
        ENVY(Component.translatable("text.hibernalherbs.sigil.alignment.envy")),
        SLOTH(Component.translatable("text.hibernalherbs.sigil.alignment.sloth")),
        WRATH(Component.translatable("text.hibernalherbs.sigil.alignment.wrath")),
        GREED(Component.translatable("text.hibernalherbs.sigil.alignment.greed")),
        LUST(Component.translatable("text.hibernalherbs.sigil.alignment.lust")),
        GLUTTONY(Component.translatable("text.hibernalherbs.sigil.alignment.gluttony")),
        MASTERY(Component.translatable("text.hibernalherbs.sigil.alignment.mastery")),
        ADVANCED_MASTERY(Component.translatable("text.hibernalherbs.sigil.alignment.advanced_mastery")),
        CONFIGURATION(Component.translatable("text.hibernalherbs.sigil.alignment.configuration")),
        ADVANCED_CONFIGURATION(Component.translatable("text.hibernalherbs.sigil.alignment.advanced_configuration"));

        final MutableComponent text;

        SigilAlignments(MutableComponent alignment) {
            text = alignment;
        }

        public MutableComponent getAlignment() {
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
