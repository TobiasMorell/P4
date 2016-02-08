package com.P4.init;

import com.P4.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ObsidiCodeItems {
    private static Item codebook;

    public static void init ()
    {
        codebook = new Item().setUnlocalizedName("CodeBook");
    }

    public  static void register()
    {
        GameRegistry.registerItem(codebook, codebook.getUnlocalizedName().substring(5));
    }

    public static void registerRenders()
    {
        registerRender(codebook);
    }

    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
