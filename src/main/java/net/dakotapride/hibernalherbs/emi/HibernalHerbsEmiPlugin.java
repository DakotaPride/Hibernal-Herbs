package net.dakotapride.hibernalherbs.emi;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.Comparison;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.recipe.EmiCookingRecipe;
import dev.emi.emi.runtime.EmiReloadLog;
import net.dakotapride.hibernalherbs.HibernalHerbsMod;
import net.dakotapride.hibernalherbs.init.BlockInit;
import net.dakotapride.hibernalherbs.init.ItemInit;
import net.dakotapride.hibernalherbs.init.RecipeInit;
import net.dakotapride.hibernalherbs.init.StatusEffectInit;
import net.dakotapride.hibernalherbs.init.enum_registry.*;
import net.dakotapride.hibernalherbs.init.enum_registry.tag.Tags;
import net.dakotapride.hibernalherbs.item.SorcererAgglomerationItem;
import net.dakotapride.hibernalherbs.item.SorcererTomeItem;
import net.dakotapride.hibernalherbs.recipe.MysticalCampfireCookingRecipe;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

@EmiEntrypoint
public class HibernalHerbsEmiPlugin implements EmiPlugin {
    public static final ResourceLocation SPRITE_SHEET = HibernalHerbsMod.asResource("textures/gui/recipe_viewer/emi.png");
    public static final EmiStack MYSTICAL_CAMPFIRE = EmiStack.of(BlockInit.MYSTICAL_CAMPFIRE);
    public static final EmiStack SORCERER_AGGLOMERATION = EmiStack.of(ItemInit.SORCERER_AGGLOMERATION);
    public static final EmiStack SORCERER_TOME = EmiStack.of(ItemInit.SORCERER_TOME);
    public static final EmiStack SACRIFICIAL_RUNE = EmiStack.of(BlockInit.SACRIFICIAL_RUNE_BLOCK);
    public static final EmiStack DETERIORATED_SACRIFICIAL_RUNE = EmiStack.of(BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK);
    public static final EmiStack FROZE_STATE_SACRIFICIAL_RUNE = EmiStack.of(BlockInit.FROZE_STATE_SACRIFICIAL_RUNE_BLOCK);
    public static final EmiStack WEATHERED_COPPER_BLOCK = EmiStack.of(Blocks.WEATHERED_COPPER);
    public static final EmiStack IRON_SICKLE = EmiStack.of(Sickles.IRON.getSickleItem());
    public static final EmiRecipeCategory MYSTICAL_CAMPFIRE_CONVERSION =
            new EmiRecipeCategory(HibernalHerbsMod.asResource("mystical_campfire_conversion"),
                    MYSTICAL_CAMPFIRE, new EmiTexture(SPRITE_SHEET, 0, 0, 16, 16));
    public static final EmiRecipeCategory AGGLOMERATION_USAGE_EFFECT =
            new EmiRecipeCategory(HibernalHerbsMod.asResource("agglomeration_usage.effect"),
                    SORCERER_AGGLOMERATION, new EmiTexture(SPRITE_SHEET, 16, 0, 16, 16));
    public static final EmiRecipeCategory TOME_USAGE_EFFECT =
            new EmiRecipeCategory(HibernalHerbsMod.asResource("tome_usage.effect"),
                    SORCERER_TOME, new EmiTexture(SPRITE_SHEET, 32, 0, 16, 16));
    public static final EmiRecipeCategory AGGLOMERATION_USAGE_ITEM =
            new EmiRecipeCategory(HibernalHerbsMod.asResource("agglomeration_usage.item"),
                    SORCERER_AGGLOMERATION, new EmiTexture(SPRITE_SHEET, 16, 0, 16, 16));
    public static final EmiRecipeCategory TOME_USAGE_ITEM =
            new EmiRecipeCategory(HibernalHerbsMod.asResource("tome_usage.item"),
                    SORCERER_TOME, new EmiTexture(SPRITE_SHEET, 32, 0, 16, 16));
    public static final EmiRecipeCategory DETERIORATION =
            new EmiRecipeCategory(HibernalHerbsMod.asResource("deterioration"),
                    SACRIFICIAL_RUNE, new EmiTexture(SPRITE_SHEET, 48, 0, 16, 16));
    public static final EmiRecipeCategory REVERT_DETERIORATION =
            new EmiRecipeCategory(HibernalHerbsMod.asResource("revert_deterioration"),
                    IRON_SICKLE, new EmiTexture(SPRITE_SHEET, 48, 0, 16, 16));
    public static final EmiRecipeCategory FREEZING_STATE =
            new EmiRecipeCategory(HibernalHerbsMod.asResource("freezing_state"),
                    WEATHERED_COPPER_BLOCK, new EmiTexture(SPRITE_SHEET, 16, 0, 16, 16));
    public static final EmiRecipeCategory UNFREEZING_STATE =
            new EmiRecipeCategory(HibernalHerbsMod.asResource("unfreezing_state"),
                    WEATHERED_COPPER_BLOCK, new EmiTexture(SPRITE_SHEET, 16, 0, 16, 16));

    public static final ResourceLocation AGGLOMERATION_EFFECTS = HibernalHerbsMod.asResource("textures/gui/recipe_viewer/agglomeration_effect_icons.png");
    public static final EmiTexture SANGUINE_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 0, 0, 18, 18);
    public static final EmiTexture LETHARGY_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 18, 0, 18, 18);
    public static final EmiTexture DEVOTION_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 36, 0, 18, 18);
    public static final EmiTexture RAPACITY_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 54, 0, 18, 18);
    public static final EmiTexture BARBARIC_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 72, 0, 18, 18);
    public static final EmiTexture ESURIENT_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 90, 0, 18, 18);
    public static final EmiTexture MIMICRY_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 108, 0, 18, 18);

    @Override
    public void register(EmiRegistry registry) {
        // Tell EMI to add a tab for your category
        registry.addCategory(MYSTICAL_CAMPFIRE_CONVERSION);
        registry.addCategory(AGGLOMERATION_USAGE_EFFECT);
        registry.addCategory(AGGLOMERATION_USAGE_ITEM);
        registry.addCategory(TOME_USAGE_EFFECT);
        registry.addCategory(TOME_USAGE_ITEM);
        registry.addCategory(DETERIORATION);
        registry.addCategory(FREEZING_STATE);
        registry.addCategory(UNFREEZING_STATE);
        registry.addCategory(REVERT_DETERIORATION);

        //registry.addRecipe(new EmiInfoRecipe(List.of(EmiIngredient.of(Ingredient.of(ItemInit.LIFE_FORCE_BOTTLE))), List.of(Component.translatable("emi.hibernalherbs.information.life_force"), Component.translatable("emi.hibernalherbs.information.life_force.usage"), Component.translatable("emi.hibernalherbs.information.life_force.slashing")), HibernalHerbsMod.asResource("life_force")));

        // Add all the workstations your category uses
        registry.addWorkstation(MYSTICAL_CAMPFIRE_CONVERSION, MYSTICAL_CAMPFIRE);
        registry.addWorkstation(AGGLOMERATION_USAGE_EFFECT, SORCERER_AGGLOMERATION);
        registry.addWorkstation(AGGLOMERATION_USAGE_ITEM, SORCERER_AGGLOMERATION);
        registry.addWorkstation(TOME_USAGE_EFFECT, SORCERER_TOME);
        registry.addWorkstation(TOME_USAGE_ITEM, SORCERER_TOME);
        registry.addWorkstation(DETERIORATION, SACRIFICIAL_RUNE);
        registry.addWorkstation(DETERIORATION, FROZE_STATE_SACRIFICIAL_RUNE);
        registry.addWorkstation(DETERIORATION, DETERIORATED_SACRIFICIAL_RUNE);
        registry.addWorkstation(FREEZING_STATE, SORCERER_AGGLOMERATION);
        registry.addWorkstation(UNFREEZING_STATE, SORCERER_AGGLOMERATION);
        registry.addWorkstation(REVERT_DETERIORATION, EmiIngredient.of(Tags.Items.SICKLES.getTag()));
        registry.addWorkstation(REVERT_DETERIORATION, EmiIngredient.of(Ingredient.of(Items.WIND_CHARGE)));

        //Comparison potionComparison = Comparison.compareData(stack -> stack.get(DataComponents.POTION_CONTENTS));

        //registry.setDefaultComparison(ItemInit.MYSTERIOUS_POTION, potionComparison);
        registry.setDefaultComparison(ItemInit.ENIGMATIC_POTION, Comparison.compareComponents());
        registry.setDefaultComparison(ItemInit.SOLAR_POTION, Comparison.compareComponents());
        registry.setDefaultComparison(ItemInit.LUNAR_POTION, Comparison.compareComponents());

        for (MysticalCampfireCookingRecipe recipe : getRecipes(registry, RecipeInit.MYSTICAL_CAMPFIRE_CONVERSION_TYPE)) {
            addRecipeSafe(registry, () -> new EmiCookingRecipe(recipe, MYSTICAL_CAMPFIRE_CONVERSION, 1, true), recipe);
        }

        // Agglomeration Usages - effect
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.SANGUINE, HerbalSigilTypes.PRIDE.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.SANGUINE.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.health_loss").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.lifesteal").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.SANGUINE.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), SANGUINE_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.LETHARGY, HerbalSigilTypes.SLOTH.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.LETHARGY.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.movement_slowness").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.apply_slowness_on_attack").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.LETHARGY.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), LETHARGY_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.BARBARIC, HerbalSigilTypes.WRATH.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.BARBARIC.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.movement_speed").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.damage_increase").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.BARBARIC.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), BARBARIC_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.DEVOTION, HerbalSigilTypes.LUST.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.DEVOTION.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.breed_entities").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.health_increase").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.DEVOTION.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), DEVOTION_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.RAPACITY, HerbalSigilTypes.GREED.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.RAPACITY.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.villager_discount").withStyle(ChatFormatting.GRAY),
                        //Component.translatable("text.hibernalherbs.effect.villager_gifting").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.RAPACITY.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), RAPACITY_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.ESURIENT, HerbalSigilTypes.GLUTTONY.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.ESURIENT.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.movement_slowness").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.consume_food_buff").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.ESURIENT.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), ESURIENT_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.MIMICRY, HerbalSigilTypes.ENVY.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.MIMICRY.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.mimicry_damage").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.apply_strength_health").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.MIMICRY.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), MIMICRY_ICON));
        // Agglomeration Usages - item
        SorcererAgglomerationItem.createEmiRecipe(registry, Items.WITHER_ROSE, HerbTypes.SAGE.getBaseBlock().asItem());
        SorcererAgglomerationItem.createEmiRecipe(registry, Items.LODESTONE, BlockInit.SACRIFICIAL_RUNE_BLOCK.asItem());
        SorcererAgglomerationItem.createEmiRecipe(registry, BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK.asItem(), ItemInit.BLANK_HERBAL_SIGIL);
        SorcererAgglomerationItem.createStoneConversionEmiRecipe(registry, Items.STONE, Items.COBBLESTONE, Items.STONE_BRICKS, Items.SMOOTH_STONE, StoneTypes.IDIOSYNCRATIC_STONE);
        SorcererAgglomerationItem.createStoneConversionEmiRecipe(registry, Items.DEEPSLATE, Items.COBBLED_DEEPSLATE, Items.DEEPSLATE_BRICKS, Items.POLISHED_DEEPSLATE, StoneTypes.NECROMANTIC_STONE);


        // Tome Usages - effect
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.SANGUINE, HerbalSigilTypes.PRIDE.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.SANGUINE.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.health_loss").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.lifesteal").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.SANGUINE.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), SANGUINE_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.LETHARGY, HerbalSigilTypes.SLOTH.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.LETHARGY.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.movement_slowness").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.apply_slowness_on_attack").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.LETHARGY.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), LETHARGY_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.BARBARIC, HerbalSigilTypes.WRATH.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.BARBARIC.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.movement_speed").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.damage_increase").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.BARBARIC.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), BARBARIC_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.DEVOTION, HerbalSigilTypes.LUST.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.DEVOTION.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.breed_entities").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.health_increase").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.DEVOTION.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), DEVOTION_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.RAPACITY, HerbalSigilTypes.GREED.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.RAPACITY.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.villager_discount").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.villager_gifting").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.RAPACITY.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), RAPACITY_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.ESURIENT, HerbalSigilTypes.GLUTTONY.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.ESURIENT.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.movement_slowness").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.consume_food_buff").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.ESURIENT.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), ESURIENT_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.MIMICRY, HerbalSigilTypes.ENVY.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.MIMICRY.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.mimicry_damage").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.apply_strength_health").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.MIMICRY.getRegisteredName().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), MIMICRY_ICON));
        // Tome Usages - item
        SorcererTomeItem.createBoundPadlockRecipe(registry, PadlockTypes.PRIDE);
        SorcererTomeItem.createBoundPadlockRecipe(registry, PadlockTypes.SLOTH);
        SorcererTomeItem.createBoundPadlockRecipe(registry, PadlockTypes.WRATH);
        SorcererTomeItem.createBoundPadlockRecipe(registry, PadlockTypes.LUST);
        SorcererTomeItem.createBoundPadlockRecipe(registry, PadlockTypes.GREED);
        SorcererTomeItem.createBoundPadlockRecipe(registry, PadlockTypes.GLUTTONY);
        SorcererTomeItem.createBoundPadlockRecipe(registry, PadlockTypes.ENVY);

        createDeteriorationRecipes(registry, BlockInit.SACRIFICIAL_RUNE_BLOCK, BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK);

        // Freeze/Unfreeze blockstates
        createFreezingRecipes(registry, BlockInit.SACRIFICIAL_RUNE_BLOCK, BlockInit.FROZE_STATE_SACRIFICIAL_RUNE_BLOCK);

        for (FrozeBlockstates states : FrozeBlockstates.values()) {
            // Copper
            createFreezingRecipes(registry, states.getBaseBlock(), states.getFrozeState());
            createFreezingRecipes(registry, states.getChiseledBlock(), states.getFrozeChiseledState());
            createFreezingRecipes(registry, states.getGrateBlock(), states.getFrozeGrateState());
            createFreezingRecipes(registry, states.getCutBlock(), states.getFrozeCutState());
            createFreezingRecipes(registry, states.getCutSlabBlock(), states.getFrozeCutSlabState());
            createFreezingRecipes(registry, states.getCutStairsBlock(), states.getFrozeCutStairsState());
            createFreezingRecipes(registry, states.getDoorBlock(), states.getFrozeDoorState());
            createFreezingRecipes(registry, states.getTrapdoorBlock(), states.getFrozeTrapdoorState());
            createFreezingRecipes(registry, states.getBulbBlock(), states.getFrozeBulbState());
        }
    }

    private static <C extends RecipeInput, T extends Recipe<C>> Iterable<T> getRecipes(EmiRegistry registry, RecipeType<T> type) {
        return registry.getRecipeManager().getAllRecipesFor(type).stream().map(RecipeHolder::value)::iterator;
    }

    private static void createDeteriorationRecipes(EmiRegistry registry, Block block, Block block2) {
        addRecipeSafe(registry, () -> new BlockUpdateFakeRecipe.DeteriorationRecipe(
                block.asItem().getDefaultInstance(),
                block2.asItem().getDefaultInstance()));
        addRecipeSafe(registry, () -> new BlockUpdateFakeRecipe.RevertDeteriorationRecipe(
                block.asItem().getDefaultInstance(),
                block2.asItem().getDefaultInstance()));
    }

    private static void createFreezingRecipes(EmiRegistry registry, Block block, Block block2) {
        addRecipeSafe(registry, () -> new BlockUpdateFakeRecipe.FreezingStateRecipe(
                block.asItem().getDefaultInstance(),
                block2.asItem().getDefaultInstance()));
        addRecipeSafe(registry, () -> new BlockUpdateFakeRecipe.UnfreezingStateRecipe(
                block.asItem().getDefaultInstance(),
                block2.asItem().getDefaultInstance()));
    }

    public static void addRecipeSafe(EmiRegistry registry, Supplier<EmiRecipe> supplier, Recipe<?> recipe) {
        try {
            registry.addRecipe(supplier.get());
        } catch (Throwable e) {
            EmiReloadLog.warn("Exception thrown when parsing vanilla recipe " + EmiPort.getId(recipe));
            EmiReloadLog.error(e);
        }
    }

    public static void addRecipeSafe(EmiRegistry registry, Supplier<EmiRecipe> supplier) {
        try {
            registry.addRecipe(supplier.get());
        } catch (Throwable e) {
            EmiReloadLog.warn("Exception thrown when parsing EMI recipe (no ID available)");
            EmiReloadLog.error(e);
        }
    }
}
