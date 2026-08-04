package com.securityplus.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTabs {
    public static final ItemGroup SECURITY_PLUS_TAB = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of("securityplus", "security_tab"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.securityplus.security_tab"))
                    .icon(() -> new ItemStack(ModBlocks.KEYPAD_BLOCK))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.KEYPAD_BLOCK);
                        entries.add(ModBlocks.REINFORCED_BLOCK);
                        entries.add(ModBlocks.LOCKDOWN_LEVER_BLOCK);
                        entries.add(ModBlocks.SENTRY_TURRET_BLOCK);
                        entries.add(ModBlocks.LOCKDOWN_DOOR);
                        entries.add(ModBlocks.ALARM_SIREN);
                        entries.add(ModBlocks.LASER_GRID);
                        entries.add(ModBlocks.RETINAL_SCANNER);
                        entries.add(ModBlocks.MOTION_SENSOR);
                        entries.add(ModBlocks.ELECTRIC_FENCE);
                        entries.add(ModBlocks.LOCKDOWN_WALL);
                        entries.add(ModBlocks.LOCKDOWN_SHUTTER);
                        entries.add(ModBlocks.PANIC_BUTTON);
                    })
                    .build()
    );

    public static void registerCreativeTabs() {}
}
