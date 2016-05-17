package com.obsidiskrivemaskine.Entity;

import com.obsidiskrivemaskine.ObsidiSkriveMaskineMod;
import com.obsidiskrivemaskine.RobotLock;
import com.obsidiskrivemaskine.Utils;
import com.obsidiskrivemaskine.block.ObsidiSkriveMaskineBlock;
import compiler.CodeGeneration.Signal;
import compiler.Utility.Coord;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.ArrayList;

public class RobotEntity extends EntityCreature
{
    public static RobotLock lock = new RobotLock(true);
    ItemStack[] Inventory;
    ArrayList<EntityLivingBase> entities;
    public RobotEntity(World worldIn)
    {
        super(worldIn);
        this.Inventory = new ItemStack[15];
        this.setSize(0.75F, 0.75F);
        this.setCanPickUpLoot(true);
    }

    public synchronized RobotLock getLock(){
        return lock;
    }

    public static void RegisterEntity(){
        EntityRegistry.registerModEntity(RobotEntity.class, "RobotEntity", 255, ObsidiSkriveMaskineMod.INSTANCE, 64, 20, true);
        EntityRegistry.registerEgg(RobotEntity.class, Utils.ColorFromRGB(137, 91, 0), Utils.ColorFromRGB(88, 62, 0));
    }

    @Override
    protected boolean canDropLoot(){
        return false;
    }

    @Override
    public void onEntityUpdate(){
        synchronized(this){
            lock.changeLockState(true);
            notifyAll();
        }
        super.onEntityUpdate();
        if(ticksExisted % 5 == 0 || ticksExisted < 5) {
            AxisAlignedBB scanArea = new AxisAlignedBB(posX - 10, posY - 10, posZ - 10, posX + 10, posY + 10, posZ + 10);
            entities = (ArrayList) worldObj.getEntitiesWithinAABB(EntityLivingBase.class, scanArea);
        }
        if(ticksExisted % 300 == 0 && ticksExisted > 0) {
            Object[] args = new Object[1];
            args[0] = new Coord(10.0f, 10.0f, 10.0f);
            ObsidiSkriveMaskineBlock.receiveSignal(new Signal("Listen", args));
        }
    }

    public ArrayList<EntityLivingBase> getHostileEntities() {
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
            f = 4.0F + weapon.getDamageVsEntity();

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

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1);
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

    public float getEyeHeight()
    {
        return this.height;
    }

    @Override
    public ItemStack[] getInventory(){
        return this.Inventory;
    }

}