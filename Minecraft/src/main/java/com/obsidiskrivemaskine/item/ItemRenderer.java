package com.obsidiskrivemaskine.item;

import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by morell on 5/16/16.
 */
public class ItemRenderer {
    public static void registerItemRenderer() {
        registerItem(ObsidiSkriveMaskineMod.errorBook);
    }

    private static void registerItem(Item i)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0,
                new ModelResourceLocation(ObsidiSkriveMaskineMod.MODID + ":" + i.getUnlocalizedName().substring(5),
                        "inventory"));
    }
}
