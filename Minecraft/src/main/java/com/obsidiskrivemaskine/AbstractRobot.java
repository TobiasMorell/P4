package com.obsidiskrivemaskine;

import com.obsidiskrivemaskine.Entity.RobotEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by esben on 15/04/16.
 */
public abstract class AbstractRobot {
    static World world;
    public static boolean IsRunning;
    static EntityPlayer player;
    private static RobotEntity Robot;

    public static void talk(String msg){
        player.addChatMessage(new ChatComponentText("\247f" + msg));
    }

    public static void move(String direction) {
        if (direction.equalsIgnoreCase("east"))
            Robot.getNavigator().tryMoveToXYZ(Robot.posX + 1, Robot.posY, Robot.posZ, 1);
        else if (direction.equalsIgnoreCase("west"))
            Robot.getNavigator().tryMoveToXYZ(Robot.posX - 1, Robot.posY, Robot.posZ, 1);
        else if (direction.equalsIgnoreCase("north"))
            Robot.getNavigator().tryMoveToXYZ(Robot.posX, Robot.posY, Robot.posZ - 1, 1);
        else if (direction.equalsIgnoreCase("south"))
            Robot.getNavigator().tryMoveToXYZ(Robot.posX, Robot.posY, Robot.posZ + 1, 1);
    }

    public static void dig(String direction) {
        if (direction.equalsIgnoreCase("down"))
            world.destroyBlock(Robot.getPosition().down(), false);
        else if (direction.equalsIgnoreCase("up"))
            world.destroyBlock(Robot.getPosition().up(), false);
        else if (direction.equalsIgnoreCase("east"))
            world.destroyBlock(Robot.getPosition().east(), false);
        else if (direction.equalsIgnoreCase("west"))
            world.destroyBlock(Robot.getPosition().west(), false);
        else if (direction.equalsIgnoreCase("north"))
            world.destroyBlock(Robot.getPosition().north(), false);
        else if (direction.equalsIgnoreCase("south"))
            world.destroyBlock(Robot.getPosition().south(), false);
    }

    public static void giveItem(String itemName){
        ItemStack[] inventory = player.inventory.mainInventory;
        for (int i = 0; i < inventory.length && inventory[i] != null; i++){
            if(inventory[i].getDisplayName().equals(itemName)) {
                Robot.addItemToInventory(inventory[i]);
                inventory[i] = null;
                break;
            }
        }
    }

    public static void equip(String weapon){
        try {
            Robot.setCurrentItemOrArmor(0, searchInventory(weapon));
        }
        catch(Exception e){
            talk("Unable to find " + weapon);
            e.printStackTrace();
        }
    }

    private static ItemStack searchInventory(String item){
        ItemStack[] inventory = Robot.getInventory();
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i] != null && inventory[i].getDisplayName().equals(item))
                return inventory[i];
        }
        return null;
    }

    public static void use(){
        Robot.getHeldItem().onItemUse(player, world, Robot.getPosition().add(0, 0, 1), Robot.getHorizontalFacing(), 0, 0, 0);
    }

    public static void drop(String toDrop, int amount){
        ItemStack itemToDrop = searchInventory(toDrop);
        if(itemToDrop != null)
            Robot.dropItem(itemToDrop.getItem(), amount);
    }

    public static void lootChest(){
        TileEntityChest chestEntity = (TileEntityChest)world.getTileEntity(new BlockPos(Robot.posX, Robot.posY, Robot.posZ - 1));
        if(chestEntity != null) {
            for (int i = 0; i < chestEntity.getSizeInventory(); i++) {
                if (Robot.addItemToInventory(chestEntity.getStackInSlot(i)))
                    chestEntity.setInventorySlotContents(i, null);
            }
        }
    }

    public static void swing(){
        if (Robot.getAttackTarget() == null || Robot.getDistanceToEntity(Robot.getAttackTarget()) > 1.5 || Robot.getAttackTarget().isDead)
            targetNearestEnemy();
        if(Robot.getDistanceToEntity(Robot.getAttackTarget()) <= 1.5)
            Robot.attackEntityAsMob(Robot.getAttackTarget());
    }
/*
    public static void createEntity(){
        Robot = new RobotEntity(world);
    }


    public static void createEntityIfNotPresent(){
        if(Robot == null || Robot.isDead) {
            //createEntity();
            spawnEntity(Robot);
        }
    }
*/
    public static void spawnEntity(RobotEntity robot, EntityPlayer playerIn, World worldIn){
        Robot = robot;
        player = playerIn;
        world = worldIn;
        /*robot.setLocationAndAngles(((double)(int)player.posX) + 5.5, (double)(int)player.posY + 1, ((double)(int)player.posZ) + 0.5, player.rotationYaw, 0.0F);
        for(int i = 0; i < 15; i++)
            robot.spawnExplosionParticle();
        worldIn.spawnEntityInWorld(robot);*/
    }

    public static void targetNearestEnemy(){
        if(findNearestEnemy() != null)
            Robot.setAttackTarget(findNearestEnemy());
    }

    public static EntityLivingBase findNearestEnemy(){
        if(Robot.getHostileEntities().get(0) != null) {
            ArrayList<EntityLivingBase> enemies = Robot.getHostileEntities();
            EntityLivingBase closest = enemies.get(0);
            for(EntityLivingBase ei : enemies) {
                if(ei.getDistanceToEntity(Robot) <= closest.getDistanceToEntity(Robot))
                    closest = ei;
            }
            return closest;
        }
        return null;
    }
}
