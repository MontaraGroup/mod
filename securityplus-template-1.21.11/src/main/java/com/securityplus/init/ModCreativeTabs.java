package com.securityplus.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTabs {

    public static final RegistryKey<ItemGroup> SECURITYPLUS_TAB_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            Identifier.of("securityplus", "securityplus_tab")
    );

    public static final ItemGroup SECURITYPLUS_TAB = Registry.register(
            Registries.ITEM_GROUP,
            SECURITYPLUS_TAB_KEY,
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.KEYCARD))
                    .displayName(Text.translatable("itemGroup.securityplus.securityplus_tab"))
                    .entries((displayContext, entries) -> {
                        // Add items directly from ModItems
                        entries.add(ModItems.KEYCARD);
                        entries.add(ModItems.KEYCARD_HOLDER);

                        // Add registered BlockItems
                        entries.add(ModItems.REINFORCED_BLOCK);
                        entries.add(ModItems.KEYPAD_BLOCK);
                        entries.add(ModItems.LOCKDOWN_LEVER_BLOCK);
                        entries.add(ModItems.SENTRY_TURRET_BLOCK);
                        entries.add(ModItems.LOCKDOWN_DOOR);
                        entries.add(ModItems.ALARM_SIREN);
                        entries.add(ModItems.LASER_GRID);
                        entries.add(ModItems.RETINAL_SCANNER);
                        entries.add(ModItems.MOTION_SENSOR);
                        entries.add(ModItems.ELECTRIC_FENCE);
                        entries.add(ModItems.LOCKDOWN_WALL);
                        entries.add(ModItems.LOCKDOWN_SHUTTER);
                        entries.add(ModItems.PANIC_BUTTON);
                    })
                    .build()
    );

    public static void registerCreativeTabs() {}
}
