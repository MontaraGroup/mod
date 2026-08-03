package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class LockdownLeverBlockEntity extends OwnableBlockEntity {
    private final List<BlockPos> savedRedstonePositions = new ArrayList<>();

    public LockdownLeverBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LOCKDOWN_LEVER_BLOCK_ENTITY, pos, state);
    }

    public void triggerLockdownOn(World world, BlockPos pos) {
        this.markDirty();
    }

    public void triggerLockdownOff(World world, BlockPos pos) {
        this.markDirty();
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        this.savedRedstonePositions.clear();
        if (nbt.contains("Positions", NbtElement.LIST_TYPE)) {
            NbtList list = nbt.getList("Positions", NbtElement.COMPOUND_TYPE);
            for (int i = 0; i < list.size(); i++) {
                NbtCompound posNbt = list.getCompound(i);
                NbtHelper.toBlockPos(posNbt, "pos").ifPresent(this.savedRedstonePositions::add);
            }
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(nbt, registries);
        NbtList list = new NbtList();
        for (BlockPos pos : this.savedRedstonePositions) {
            list.add(NbtHelper.fromBlockPos(pos));
        }
        nbt.put("Positions", list);
    }
}
