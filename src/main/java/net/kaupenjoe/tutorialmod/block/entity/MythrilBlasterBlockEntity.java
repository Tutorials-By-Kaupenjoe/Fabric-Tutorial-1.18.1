package net.kaupenjoe.tutorialmod.block.entity;

import net.kaupenjoe.tutorialmod.item.ModItems;
import net.kaupenjoe.tutorialmod.item.inventory.ImplementedInventory;
import net.kaupenjoe.tutorialmod.screen.MythrilBlasterScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MythrilBlasterBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(4, ItemStack.EMPTY);

    public MythrilBlasterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MYTHRIL_BLASTER, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Mythril Blaster");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new MythrilBlasterScreenHandler(syncId, inv, this);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
    }

    public static void tick(World world, BlockPos pos, BlockState state, MythrilBlasterBlockEntity entity) {
        if(hasRecipe(entity) && hasNotReachedStackLimit(entity)) {
            craftItem(entity);
        }
    }

    private static void craftItem(MythrilBlasterBlockEntity entity) {
        entity.removeStack(0, 1);
        entity.removeStack(1, 1);
        entity.removeStack(2, 1);

        entity.setStack(3, new ItemStack(ModItems.MYTHRIL_PICKAXE,
                entity.getStack(3).getCount() + 1));
    }

    private static boolean hasRecipe(MythrilBlasterBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == ModItems.LILAC_FLOWER_BULB;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == Items.GOLDEN_PICKAXE;
        boolean hasItemInThirdSlot = entity.getStack(2).getItem() == ModItems.MYTHRIL_INGOT;

        return hasItemInFirstSlot && hasItemInSecondSlot && hasItemInThirdSlot;
    }

    private static boolean hasNotReachedStackLimit(MythrilBlasterBlockEntity entity) {
        return entity.getStack(3).getCount() < entity.getStack(3).getMaxCount();
    }
}
