package com.securityplus.init;

import com.securityplus.blockentity.KeypadBlockEntity;
import com.securityplus.blockentity.LockdownLeverBlockEntity;
import com.securityplus.blockentity.OwnableBlockEntity;
import com.securityplus.blockentity.SentryTurretBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<OwnableBlockEntity> OWNABLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("securityplus", "ownable_block_entity"),
            FabricBlockEntityTypeBuilder.create(OwnableBlockEntity::new, ModBlocks.REINFORCED_BLOCK).build()
    );

    public static final BlockEntityType<KeypadBlockEntity> KEYPAD_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("securityplus", "keypad_block_entity"),
            FabricBlockEntityTypeBuilder.create(KeypadBlockEntity::new, ModBlocks.KEYPAD_BLOCK).build()
    );

    public static final BlockEntityType<LockdownLeverBlockEntity> LOCKDOWN_LEVER_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("securityplus", "lockdown_lever_block_entity"),
            FabricBlockEntityTypeBuilder.create(LockdownLeverBlockEntity::new, ModBlocks.LOCKDOWN_LEVER_BLOCK).build()
    );

    public static final BlockEntityType<SentryTurretBlockEntity> SENTRY_TURRET_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("securityplus", "sentry_turret_block_entity"),
            FabricBlockEntityTypeBuilder.create(SentryTurretBlockEntity::new, ModBlocks.SENTRY_TURRET_BLOCK).build()
    );

    public static void registerBlockEntities() {}
}
