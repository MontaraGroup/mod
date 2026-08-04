package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

import java.util.UUID;

public class OwnableBlockEntity extends BlockEntity {
    private UUID ownerUuid;

    public OwnableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OWNABLE_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        if (nbt.contains("Owner")) {
            this.ownerUuid = nbt.getUuid("Owner").orElse(null);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(nbt, registries);
        if (this.ownerUuid != null) {
            nbt.putUuid("Owner", this.ownerUuid);
        }
    }

    public UUID getOwnerUuid() {
        return ownerUuid;
    }

    public void setOwner(PlayerEntity player) {
        if (player != null) {
            this.ownerUuid = player.getUuid();
            markDirty();
        }
    }

    public boolean isOwnedBy(PlayerEntity player) {
        if (player == null) return false;
        return ownerUuid != null && ownerUuid.equals(player.getUuid());
    }
}
