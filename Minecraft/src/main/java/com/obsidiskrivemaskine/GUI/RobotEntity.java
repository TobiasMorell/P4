package com.obsidiskrivemaskine.GUI;

import com.obsidiskrivemaskine.AbstractRobot;
import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
import com.obsidiskrivemaskine.Utils;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.ArrayList;
import java.util.List;

public class RobotEntity extends EntityAgeable
{
    ItemStack[] Inventory;
    ArrayList<EntityLivingBase> entities;
    public RobotEntity(World worldIn)
    {
        super(worldIn);
        this.Inventory = new ItemStack[15];
        this.setSize(0.9F, 1.3F);
        this.setCanPickUpLoot(true);
    }

    public static void RegisterEntity(){
        EntityRegistry.registerModEntity(RobotEntity.class, "RobotEntity", 255, ObsidiSkriveMaskineMod.INSTANCE, 64, 20, true);
        EntityRegistry.registerEgg(RobotEntity.class, Utils.ColorFromRGB(137, 91, 0), Utils.ColorFromRGB(88, 62, 0));
    }

    @Override
    public void onEntityUpdate(){
        super.onEntityUpdate();
        if(ticksExisted % 5 == 0 || ticksExisted < 5) {
            AxisAlignedBB scanArea = new AxisAlignedBB(posX - 10, posY - 10, posZ - 10, posX + 10, posY + 10, posZ + 10);

            entities = (ArrayList) worldObj.getEntitiesWithinAABB(EntityLivingBase.class, scanArea);
        }
    }

    public ArrayList<EntityLivingBase> getHostileEntities() {
        onEntityUpdate();
        ArrayList<EntityLivingBase> hostileMobs = new ArrayList<EntityLivingBase>();
        for(EntityLivingBase ei : entities) {
            if(ei instanceof EntityMob)
                hostileMobs.add(ei);
        }
        return hostileMobs;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn){
        float f = 1;
        if(getHeldItem().getItem() instanceof ItemSword){
            ItemSword weapon = (ItemSword)getHeldItem().getItem();
            f = weapon.getDamageVsEntity();
        }
        int i = 0;
        this.onUpdate();
        if (entityIn instanceof EntityLivingBase)
        {
            f += EnchantmentHelper.func_152377_a(this.getHeldItem(), ((EntityLivingBase)entityIn).getCreatureAttribute());
            i += EnchantmentHelper.getKnockbackModifier(this);
        }

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag)
        {
            if (i > 0)
            {
                entityIn.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if (j > 0)
            {
                entityIn.setFire(j * 4);
            }

            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityIn){}

    @Override
    public void applyEntityCollision(Entity entityIn){}

    public void breakBlock(BlockPos blockpos, Block blockToBreak){
        blockToBreak.breakBlock(worldObj, blockpos, blockToBreak.getDefaultState());
    }

    public boolean addItemToInventory(ItemStack item){
        if(item != null) {
            int i = 0;
            do {
                if (Inventory[i] == null) {
                    Inventory[i] = item;
                    return true;
                }
            } while (Inventory[i++] != null && i < Inventory.length);
        }
        return false;

    }

    @Override
    public boolean canBePushed(){
        return false;
    }

    /* Makes the entity immovable.
    @Override
    public void moveEntity(double x, double y, double z){

    }*/

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.cow.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.cow.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.cow.hurt";
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound("mob.cow.step", 0.15F, 1.0F);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected Item getDropItem()
    {
        return Items.leather;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_){}

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() == Items.bucket && !player.capabilities.isCreativeMode && !this.isChild())
        {
            if (itemstack.stackSize-- == 1)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.milk_bucket));
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.milk_bucket)))
            {
                player.dropPlayerItemWithRandomChoice(new ItemStack(Items.milk_bucket, 1, 0), false);
            }

            return true;
        }
        else
        {
            return super.interact(player);
        }
    }

    public RobotEntity createChild(EntityAgeable ageable)
    {
        return new RobotEntity(this.worldObj);
    }

    public float getEyeHeight()
    {
        return this.height;
    }

    @Override
    public ItemStack[] getInventory(){
        return this.Inventory;
    }

}