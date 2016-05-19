package com.obsidiskrivemaskine.block;

import com.obsidiskrivemaskine.AbstractRobot;
import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
import com.obsidiskrivemaskine.SyncRobot;
import com.obsidiskrivemaskine.item.ErrorBook;
import compiler.CodeGeneration.Signal;
import compiler.Utility.ErrorHandling;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.PositionImpl;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 06-04-2016.
 */
public class ObsidiCodingMachine extends Block
{
    public static List<SyncRobot> RobotList = new ArrayList<SyncRobot>();
    private static BlockPos pos;
    private static World world;

    public ObsidiCodingMachine() {
        super(Material.rock);
        this.setUnlocalizedName("ObsidiCodingMachine");
        setCreativeTab(CreativeTabs.tabMisc);
    }

    public static void receiveSignal(Signal si){
        if(RobotList != null) {
            for (SyncRobot robot : RobotList) {
                robot.Signal(si);
            }
        }
    }


    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state) {
        float f = 0.125F;
        return new AxisAlignedBB((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)(pos.getX() + 1),
                (double)((float)(pos.getY() + 1) - f), (double)(pos.getZ() + 1));
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        entity.motionX *= 2.3D;
        entity.motionY *= 2.3D;
    }

    public static void dropErrorLog(ErrorBook errorBook)
    {
        IPosition position = new PositionImpl(pos.getX(), pos.getY(), pos.getZ());
        ErrorBook.errors = (ArrayList<String>)ErrorHandling.GetErrors().clone();
        if(!Minecraft.getMinecraft().thePlayer.inventory.hasItemStack(new ItemStack(errorBook)))
            BehaviorProjectileDispense.doDispense(world, new ItemStack(errorBook), 1, EnumFacing.NORTH, position);
        AbstractRobot.talk("Compilation failed, check provided error log");
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side,
                                    float hitX, float hitY, float hitZ) {
        player.openGui(ObsidiSkriveMaskineMod.INSTANCE, ObsidiSkriveMaskineMod.obsidiguiid, world, pos.getX(), pos.getY(), pos.getZ());
        this.pos = pos;
        this.world = world;
        SyncRobot.init(world, player);
        return super.onBlockActivated(world, pos, state, player, side, hitX, hitY, hitZ);
    }
}
