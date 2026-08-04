package com.securityplus.blocks;

import com.securityplus.blockentity.OwnableBlockEntity;
import com.securityplus.blockentity.SentryTurretBlockEntity;
import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SentryTurretBlock extends Block implements BlockEntityProvider {
    public SentryTurretBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SentryTurretBlockEntity(pos, state);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!world.isClient() && placer instanceof PlayerEntity player) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof OwnableBlockEntity ownable) {
                ownable.setOwner(player);
            }
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return type == ModBlockEntities.SENTRY_TURRET_BLOCK_ENTITY ? (world1, pos, state1, blockEntity) -> SentryTurretBlockEntity.tick(world1, pos, state1, (SentryTurretBlockEntity) blockEntity) : null;
    }
}
