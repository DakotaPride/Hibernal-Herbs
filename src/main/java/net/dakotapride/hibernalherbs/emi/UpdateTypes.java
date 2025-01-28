package net.dakotapride.hibernalherbs.emi;

import dev.emi.emi.api.recipe.EmiRecipeCategory;

import java.util.Locale;

public enum UpdateTypes {
    DETERIORATION(HibernalHerbsEmiPlugin.DETERIORATION),
    REVERT_DETERIORATION(HibernalHerbsEmiPlugin.REVERT_DETERIORATION),
    FREEZE_STATE(HibernalHerbsEmiPlugin.FREEZING_STATE),
    UNFREEZE_STATE(HibernalHerbsEmiPlugin.UNFREEZING_STATE),;

    String id;
    EmiRecipeCategory category;

    UpdateTypes(EmiRecipeCategory category) {
        this.id = name().toLowerCase(Locale.ROOT);
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public EmiRecipeCategory getCategory() {
        return category;
    }
}
