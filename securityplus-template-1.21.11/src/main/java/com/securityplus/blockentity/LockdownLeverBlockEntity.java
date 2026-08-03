package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import com.securityplus.init.ModBlocks;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2499;
import net.minecraft.class_2503;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class LockdownLeverBlockEntity extends OwnableBlockEntity {
   private final List<class_2338> savedRedstonePositions = new ArrayList();

   public LockdownLeverBlockEntity(class_2338 var1, class_2680 var2) {
      super(ModBlockEntities.LOCKDOWN_LEVER_BLOCK_ENTITY, var1, var2);
   }

   public void triggerLockdownOn(class_1937 var1, class_2338 var2) {
      this.savedRedstonePositions.clear();
      byte var3 = 15;
      class_2248 var4 = (class_2248)class_7923.BLOCK.get(new class_2960("minecraft", "air"));

      for(int var5 = -var3; var5 <= var3; ++var5) {
         for(int var6 = -var3; var6 <= var3; ++var6) {
            for(int var7 = -var3; var7 <= var3; ++var7) {
               class_2338 var8 = var2.offset(var5, var6, var7);
               class_2680 var9 = var1.getBlockState(var8);
               if (var9.is(ModBlocks.DISRUPTABLE_REDSTONE)) {
                  this.savedRedstonePositions.add(var8);
                  var1.setBlock(var8, var4.defaultBlockState(), 3);
               }
            }
         }
      }

      this.setChanged();
   }

   public void triggerLockdownOff(class_1937 var1, class_2338 var2) {
      for(class_2338 var4 : this.savedRedstonePositions) {
         if (var1.getBlockState(var4).isAir()) {
            var1.setBlock(var4, ModBlocks.DISRUPTABLE_REDSTONE.defaultBlockState(), 3);
         }
      }

      this.savedRedstonePositions.clear();
      this.setChanged();
   }

   public void load(class_2487 var1) {
      super.load(var1);
      this.savedRedstonePositions.clear();
      if (var1.contains("SavedRedstone", 9)) {
         class_2499 var2 = var1.getList("SavedRedstone", 10);

         for(int var3 = 0; var3 < var2.size(); ++var3) {
            class_2487 var4 = var2.getCompound(var3);
            this.savedRedstonePositions.add(class_2503.readBlockPos(var4));
         }
      }

   }

   protected void saveAdditional(class_2487 var1) {
      super.saveAdditional(var1);
      class_2499 var2 = new class_2499();

      for(class_2338 var4 : this.savedRedstonePositions) {
         var2.add(class_2503.writeBlockPos(var4));
      }

      var1.put("SavedRedstone", var2);
   }
}
