package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class KeypadBlockEntity extends OwnableBlockEntity {
    private String passcode = "";

    public KeypadBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.KEYPAD_BLOCK_ENTITY, pos, state);
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
        this.markDirty();
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        if (nbt.contains("Passcode")) {
            this.passcode = nbt.getString("Passcode");
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(nbt, registries);
        if (this.passcode != null) {
            nbt.putString("Passcode", this.passcode);
        }
    }
}
