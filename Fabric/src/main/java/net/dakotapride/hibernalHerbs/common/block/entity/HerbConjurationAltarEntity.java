package net.dakotapride.hibernalHerbs.common.block.entity;

import net.dakotapride.hibernalHerbs.common.Utilities;
import net.dakotapride.hibernalHerbs.common.init.BlockEntityInit;
import net.dakotapride.hibernalHerbs.common.init.ItemInit;
import net.dakotapride.hibernalHerbs.common.recipe.HerbalConjurationRecipe;
import net.dakotapride.hibernalHerbs.common.screen.HerbConjurationAltarScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class HerbConjurationAltarEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(7, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 36;

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return pos.isWithinDistance(player.getBlockPos(), 5.5);
    }

    public HerbConjurationAltarEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.HERB_CONJURATION_ALTAR_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return HerbConjurationAltarEntity.this.progress;
                    case 1: return HerbConjurationAltarEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: HerbConjurationAltarEntity.this.progress = value; break;
                    case 1: HerbConjurationAltarEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 7;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.hibernalherbs.conjuration_altar");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new HerbConjurationAltarScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("conjuration_altar.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("conjuration_altar.progress");
    }

    private void resetProgress() {
        this.progress = 0;
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, HerbConjurationAltarEntity entity) {
        if(world.isClient()) {
            return;
        }

        if(hasRecipe(entity)) {
            entity.progress++;
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }
    }

    private static void craftItem(HerbConjurationAltarEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<HerbalConjurationRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(HerbalConjurationRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            if (!(entity.getStack(0).isIn(Utilities.SIGILS))) {
                if (!entity.getStack(0).isOf(ItemInit.SINGED_GRIMOIRE)) {
                    entity.removeStack(0, 1);
                }
            } else {
                entity.setStack(0, new ItemStack(ItemInit.CRACKED_SIGIL, 1));
            }
            if (!(entity.getStack(1).isIn(Utilities.SIGILS))) {
                if (!entity.getStack(1).isOf(ItemInit.SINGED_GRIMOIRE)) {
                    entity.removeStack(1, 1);
                }
            } else {
                entity.setStack(1, new ItemStack(ItemInit.CRACKED_SIGIL, 1));
            }
            if (!(entity.getStack(2).isIn(Utilities.SIGILS))) {
                if (!entity.getStack(2).isOf(ItemInit.SINGED_GRIMOIRE)) {
                    entity.removeStack(2, 1);
                }
            } else {
                entity.setStack(2, new ItemStack(ItemInit.CRACKED_SIGIL, 1));
            }
            if (!(entity.getStack(3).isIn(Utilities.SIGILS))) {
                if (!entity.getStack(3).isOf(ItemInit.SINGED_GRIMOIRE)) {
                    entity.removeStack(3, 1);
                }
            } else {
                entity.setStack(3, new ItemStack(ItemInit.CRACKED_SIGIL, 1));
            }
            if (!(entity.getStack(4).isIn(Utilities.SIGILS))) {
                if (!entity.getStack(4).isOf(ItemInit.SINGED_GRIMOIRE)) {
                    entity.removeStack(4, 1);
                }
            } else {
                entity.setStack(4, new ItemStack(ItemInit.CRACKED_SIGIL, 1));
            }
            if (!(entity.getStack(5).isIn(Utilities.SIGILS))) {
                if (!entity.getStack(5).isOf(ItemInit.SINGED_GRIMOIRE)) {
                    entity.removeStack(5, 1);
                }
            } else {
                entity.setStack(5, new ItemStack(ItemInit.CRACKED_SIGIL, 1));
            }

            entity.setStack(6, new ItemStack(recipe.get().getOutput().getItem(),
                    entity.getStack(6).getCount() + recipe.get().getOutput().getCount()));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(HerbConjurationAltarEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<HerbalConjurationRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(HerbalConjurationRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput().getItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {

        return inventory.getStack(6).getItem() == output || inventory.getStack(6).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(6).getMaxCount() > inventory.getStack(6).getCount();
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
}
