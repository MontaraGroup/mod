package com.securityplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LockdownShutterBlock extends Block {
    public LockdownShutterBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient()) {
            // Shutter opening/closing logic
        }
    }
}
