package com.obsidiskrivemaskine;

import compiler.Utility.Coord;
import com.obsidiskrivemaskine.Entity.RobotEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDropper;
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
    static EntityPlayer player;
    private static RobotEntity Robot;

    public static void talk(String msg){
        if(player != null)
            player.addChatMessage(new ChatComponentText("\247f" + msg));
    }


    public static void init(World worldIn, EntityPlayer playerIn){
        world = worldIn;
        player = playerIn;
    }


    public static void move(String direction) {
        double targetX, targetY,targetZ;
        //Sets the target position based on argument
        if (direction.equalsIgnoreCase("east")){
            targetX = Robot.posX + 1;
            targetY = Robot.posY;
            targetZ = Robot.posZ;
        }
        else if (direction.equalsIgnoreCase("west")){
            targetX = Robot.posX - 1;
            targetY = Robot.posY;
            targetZ = Robot.posZ;
        }
        else if (direction.equalsIgnoreCase("north")){
            targetX = Robot.posX;
            targetY = Robot.posY;
            targetZ = Robot.posZ - 1;
        }
        else if (direction.equalsIgnoreCase("south")){
            targetX = Robot.posX;
            targetY = Robot.posY;
            targetZ = Robot.posZ + 1;
        }
        else{
            talk("Invalid direction");
            targetX = Robot.posX;
            targetY = Robot.posY;
            targetZ = Robot.posZ;
        }
        BlockPos targetPos = new BlockPos(targetX, targetY, targetZ);
        /*Checks whether the targetposition is an air block, and attempts to move above it, if it is not.
        * It is necessary to use .setLocationAndAngles, as the PathEntity Minecraft uses to move entities only tend to go
        * near the target location but not exactly. Therefore .setLocationAndAngles is used to "teleport" the entity
        * to the intended location after the Robot has walked near it. */
        if(!world.getBlockState(targetPos).getBlock().isAir(world, targetPos)) {
            targetPos = new BlockPos(targetX, ++targetY, targetZ);
            if(world.getBlockState(targetPos).getBlock().isAir(world, targetPos)){
                Robot.getNavigator().clearPathEntity();
                Robot.getNavigator().setPath(Robot.getNavigator().getPathToPos(targetPos), 0.8D);
                Robot.setLocationAndAngles(targetX, targetY, targetZ, Robot.rotationYaw, Robot.rotationPitch);
            }
        }
        else{
            Robot.getNavigator().clearPathEntity();
            Robot.getNavigator().setPath(Robot.getNavigator().getPathToPos(targetPos), 0.8D);
            Robot.setLocationAndAngles(targetX, targetY, targetZ, Robot.rotationYaw, Robot.rotationPitch);
        }
        Robot.getNavigator().clearPathEntity();
        Robot.setLocationAndAngles(targetX, targetY, targetZ, Robot.rotationYaw, Robot.rotationPitch);

    }

    public static void dig(String direction) {
        BlockPos blockToDig = null;
        if (direction.equalsIgnoreCase("down"))
            blockToDig = Robot.getPosition().down();
        else if (direction.equalsIgnoreCase("up"))
            blockToDig = Robot.getPosition().up();
        else if (direction.equalsIgnoreCase("east"))
            blockToDig = Robot.getPosition().east();
        else if (direction.equalsIgnoreCase("west"))
            blockToDig = Robot.getPosition().west();
        else if (direction.equalsIgnoreCase("north"))
            blockToDig = Robot.getPosition().north();
        else if (direction.equalsIgnoreCase("south"))
            blockToDig = Robot.getPosition().south();
        else
            talk("Invalid direction");
        //Checks if there is a digable block at the target location, and adds it to inventory before removing it
        if(blockToDig != null && !world.getBlockState(blockToDig).getBlock().isAir(world, blockToDig)) {
            AddToInventory(world.getBlockState(blockToDig).getBlock());
            world.destroyBlock(blockToDig, false);
        }
    }

    public static void giveItem(String itemName){
        ItemStack[] inventory = player.inventory.mainInventory;
        for (int i = 0; i < inventory.length; i++){
            if(inventory[i] != null && inventory[i].getDisplayName().equals(itemName)) {
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

    public static void Place(String name){
        ItemStack toPlace = searchInventory(name);
        if(toPlace != null)
        {
            toPlace.onItemUse(player, world, Robot.getPosition().add(0, 0, 1), Robot.getHorizontalFacing(), 0, 0, 0);
            removeFromInventory(toPlace);
        }
    }

    private static void removeFromInventory(ItemStack toPlace) {
        ItemStack[] inventory = Robot.getInventory();
        Boolean removed = false;
        int i = 0;
        while(i < inventory.length && !removed){
            if(inventory[i] != null && inventory[i].getDisplayName().equals(toPlace.getDisplayName()) && inventory[i].stackSize != 0) {
                inventory[i] = null;
                removed = true;
            }
        }
    }

    private static void AddToInventory(Block block){
        ItemStack[] inventory = Robot.getInventory();
        ItemStack item = new ItemStack(block);
        int i = 0, emptySlot = 16;
        while(i < inventory.length && item != null){
            //Checks if the item is already present in somewhere inventory and if it has reached it's stack limit.
            if(inventory[i] != null && inventory[i].getDisplayName().equals(item.getDisplayName()) && inventory[i].stackSize != inventory[i].getMaxStackSize()){
                inventory[i].stackSize++;
                item = null;
            }
            else if(inventory[i] == null)
                emptySlot = i;
            i++;
        }
        //If the item is not in the inventory already, it is added to the first empty slot
        if(item != null && emptySlot != 16) {
            inventory[emptySlot] = new ItemStack(block);
        }

    }

    public static void StoreAllInChest() {
        //Attempts to find a chest near the Robot
        TileEntityChest chestEntity = (TileEntityChest) world.getTileEntity(new BlockPos(Robot.posX, Robot.posY, Robot.posZ - 1));
        if (chestEntity == null)
            chestEntity = (TileEntityChest) world.getTileEntity(new BlockPos(Robot.posX, Robot.posY, Robot.posZ + 1));
        if (chestEntity == null)
            chestEntity = (TileEntityChest) world.getTileEntity(new BlockPos(Robot.posX + 1, Robot.posY, Robot.posZ));
        if (chestEntity == null)
            chestEntity = (TileEntityChest) world.getTileEntity(new BlockPos(Robot.posX - 1, Robot.posY, Robot.posZ));
        if (chestEntity != null) {
            try {
                ItemStack[] RoboInventory = Robot.getInventory();
                //Runs through both RobotInventory and ChestInventory to fill up already present itemstacks before adding new ones.
                for (int i = 0; i < RoboInventory.length; i++) {
                    for (int j = 0; j < chestEntity.getSizeInventory(); j++) {
                        if (chestEntity.getStackInSlot(j) == null && RoboInventory[i] != null) {
                            chestEntity.setInventorySlotContents(j, RoboInventory[i].copy());
                            RoboInventory[i] = null;
                        }
                        else if(RoboInventory[i] != null && chestEntity.getStackInSlot(j).getItem().equals(RoboInventory[i].getItem())){
                            ItemStack tempStack = chestEntity.getStackInSlot(j);
                            if((tempStack.stackSize + RoboInventory[i].stackSize) <= tempStack.getMaxStackSize()) {
                                tempStack.stackSize += RoboInventory[i].stackSize;
                                RoboInventory[i] = null;
                            }
                            else{
                                RoboInventory[i].stackSize = tempStack.getMaxStackSize() - tempStack.stackSize;
                                tempStack.stackSize = tempStack.getMaxStackSize();
                            }
                        }
                    }
                }
                cleanInventory();
            } catch (Exception e) {
                talk("Unable to find nearby chest");
                e.printStackTrace();
            }
        } else
            talk("Unable to find nearby chest");
    }

    //Does the same as StoreAllInChest, however this only stores a specified amount of a specified item
    public static void StoreInChest(String name, int amount){
        ItemStack itemToStore = searchInventory(name);
        TileEntityChest chestEntity = (TileEntityChest)world.getTileEntity(new BlockPos(Robot.posX, Robot.posY, Robot.posZ - 1));
        if(chestEntity == null)
            chestEntity = (TileEntityChest)world.getTileEntity(new BlockPos(Robot.posX, Robot.posY, Robot.posZ + 1));
        if(chestEntity == null)
            chestEntity = (TileEntityChest)world.getTileEntity(new BlockPos(Robot.posX + 1, Robot.posY, Robot.posZ));
        if(chestEntity == null)
            chestEntity = (TileEntityChest)world.getTileEntity(new BlockPos(Robot.posX - 1, Robot.posY, Robot.posZ));
        if(chestEntity != null) {
            try {
                for (int i = 0; i < Robot.getInventory().length; i++) {
                    if (chestEntity.getStackInSlot(i) == null && itemToStore != null) {
                        if(amount >= itemToStore.stackSize) {
                            chestEntity.setInventorySlotContents(i, itemToStore.copy());
                            amount = amount - itemToStore.stackSize;
                            itemToStore.stackSize = 0;
                            itemToStore = searchInventory(name);
                        }
                        else{
                            ItemStack tempStack = itemToStore.copy();
                            tempStack.stackSize = amount;
                            chestEntity.setInventorySlotContents(i, tempStack);
                            itemToStore.stackSize = itemToStore.stackSize - amount;
                            itemToStore = searchInventory(name);
                        }
                    }
                }
                cleanInventory();
            }
            catch (Exception e){
                talk("Unable to find nearby chest");
                e.printStackTrace();
            }
        }
        else
            talk("Unable to find nearby chest");
    }

    //Removes any itemstack with a stacksize of 0 from the inventory, as this item technically doesn't exist
    private static void cleanInventory() {
        ItemStack[] inventory = Robot.getInventory();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].stackSize == 0)
                inventory[i] = null;
        }
    }

    public static float GetHealth(){
        return Robot.getHealth();
    }

    public static float getX() {
        return Robot.getPosition().getX();
    }

    public static float getY() {
        return Robot.getPosition().getY();
    }

    public static float getZ() {
        return Robot.getPosition().getZ();
    }

    public static Coord getPosition(){
        return new Coord(Robot.getPosition().getX(), Robot.getPosition().getY(), Robot.getPosition().getZ());
    }

    private static ItemStack searchInventory(String item){
        ItemStack[] inventory = Robot.getInventory();
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i] != null && inventory[i].getDisplayName().equals(item) && inventory[i].stackSize != 0)
                return inventory[i];
        }
        return null;
    }

    public static void use(){
        try {
            Robot.getHeldItem().onItemUse(player, world, Robot.getPosition().add(0, 0, 1), Robot.getHorizontalFacing(), 0, 0, 0);
        }
        catch (Exception e){
            talk("Unable to use currently held items");
        }
    }


    public static void drop(String toDrop, int amount){
        ItemStack itemToDrop = searchInventory(toDrop);
        if(itemToDrop != null && itemToDrop.stackSize > amount) {
            Robot.dropItem(itemToDrop.getItem(), amount);
            itemToDrop.stackSize = itemToDrop.stackSize - amount;
        }
        else if(itemToDrop != null && itemToDrop.stackSize <= amount) {
            Robot.dropItem(itemToDrop.getItem(), itemToDrop.stackSize);
            itemToDrop.stackSize = 0;
        }
        else
            talk("Item not found in inventory");
    }

    public static void lootChest(){
        TileEntityChest chestEntity = (TileEntityChest)world.getTileEntity(new BlockPos(Robot.posX, Robot.posY, Robot.posZ - 1));
        if(chestEntity == null)
            chestEntity = (TileEntityChest)world.getTileEntity(new BlockPos(Robot.posX, Robot.posY, Robot.posZ + 1));
        if(chestEntity == null)
            chestEntity = (TileEntityChest)world.getTileEntity(new BlockPos(Robot.posX + 1, Robot.posY, Robot.posZ));
        if(chestEntity == null)
            chestEntity = (TileEntityChest)world.getTileEntity(new BlockPos(Robot.posX - 1, Robot.posY, Robot.posZ));
        if(chestEntity != null) {
           try {
               for (int i = 0; i < chestEntity.getSizeInventory(); i++) {
                   if (Robot.addItemToInventory(chestEntity.getStackInSlot(i)))
                       chestEntity.setInventorySlotContents(i, null);
               }
           }
           catch (Exception e){
               talk("Unable to find nearby chest");
               e.printStackTrace();
           }
        }
        else
            talk("Unable to find nearby chest");
    }

    //Attempts to obtain a viable target if not already present before swinging.
    public static void swing(){
        if (Robot.getAttackTarget() == null || Robot.getDistanceToEntity(Robot.getAttackTarget()) > 1.5 || Robot.getAttackTarget().isDead)
            targetNearestEnemy();
        if(Robot.getDistanceToEntity(Robot.getAttackTarget()) <= 1.5)
            Robot.attackEntityAsMob(Robot.getAttackTarget());
    }

    public static void instantiateEntity(RobotEntity robot, EntityPlayer playerIn, World worldIn){
        Robot = robot;
        player = playerIn;
        world = worldIn;
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
