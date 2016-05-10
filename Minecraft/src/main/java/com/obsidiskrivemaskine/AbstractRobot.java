package com.obsidiskrivemaskine;

import com.obsidiskrivemaskine.Entity.RobotEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Vec3;
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
        player.addChatMessage(new ChatComponentText("\247f" + msg));
    }

    public static void move(String direction) {
        double targetX, targetY,targetZ;
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
        if(!world.getBlockState(targetPos).getBlock().isAir(world, targetPos)) {
            targetPos = new BlockPos(targetX, ++targetY, targetZ);
            if(world.getBlockState(targetPos).getBlock().isAir(world, targetPos)){
                Robot.getNavigator().clearPathEntity();
                Robot.getNavigator().setPath(Robot.getNavigator().getPathToPos(targetPos), 0.8D);
                //The path tends to lead the entity close to the intended location but not to the exact location.
                //This is to ensure that it ends up in the intended location.
                Robot.setLocationAndAngles(targetX, targetY, targetZ, Robot.rotationYaw, Robot.rotationPitch);
            }
        }
        else{
            Robot.getNavigator().clearPathEntity();
            Robot.getNavigator().setPath(Robot.getNavigator().getPathToPos(targetPos), 0.8D);
            //The path tends to lead the entity close to the intended location but not to the exact location.
            //This is to ensure that it ends up in the intended location.
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
        if(searchInventory(name) != null)
        {
            searchInventory(name).onItemUse(player, world, Robot.getPosition().add(0, 0, 1), Robot.getHorizontalFacing(), 0, 0, 0);
        }
    }

    private static void AddToInventory(Block block){
        ItemStack[] inventory = Robot.getInventory();
        ItemStack item = new ItemStack(block);
        int i = 0, emptySlot = 16;
        while(i < inventory.length && item != null){
            if(inventory[i] != null && inventory[i].getDisplayName().equals(item.getDisplayName()) && inventory[i].stackSize != inventory[i].getMaxStackSize()){
                inventory[i].stackSize++;
                item = null;
            }
            else if(inventory[i] == null)
                emptySlot = i;
            i++;
        }
        if(item != null && emptySlot != 16) {
            inventory[emptySlot] = new ItemStack(block);
        }

    }

    public static void StoreAllInChest() {
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
            talk("Unable to use currently held item");
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
