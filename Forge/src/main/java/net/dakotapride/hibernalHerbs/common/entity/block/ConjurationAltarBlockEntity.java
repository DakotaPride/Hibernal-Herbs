package net.dakotapride.hibernalHerbs.common.entity.block;

import net.dakotapride.hibernalHerbs.common.HibernalHerbsForge;
import net.dakotapride.hibernalHerbs.common.entity.HibernalBlockEntities;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.dakotapride.hibernalHerbs.common.registry.ItemRegistry;
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
    private final ItemStackHandler itemHandler = new ItemStackHandler(7);

    private static final int INPUT_SLOT_0 = 0, INPUT_SLOT_1 = 1, INPUT_SLOT_2 = 2, INPUT_SLOT_3 = 3, INPUT_SLOT_4 = 4, INPUT_SLOT_5 = 5;
    private static final int OUTPUT_SLOT = 6;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 36;

    public ConjurationAltarBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(HibernalBlockEntities.CONJURATION_ALTAR.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> ConjurationAltarBlockEntity.this.progress;
                    case 1 -> ConjurationAltarBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> ConjurationAltarBlockEntity.this.progress = pValue;
                    case 1 -> ConjurationAltarBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 6;
            }
        };
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

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.hibernalherbs.conjuration_altar");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new HerbalConjurationMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("conjuration.progress", progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("conjuration.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (hasRecipe()) {
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<HerbalConjurationRecipe> recipe = getCurrentRecipe();
        ItemStack result = recipe.get().getResultItem();


        if (!this.itemHandler.getStackInSlot(0).is(HibernalHerbsForge.SIGILS_TAG)) {
            if (!this.itemHandler.getStackInSlot(0).is(ItemRegistry.SINGED_GRIMOIRE.get())) {
                this.itemHandler.extractItem(INPUT_SLOT_0, 1, false);
            }
        } else  {
            this.itemHandler.setStackInSlot(0, ItemRegistry.CRACKED_SIGIL.get().getDefaultInstance());
        }
        if (!this.itemHandler.getStackInSlot(1).is(HibernalHerbsForge.SIGILS_TAG)) {
            if (!this.itemHandler.getStackInSlot(1).is(ItemRegistry.SINGED_GRIMOIRE.get())) {
                this.itemHandler.extractItem(INPUT_SLOT_1, 1, false);
            }
        } else  {
            this.itemHandler.setStackInSlot(1, ItemRegistry.CRACKED_SIGIL.get().getDefaultInstance());
        }
        if (!this.itemHandler.getStackInSlot(2).is(HibernalHerbsForge.SIGILS_TAG)) {
            if (!this.itemHandler.getStackInSlot(2).is(ItemRegistry.SINGED_GRIMOIRE.get())) {
                this.itemHandler.extractItem(INPUT_SLOT_2, 1, false);
            }
        } else  {
            this.itemHandler.setStackInSlot(2, ItemRegistry.CRACKED_SIGIL.get().getDefaultInstance());
        }
        if (!this.itemHandler.getStackInSlot(3).is(HibernalHerbsForge.SIGILS_TAG)) {
            if (!this.itemHandler.getStackInSlot(3).is(ItemRegistry.SINGED_GRIMOIRE.get())) {
                this.itemHandler.extractItem(INPUT_SLOT_3, 1, false);
            }
        } else  {
            this.itemHandler.setStackInSlot(3, ItemRegistry.CRACKED_SIGIL.get().getDefaultInstance());
        }
        if (!this.itemHandler.getStackInSlot(4).is(HibernalHerbsForge.SIGILS_TAG)) {
            if (!this.itemHandler.getStackInSlot(4).is(ItemRegistry.SINGED_GRIMOIRE.get())) {
                this.itemHandler.extractItem(INPUT_SLOT_4, 1, false);
            }
        } else  {
            this.itemHandler.setStackInSlot(4, ItemRegistry.CRACKED_SIGIL.get().getDefaultInstance());
        }
        if (!this.itemHandler.getStackInSlot(5).is(HibernalHerbsForge.SIGILS_TAG)) {
            if (!this.itemHandler.getStackInSlot(5).is(ItemRegistry.SINGED_GRIMOIRE.get())) {
                this.itemHandler.extractItem(INPUT_SLOT_5, 1, false);
            }
        } else  {
            this.itemHandler.setStackInSlot(5, ItemRegistry.CRACKED_SIGIL.get().getDefaultInstance());
        }

        // this.itemHandler.extractItem(INPUT_SLOT_1, 1, false);
        // this.itemHandler.extractItem(INPUT_SLOT_2, 1, false);
        // this.itemHandler.extractItem(INPUT_SLOT_3, 1, false);
        // this.itemHandler.extractItem(INPUT_SLOT_4, 1, false);
        // this.itemHandler.extractItem(INPUT_SLOT_5, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasRecipe() {
        Optional<HerbalConjurationRecipe> recipe = getCurrentRecipe();

        return recipe.isPresent();
    }

    private Optional<HerbalConjurationRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(HerbalConjurationRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }
}