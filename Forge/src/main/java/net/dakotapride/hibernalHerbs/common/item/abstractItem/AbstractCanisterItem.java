package net.dakotapride.hibernalHerbs.common.item.abstractItem;

import net.dakotapride.hibernalHerbs.client.ITooltipProvider;
import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.BundleTooltip;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class AbstractCanisterItem extends BundleItem implements ITooltipProvider {

    //
    // Credit Goes To Cheaterpaul (Owner Of Better Bundles Mod For Forge) For BundleItem Code Used Below (slightly modified)
    // As Well As Updating It To 1.19+
    //

    public final int size;

    public AbstractCanisterItem(Properties properties, int size) {
        super(properties);
        this.size = size;
    }

    @Override
    public boolean overrideStackedOnOther(@Nonnull ItemStack stack, @Nonnull Slot slot, @Nonnull ClickAction action, @Nonnull Player player) {
        if (action != ClickAction.SECONDARY) {
            return false;
        } else {
            ItemStack itemStack = slot.getItem();
            if (itemStack.isEmpty()) {
                removeOne(stack).ifPresent((p_150740_) -> {
                    add(stack, slot.safeInsert(p_150740_), size, player);
                });

                if (stack.hasTag()) {
                    playRemoveOneSound(player);
                }

            } else if (itemStack.is(HibernalHerbsForge.BLENDS_TAG)) {
                int var6 = (size - getContentWeight(stack, 64)) / getWeight(itemStack, 64);

                playInsertSound(player);
                add(stack, slot.safeTake(itemStack.getCount(), var6, player), size, player);
            }

            return true;
        }
    }

    @Override
    public boolean overrideOtherStackedOnMe(@Nonnull ItemStack stack1, @Nonnull ItemStack stack2, @Nonnull Slot slot, @Nonnull ClickAction action, @Nonnull Player player, @Nonnull SlotAccess slotAccess) {
        if (action == ClickAction.SECONDARY && slot.allowModification(player)) {
            if (stack2.isEmpty()) {
                Optional<ItemStack> var10000 = removeOne(stack1);
                Objects.requireNonNull(slotAccess);
                var10000.ifPresent(slotAccess::set);

                if (this.getDefaultInstance().hasTag()) {
                    playRemoveOneSound(player);
                }
            } else {
                playInsertSound(player);
                stack2.shrink(add(stack1, stack2, size, player));
            }

            return true;
        } else {
            return false;
        }
    }

    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level level, Player player, @Nonnull InteractionHand hand) {
        ItemStack var4 = player.getItemInHand(hand);
        if (dropContents(var4, player)) {
            playDropContentsSound(player);
            player.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResultHolder.sidedSuccess(var4, level.isClientSide());
        } else {
            return InteractionResultHolder.fail(var4);
        }
    }

    @Override
    public boolean isBarVisible(@Nonnull ItemStack stack) {
        return getContentWeight(stack, 64) > 0;
    }

    @Override
    public int getBarWidth(@Nonnull ItemStack stack) {
        return Math.min(1 + 12 * getContentWeight(stack, 64) / size, 13);
    }

    @Override
    public int getBarColor(@Nonnull ItemStack stack) {
        return super.getBarColor(stack);
    }

    @Nonnull
    @Override
    public Optional<TooltipComponent> getTooltipImage(@Nonnull ItemStack stack) {
        NonNullList<ItemStack> var2 = NonNullList.create();
        Stream<ItemStack> var10000 = getContents(stack);
        Objects.requireNonNull(var2);
        var10000.forEach(var2::add);
        return Optional.of(new BundleTooltip(var2, getContentWeight(stack, 64)));
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nonnull Level level, List<Component> components, @Nonnull TooltipFlag flag) {
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
            components.add(Component.translatable(shiftControlsText).withStyle(ChatFormatting.DARK_GRAY));
        } else if (Screen.hasShiftDown()) {
            if (stack.is(itemRegistry.CANISTER_IRON.get())) {
                components.add(Component.translatable("text.hibernalherbs.canister.quality.iron").withStyle(ChatFormatting.GRAY));
            } else if (stack.is(itemRegistry.CANISTER_AMETHYST.get())) {
                components.add(Component.translatable("text.hibernalherbs.canister.quality.amethyst").withStyle(ChatFormatting.GRAY));
            } else if (stack.is(itemRegistry.CANISTER_DIAMOND.get())) {
                components.add(Component.translatable("text.hibernalherbs.canister.quality.diamond").withStyle(ChatFormatting.GRAY));
            }

            components.add(Component.translatable("text.hibernalherbs.canister.container", getContentWeight(stack, 1), actualSize).withStyle(ChatFormatting.GRAY));

            if (!Screen.hasAltDown()) {
                components.add(Component.literal(""));
                components.add(Component.translatable(leftAltControlsText).withStyle(ChatFormatting.DARK_GRAY));
            } else {
                components.add(Component.literal(""));
                components.add(Component.translatable("text.hibernalherbs.canister.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                components.add(Component.translatable("text.hibernalherbs.canister.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                components.add(Component.literal(""));
                components.add(Component.translatable("text.hibernalherbs.container.variant.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                components.add(Component.translatable("text.hibernalherbs.container.variant.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                components.add(Component.translatable("text.hibernalherbs.container.variant.help.three").withStyle(ChatFormatting.DARK_PURPLE));

                components.add(Component.literal(""));
                components.add(Component.translatable(rightClickInventoryControlsText).withStyle(ChatFormatting.DARK_GRAY));
                components.add(Component.translatable("text.hibernalherbs.canister.inventory_controls.help.one").withStyle(ChatFormatting.DARK_PURPLE));
                components.add(Component.translatable("text.hibernalherbs.canister.inventory_controls.help.two").withStyle(ChatFormatting.DARK_PURPLE));
                components.add(Component.translatable("text.hibernalherbs.canister.inventory_controls.help.three").withStyle(ChatFormatting.DARK_PURPLE));
            }

            components.add(Component.literal(""));
            components.add(Component.translatable("text.hibernalherbs.container.can_contain.help").withStyle(ChatFormatting.DARK_GRAY));
            components.add(Component.translatable("text.hibernalherbs.container.can_contain.blends").withStyle(ChatFormatting.DARK_GRAY));
            components.add(Component.translatable("text.hibernalherbs.container.can_contain.smoked_blends").withStyle(ChatFormatting.DARK_GRAY));

            components.add(Component.literal(""));
        }
    }

    @Override
    public void onDestroyed(@Nonnull ItemEntity entity) {
        ItemUtils.onContainerDestroyed(entity, getContents(entity.getItem()));
    }



    public static int add(ItemStack bundleStack, ItemStack addStack, int size, @Nullable Player player) {
        if (!addStack.isEmpty() && addStack.is(HibernalHerbsForge.BLENDS_TAG)) {
            CompoundTag tag = bundleStack.getOrCreateTag();
            if (!tag.contains("Items")) {
                tag.put("Items", new ListTag());
            }

            int contentWeight = getContentWeight(bundleStack, 64);
            int addStackWeight = getWeight(addStack, 64);
            int remainingSlots = Math.min(addStack.getCount(), (size - contentWeight) / addStackWeight);
            if (remainingSlots == 0) {
                return 0;
            } else {
                int putSize = remainingSlots;
                ListTag list = tag.getList("Items", 10);
                List<CompoundTag> var7 = getMatchingItem(addStack, list);
                for (CompoundTag itemTag : var7) {
                    if (remainingSlots <= 0) break;
                    ItemStack var9 = ItemStack.of(itemTag);
                    int freeSlots = Math.min(var9.getMaxStackSize() - var9.getCount(), remainingSlots);
                    var9.grow(freeSlots);
                    var9.save(itemTag);
                    list.remove(itemTag);
                    list.add(0, itemTag);
                    remainingSlots -= freeSlots;
                }
                if (remainingSlots > 0) {
                    ItemStack var10 = addStack.copy();
                    var10.setCount(remainingSlots);
                    CompoundTag var11 = new CompoundTag();
                    var10.save(var11);
                    list.add(0, var11);
                }

                return putSize;
            }
        } else {
            return 0;
        }
    }

    public static List<CompoundTag> getMatchingItem(ItemStack itemStack, ListTag listTag) {
        if (itemStack.is(itemRegistry.POUCH.get())) {
            return Collections.emptyList();
        } else {
            Stream<?> var10000 = listTag.stream();
            var10000 = var10000.filter(CompoundTag.class::isInstance);
            return var10000.map(CompoundTag.class::cast).filter((p_150755_) -> {
                return ItemStack.isSameItemSameTags(ItemStack.of(p_150755_), itemStack);
            }).filter(tag -> {
                ItemStack stack = ItemStack.of(tag);
                return stack.getCount() < stack.getMaxStackSize();
            }).toList();
        }
    }

    public static int getWeight(ItemStack stack, int size) {
        if (stack.is(itemRegistry.POUCH.get())) {
            return 4 + getContentWeight(stack, size);
        } else {
            return size / stack.getMaxStackSize();
        }
    }

    public static int getContentWeight(ItemStack bundleStack, int size) {
        return getContents(bundleStack).mapToInt((stack) -> {
            return getWeight(stack,size) * stack.getCount();
        }).sum();
    }

    public static Optional<ItemStack> removeOne(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains("Items")) {
            return Optional.empty();
        } else {
            ListTag tagList = tag.getList("Items", 10);
            if (tagList.isEmpty()) {
                return Optional.empty();
            } else {
                CompoundTag tag1 = tagList.getCompound(0);
                ItemStack stack1 = ItemStack.of(tag1);
                tagList.remove(0);
                if (tagList.isEmpty()) {
                    stack.removeTagKey("Items");
                }

                return Optional.of(stack1);
            }
        }
    }

    public static boolean dropContents(ItemStack stack, Player player) {
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains("Items")) {
            return false;
        } else {
            if (player instanceof ServerPlayer) {
                ListTag tagList = tag.getList("Items", 10);

                for(int i = 0; i < tagList.size(); ++i) {
                    CompoundTag tag2 = tagList.getCompound(i);
                    ItemStack stack2 = ItemStack.of(tag2);
                    player.drop(stack2, true);
                }
            }

            stack.removeTagKey("Items");
            return true;
        }
    }

    public static Stream<ItemStack> getContents(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag == null) {
            return Stream.empty();
        } else {
            ListTag itemList = tag.getList("Items", 10);
            Stream<?> items = itemList.stream();
            return items.map(CompoundTag.class::cast).map(ItemStack::of);
        }
    }

    private void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_REMOVE_ONE, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_INSERT, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private void playDropContentsSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_DROP_CONTENTS, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }
}
