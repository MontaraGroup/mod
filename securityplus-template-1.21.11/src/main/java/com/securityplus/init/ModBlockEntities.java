package com.securityplus.init;

import com.securityplus.blockentity.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<OwnableBlockEntity> OWNABLE_BLOCK_ENTITY;
    public static BlockEntityType<KeypadBlockEntity> KEYPAD_BLOCK_ENTITY;
    public static BlockEntityType<LockdownLeverBlockEntity> LOCKDOWN_LEVER_BLOCK_ENTITY;
    public static BlockEntityType<SentryTurretBlockEntity> SENTRY_TURRET_BLOCK_ENTITY;

    public static void registerBlockEntities() {
        OWNABLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("securityplus", "ownable"),
            FabricBlockEntityTypeBuilder.create(OwnableBlockEntity::new, ModBlocks.REINFORCED_BLOCK).build()
        );

        KEYPAD_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("securityplus", "keypad"),
            FabricBlockEntityTypeBuilder.create(KeypadBlockEntity::new, ModBlocks.KEYPAD_BLOCK).build()
        );

        LOCKDOWN_LEVER_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("securityplus", "lockdown_lever"),
            FabricBlockEntityTypeBuilder.create(LockdownLeverBlockEntity::new, ModBlocks.LOCKDOWN_LEVER_BLOCK).build()
        );

        SENTRY_TURRET_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("securityplus", "sentry_turret"),
            FabricBlockEntityTypeBuilder.create(SentryTurretBlockEntity::new, ModBlocks.SENTRY_TURRET_BLOCK).build()
        );
    }
}
