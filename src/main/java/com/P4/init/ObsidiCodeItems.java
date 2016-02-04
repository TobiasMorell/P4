package com.P4.init;

import com.P4.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ObsidiCodeItems {
    public static Item codebook;

    public static void init()
    {
        codebook = new Item().setUnlocalizedName("codebook");
    }

    public static void register()
    {
        //.substring(5) removes the tile. appended by Minecraft engine
        GameRegistry.registerItem(codebook, codebook.getUnlocalizedName().substring(5));
    }

    public static void registerRenders()
    {
        registerRender(codebook);
    }

    private static void registerRender(Item i)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0,
                new ModelResourceLocation(Reference.MOD_ID + ":" + i.getUnlocalizedName().substring(5), "inventory"));
    }

    //Prevents initialization
    private ObsidiCodeItems()
    {}
}