package com.obsidiskrivemaskine.GUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by esben on 18/05/16.
 */

//This class is necessary to be able to open the ErrorBookGuiScreen, and as such this class serves no real purpose on it's own.
public class ErrorBookContainer extends Container {
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
