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

    public OwnableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public OwnableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OWNABLE_BLOCK_ENTITY, pos, state);
    }

    public void setOwner(UUID ownerUuid) {
        this.ownerUuid = ownerUuid;
        this.markDirty();
    }

    public void setOwner(PlayerEntity player) {
        if (player != null) {
            this.ownerUuid = player.getUuid();
            this.markDirty();
        }
    }

    public void setOwner(String uuidString, String nameString) {
        try {
            if (uuidString != null && !uuidString.isEmpty()) {
                this.ownerUuid = UUID.fromString(uuidString);
                this.markDirty();
            }
        } catch (IllegalArgumentException ignored) {}
    }

    public boolean isOwnedBy(PlayerEntity player) {
        return player != null && player.getUuid().equals(this.ownerUuid);
    }

    public UUID getOwnerUuid() {
        return this.ownerUuid;
    }

    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        if (nbt.contains("OwnerUuid")) {
            String uuidStr = nbt.getString("OwnerUuid").orElse("");
            if (!uuidStr.isEmpty()) {
                try {
                    this.ownerUuid = UUID.fromString(uuidStr);
                } catch (IllegalArgumentException ignored) {}
            }
        }
    }

    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        if (this.ownerUuid != null) {
            nbt.putString("OwnerUuid", this.ownerUuid.toString());
        }
    }
}
