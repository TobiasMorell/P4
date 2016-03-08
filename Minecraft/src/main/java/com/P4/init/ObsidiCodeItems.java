package com.P4.init;

import com.P4.ObsidiCodeItems.MagicWand;
import com.P4.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ObsidiCodeItems {
    public static Item codebook;
    public static Item magicwand;
    public static Item.ToolMaterial MagicMaterial = EnumHelper.addToolMaterial("MagicMaterial", 3, 1, 12f, 7f, 30);
    //.addToolMaterial(name, harvest lvl, durability, mining speed, dmg, enchantability)

    public static void init ()
    {
        codebook = new Item().setUnlocalizedName("CodeBook");
        magicwand = new MagicWand(MagicMaterial);
    }

    public  static void register()
    {
        GameRegistry.registerItem(codebook, codebook.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(magicwand, magicwand.getUnlocalizedName().substring(5));
    }

    public static void registerRenders()
    {
        registerRender(codebook);
        registerRender(magicwand);
    }

    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
