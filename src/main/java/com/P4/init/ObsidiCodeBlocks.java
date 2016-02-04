package com.P4.init;

import com.P4.ObsidiBlock;
import com.P4.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Tobias Morell on 04-02-2016.
 */
public class ObsidiCodeBlocks {
    private  static Block codeblock;

    public static void init()
    {
        codeblock = new ObsidiBlock(Material.redstoneLight).setUnlocalizedName("codeblock");
    }

    public  static  void register()
    {
        GameRegistry.registerBlock(codeblock, codeblock.getUnlocalizedName().substring(5));
    }

    public static void registerRenders()
    {
        registerRender(codeblock);
    }

    private static void registerRender(Block b)
    {
        //Creates an inventory item from the block
        Item i = Item.getItemFromBlock(b);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0,
                new ModelResourceLocation(Reference.MOD_ID + ":" + i.getUnlocalizedName().substring(5), "inventory"));
    }
}
