package com.obsidiskrivemaskine.item;

import com.obsidiskrivemaskine.GUI.ErrorBookGUIScreen;
import com.obsidiskrivemaskine.Handler.ObsidiGuiHandler;
import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
import com.obsidiskrivemaskine.block.ObsidiCodingMachine;
import compiler.Utility.ErrorHandling;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;

/**
 * Created by morell on 5/16/16.
 */
public class ErrorBook extends ItemBook implements Cloneable{
    public static ArrayList<String> errors = new ArrayList<String>();
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

    //Sets the errorlog and attempst to open the gui.
    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if(!worldIn.isRemote)
        {
            ErrorBookGUIScreen.errorLog = this;
            playerIn.openGui(ObsidiSkriveMaskineMod.INSTANCE, ObsidiSkriveMaskineMod.errorguiid, worldIn, 0, 0, 0);
        }
        return itemStackIn;
    }

    //Allows ErrorBook to be cloned.
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
