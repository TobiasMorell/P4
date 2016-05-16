package com.obsidiskrivemaskine;

import com.obsidiskrivemaskine.Entity.RobotEntity;
import com.obsidiskrivemaskine.block.ObsidiSkriveMaskineBlock;
import com.obsidiskrivemaskine.Handler.ObsidiGuiHandler;
import com.obsidiskrivemaskine.Proxy.ObsidiServerProxy;
import com.obsidiskrivemaskine.item.ErrorBook;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ObsidiSkriveMaskineMod.MODID, version = ObsidiSkriveMaskineMod.VERSION)
public class ObsidiSkriveMaskineMod
{
    public static final String MODID = "obsidiskrivemaskine";
    public static final String VERSION = "1.0";

    @Mod.Instance(MODID)
    public static ObsidiSkriveMaskineMod INSTANCE;

    public static Block obsidiblock;
    public static Item errorBook;

    @SidedProxy(clientSide = "com.obsidiskrivemaskine.Proxy.ObsidiClientProxy", serverSide = "com.obsidiskrivemaskine.Proxy.ObsidiServerProxy")
    public static ObsidiServerProxy PROXY;

    public static int obsidiguiid;

    @EventHandler
    public void preinit (FMLPreInitializationEvent event)
    {
        obsidiblock = new ObsidiSkriveMaskineBlock().setUnlocalizedName("ObsidiSkriveMaskineBlock").setCreativeTab(CreativeTabs.tabRedstone);
        errorBook = new ErrorBook();
        obsidiguiid = 1;
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        registerBlocks();
        registerItems();
        registerHandlers();
        RobotEntity.RegisterEntity();
    }

    @EventHandler
    public void postinit (FMLPostInitializationEvent event)
    {
        PROXY.registerModels();
    }

    public void registerBlocks ()
    {
        GameRegistry.registerBlock(obsidiblock, "ObsidiSkriveMaskineBlock");
    }
    public void registerItems () { GameRegistry.registerItem(errorBook, "Error_Book");}

    public void registerHandlers ()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new ObsidiGuiHandler());
    }
}
