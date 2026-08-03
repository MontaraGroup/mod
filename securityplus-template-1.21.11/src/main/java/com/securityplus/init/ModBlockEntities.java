package com.securityplus.init;

import com.securityplus.blockentity.KeypadBlockEntity;
import com.securityplus.blockentity.LockdownLeverBlockEntity;
import com.securityplus.blockentity.OwnableBlockEntity;
import com.securityplus.blockentity.SentryTurretBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<OwnableBlockEntity> OWNABLE_BLOCK_ENTITY = register(
            "ownable_block_entity",
            BlockEntityType.Builder.create(
                    OwnableBlockEntity::new,
                    ModBlocks.REINFORCED_STONE,
                    ModBlocks.REINFORCED_OBSIDIAN,
                    ModBlocks.REINFORCED_IRON_BARS
            ).build()
    );

    public static final BlockEntityType<KeypadBlockEntity> KEYPAD_BLOCK_ENTITY = register(
            "keypad_block_entity",
            BlockEntityType.Builder.create(
                    KeypadBlockEntity::new,
                    ModBlocks.KEYPAD
            ).build()
    );

    public static final BlockEntityType<LockdownLeverBlockEntity> LOCKDOWN_LEVER_BLOCK_ENTITY = register(
            "lockdown_lever_block_entity",
            BlockEntityType.Builder.create(
                    LockdownLeverBlockEntity::new,
                    ModBlocks.LOCKDOWN_LEVER
            ).build()
    );

    public static final BlockEntityType<SentryTurretBlockEntity> SENTRY_TURRET_BLOCK_ENTITY = register(
            "sentry_turret_block_entity",
            BlockEntityType.Builder.create(
                    SentryTurretBlockEntity::new,
                    ModBlocks.SENTRY_TURRET
            ).build()
    );

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("securityplus", name), type);
    }

    public static void registerModBlockEntities() {
        // Triggers static initialization
    }
}
