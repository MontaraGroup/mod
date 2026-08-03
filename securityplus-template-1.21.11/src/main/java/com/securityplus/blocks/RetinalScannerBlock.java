package com.securityplus.blocks;

import com.securityplus.blockentity.OwnableBlockEntity;
import com.securityplus.init.ModBlockEntities;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class RetinalScannerBlock extends class_2248 implements class_2343 {
   public static final class_2746 POWERED;

   public RetinalScannerBlock(class_4970.class_2251 var1) {
      super(var1);
      this.registerDefaultState((class_2680)((class_2680)this.stateDefinition.any()).setValue(POWERED, false));
   }

   protected void createBlockStateDefinition(class_2689.class_2690<class_2248, class_2680> var1) {
      var1.add(new class_2769[]{POWERED});
   }

   public class_2586 newBlockEntity(class_2338 var1, class_2680 var2) {
      return new OwnableBlockEntity(ModBlockEntities.OWNABLE_BLOCK_ENTITY, var1, var2);
   }

   public boolean isSignalSource(class_2680 var1) {
      return true;
   }

   public int getSignal(class_2680 var1, class_1922 var2, class_2338 var3, class_2350 var4) {
      return (Boolean)var1.getValue(POWERED) ? 15 : 0;
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

   public void onPlace(class_2680 var1, class_1937 var2, class_2338 var3, class_2680 var4, boolean var5) {
      if (!var2.isClientSide()) {
         var2.scheduleTick(var3, this, 5);
      }

   }

   public void tick(class_2680 var1, class_3218 var2, class_2338 var3, class_5819 var4) {
      class_2586 var5 = var2.getBlockEntity(var3);
      boolean var6 = false;
      class_1657 var7 = null;
      if (var5 instanceof OwnableBlockEntity var8) {
         class_238 var9 = (new class_238(var3)).inflate((double)3.0F);

         for(class_1657 var12 : var2.getEntitiesOfClass(class_1657.class, var9)) {
            if (var8.isOwnedBy(var12)) {
               var6 = true;
               var7 = var12;
               break;
            }
         }
      }

      if ((Boolean)var1.getValue(POWERED) != var6) {
         var2.setBlock(var3, (class_2680)var1.setValue(POWERED, var6), 3);
         var2.updateNeighborsAt(var3, this);
         if (var6 && var7 != null) {
            var2.playSound((class_1657)null, var3, class_3417.BEACON_ACTIVATE, class_3419.BLOCKS, 0.8F, 1.8F);
            var7.displayClientMessage(class_2561.literal("§8[§aRETINA: RECOGNIZED§8] §aBiometric Verification Confirmed: " + var7.getName().getString()), true);
         }
      }

      var2.scheduleTick(var3, this, 5);
   }

   static {
      POWERED = class_2741.field_12521;
   }
}
