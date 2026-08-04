package com.securityplus.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class LockdownLeverBlockEntity extends OwnableBlockEntity {
    private final List<BlockPos> savedRedstonePositions = new ArrayList<>();

    public LockdownLeverBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        this.savedRedstonePositions.clear();
        
        NbtList list = nbt.getList("Positions").orElseGet(NbtList::new);
        for (int i = 0; i < list.size(); i++) {
            NbtCompound posNbt = list.getCompound(i).orElseGet(NbtCompound::new);
            NbtHelper.toBlockPos(posNbt).ifPresent(this.savedRedstonePositions::add);
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

    public List<BlockPos> getSavedRedstonePositions() {
        return savedRedstonePositions;
    }

    public void addPosition(BlockPos pos) {
        if (!savedRedstonePositions.contains(pos)) {
            savedRedstonePositions.add(pos);
            markDirty();
        }
    }
}
