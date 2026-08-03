package com.securityplus.client;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import java.lang.reflect.Proxy;
import net.minecraft.class_437;

public class ModMenuIntegration implements ModMenuApi {
   public ConfigScreenFactory<?> getModConfigScreenFactory() {
      return (ConfigScreenFactory)Proxy.newProxyInstance(ModMenuApi.class.getClassLoader(), new Class[]{ConfigScreenFactory.class}, (var0, var1, var2) -> "create".equals(var1.getName()) && var2 != null && var2.length == 1 ? new SecurityConfigScreen((class_437)var2[0]) : null);
   }
}
