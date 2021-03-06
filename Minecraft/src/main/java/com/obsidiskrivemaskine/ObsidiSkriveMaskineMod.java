package com.obsidiskrivemaskine;

import com.obsidiskrivemaskine.Entity.RobotEntity;
import com.obsidiskrivemaskine.block.ObsidiCodingMachine;
import com.obsidiskrivemaskine.Handler.ObsidiGuiHandler;
import com.obsidiskrivemaskine.Proxy.ObsidiServerProxy;
import com.obsidiskrivemaskine.item.ErrorBook;
import compiler.Utility.Coord;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

import java.lang.instrument.Instrumentation;

@Mod(modid = ObsidiSkriveMaskineMod.MODID, version = ObsidiSkriveMaskineMod.VERSION)
public class ObsidiSkriveMaskineMod
{
    public static final String MODID = "obsidiskrivemaskine";
    public static final String VERSION = "1.0";

    @Mod.Instance(MODID)
    public static ObsidiSkriveMaskineMod INSTANCE;

    public static Block ObsidiCodingMachine;
    public static Item error_book;

    @SidedProxy(clientSide = "com.obsidiskrivemaskine.Proxy.ObsidiClientProxy", serverSide = "com.obsidiskrivemaskine.Proxy.ObsidiServerProxy")
    public static ObsidiServerProxy PROXY;

    public static int obsidiguiid, errorguiid;

    //Makes it possible to obtain clones of the ErrorBook
    public static ErrorBook errorBook(){
        ErrorBook tempBook = (ErrorBook)error_book;
        try {
            return (ErrorBook)tempBook.clone();
        } catch (CloneNotSupportedException e){
            System.out.println("Unable to clone Error Book");
            return null;
        }
    }

    @EventHandler
    public void preinit (FMLPreInitializationEvent event)
    {
        //Instantiate blocks and items
        ObsidiCodingMachine = new ObsidiCodingMachine();
        error_book = new ErrorBook();
        obsidiguiid = 1;
        errorguiid = 2;

        //Register to the game - makes them appear in game
        registerBlocks();
        registerItems();
        RobotEntity.RegisterEntity();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        registerHandlers();

        LanguageRegistry.instance().addStringLocalization("tile.ObsidiCodingMachine.name", "en_US", "Obsidi Coding Machine");

        //Register the models - gives texture and models to items and blocks
        PROXY.registerModels();
    }

    @EventHandler
    public void postinit (FMLPostInitializationEvent event)
    {

    }

    public static void registerBlocks ()
    {
        GameRegistry.registerBlock(ObsidiCodingMachine, ObsidiCodingMachine.getUnlocalizedName().substring(5));
    }
    public static void registerItems () { GameRegistry.registerItem(error_book, error_book.getUnlocalizedName().substring(5));}

    public static void registerHandlers ()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new ObsidiGuiHandler());
    }
}
