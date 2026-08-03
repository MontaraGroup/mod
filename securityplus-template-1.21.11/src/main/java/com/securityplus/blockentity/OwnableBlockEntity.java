package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

import java.util.UUID;

public class OwnableBlockEntity extends BlockEntity {
    private UUID ownerUuid;

    public OwnableBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntities.OWNABLE_BLOCK_ENTITY, pos, state);
    }

    public OwnableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public boolean isOwnedBy(PlayerEntity player) {
        return ownerUuid != null && ownerUuid.equals(player.getUuid());
    }

    public void setOwner(UUID uuid) {
        this.ownerUuid = uuid;
        this.markDirty();
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        if (nbt.containsUuid("Owner")) {
            this.ownerUuid = nbt.getUuid("Owner");
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(nbt, registries);
        if (this.ownerUuid != null) {
            nbt.putUuid("Owner", this.ownerUuid);
        }
    }
}
