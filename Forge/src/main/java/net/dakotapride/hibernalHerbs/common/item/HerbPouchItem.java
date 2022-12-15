package net.dakotapride.hibernalHerbs.common.item;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
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
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class HerbPouchItem extends Item {
    private static final String TAG_ITEMS = "Items";
    public static final int MAX_WEIGHT = 64;
    private static final int BUNDLE_IN_BUNDLE_WEIGHT = 4;
    private static final int BAR_COLOR = Mth.color(0.4F, 0.4F, 1.0F);

    public HerbPouchItem(Item.Properties properties) {
        super(properties);
    }

    public static float getFullnessDisplay(ItemStack stack) {
        return (float)getContentWeight(stack) / 64.0F;
    }

    public boolean overrideStackedOnOther(@NotNull ItemStack stack, @NotNull Slot slot, @NotNull ClickAction clickAction, @NotNull Player player) {
        if (clickAction != ClickAction.SECONDARY) {
            return false;
        } else {
            ItemStack itemstack = slot.getItem();
            if (itemstack.isEmpty()) {
                this.playRemoveOneSound(player);
                removeOne(stack).ifPresent((p_150740_) -> {
                    add(stack, slot.safeInsert(p_150740_));
                });
            } else if (itemstack.is(HibernalHerbsForge.HERBS_TAG)) {
                int i = (64 - getContentWeight(stack)) / getWeight(itemstack);
                int j = add(stack, slot.safeTake(itemstack.getCount(), i, player));
                if (j > 0) {
                    this.playInsertSound(player);
                }
            }

            return true;
        }
    }

    public boolean overrideOtherStackedOnMe(@NotNull ItemStack stack, @NotNull ItemStack otherStack, @NotNull Slot slot, @NotNull ClickAction clickAction, @NotNull Player player, @NotNull SlotAccess slotAccess) {
        if (clickAction == ClickAction.SECONDARY && slot.allowModification(player)) {
            if (otherStack.isEmpty()) {
                removeOne(stack).ifPresent((p_186347_) -> {
                    this.playRemoveOneSound(player);
                    slotAccess.set(p_186347_);
                });
            } else {
                int i = add(stack, otherStack);
                if (i > 0) {
                    this.playInsertSound(player);
                    otherStack.shrink(i);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (dropContents(itemstack, player)) {
            this.playDropContentsSound(player);
            player.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }

    public boolean isBarVisible(@NotNull ItemStack stack) {
        return getContentWeight(stack) > 0;
    }

    public int getBarWidth(@NotNull ItemStack stack) {
        return Math.min(1 + 12 * getContentWeight(stack) / 64, 13);
    }

    public int getBarColor(@NotNull ItemStack stack) {
        return BAR_COLOR;
    }

    private static int add(ItemStack stack, ItemStack otherStack) {
        if (!otherStack.isEmpty() && otherStack.is(HibernalHerbsForge.HERBS_TAG)) {
            CompoundTag compoundtag = stack.getOrCreateTag();
            if (!compoundtag.contains("Items")) {
                compoundtag.put("Items", new ListTag());
            }

            int i = getContentWeight(stack);
            int j = getWeight(otherStack);
            int k = Math.min(otherStack.getCount(), (64 - i) / j);
            if (k == 0) {
                return 0;
            } else {
                ListTag listtag = compoundtag.getList("Items", 10);
                Optional<CompoundTag> optional = getMatchingItem(otherStack, listtag);
                if (optional.isPresent()) {
                    CompoundTag compoundtag1 = optional.get();
                    ItemStack itemstack = ItemStack.of(compoundtag1);
                    itemstack.grow(k);
                    itemstack.save(compoundtag1);
                    listtag.remove(compoundtag1);
                    listtag.add(0, (Tag)compoundtag1);
                } else {
                    ItemStack itemstack1 = otherStack.copy();
                    itemstack1.setCount(k);
                    CompoundTag compoundtag2 = new CompoundTag();
                    itemstack1.save(compoundtag2);
                    listtag.add(0, (Tag)compoundtag2);
                }

                return k;
            }
        } else {
            return 0;
        }
    }

    private static Optional<CompoundTag> getMatchingItem(ItemStack stack, ListTag listTag) {
        return stack.is(itemRegistry.POUCH.get()) ? Optional.empty() : listTag.stream().filter(CompoundTag.class::isInstance).map(CompoundTag.class::cast).filter((p_186350_) -> {
            return ItemStack.isSameItemSameTags(ItemStack.of(p_186350_), stack);
        }).findFirst();
    }

    private static int getWeight(ItemStack stack) {
        if (stack.is(itemRegistry.POUCH.get())) {
            return 4 + getContentWeight(stack);
        } else {
            return 64 / stack.getMaxStackSize();
        }
    }

    private static int getContentWeight(ItemStack stack) {
        return getContents(stack).mapToInt((itemStack) -> {
            return getWeight(itemStack) * itemStack.getCount();
        }).sum();
    }

    private static Optional<ItemStack> removeOne(ItemStack stack) {
        CompoundTag compoundtag = stack.getOrCreateTag();
        if (!compoundtag.contains("Items")) {
            return Optional.empty();
        } else {
            ListTag listtag = compoundtag.getList("Items", 10);
            if (listtag.isEmpty()) {
                return Optional.empty();
            } else {
                int i = 0;
                CompoundTag compoundtag1 = listtag.getCompound(0);
                ItemStack itemstack = ItemStack.of(compoundtag1);
                listtag.remove(0);
                if (listtag.isEmpty()) {
                    stack.removeTagKey("Items");
                }

                return Optional.of(itemstack);
            }
        }
    }

    private static boolean dropContents(ItemStack stack, Player player) {
        CompoundTag compoundtag = stack.getOrCreateTag();
        if (!compoundtag.contains("Items")) {
            return false;
        } else {
            if (player instanceof ServerPlayer) {
                ListTag listtag = compoundtag.getList("Items", 10);

                for(int i = 0; i < listtag.size(); ++i) {
                    CompoundTag compoundtag1 = listtag.getCompound(i);
                    ItemStack itemstack = ItemStack.of(compoundtag1);
                    player.drop(itemstack, true);
                }
            }

            stack.removeTagKey("Items");
            return true;
        }
    }

    private static Stream<ItemStack> getContents(ItemStack stack) {
        CompoundTag compoundtag = stack.getTag();
        if (compoundtag == null) {
            return Stream.empty();
        } else {
            ListTag listtag = compoundtag.getList("Items", 10);
            return listtag.stream().map(CompoundTag.class::cast).map(ItemStack::of);
        }
    }

    public @NotNull Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack stack) {
        NonNullList<ItemStack> nonnulllist = NonNullList.create();
        getContents(stack).forEach(nonnulllist::add);
        return Optional.of(new BundleTooltip(nonnulllist, getContentWeight(stack)));
    }

    public void appendHoverText(@NotNull ItemStack stack, Level level, List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        list.add(Component.translatable("item.minecraft.bundle.fullness", getContentWeight(stack), 64).withStyle(ChatFormatting.GRAY));
    }

    public void onDestroyed(@NotNull ItemEntity itemEntity) {
        ItemUtils.onContainerDestroyed(itemEntity, getContents(itemEntity.getItem()));
    }

    private void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_REMOVE_ONE, 0.4F, 0.4F + entity.getLevel().getRandom().nextFloat() * 0.4F);
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_INSERT, 0.4F, 0.4F + entity.getLevel().getRandom().nextFloat() * 0.4F);
    }

    private void playDropContentsSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_DROP_CONTENTS, 0.4F, 0.4F + entity.getLevel().getRandom().nextFloat() * 0.4F);
    }
}
