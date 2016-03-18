package com.P4;

import com.P4.init.ObsidiCodeItems;
import com.P4.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class ObsidiCodeMod {

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @instance
    public static ObsidiCodeMod reference = new ObsidiCodeMod();

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        ObsidiCodeItems.init();
        ObsidiCodeItems.register();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event)
    {
        proxy.registerRenders();
        proxy.init(event);
    }

    @Mod.EventHandler
    public  static  void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
