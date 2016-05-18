package com.obsidiskrivemaskine.Proxy;

import com.obsidiskrivemaskine.GUI.ErrorBookGUIScreen;
import net.minecraft.client.Minecraft;
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

    @Override
    public void openErrorGUI() {
        Minecraft.getMinecraft().displayGuiScreen(new ErrorBookGUIScreen());
    }
}