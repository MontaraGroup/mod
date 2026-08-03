package com.securityplus.items;

import com.securityplus.blockentity.OwnableBlockEntity;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1838;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2561;
import net.minecraft.class_2586;

public class UniversalBlockRemoverItem extends class_1792 {
   public UniversalBlockRemoverItem(class_1792.class_1793 var1) {
      super(var1);
   }

   public class_1269 useOn(class_1838 var1) {
      class_1937 var2 = var1.getLevel();
      class_2338 var3 = var1.getClickedPos();
      class_1657 var4 = var1.getPlayer();
      if (!var2.isClientSide() && var4 != null) {
         class_2586 var5 = var2.getBlockEntity(var3);
         if (var5 instanceof OwnableBlockEntity) {
            OwnableBlockEntity var6 = (OwnableBlockEntity)var5;
            if (!var6.isOwnedBy(var4) && !var4.isCreative()) {
               var4.displayClientMessage(class_2561.literal("§cOnly the owner (" + var6.getOwnerName() + ") can use Universal Block Remover!"), true);
               return class_1269.FAIL;
            }

            var2.destroyBlock(var3, true, var4);
            var4.displayClientMessage(class_2561.literal("§aReinforced block deconstructed."), true);
            return class_1269.SUCCESS;
         }
      }

      return super.useOn(var1);
   }
}
