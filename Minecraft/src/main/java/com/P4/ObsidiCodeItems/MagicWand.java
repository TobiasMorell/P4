package com.P4.ObsidiCodeItems;

import com.P4.Utility.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemSword;

/**
 * Created by Nete on 16-02-2016.
 */
public class MagicWand extends ItemSword {
    //BlockLoader bl;
    //C:\Users\Nete\Documents\Forge\classes\production\Forge\com\P4\ObisiCodeBlocks/TestBlock.class
    public MagicWand (Item.ToolMaterial tm)
    {
        super(tm);
        this.setUnlocalizedName("MagicWand");
        this.setCreativeTab(CreativeTabs.tabTools);
        //bl = new BlockLoader("C:\\Users\\Nete\\Documents\\Forge\\classes\\production\\Forge\\com\\P4\\ObisiCodeBlocks\\TestBlock.class");
    }


    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        //world.destroyBlock(pos, false);
        //Block newBlock = bl.getBlock();
        MovingObjectPosition ent_pos = getMovingObjectPositionFromPlayer(world, player, false);

        if(ent_pos != null && ent_pos.entityHit != null)
        {
            EntityLiving el = (EntityLiving) ent_pos.entityHit;
            el.onLivingUpdate();
        }
        return false;

    }
}
