package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SentryTurretBlockEntity extends OwnableBlockEntity {

    public SentryTurretBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SENTRY_TURRET_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        if (world.isClient() || !(world instanceof ServerWorld serverWorld)) return;
        if (blockEntity instanceof SentryTurretBlockEntity turret) {
            turret.updateTurret(serverWorld, pos);
        }
    }

    private void updateTurret(ServerWorld world, BlockPos pos) {
        // Sentry targeting and shooting logic
    }
}
