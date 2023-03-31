package net.dakotapride.hibernalHerbs.common.entity.block;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.entity.HibernalBlockEntities;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.dakotapride.hibernalHerbs.common.registry.itemRegistry;
import net.dakotapride.hibernalHerbs.common.screen.HerbalConjurationMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Optional;

public class ConjurationAltarBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(7) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 36;

    public ConjurationAltarBlockEntity(BlockPos pos, BlockState state) {
        super(HibernalBlockEntities.CONJURATION_ALTAR.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ConjurationAltarBlockEntity.this.progress;
                    case 1 -> ConjurationAltarBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ConjurationAltarBlockEntity.this.progress = value;
                    case 1 -> ConjurationAltarBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 6;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.hibernalherbs.conjuration_altar");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new HerbalConjurationMenu(id, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("conjuration.progress", this.progress);

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("conjuration.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ConjurationAltarBlockEntity entity) {
        if(level.isClientSide()) {
            return;
        }

        if(hasRecipe(entity)) {
            entity.progress++;
            setChanged(level, pos, state);

            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(ConjurationAltarBlockEntity entity) {

        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<HerbalConjurationRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(HerbalConjurationRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(entity)) {
            if (!(entity.itemHandler.getStackInSlot(0).is(HibernalHerbsForge.SIGILS_TAG))) {
                entity.itemHandler.extractItem(0, 1, false);
            } else {
                entity.itemHandler.setStackInSlot(0, new ItemStack(itemRegistry.CRACKED_SIGIL.get(), 1));
            }
            if (!(entity.itemHandler.getStackInSlot(1).is(HibernalHerbsForge.SIGILS_TAG))) {
                entity.itemHandler.extractItem(1, 1, false);
            } else {
                entity.itemHandler.setStackInSlot(1, new ItemStack(itemRegistry.CRACKED_SIGIL.get(), 1));
            }
            if (!(entity.itemHandler.getStackInSlot(2).is(HibernalHerbsForge.SIGILS_TAG))) {
                entity.itemHandler.extractItem(2, 1, false);
            } else {
                entity.itemHandler.setStackInSlot(2, new ItemStack(itemRegistry.CRACKED_SIGIL.get(), 1));
            }
            if (!(entity.itemHandler.getStackInSlot(3).is(HibernalHerbsForge.SIGILS_TAG))) {
                entity.itemHandler.extractItem(3, 1, false);
            } else {
                entity.itemHandler.setStackInSlot(3, new ItemStack(itemRegistry.CRACKED_SIGIL.get(), 1));
            }
            if (!(entity.itemHandler.getStackInSlot(4).is(HibernalHerbsForge.SIGILS_TAG))) {
                entity.itemHandler.extractItem(4, 1, false);
            } else {
                entity.itemHandler.setStackInSlot(4, new ItemStack(itemRegistry.CRACKED_SIGIL.get(), 1));
            }
            if (!(entity.itemHandler.getStackInSlot(5).is(HibernalHerbsForge.SIGILS_TAG))) {
                entity.itemHandler.extractItem(5, 1, false);
            } else {
                entity.itemHandler.setStackInSlot(5, new ItemStack(itemRegistry.CRACKED_SIGIL.get(), 1));
            }
            entity.itemHandler.setStackInSlot(6, new ItemStack(recipe.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(6).getCount() + recipe.get().getResultItem().getCount()));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(ConjurationAltarBlockEntity entity) {
        Level level = entity.level;

        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<HerbalConjurationRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(HerbalConjurationRecipe.Type.INSTANCE, inventory, level);

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inventory) &&
                canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(6).getItem() == stack.getItem() || inventory.getItem(6).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(6).getMaxStackSize() > inventory.getItem(6).getCount();
    }
}