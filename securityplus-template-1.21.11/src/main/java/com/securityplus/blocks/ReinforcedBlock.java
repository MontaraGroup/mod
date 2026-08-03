package com.securityplus.blocks;

import com.securityplus.blockentity.OwnableBlockEntity;
import com.securityplus.init.ModBlockEntities;
import com.securityplus.init.ModItems;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_4970;

public class ReinforcedBlock extends class_2248 implements class_2343 {
   public ReinforcedBlock(class_4970.class_2251 var1) {
      super(var1);
   }

   public class_2586 newBlockEntity(class_2338 var1, class_2680 var2) {
      return new OwnableBlockEntity(ModBlockEntities.OWNABLE_BLOCK_ENTITY, var1, var2);
   }

   public void setPlacedBy(class_1937 var1, class_2338 var2, class_2680 var3, class_1309 var4, class_1799 var5) {
      super.setPlacedBy(var1, var2, var3, var4, var5);
      if (!var1.isClientSide() && var4 instanceof class_1657 var6) {
         class_2586 var7 = var1.getBlockEntity(var2);
         if (var7 instanceof OwnableBlockEntity var8) {
            var8.setOwner(var6.getUUID().toString(), var6.getName().getString());
         }
      }

   }

   public class_2680 playerWillDestroy(class_1937 var1, class_2338 var2, class_2680 var3, class_1657 var4) {
      if (!var1.isClientSide() && !var4.isCreative()) {
         class_2586 var5 = var1.getBlockEntity(var2);
         if (var5 instanceof OwnableBlockEntity) {
            OwnableBlockEntity var6 = (OwnableBlockEntity)var5;
            if (!var6.isOwnedBy(var4) && !var4.getMainHandItem().is(ModItems.UNIVERSAL_BLOCK_REMOVER)) {
               var4.displayClientMessage(class_2561.literal("§cThis block belongs to " + var6.getOwnerName() + "!"), true);
            }
         }
      }

      return super.playerWillDestroy(var1, var2, var3, var4);
   }
}
