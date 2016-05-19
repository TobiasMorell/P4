package com.obsidiskrivemaskine.Proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by Lee on 06-04-2016.
 */
public class ObsidiClientProxy extends ObsidiServerProxy
{
    public void registerModels()
    {
        com.obsidiskrivemaskine.block.BlockRenderer.registerBlockRenderer();
        com.obsidiskrivemaskine.item.ItemRenderer.registerItemRenderer();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }
}