package com.obsidiskrivemaskine;

import com.obsidiskrivemaskine.Entity.RobotEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by esben on 28/04/16.
 */

public class SyncRobot extends Thread{
    private static World world;
    private static RobotEntity Robot;
    private static EntityPlayer player;
    private final int mutex_ID;

    public SyncRobot(){
        start();
        mutex_ID = 1;
    }

    public synchronized void move(String direction){
        try {
            Robot.getMutex().isLockOpen();
            AbstractRobot.move(direction);
            synchronized (this){ wait(1050); }
            Robot.getMutex().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void dig(String direction){
        try {
            Robot.getMutex().isLockOpen();
            AbstractRobot.dig(direction);
            Robot.getMutex().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void giveItem(String itemName){
        try {
            Robot.getMutex().isLockOpen();
            AbstractRobot.giveItem(itemName);
            Robot.getMutex().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void use(){
        try {
            Robot.getMutex().isLockOpen();
            AbstractRobot.use();
            Robot.getMutex().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void swing(){
        try {
            Robot.getMutex().isLockOpen();
            AbstractRobot.swing();
            Robot.getMutex().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void findNearestEnemy(){
        try {
            Robot.getMutex().isLockOpen();
            AbstractRobot.findNearestEnemy();
            Robot.getMutex().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public void createEntityIfNotPresent(){
        if(Robot == null || Robot.isDead)
            spawnEntity();
    }

    public synchronized void drop(String toDrop, int amount){
        try {
            Robot.getMutex().isLockOpen();
            AbstractRobot.drop(toDrop, amount);
            Robot.getMutex().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void equip(String weapon){
        try {
            Robot.getMutex().isLockOpen();
            AbstractRobot.equip(weapon);
            Robot.getMutex().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void lootChest(){
        try {
            Robot.getMutex().isLockOpen();
            AbstractRobot.lootChest();
            Robot.getMutex().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public static void hack(World worldIn, EntityPlayer playerIn){
        world = worldIn;
        player = playerIn;
    }

    public void spawnEntity(){
        Robot = (RobotEntity)EntityList.createEntityByName("obsidiskrivemaskine.RobotEntity", world);
        Robot.setLocationAndAngles(((double)(int)player.posX) + 5.5, (double)(int)player.posY, ((double)(int)player.posZ) + 0.5, player.rotationYaw, 15.0F);
        for(int i = 0; i < 15; i++)
            Robot.spawnExplosionParticle();
        world.spawnEntityInWorld(Robot);
        AbstractRobot.instantiateEntity(Robot, player, world);
    }

    public synchronized void talk(String msg){
            try {
                Robot.getMutex().isLockOpen(    );
                AbstractRobot.talk(msg);
                Robot.getMutex().changeLockState(false);
            } catch (InterruptedException e) {
                System.out.println("Could not sleep the SyncRobot");
            }
    }

    public synchronized void targetNearestEnemy(){
        try {
            Robot.getMutex().isLockOpen();
            AbstractRobot.targetNearestEnemy();
            Robot.getMutex().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }
}
