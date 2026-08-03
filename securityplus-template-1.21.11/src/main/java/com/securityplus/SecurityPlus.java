package com.securityplus;

import com.securityplus.init.ModBlockEntities;
import com.securityplus.init.ModBlocks;
import com.securityplus.init.ModCreativeTabs;
import com.securityplus.init.ModItems;
import net.fabricmc.api.ModInitializer;

public class SecurityPlus implements ModInitializer {
   public static final String MODID = "securityplus";

   public void onInitialize() {
      ModBlocks.registerModBlocks();
      ModItems.registerModItems();
      ModBlockEntities.registerBlockEntities();
      ModCreativeTabs.registerCreativeTabs();
   }
}
