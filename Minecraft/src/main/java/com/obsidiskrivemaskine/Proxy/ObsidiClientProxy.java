package com.obsidiskrivemaskine.Proxy;

import com.obsidiskrivemaskine.Entity.RobotEntity;
import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by Lee on 06-04-2016.
 */
public class ObsidiClientProxy extends ObsidiServerProxy
{
    public void registerRenderThings() {
    }

    public void registerModels()
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(ObsidiSkriveMaskineMod.obsidiblock), 0,
                        new ModelResourceLocation(ObsidiSkriveMaskineMod.MODID + ":KurtSkriveMaskineBlock",
                                "inventory"));
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);

        //com.obsidiskrivemaskine.item.ItemRenderer.registerItemRenderer();
    }
}