package com.P4;

import com.P4.ObsidiCodeItems.MagicWand;
import com.P4.init.ObsidiCodeItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Nete on 22-02-2016.
 */
public class Crafting {

    public static void initCrafting()
    {
        GameRegistry.addRecipe(new ItemStack(ObsidiCodeItems.magicwand), " # ", " I ",
                " I ", '#', Items.glowstone_dust, 'I', Items.stick);
        GameRegistry.addRecipe(new ItemStack(ObsidiCodeItems.codebook),
                Items.paper, Items.paper, Items.paper, Items.glowstone_dust);

        //GameRegistry.addSmelting(Items.item, new ItemStack(Items.item), 1.0F);
        //1.0F is for diamond
        //0.7F is for iron
        //0.35F is for beef
    }
}
