package com.obsidiskrivemaskine;

import compiler.CodeGeneration.Signal;
import compiler.Utility.Coord;
import com.obsidiskrivemaskine.Entity.RobotEntity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import scala.NotImplementedError;
import scala.tools.nsc.Global;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by esben on 28/04/16.
 */

public class SyncRobot extends Thread{
    private static World world;
    private static RobotEntity Robot;
    private static EntityPlayer player;

    protected Queue<Signal> signalQueue = new LinkedList<Signal>();
    protected SignalMutex mutex = new SignalMutex();
    protected Thread normal_thread = new Thread(new NormalThread());
    protected Thread hear_thread;

    public SyncRobot(){
        start();
    }

    public synchronized float GetHealth(){
        try {
            Robot.getLock().isLockOpen();
            Robot.getLock().changeLockState(false);
            return AbstractRobot.GetHealth();
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
        return 0;
    }

    public synchronized float GetX() {
        try {
            Robot.getLock().isLockOpen();
            Robot.getLock().changeLockState(false);
            return AbstractRobot.getX();
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
        return 0;
    }

    public synchronized Coord GetPosition() {
        try {
            Robot.getLock().isLockOpen();
            Robot.getLock().changeLockState(false);
            return AbstractRobot.getPosition();
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
        return new Coord(0 ,0 ,0);
    }

    public synchronized float GetY() {
        try {
            Robot.getLock().isLockOpen();
            Robot.getLock().changeLockState(false);
            return AbstractRobot.getY();
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
        return 0;
    }

    public synchronized float GetZ() {
        try {
            Robot.getLock().isLockOpen();
            Robot.getLock().changeLockState(false);
            return AbstractRobot.getZ();
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
        return 0;
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

    protected abstract class HearThread implements Runnable {
        @Override
        public void run() {
            System.out.println();
            try {
                synchronized (mutex) {
                    mutex.wait();
                }
                while (true) {
                    Signal s = signalQueue.poll();
                    Handle(s);
                    if (signalQueue.isEmpty()) {
                        synchronized (mutex) {
                            mutex.SwitchTurns(false);
                            mutex.wait();
                        }
                    }
                }
            } catch (InterruptedException e)
            {
                System.out.println("Something wrong in HearThread.");
            }
        }

        /***
         * Find a hear-method that corresponds to a given signal
         * @param si The current signal
         * @return Either null or the method corresponding to the current signal
         */
        protected Method findMethodFromSignal(Signal si)
        {
            Object[] objs = si.GetArguments();
            Class[] argClasses = new Class[objs.length];
            for(int i = 0; i < objs.length; i++) {
                argClasses[i] = objs[i].getClass();
            }
            try {
                return this.getClass().getDeclaredMethod(si.GetID(), argClasses);
            } catch (NoSuchMethodException e)
            {
                return null;
            }
        }

        /***
         * Invokes a method with the parameters of a given signal
         * @param m the method to invoke
         * @param si the signal with the parameters to invoke with
         */
        protected void invokeMethod(Method m, Signal si)
        {
            Object[] objs = si.GetArguments();
            try {
                m.invoke(this, objs);
            } catch (InvocationTargetException e)
            {
                //Should never reach this point, as parameters have been checked.
                e.printStackTrace();
            } catch (IllegalAccessException e)
            {
                //If this exception is thrown the method is private
                System.out.println("The method was not accessible.");
            }
        }

        public abstract void Handle(Signal signal);
    }

    protected class NormalThread implements Runnable {
        @Override
        public void run() {
            Start();
        }
    }

    protected class SignalMutex {
        private AtomicBoolean pendingSignals = new AtomicBoolean(false);

        public synchronized void SwitchTurns(boolean setTo)
        {
            pendingSignals.set(setTo);
            notifyAll();
        }

        public synchronized void WaitForTurn()
        {
            try {
                if(pendingSignals.get())
                    wait();
            } catch (InterruptedException e)
            {
                System.out.println("Failed to wait for turn.");
            }
        }
    }

    protected void Start()
    {
        throw new NotImplementedException();
    }
}
