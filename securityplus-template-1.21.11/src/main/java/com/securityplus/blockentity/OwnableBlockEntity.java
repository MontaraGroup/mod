package com.securityplus.blockentity;

import com.securityplus.init.ModBlockEntities;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;

public class OwnableBlockEntity extends class_2586 {
   private String ownerUUID = "";
   private String ownerName = "";

   public OwnableBlockEntity(class_2338 var1, class_2680 var2) {
      super(ModBlockEntities.OWNABLE_BLOCK_ENTITY, var1, var2);
   }

   public OwnableBlockEntity(class_2591<?> var1, class_2338 var2, class_2680 var3) {
      super(var1, var2, var3);
   }

   public void setOwner(String var1, String var2) {
      this.ownerUUID = var1 != null ? var1 : "";
      this.ownerName = var2 != null ? var2 : "";
      this.setChanged();
   }

   public String getOwnerUUID() {
      return this.ownerUUID;
   }

   public String getOwnerName() {
      return this.ownerName;
   }

   public boolean isOwnedBy(class_1657 var1) {
      return this.ownerUUID.isEmpty() ? true : var1.getUUID().toString().equals(this.ownerUUID);
   }

   public void load(class_2487 var1) {
      super.load(var1);
      if (var1.contains("OwnerUUID")) {
         this.ownerUUID = var1.getString("OwnerUUID");
      }

      if (var1.contains("OwnerName")) {
         this.ownerName = var1.getString("OwnerName");
      }

   }

   protected void saveAdditional(class_2487 var1) {
      super.saveAdditional(var1);
      var1.putString("OwnerUUID", this.ownerUUID);
      var1.putString("OwnerName", this.ownerName);
   }
}
