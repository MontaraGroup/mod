package com.securityplus.blocks;

import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3965;
import net.minecraft.class_4970;

public class LockdownDoorBlock extends class_2248 {
   public static final class_2746 POWERED;
   public static final class_2746 OPEN;

   public LockdownDoorBlock(class_4970.class_2251 var1) {
      super(var1);
      this.registerDefaultState((class_2680)((class_2680)((class_2680)this.stateDefinition.any()).setValue(POWERED, false)).setValue(OPEN, false));
   }

   protected void createBlockStateDefinition(class_2689.class_2690<class_2248, class_2680> var1) {
      var1.add(new class_2769[]{POWERED, OPEN});
   }

   public void neighborChanged(class_2680 var1, class_1937 var2, class_2338 var3, class_2248 var4, class_2338 var5, boolean var6) {
      if (!var2.isClientSide()) {
         boolean var7 = var2.hasNeighborSignal(var3);
         if ((Boolean)var1.getValue(POWERED) != var7) {
            if (var7) {
               var2.setBlock(var3, (class_2680)((class_2680)var1.setValue(POWERED, true)).setValue(OPEN, false), 3);
               var2.playSound((class_1657)null, var3, class_3417.IRON_DOOR_CLOSE, class_3419.BLOCKS, 1.0F, 0.8F);
            } else {
               var2.setBlock(var3, (class_2680)var1.setValue(POWERED, false), 3);
            }
         }
      }

   }

   public class_1269 use(class_2680 var1, class_1937 var2, class_2338 var3, class_1657 var4, class_1268 var5, class_3965 var6) {
      if (!var2.isClientSide()) {
         if ((Boolean)var1.getValue(POWERED)) {
            var4.displayClientMessage(class_2561.literal("§c[SEALED] Lockdown Door cannot be opened while Lockdown is active!"), true);
            return class_1269.FAIL;
         }

         boolean var7 = !(Boolean)var1.getValue(OPEN);
         var2.setBlock(var3, (class_2680)var1.setValue(OPEN, var7), 3);
         var2.playSound((class_1657)null, var3, var7 ? class_3417.IRON_DOOR_OPEN : class_3417.IRON_DOOR_CLOSE, class_3419.BLOCKS, 1.0F, 1.0F);
      }

      return class_1269.SUCCESS;
   }

   static {
      POWERED = class_2741.field_12521;
      OPEN = class_2741.field_12504;
   }
}
