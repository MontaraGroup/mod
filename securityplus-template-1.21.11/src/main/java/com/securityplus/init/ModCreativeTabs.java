package com.securityplus.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTabs {

    public static final ItemGroup SECURITYPLUS_TAB = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of("securityplus", "securityplus_tab"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.KEYPAD))
                    .displayName(Text.translatable("itemGroup.securityplus.securityplus_tab"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.UNIVERSAL_BLOCK_REMOVER);
                        entries.add(ModItems.UNIVERSAL_OWNER_CHANGER);
                        entries.add(ModItems.CODEBREAKER);
                        entries.add(ModBlocks.SENTRY_TURRET);
                        entries.add(ModBlocks.DISRUPTABLE_REDSTONE);
                        entries.add(ModBlocks.MOTION_SENSOR);
                        entries.add(ModBlocks.ELECTRIC_FENCE);
                        entries.add(ModBlocks.ALARM_SIREN);
                        entries.add(ModBlocks.LASER_GRID);
                        entries.add(ModBlocks.SPIKE_TRAP);
                        entries.add(ModBlocks.KEYPAD);
                        entries.add(ModBlocks.RETINAL_SCANNER);
                        entries.add(ModBlocks.LOCKDOWN_LEVER);
                        entries.add(ModBlocks.PANIC_BUTTON);
                        entries.add(ModBlocks.LOCKDOWN_DOOR);
                        entries.add(ModBlocks.LOCKDOWN_SHUTTER);
                        entries.add(ModBlocks.LOCKDOWN_WALL);
                        entries.add(ModBlocks.REINFORCED_STONE);
                        entries.add(ModBlocks.REINFORCED_OBSIDIAN);
                        entries.add(ModBlocks.REINFORCED_IRON_BARS);
                    })
                    .build()
    );

    public static void registerModCreativeTabs() {
        // Triggers static initialization
    }
}
