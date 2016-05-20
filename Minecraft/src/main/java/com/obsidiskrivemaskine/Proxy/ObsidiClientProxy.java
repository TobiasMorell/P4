package com.obsidiskrivemaskine.Proxy;

import com.obsidiskrivemaskine.Entity.RobotEntity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
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
    public void preInit() {

    }
}