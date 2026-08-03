package com.securityplus.init;

import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_2378;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_7923;
import net.minecraft.class_1761.class_7916;

public class ModCreativeTabs {
   public static final class_1761 SECURITYPLUS_TAB;

   public static void registerCreativeTabs() {
   }

   static {
      SECURITYPLUS_TAB = (class_1761)class_2378.register(class_7923.CREATIVE_MODE_TAB, new class_2960("securityplus", "securityplus_tab"), class_1761.builder(class_7916.TOP, 0).title(class_2561.translatable("itemGroup.securityplus")).icon(() -> new class_1799(ModItems.SENTRY_TURRET)).displayItems((var0, var1) -> {
         var1.accept(ModItems.SENTRY_TURRET);
         var1.accept(ModItems.DISRUPTABLE_REDSTONE);
         var1.accept(ModItems.LOCKDOWN_LEVER);
         var1.accept(ModItems.PANIC_BUTTON);
         var1.accept(ModItems.LOCKDOWN_DOOR);
         var1.accept(ModItems.LOCKDOWN_SHUTTER);
         var1.accept(ModItems.LOCKDOWN_WALL);
         var1.accept(ModItems.UNIVERSAL_BLOCK_REMOVER);
         var1.accept(ModItems.UNIVERSAL_OWNER_CHANGER);
         var1.accept(ModItems.CODEBREAKER);
         var1.accept(ModItems.KEYPAD);
         var1.accept(ModItems.RETINAL_SCANNER);
         var1.accept(ModItems.MOTION_SENSOR);
         var1.accept(ModItems.ELECTRIC_FENCE);
         var1.accept(ModItems.ALARM_SIREN);
         var1.accept(ModItems.LASER_GRID);
         var1.accept(ModItems.SPIKE_TRAP);
         var1.accept(ModItems.REINFORCED_STONE);
         var1.accept(ModItems.REINFORCED_OBSIDIAN);
         var1.accept(ModItems.REINFORCED_IRON_BARS);
      }).build());
   }
}
