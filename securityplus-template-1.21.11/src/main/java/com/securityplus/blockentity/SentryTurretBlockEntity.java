package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class SentryTurretBlockEntity extends OwnableBlockEntity {

    public SentryTurretBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SENTRY_TURRET_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SentryTurretBlockEntity blockEntity) {
        if (world.isClient || !(world instanceof ServerWorld serverWorld)) return;

        Box searchArea = new Box(pos).expand(10.0);
        List<LivingEntity> targets = world.getNonSpectatingEntities(LivingEntity.class, searchArea);

        for (LivingEntity target : targets) {
            if (target instanceof PlayerEntity player && blockEntity.isOwnedBy(player)) {
                continue;
            }
            if (target.isAlive()) {
                blockEntity.fireArrow(serverWorld, pos, target);
                break;
            }
        }
    }

    private void fireArrow(ServerWorld world, BlockPos pos, LivingEntity target) {
        double dx = target.getX() - (pos.getX() + 0.5);
        double dy = target.getEyeY() - (pos.getY() + 0.5);
        double dz = target.getZ() - (pos.getZ() + 0.5);

        PersistentProjectileEntity arrow = new ArrowEntity(world, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, new ItemStack(Items.ARROW), null);
        arrow.setVelocity(dx, dy + 0.1, dz, 1.6F, 12.0F);

        world.spawnEntity(arrow);
        world.playSound(null, pos, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
}
