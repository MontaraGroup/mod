package com.securityplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ElectricFenceBlock extends Block {
    public ElectricFenceBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient()) {
            entity.serverDamage(world.getDamageSources().lightningBolt(), 2.0f);
        }
    }
}
