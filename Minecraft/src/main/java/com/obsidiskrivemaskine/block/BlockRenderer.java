package com.obsidiskrivemaskine.block;

import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
import com.obsidiskrivemaskine.item.ItemRenderer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * Created by morell on 5/16/16.
 */
public class BlockRenderer {
    public static void registerBlockRenderer()
    {
        registerBlockRenderer(ObsidiSkriveMaskineMod.ObsidiCodingMachine);
    }

    private static void registerBlockRenderer(Block b)
    {
        Item item = Item.getItemFromBlock(b);
        ItemRenderer.registerItem(item);
    }
}
