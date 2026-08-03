package com.securityplus.init;

import com.securityplus.blockentity.KeypadBlockEntity;
import com.securityplus.blockentity.LockdownLeverBlockEntity;
import com.securityplus.blockentity.OwnableBlockEntity;
import com.securityplus.blockentity.SentryTurretBlockEntity;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2591;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class ModBlockEntities {
   public static final class_2591<OwnableBlockEntity> OWNABLE_BLOCK_ENTITY;
   public static final class_2591<KeypadBlockEntity> KEYPAD_BLOCK_ENTITY;
   public static final class_2591<LockdownLeverBlockEntity> LOCKDOWN_LEVER_BLOCK_ENTITY;
   public static final class_2591<SentryTurretBlockEntity> SENTRY_TURRET_BLOCK_ENTITY;

   public static void registerBlockEntities() {
   }

   static {
      OWNABLE_BLOCK_ENTITY = (class_2591)class_2378.register(class_7923.BLOCK_ENTITY_TYPE, new class_2960("securityplus", "ownable_be"), class_2591.create(OwnableBlockEntity::new, new class_2248[]{ModBlocks.REINFORCED_STONE, ModBlocks.REINFORCED_OBSIDIAN, ModBlocks.REINFORCED_IRON_BARS, ModBlocks.RETINAL_SCANNER}));
      KEYPAD_BLOCK_ENTITY = (class_2591)class_2378.register(class_7923.BLOCK_ENTITY_TYPE, new class_2960("securityplus", "keypad_be"), class_2591.create(KeypadBlockEntity::new, new class_2248[]{ModBlocks.KEYPAD}));
      LOCKDOWN_LEVER_BLOCK_ENTITY = (class_2591)class_2378.register(class_7923.BLOCK_ENTITY_TYPE, new class_2960("securityplus", "lockdown_lever_be"), class_2591.create(LockdownLeverBlockEntity::new, new class_2248[]{ModBlocks.LOCKDOWN_LEVER}));
      SENTRY_TURRET_BLOCK_ENTITY = (class_2591)class_2378.register(class_7923.BLOCK_ENTITY_TYPE, new class_2960("securityplus", "sentry_turret_be"), class_2591.create(SentryTurretBlockEntity::new, new class_2248[]{ModBlocks.SENTRY_TURRET}));
   }
}
