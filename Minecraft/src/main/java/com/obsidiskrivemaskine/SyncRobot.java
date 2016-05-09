package com.obsidiskrivemaskine;

import com.obsidiskrivemaskine.Entity.RobotEntity;
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

    public SyncRobot(){
        start();
    }

    public synchronized void Move(String direction){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.move(direction);
            synchronized (this){ wait(1050); }
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void Mine(String direction){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.dig(direction);
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void Place(String item){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.Place(item);
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void GiveItem(String itemName){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.giveItem(itemName);
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void Use(){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.use();
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void Swing(){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.swing();
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void FindNearestEnemy(){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.findNearestEnemy();
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public void createEntityIfNotPresent(){
        if(Robot == null || Robot.isDead)
            spawnEntity();
    }

    public synchronized void Drop(String toDrop, int amount){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.drop(toDrop, amount);
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void Equip(String weapon){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.equip(weapon);
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void LootChest(){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.lootChest();
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void StoreInChest(String itemToStore, int amount){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.StoreInChest(itemToStore, amount);
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void StoreAllInChest(){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.StoreAllInChest();
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public static void init(World worldIn, EntityPlayer playerIn){
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

    public synchronized void Talk(String msg){
            try {
                Robot.getLock().isLockOpen(    );
                AbstractRobot.talk(msg);
                Robot.getLock().changeLockState(false);
            } catch (InterruptedException e) {
                System.out.println("Could not sleep the SyncRobot");
            }
    }

    public synchronized void TargetNearestEnemy(){
        try {
            Robot.getLock().isLockOpen();
            AbstractRobot.targetNearestEnemy();
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }
}
