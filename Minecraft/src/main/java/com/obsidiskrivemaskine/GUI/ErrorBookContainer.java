package com.obsidiskrivemaskine.GUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by esben on 18/05/16.
 */
public class ErrorBookContainer extends Container {
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
