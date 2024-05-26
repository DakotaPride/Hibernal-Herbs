package net.dakotapride.hibernalHerbs.common.item.canister;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.Utilities;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.BundleTooltipData;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.item.TooltipData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.BundleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class AbstractCanisterItem extends BundleItem implements ITooltipProvider {

    //
    // Credit To Cheaterpaul (Owner Of Better Bundles Mod For Forge)
    // Ported Cheaterpaul's BundleItem Code To Fabric + 1.19+
    //

    public final int size;

    public AbstractCanisterItem(Item.Settings settings, int size) {
        super(settings);
        this.size = size;
    }

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        if (clickType != ClickType.RIGHT) {
            return false;
        } else {
            ItemStack itemStack = slot.getStack();
            if (itemStack.isEmpty()) {
                removeOne(stack).ifPresent((stack1) -> {
                    add(stack, slot.insertStack(stack1), size, player);
                });

                if (stack.hasNbt()) {
                    playRemoveOneSound(player);
                }

            } else if (itemStack.isIn(Utilities.BLENDS)) {
                int var6 = (size - getContentWeight(stack, 64)) / getWeight(itemStack, 64);

                playInsertSound(player);
                add(stack, slot.takeStackRange(itemStack.getCount(), var6, player), size, player);
            }

            return true;
        }
    }

    @Override
    public boolean onClicked(ItemStack stack1, ItemStack stack2, Slot slot, ClickType action, PlayerEntity player, StackReference stackReference) {
        if (action == ClickType.RIGHT && slot.canTakePartial(player)) {
            if (stack2.isEmpty()) {
                Optional<ItemStack> var10000 = removeOne(stack1);
                Objects.requireNonNull(stackReference);
                var10000.ifPresent(stackReference::set);

                if (this.getDefaultStack().hasNbt()) {
                    playRemoveOneSound(player);
                }
            } else {
                playInsertSound(player);
                stack2.decrement(add(stack1, stack2, size, player));
            }

            return true;
        } else {
            return false;
        }
    }

    @Nonnull
    @Override
    public TypedActionResult<ItemStack> use(@Nonnull World world, PlayerEntity player, @Nonnull Hand hand) {
        ItemStack var4 = player.getStackInHand(hand);
        if (dropAllBundledItems(var4, player)) {
            playDropContentsSound(player);
            player.incrementStat(Stats.USED.getOrCreateStat(ItemInit.CANISTER));
            return TypedActionResult.success(var4, world.isClient);
        } else {
            return TypedActionResult.fail(var4);
        }
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return getContentWeight(stack, 64) > 0;
    }

    @Override
    public int getItemBarStep(ItemStack stack) {
        return Math.min(1 + 12 * getContentWeight(stack, 64) / size, 13);
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return super.getItemBarColor(stack);
    }

    @Nonnull
    @Override
    public Optional<TooltipData> getTooltipData(@Nonnull ItemStack stack) {
        DefaultedList<ItemStack> var2 = DefaultedList.of();
        Stream<ItemStack> var10000 = getContents(stack);
        Objects.requireNonNull(var2);
        var10000.forEach(var2::add);
        return Optional.of(new BundleTooltipData(var2, getContentWeight(stack, 64)));
    }

    @Override
    public void appendTooltip(@Nonnull ItemStack stack, @Nonnull World world, List<Text> tooltip, @Nonnull TooltipContext context) {
        int actualSize;

        if (size == 128) {
            actualSize = 2;
        } else if (size == 256) {
            actualSize = 4;
        } else if (size == 384) {
            actualSize = 6;
        } else {
            actualSize = 0;
        }

        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.translatable(shiftControlsText).formatted(Formatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            if (stack.isOf(ItemInit.IRON_CANISTER)) {
                tooltip.add(Text.translatable("text.hibernalherbs.canister.quality.iron").formatted(Formatting.GRAY));
            } else if (stack.isOf(ItemInit.AMETHYST_CANISTER)) {
                tooltip.add(Text.translatable("text.hibernalherbs.canister.quality.amethyst").formatted(Formatting.GRAY));
            } else if (stack.isOf(ItemInit.DIAMOND_CANISTER)) {
                tooltip.add(Text.translatable("text.hibernalherbs.canister.quality.diamond").formatted(Formatting.GRAY));
            }

            tooltip.add(Text.translatable("text.hibernalherbs.canister.container", getContentWeight(stack, 1), actualSize).formatted(Formatting.GRAY));

            if (!Screen.hasAltDown()) {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable(leftAltControlsText).formatted(Formatting.DARK_GRAY));
            } else {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable("text.hibernalherbs.canister.help.one").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.canister.help.two").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable("text.hibernalherbs.container.variant.help.one").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.container.variant.help.two").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.container.variant.help.three").formatted(Formatting.DARK_PURPLE));

                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable(rightClickInventoryControlsText).formatted(Formatting.DARK_GRAY));
                tooltip.add(Text.translatable("text.hibernalherbs.canister.inventory_controls.help.one").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.canister.inventory_controls.help.two").formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.translatable("text.hibernalherbs.canister.inventory_controls.help.three").formatted(Formatting.DARK_PURPLE));
            }

            tooltip.add(Text.literal(""));
            tooltip.add(Text.translatable("text.hibernalherbs.container.can_contain.help").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.translatable("text.hibernalherbs.container.can_contain.blends").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.translatable("text.hibernalherbs.container.can_contain.smoked_blends").formatted(Formatting.DARK_GRAY));

            tooltip.add(Text.literal(""));
        }
    }

    @Override
    public void onItemEntityDestroyed(@Nonnull ItemEntity entity) {
        ItemUsage.spawnItemContents(entity, getContents(entity.getStack()));
    }



    public static int add(ItemStack bundleStack, ItemStack addStack, int size, PlayerEntity player) {
        if (!addStack.isEmpty() && addStack.isIn(Utilities.BLENDS)) {
            NbtCompound tag = bundleStack.getOrCreateNbt();
            if (!tag.contains("Items")) {
                tag.put("Items", new NbtList());
            }

            int contentWeight = getContentWeight(bundleStack, 64);
            int addStackWeight = getWeight(addStack, 64);
            int remainingSlots = Math.min(addStack.getCount(), (size - contentWeight) / addStackWeight);
            if (remainingSlots == 0) {
                return 0;
            } else {
                int putSize = remainingSlots;
                NbtList list = tag.getList("Items", 10);
                List<NbtCompound> var7 = getMatchingItem(addStack, list);
                for (NbtCompound itemTag : var7) {
                    if (remainingSlots <= 0) break;
                    ItemStack var9 = ItemStack.fromNbt(itemTag);
                    int freeSlots = Math.min(var9.getMaxCount() - var9.getCount(), remainingSlots);
                    var9.increment(freeSlots);
                    var9.writeNbt(itemTag);
                    list.remove(itemTag);
                    list.add(0, itemTag);
                    remainingSlots -= freeSlots;
                }
                if (remainingSlots > 0) {
                    ItemStack var10 = addStack.copy();
                    var10.setCount(remainingSlots);
                    NbtCompound var11 = new NbtCompound();
                    var10.writeNbt(var11);
                    list.add(0, var11);
                }

                return putSize;
            }
        } else {
            return 0;
        }
    }

    public static List<NbtCompound> getMatchingItem(ItemStack itemStack, NbtList listTag) {
        if (itemStack.isIn(Utilities.CANISTERS)) {
            return Collections.emptyList();
        } else {
            Stream<?> var10000 = listTag.stream();
            var10000 = var10000.filter(NbtCompound.class::isInstance);
            return var10000.map(NbtCompound.class::cast).filter((p_150755_) -> {
                return ItemStack.canCombine(ItemStack.fromNbt(p_150755_), itemStack);
            }).filter(tag -> {
                ItemStack stack = ItemStack.fromNbt(tag);
                return stack.getCount() < stack.getMaxCount();
            }).toList();
        }
    }

    public static int getWeight(ItemStack stack, int size) {
        if (stack.isIn(Utilities.CANISTERS)) {
            return 4 + getContentWeight(stack, size);
        } else {
            return size / stack.getMaxCount();
        }
    }

    public static int getContentWeight(ItemStack bundleStack, int size) {
        return getContents(bundleStack).mapToInt((stack) -> {
            return getWeight(stack,size) * stack.getCount();
        }).sum();
    }

    public static Optional<ItemStack> removeOne(ItemStack stack) {
        NbtCompound tag = stack.getOrCreateNbt();
        if (!tag.contains("Items")) {
            return Optional.empty();
        } else {
            NbtList tagList = tag.getList("Items", 10);
            if (tagList.isEmpty()) {
                return Optional.empty();
            } else {
                NbtCompound tag1 = tagList.getCompound(0);
                ItemStack stack1 = ItemStack.fromNbt(tag1);
                tagList.remove(0);
                if (tagList.isEmpty()) {
                    stack.removeSubNbt("Items");
                }

                return Optional.of(stack1);
            }
        }
    }

    private static boolean dropAllBundledItems(ItemStack stack, PlayerEntity player) {
        NbtCompound tag = stack.getOrCreateNbt();
        if (!tag.contains("Items")) {
            return false;
        } else {
            if (player instanceof ServerPlayerEntity) {
                NbtList tagList = tag.getList("Items", 10);

                for(int i = 0; i < tagList.size(); ++i) {
                    NbtCompound tag2 = tagList.getCompound(i);
                    ItemStack stack2 = ItemStack.fromNbt(tag2);
                    player.dropItem(stack2, true);
                }
            }

            stack.removeSubNbt("Items");
            return true;
        }
    }

    public static Stream<ItemStack> getContents(ItemStack stack) {
        NbtCompound tag = stack.getNbt();
        if (tag == null) {
            return Stream.empty();
        } else {
            NbtList itemList = tag.getList("Items", 10);
            Stream<?> items = itemList.stream();
            return items.map(NbtCompound.class::cast).map(ItemStack::fromNbt);
        }
    }

    private void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BOTTLE_EMPTY, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BOTTLE_FILL, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    private void playDropContentsSound(Entity entity) {
        entity.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }
}
