package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class KeypadBlockEntity extends OwnableBlockEntity {
    private String passcode = "1234";

    public KeypadBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.KEYPAD_BLOCK_ENTITY, pos, state);
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode != null ? passcode : "";
        this.markDirty();
    }

    public String getPasscode() {
        return this.passcode;
    }

    public boolean verifyPasscode(String passcode) {
        return this.passcode.equals(passcode);
    }

    @Override
    protected void readData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readData(nbt, registries);
        this.passcode = nbt.getString("Passcode").orElse("1234");
    }

    @Override
    protected void writeData(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeData(nbt, registries);
        nbt.putString("Passcode", this.passcode);
    }
}
