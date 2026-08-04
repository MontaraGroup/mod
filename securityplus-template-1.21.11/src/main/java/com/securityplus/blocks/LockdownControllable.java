package com.securityplus.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface LockdownControllable {
    /**
     * Triggered when a Lockdown Lever within range changes state.
     * @param active true if lockdown was turned ON, false if OFF
     */
    void setLockdownState(World world, BlockPos pos, BlockState state, boolean active);
}
