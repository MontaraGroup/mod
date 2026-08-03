package com.securityplus.blocks;

import com.securityplus.blockentity.LockdownLeverBlockEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2350;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3965;
import net.minecraft.class_4970;

public class LockdownLeverBlock extends class_2248 implements class_2343 {
   public static final class_2746 POWERED;

   public LockdownLeverBlock(class_4970.class_2251 var1) {
      super(var1);
      this.registerDefaultState((class_2680)((class_2680)this.stateDefinition.any()).setValue(POWERED, false));
   }

   protected void createBlockStateDefinition(class_2689.class_2690<class_2248, class_2680> var1) {
      var1.add(new class_2769[]{POWERED});
   }

   public class_2586 newBlockEntity(class_2338 var1, class_2680 var2) {
      return new LockdownLeverBlockEntity(var1, var2);
   }

   public boolean isSignalSource(class_2680 var1) {
      return true;
   }

   public int getSignal(class_2680 var1, class_1922 var2, class_2338 var3, class_2350 var4) {
      return (Boolean)var1.getValue(POWERED) ? 15 : 0;
   }

   public class_1269 use(class_2680 var1, class_1937 var2, class_2338 var3, class_1657 var4, class_1268 var5, class_3965 var6) {
      if (!var2.isClientSide()) {
         boolean var7 = !(Boolean)var1.getValue(POWERED);
         var2.setBlock(var3, (class_2680)var1.setValue(POWERED, var7), 3);
         var2.updateNeighborsAt(var3, this);
         class_2586 var8 = var2.getBlockEntity(var3);
         if (var8 instanceof LockdownLeverBlockEntity) {
            LockdownLeverBlockEntity var9 = (LockdownLeverBlockEntity)var8;
            if (var7) {
               var9.triggerLockdownOn(var2, var3);
               var2.playSound((class_1657)null, var3, class_3417.END_PORTAL_SPAWN, class_3419.BLOCKS, 1.0F, 0.5F);
               var4.displayClientMessage(class_2561.literal("§c§l[FACILITY LOCKDOWN ACTIVATED] §rRedstone self-broken!"), false);
            } else {
               var9.triggerLockdownOff(var2, var3);
               var2.playSound((class_1657)null, var3, (class_3414)class_3417.NOTE_BLOCK_BELL.value(), class_3419.BLOCKS, 1.0F, 1.2F);
               var4.displayClientMessage(class_2561.literal("§a[Lockdown Deactivated] §rRedstone wires restored!"), false);
            }
         }
      }

      return class_1269.SUCCESS;
   }

   static {
      POWERED = class_2741.field_12521;
   }
}
