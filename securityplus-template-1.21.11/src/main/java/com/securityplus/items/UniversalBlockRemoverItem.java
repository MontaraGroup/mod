package com.securityplus.items;

import com.securityplus.blockentity.OwnableBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UniversalBlockRemoverItem extends Item {
    public UniversalBlockRemoverItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        if (!world.isClient() && player != null) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof OwnableBlockEntity ownable) {
                boolean canRemove = ownable.isOwnedBy(player) || player.isCreative() || (player instanceof ServerPlayerEntity serverPlayer && serverPlayer.getCommandSource().hasPermissionLevel(2));
                if (canRemove) {
                    world.breakBlock(pos, true, player);
                    player.sendMessage(Text.literal("§a[SECURITY] Block removed."), true);
                    return ActionResult.SUCCESS;
                } else {
                    player.sendMessage(Text.literal("§c[SECURITY] Access Denied: You do not own this block."), true);
                    return ActionResult.FAIL;
                }
            }
        }
        return ActionResult.PASS;
    }
}
