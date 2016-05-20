package com.obsidiskrivemaskine;

import com.obsidiskrivemaskine.block.ObsidiCodingMachine;
import compiler.CodeGeneration.Signal;
import compiler.Utility.Coord;
import com.obsidiskrivemaskine.Entity.RobotEntity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

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
    protected HearThread hear;
    protected Thread hear_thread;

    public SyncRobot(){
        ObsidiCodingMachine.RobotList.add(this);
    }

    public void StartThreads()
    {
        if(hear != null) {
            hear_thread = new Thread(hear);
            hear_thread.start();
        }
        normal_thread.start();
    }
    /*most SyncRobot methods follow the same basic pattern
    * First it checks if the lock is openend
    * Once it is, it calls the corresponding method in AbstractRobot
    * and finally it locks the lock again*/
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
        return new Coord(0, 0, 0);
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
            if(direction.equalsIgnoreCase("down"))
                synchronized (this){wait(1150);}
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

    public synchronized void createEntityIfNotPresent(){
        if(Robot == null || Robot.isDead)
            spawnEntity();
        try{
            wait(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
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
    /* Robot is initialized by createEntitybyName, which finds the entity with the given name
    * The location of the robot is then set to be 5 blocks west of the player
    * The reason for the cast to int and then back to double is to round the number.
    * 5.5 is then added to the X coordinate to set it 5 blocks west for the user. The .5 is to center the Robot.
    * spawnExplosionParticle is just for some fancy particles on spawn.
    * */
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

    public void Talk(Coord coord){
        Talk(coord.toString());
    }

    public void Talk(Float floatOut){
        Talk(floatOut.toString());
    }

    public void Talk(Boolean bool){
        Talk(bool.toString());
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

    public synchronized void sendSignal(String channel, Object[] args){
        try {
            Robot.getLock().isLockOpen();
            System.out.println("sendSignal called - sending signal with id " + channel);
            ObsidiCodingMachine.receiveSignal(new Signal(channel, args));
            Robot.getLock().changeLockState(false);
        } catch (InterruptedException e) {
            System.out.println("Could not sleep the SyncRobot");
        }
    }

    public synchronized void Signal(Signal signal){
        hear.Signal(signal);
    }
    // The base class for the HearThread, it is a nested class so that the ObsidiCode Robot HearThread class has access to it
    protected abstract class HearThread implements Runnable {
        protected Queue<Signal> signalQueue = new LinkedList<Signal>();

        public synchronized void Signal(Signal signal) {
            signalQueue.add(signal);
            mutex.SwitchTurns(true);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (signalQueue.isEmpty()) {
                        synchronized (mutex) {
                            mutex.SwitchTurns(false);
                            mutex.wait();
                        }
                    }
                    Signal s = signalQueue.poll();
                    Handle(s);
                }
            } catch (InterruptedException e)
            {
                System.out.println("HearThread interrupted.");
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
            START();
        }
    }

    protected class SignalMutex {
        private AtomicBoolean pendingSignals = new AtomicBoolean(false);

        public synchronized void SwitchTurns(boolean setTo)
        {
            pendingSignals.set(setTo);
            mutex.notifyAll();
        }

        public synchronized void WaitForTurn()
        {
            try {
                if(pendingSignals.get()) {
                    System.out.println("Got a signal");
                    mutex.wait();
                    System.out.println("Waiting over");
                }
            } catch (InterruptedException e)
            {
                System.out.println("Failed to wait for turn.");
            }
        }
    }

    protected void START()
    {
    }

    protected String multStringString(String s1, String s2)
    {
        char[] chars = new char[s1.length() + s2.length()];
        int full_length = 0;
        int first = 0;
        int second = 0;

        while(full_length < s1.length() + s2.length()) {
            if(first < s1.length()) {
                chars[full_length] = s1.charAt(first);
                first++;
                full_length++;
            }
            if(second < s2.length()) {
                chars[full_length] = s2.charAt(second);
                second++;
                full_length++;
            }
        }

        return String.valueOf(chars);
    }

    protected String multStringNum(String s1, float n1)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n1; i++)
        {
            sb.append(s1);
        }

        return sb.toString();
    }

    protected String divStringString(String s1, String s2)
    {
        StringBuilder sb = new StringBuilder();
        //Run through s1 and find out if the chars are in s2
        for (int i = 0; i < s1.length(); i++) {
            char current = s1.charAt(i);
            if(s2.contains(String.valueOf(current)))
            {
                sb.append(current);
            }
        }

        return sb.toString();
    }
}
