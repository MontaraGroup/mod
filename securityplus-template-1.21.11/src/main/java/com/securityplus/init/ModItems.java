package com.securityplus.init;

import com.securityplus.items.CodebreakerItem;
import com.securityplus.items.UniversalBlockRemoverItem;
import com.securityplus.items.UniversalOwnerChangerItem;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class ModItems {
   public static final class_1792 UNIVERSAL_BLOCK_REMOVER = register("universal_block_remover", new UniversalBlockRemoverItem((new class_1792.class_1793()).method_7892(1)));
   public static final class_1792 UNIVERSAL_OWNER_CHANGER = register("universal_owner_changer", new UniversalOwnerChangerItem((new class_1792.class_1793()).method_7892(1)));
   public static final class_1792 CODEBREAKER = register("codebreaker", new CodebreakerItem((new class_1792.class_1793()).method_7889(5)));
   public static final class_1792 SENTRY_TURRET;
   public static final class_1792 DISRUPTABLE_REDSTONE;
   public static final class_1792 LOCKDOWN_LEVER;
   public static final class_1792 PANIC_BUTTON;
   public static final class_1792 LOCKDOWN_DOOR;
   public static final class_1792 LOCKDOWN_SHUTTER;
   public static final class_1792 LOCKDOWN_WALL;
   public static final class_1792 MOTION_SENSOR;
   public static final class_1792 ELECTRIC_FENCE;
   public static final class_1792 ALARM_SIREN;
   public static final class_1792 LASER_GRID;
   public static final class_1792 SPIKE_TRAP;
   public static final class_1792 KEYPAD;
   public static final class_1792 RETINAL_SCANNER;
   public static final class_1792 REINFORCED_STONE;
   public static final class_1792 REINFORCED_OBSIDIAN;
   public static final class_1792 REINFORCED_IRON_BARS;

   private static class_1792 register(String var0, class_1792 var1) {
      return (class_1792)class_2378.register(class_7923.ITEM, new class_2960("securityplus", var0), var1);
   }

   public static void registerModItems() {
   }

   static {
      SENTRY_TURRET = register("sentry_turret", new class_1747(ModBlocks.SENTRY_TURRET, new class_1792.class_1793()));
      DISRUPTABLE_REDSTONE = register("disruptable_redstone", new class_1747(ModBlocks.DISRUPTABLE_REDSTONE, new class_1792.class_1793()));
      LOCKDOWN_LEVER = register("lockdown_lever", new class_1747(ModBlocks.LOCKDOWN_LEVER, new class_1792.class_1793()));
      PANIC_BUTTON = register("panic_button", new class_1747(ModBlocks.PANIC_BUTTON, new class_1792.class_1793()));
      LOCKDOWN_DOOR = register("lockdown_door", new class_1747(ModBlocks.LOCKDOWN_DOOR, new class_1792.class_1793()));
      LOCKDOWN_SHUTTER = register("lockdown_shutter", new class_1747(ModBlocks.LOCKDOWN_SHUTTER, new class_1792.class_1793()));
      LOCKDOWN_WALL = register("lockdown_wall", new class_1747(ModBlocks.LOCKDOWN_WALL, new class_1792.class_1793()));
      MOTION_SENSOR = register("motion_sensor", new class_1747(ModBlocks.MOTION_SENSOR, new class_1792.class_1793()));
      ELECTRIC_FENCE = register("electric_fence", new class_1747(ModBlocks.ELECTRIC_FENCE, new class_1792.class_1793()));
      ALARM_SIREN = register("alarm_siren", new class_1747(ModBlocks.ALARM_SIREN, new class_1792.class_1793()));
      LASER_GRID = register("laser_grid", new class_1747(ModBlocks.LASER_GRID, new class_1792.class_1793()));
      SPIKE_TRAP = register("spike_trap", new class_1747(ModBlocks.SPIKE_TRAP, new class_1792.class_1793()));
      KEYPAD = register("keypad", new class_1747(ModBlocks.KEYPAD, new class_1792.class_1793()));
      RETINAL_SCANNER = register("retinal_scanner", new class_1747(ModBlocks.RETINAL_SCANNER, new class_1792.class_1793()));
      REINFORCED_STONE = register("reinforced_stone", new class_1747(ModBlocks.REINFORCED_STONE, new class_1792.class_1793()));
      REINFORCED_OBSIDIAN = register("reinforced_obsidian", new class_1747(ModBlocks.REINFORCED_OBSIDIAN, new class_1792.class_1793()));
      REINFORCED_IRON_BARS = register("reinforced_iron_bars", new class_1747(ModBlocks.REINFORCED_IRON_BARS, new class_1792.class_1793()));
   }
}
