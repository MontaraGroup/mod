package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

import java.util.UUID;

public class OwnableBlockEntity extends BlockEntity {
    private UUID ownerUuid;

    public OwnableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OWNABLE_BLOCK_ENTITY, pos, state);
    }

    public OwnableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public void setOwner(UUID uuid) {
        this.ownerUuid = uuid;
        this.markDirty();
    }

    public UUID getOwner() {
        return this.ownerUuid;
    }

    public boolean isOwnedBy(PlayerEntity player) {
        return this.ownerUuid != null && this.ownerUuid.equals(player.getUuid());
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        if (nbt.contains("Owner")) {
            this.ownerUuid = NbtHelper.toUuid(nbt.get("Owner"));
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(nbt, registries);
        if (this.ownerUuid != null) {
            nbt.put("Owner", NbtHelper.fromUuid(this.ownerUuid));
        }
    }
}
