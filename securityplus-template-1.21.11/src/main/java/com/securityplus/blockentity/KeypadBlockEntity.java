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

    public void setPasscode(String passcode) {
        this.passcode = passcode;
        this.markDirty();
    }

    public String getPasscode() {
        return this.passcode;
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        if (nbt.contains("Passcode")) {
            this.passcode = nbt.getString("Passcode");
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(nbt, registries);
        nbt.putString("Passcode", this.passcode);
    }
}
