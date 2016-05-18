package com.obsidiskrivemaskine.Handler;

import com.obsidiskrivemaskine.GUI.ErrorBookContainer;
import com.obsidiskrivemaskine.GUI.ErrorBookGUIScreen;
import com.obsidiskrivemaskine.GUI.ObsidiGUIScreen;
import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by Lee on 06-04-2016.
 */
public class ObsidiGuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == ObsidiSkriveMaskineMod.errorguiid){
            return new ErrorBookContainer();
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == ObsidiSkriveMaskineMod.obsidiguiid) {
            return new ObsidiGUIScreen();
        }
        if(ID == ObsidiSkriveMaskineMod.errorguiid){
            return new ErrorBookGUIScreen();
        }

        return null;
    }

}
