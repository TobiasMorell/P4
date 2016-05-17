package com.obsidiskrivemaskine.item;

import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
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

        this.setMaxStackSize(1);
        this.setUnlocalizedName("error_book");
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return "Error Book";
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if(!worldIn.isRemote)
        {
            ObsidiSkriveMaskineMod.PROXY.openErrorGUI();
        }

        return itemStackIn;
    }
}
