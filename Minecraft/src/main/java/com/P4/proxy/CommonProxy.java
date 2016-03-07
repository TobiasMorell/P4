package com.P4.proxy;

import com.P4.Crafting;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void registerRenders()
    {

    }

    public void preInit(FMLPreInitializationEvent e)
    {

    }

    public void init(FMLInitializationEvent e)
    {
        Crafting.initCrafting();
    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }
}
