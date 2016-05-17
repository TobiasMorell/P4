package com.obsidiskrivemaskine.block;

import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
import com.obsidiskrivemaskine.SyncRobot;
import compiler.CodeGeneration.Signal;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 06-04-2016.
 */
public class ObsidiCodingMachine extends Block
{
    public static List<SyncRobot> RobotList = new ArrayList<SyncRobot>();
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

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side,
                                    float hitX, float hitY, float hitZ) {
        player.openGui(ObsidiSkriveMaskineMod.INSTANCE, ObsidiSkriveMaskineMod.obsidiguiid, world, pos.getX(), pos.getY(), pos.getZ());
        SyncRobot.init(world, player);
        return super.onBlockActivated(world, pos, state, player, side, hitX, hitY, hitZ);
    }
}
