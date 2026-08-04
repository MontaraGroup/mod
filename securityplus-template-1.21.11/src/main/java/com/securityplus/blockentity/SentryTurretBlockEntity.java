package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
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
    private int cooldown = 0;

    public SentryTurretBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SENTRY_TURRET_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SentryTurretBlockEntity blockEntity) {
        if (!world.isClient()) {
            if (blockEntity.cooldown > 0) {
                --blockEntity.cooldown;
            } else {
                Box box = new Box(pos).expand(10.0);
                List<LivingEntity> targets = world.getEntitiesByClass(LivingEntity.class, box, (entity) -> {
                    if (!entity.isSpectator() && entity.isAlive()) {
                        if (entity instanceof PlayerEntity player) {
                            return !blockEntity.isOwnedBy(player);
                        } else {
                            return entity instanceof HostileEntity;
                        }
                    }
                    return false;
                });
                if (!targets.isEmpty()) {
                    LivingEntity target = targets.get(0);
                    blockEntity.fireArrow((ServerWorld) world, pos, target);
                    blockEntity.cooldown = 10;
                }
            }
        }
    }

    private void fireArrow(ServerWorld world, BlockPos pos, LivingEntity target) {
        ArrowEntity arrow = new ArrowEntity(world, (double)pos.getX() + 0.5, (double)pos.getY() + 1.2, (double)pos.getZ() + 0.5, new ItemStack(Items.ARROW), null);
        double dx = target.getX() - ((double)pos.getX() + 0.5);
        double dy = target.getBodyY(0.5) - ((double)pos.getY() + 1.2);
        double dz = target.getZ() - ((double)pos.getZ() + 0.5);
        arrow.setVelocity(dx, dy, dz, 1.6F, 12.0F);
        world.spawnEntity(arrow);
        world.playSound(null, pos, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.BLOCKS, 1.0F, 1.2F);
    }
}
