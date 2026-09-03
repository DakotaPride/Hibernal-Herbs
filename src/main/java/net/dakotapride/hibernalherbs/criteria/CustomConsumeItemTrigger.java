package net.dakotapride.hibernalherbs.criteria;

import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.resources.ResourceLocation;

public class CustomConsumeItemTrigger extends ConsumeItemTrigger {
    String string;
    public CustomConsumeItemTrigger(String id) {
        this.string = id;
    }

    @Override
    public ResourceLocation getId() {
        return HibernalHerbsMod.asResource(string);
    }
}
