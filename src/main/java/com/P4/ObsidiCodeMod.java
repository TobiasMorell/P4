package com.P4;

import com.P4.init.ObsidiCodeBlocks;
import com.P4.init.ObsidiCodeItems;
import com.P4.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class ObsidiCodeMod {

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ObsidiCodeBlocks.init();
        ObsidiCodeBlocks.register();
        ObsidiCodeItems.init();
        ObsidiCodeItems.register();
    }

    @EventHandler
    public void init (FMLInitializationEvent event)
    {
        proxy.registerRenders();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}