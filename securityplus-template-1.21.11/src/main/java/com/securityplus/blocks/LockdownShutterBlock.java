package com.securityplus.blocks;

import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4970;

public class LockdownShutterBlock extends class_2248 {
   public static final class_2746 POWERED;

   public LockdownShutterBlock(class_4970.class_2251 var1) {
      super(var1);
      this.registerDefaultState((class_2680)((class_2680)this.stateDefinition.any()).setValue(POWERED, false));
   }

   protected void createBlockStateDefinition(class_2689.class_2690<class_2248, class_2680> var1) {
      var1.add(new class_2769[]{POWERED});
   }

   public void neighborChanged(class_2680 var1, class_1937 var2, class_2338 var3, class_2248 var4, class_2338 var5, boolean var6) {
      if (!var2.isClientSide()) {
         boolean var7 = var2.hasNeighborSignal(var3);
         if ((Boolean)var1.getValue(POWERED) != var7) {
            var2.setBlock(var3, (class_2680)var1.setValue(POWERED, var7), 3);
            var2.playSound((class_1657)null, var3, class_3417.ANVIL_USE, class_3419.BLOCKS, 0.5F, 1.2F);
         }
      }

   }

   static {
      POWERED = class_2741.field_12521;
   }
}
