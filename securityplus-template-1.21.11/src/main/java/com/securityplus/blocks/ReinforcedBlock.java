package com.securityplus.blocks;

import com.securityplus.blockentity.OwnableBlockEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ReinforcedBlock extends Block implements BlockEntityProvider {

    public ReinforcedBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OwnableBlockEntity(pos, state);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (placer instanceof PlayerEntity player && world.getBlockEntity(pos) instanceof OwnableBlockEntity ownable) {
            ownable.setOwner(player.getUuid());
        }
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        return super.onBreak(world, pos, state, player);
    }
}
