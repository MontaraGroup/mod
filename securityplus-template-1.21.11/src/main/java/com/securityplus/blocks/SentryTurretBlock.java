package com.securityplus.blocks;

import com.securityplus.blockentity.OwnableBlockEntity;
import com.securityplus.blockentity.SentryTurretBlockEntity;
import com.securityplus.init.ModBlockEntities;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import net.minecraft.class_5558;

public class SentryTurretBlock extends class_2248 implements class_2343 {
   public SentryTurretBlock(class_4970.class_2251 var1) {
      super(var1);
   }

   public class_2586 newBlockEntity(class_2338 var1, class_2680 var2) {
      return new SentryTurretBlockEntity(var1, var2);
   }

   public <T extends class_2586> class_5558<T> getTicker(class_1937 var1, class_2680 var2, class_2591<T> var3) {
      return var1.isClientSide() ? null : createTickerHelper(var3, ModBlockEntities.SENTRY_TURRET_BLOCK_ENTITY, SentryTurretBlockEntity::tick);
   }

   private static <E extends class_2586, A extends class_2586> class_5558<A> createTickerHelper(class_2591<A> var0, class_2591<E> var1, class_5558<? super E> var2) {
      return var0 == var1 ? var2 : null;
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
}
