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
import net.dakotapride.hibernalherbs.item.SorcererTomeItem;
import net.dakotapride.hibernalherbs.recipe.MysticalCampfireCookingRecipe;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.item.Item;
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
    public static final EmiStack INCENSE_PROVIDER = EmiStack.of(BlockInit.INCENSE_PROVIDER);
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
    public static final EmiRecipeCategory INCENSE_BURNING =
            new EmiRecipeCategory(HibernalHerbsMod.asResource("incense_item_burning"),
                    INCENSE_PROVIDER, new EmiTexture(SPRITE_SHEET, 64, 0, 16, 16));

    public static final ResourceLocation AGGLOMERATION_EFFECTS = HibernalHerbsMod.asResource("textures/gui/recipe_viewer/agglomeration_effect_icons.png");
    public static final EmiTexture SANGUINE_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 0, 0, 18, 18);
    public static final EmiTexture LETHARGY_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 18, 0, 18, 18);
    public static final EmiTexture DEVOTION_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 36, 0, 18, 18);
    public static final EmiTexture RAPACITY_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 54, 0, 18, 18);
    public static final EmiTexture BARBARIC_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 72, 0, 18, 18);
    public static final EmiTexture ESURIENT_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 90, 0, 18, 18);
    public static final EmiTexture MIMICRY_ICON = new EmiTexture(AGGLOMERATION_EFFECTS, 108, 0, 18, 18);

    public static void createStoneConversionEmiRecipe(EmiRegistry registry,
                                                      Item base, Item cobbled, Item bricks, Item polished,
                                                      StoneTypes types) {
        HibernalHerbsEmiPlugin.addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                CustomAgglomerationUsageRecipe(base.getDefaultInstance(), types.getBaseBlock().asItem().getDefaultInstance(), false));
        HibernalHerbsEmiPlugin.addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                CustomAgglomerationUsageRecipe(cobbled.getDefaultInstance(), types.getCobbledBlock().asItem().getDefaultInstance(), false));
        HibernalHerbsEmiPlugin.addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                CustomAgglomerationUsageRecipe(bricks.getDefaultInstance(), types.getBricksBlock().asItem().getDefaultInstance(), false));
        HibernalHerbsEmiPlugin.addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                CustomAgglomerationUsageRecipe(polished.getDefaultInstance(), types.getPolishedBlock().asItem().getDefaultInstance(), false));
    }

    public static void createAgglomerationEmiRecipe(EmiRegistry registry, Item item0, Item item1) {
        HibernalHerbsEmiPlugin.addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                CustomAgglomerationUsageRecipe(item0.getDefaultInstance(), item1.getDefaultInstance(), false));
    }

    public static void createTomeEmiRecipe(EmiRegistry registry, Item item0, Item item1) {
        HibernalHerbsEmiPlugin.addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.CustomTomeUsageRecipe(item0.getDefaultInstance(), item1.getDefaultInstance(), false));
    }

    public static void createBoundPadlockRecipe(EmiRegistry registry, PadlockTypes types) {
        createTomeEmiRecipe(registry, types.getUnboundPadlockItem(), types.getBoundPadlockItem());
    }

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
        registry.addCategory(INCENSE_BURNING);

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
        registry.addWorkstation(INCENSE_BURNING, INCENSE_PROVIDER);
        registry.addWorkstation(INCENSE_BURNING, DETERIORATED_SACRIFICIAL_RUNE);

        //Comparison potionComparison = Comparison.compareData(stack -> stack.get(DataComponents.POTION_CONTENTS));

        //registry.setDefaultComparison(ItemInit.MYSTERIOUS_POTION, potionComparison);
        registry.setDefaultComparison(ItemInit.ENIGMATIC_POTION, Comparison.compareNbt());
        registry.setDefaultComparison(ItemInit.SOLAR_POTION, Comparison.compareNbt());
        registry.setDefaultComparison(ItemInit.LUNAR_POTION, Comparison.compareNbt());

        for (MysticalCampfireCookingRecipe recipe : getRecipes(registry, RecipeInit.MYSTICAL_CAMPFIRE_CONVERSION_TYPE)) {
            addRecipeSafe(registry, () -> new EmiCookingRecipe(recipe, MYSTICAL_CAMPFIRE_CONVERSION, 1, true), recipe);
        }

        // Agglomeration Usages - effect
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.SANGUINE, HerbalSigilTypes.PRIDE.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.SANGUINE.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.health_loss").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.lifesteal").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.SANGUINE.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), SANGUINE_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.LETHARGY, HerbalSigilTypes.SLOTH.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.LETHARGY.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.movement_slowness").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.apply_slowness_on_attack").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.LETHARGY.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), LETHARGY_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.BARBARIC, HerbalSigilTypes.WRATH.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.BARBARIC.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.movement_speed").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.damage_increase").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.BARBARIC.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), BARBARIC_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.DEVOTION, HerbalSigilTypes.LUST.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.DEVOTION.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.breed_entities").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.health_increase").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.DEVOTION.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), DEVOTION_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.RAPACITY, HerbalSigilTypes.GREED.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.RAPACITY.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.villager_discount").withStyle(ChatFormatting.GRAY),
                        //Component.translatable("text.hibernalherbs.effect.villager_gifting").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.RAPACITY.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), RAPACITY_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.ESURIENT, HerbalSigilTypes.GLUTTONY.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.ESURIENT.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.movement_slowness").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.consume_food_buff").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.ESURIENT.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), ESURIENT_ICON));
        addRecipeSafe(registry, () -> new AbstractAgglomerationUsageRecipe.
                AgglomerationUsageRecipe(StatusEffectInit.MIMICRY, HerbalSigilTypes.ENVY.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.MIMICRY.value().getDescriptionId()),
                        Component.translatable("text.hibernalherbs.effect.mimicry_damage").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.apply_strength_health").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.MIMICRY.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), MIMICRY_ICON));
        // Agglomeration Usages - item
        createAgglomerationEmiRecipe(registry, Items.WITHER_ROSE, HerbTypes.SAGE.getBaseBlock().asItem());
        createAgglomerationEmiRecipe(registry, Items.LODESTONE, BlockInit.SACRIFICIAL_RUNE_BLOCK.asItem());
        createAgglomerationEmiRecipe(registry, BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK.asItem(), ItemInit.BLANK_HERBAL_SIGIL);
        createStoneConversionEmiRecipe(registry, Items.STONE, Items.COBBLESTONE, Items.STONE_BRICKS, Items.SMOOTH_STONE, StoneTypes.IDIOSYNCRATIC_STONE);
        createStoneConversionEmiRecipe(registry, Items.DEEPSLATE, Items.COBBLED_DEEPSLATE, Items.DEEPSLATE_BRICKS, Items.POLISHED_DEEPSLATE, StoneTypes.NECROMANTIC_STONE);


        // Tome Usages - effect
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.SANGUINE, HerbalSigilTypes.PRIDE.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.SANGUINE.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.health_loss").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.lifesteal").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.SANGUINE.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), SANGUINE_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.LETHARGY, HerbalSigilTypes.SLOTH.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.LETHARGY.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.movement_slowness").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.apply_slowness_on_attack").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.LETHARGY.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), LETHARGY_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.BARBARIC, HerbalSigilTypes.WRATH.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.BARBARIC.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.movement_speed").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.damage_increase").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.BARBARIC.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), BARBARIC_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.DEVOTION, HerbalSigilTypes.LUST.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.DEVOTION.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.breed_entities").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.health_increase").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.DEVOTION.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), DEVOTION_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.RAPACITY, HerbalSigilTypes.GREED.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.RAPACITY.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.villager_discount").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.villager_gifting").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.RAPACITY.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), RAPACITY_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.ESURIENT, HerbalSigilTypes.GLUTTONY.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.ESURIENT.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.movement_slowness").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.consume_food_buff").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.ESURIENT.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), ESURIENT_ICON));
        addRecipeSafe(registry, () -> new AbstractTomeUsageRecipe.
                TomeUsageRecipe(StatusEffectInit.MIMICRY, HerbalSigilTypes.ENVY.getHerbalSigilItem(),
                List.of(Component.translatable(StatusEffectInit.MIMICRY.value().getDescriptionId() + ".level", "II"),
                        Component.translatable("text.hibernalherbs.effect.mimicry_damage").withStyle(ChatFormatting.GRAY),
                        Component.translatable("text.hibernalherbs.effect.apply_strength_health").withStyle(ChatFormatting.GRAY),
                        Component.literal(StatusEffectInit.MIMICRY.toString().toLowerCase(Locale.ROOT)).withStyle(ChatFormatting.DARK_GRAY),
                        Component.translatable("text.hibernalherbs.mod_id").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC)), MIMICRY_ICON));
        // Tome Usages - item
        createBoundPadlockRecipe(registry, PadlockTypes.PRIDE);
        createBoundPadlockRecipe(registry, PadlockTypes.SLOTH);
        createBoundPadlockRecipe(registry, PadlockTypes.WRATH);
        createBoundPadlockRecipe(registry, PadlockTypes.LUST);
        createBoundPadlockRecipe(registry, PadlockTypes.GREED);
        createBoundPadlockRecipe(registry, PadlockTypes.GLUTTONY);
        createBoundPadlockRecipe(registry, PadlockTypes.ENVY);

        createDeteriorationRecipes(registry, BlockInit.SACRIFICIAL_RUNE_BLOCK, BlockInit.DETERIORATED_SACRIFICIAL_RUNE_BLOCK);

        // Freeze/Unfreeze blockstates
        createFreezingRecipes(registry, BlockInit.SACRIFICIAL_RUNE_BLOCK, BlockInit.FROZE_STATE_SACRIFICIAL_RUNE_BLOCK);

        // Incense Item Burning
        createItemBurningFromIncenseRecipe(registry, Items.PAPER, ItemInit.CHARRED_PAPER.asItem(), false, 100);
        createItemBurningFromIncenseRecipe(registry, Items.BOOK, Items.ENCHANTED_BOOK, true, 75);
        createItemBurningFromIncenseRecipe(registry, Items.BOOK, ItemInit.CHARRED_PAPER.asItem(), false, 25);
    }

    private static void createItemBurningFromIncenseRecipe(EmiRegistry registry, Item input, Item result, boolean ench, int chance) {
        addRecipeSafe(registry, () -> new IncenseItemBurningFakeRecipe(input.getDefaultInstance(), result.getDefaultInstance(), ench, chance));
    }

    private static <C extends Container, T extends Recipe<C>> Iterable<T> getRecipes(EmiRegistry registry, RecipeType<T> type) {
        return registry.getRecipeManager().getAllRecipesFor(type).stream()::iterator;
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
            EmiReloadLog.warn(e.toString());
        }
    }

    public static void addRecipeSafe(EmiRegistry registry, Supplier<EmiRecipe> supplier) {
        try {
            registry.addRecipe(supplier.get());
        } catch (Throwable e) {
            EmiReloadLog.warn("Exception thrown when parsing EMI recipe (no ID available)");
            EmiReloadLog.warn(e.toString());
        }
    }
}
