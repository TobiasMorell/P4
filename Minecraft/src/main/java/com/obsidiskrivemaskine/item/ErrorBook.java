package com.obsidiskrivemaskine.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by morell on 5/16/16.
 */
public class ErrorBook extends ItemBook {
    public ErrorBook ()
    {
        super();

        this.setUnlocalizedName("Error_Book");
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
}
