package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.NbtCompound;
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
        this.savedRedstonePositions.clear();
        int radius = 10;
        BlockPos.iterate(pos.add(-radius, -radius, -radius), pos.add(radius, radius, radius)).forEach(p -> {
            if (world.getBlockState(p).isOf(Blocks.REDSTONE_WIRE)) {
                this.savedRedstonePositions.add(p.toImmutable());
                world.setBlockState(p, Blocks.AIR.getDefaultState(), 3);
            }
        });
        this.markDirty();
    }

    public void triggerLockdownOff(World world, BlockPos pos) {
        for (BlockPos redstonePos : this.savedRedstonePositions) {
            if (world.getBlockState(redstonePos).isAir()) {
                world.setBlockState(redstonePos, Blocks.REDSTONE_WIRE.getDefaultState(), 3);
            }
        }
        this.savedRedstonePositions.clear();
        this.markDirty();
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        this.savedRedstonePositions.clear();
        if (nbt.contains("RedstonePositions")) {
            NbtList list = nbt.getList("RedstonePositions").orElse(new NbtList());
            for (int i = 0; i < list.size(); i++) {
                NbtCompound posNbt = list.getCompound(i).orElse(new NbtCompound());
                if (posNbt.contains("X") && posNbt.contains("Y") && posNbt.contains("Z")) {
                    int x = posNbt.getInt("X").orElse(0);
                    int y = posNbt.getInt("Y").orElse(0);
                    int z = posNbt.getInt("Z").orElse(0);
                    this.savedRedstonePositions.add(new BlockPos(x, y, z));
                }
            }
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(nbt, registries);
        NbtList list = new NbtList();
        for (BlockPos pos : this.savedRedstonePositions) {
            NbtCompound posNbt = new NbtCompound();
            posNbt.putInt("X", pos.getX());
            posNbt.putInt("Y", pos.getY());
            posNbt.putInt("Z", pos.getZ());
            list.add(posNbt);
        }
        nbt.put("RedstonePositions", list);
    }
}
