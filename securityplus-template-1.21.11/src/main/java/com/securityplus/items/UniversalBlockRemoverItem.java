package com.securityplus.items;

import com.securityplus.blockentity.OwnableBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UniversalBlockRemoverItem extends Item {

    public UniversalBlockRemoverItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        if (!world.isClient() && player != null) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof OwnableBlockEntity ownable) {
                if (ownable.isOwnedBy(player) || player.hasPermissionLevel(2)) {
                    world.breakBlock(pos, true, player);
                    return ActionResult.SUCCESS;
                } else {
                    player.sendMessage(Text.literal("You do not own this block!"), true);
                }
            }
        }
        return ActionResult.PASS;
    }
}
