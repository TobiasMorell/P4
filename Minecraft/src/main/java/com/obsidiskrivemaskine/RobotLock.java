package com.obsidiskrivemaskine;

/**
 * Created by esben on 02/05/16.
 */
public class RobotLock {
    private boolean lockIsOpen;
    //Used by SyncRobot to check if it is allowed to proceed.
    public RobotLock(boolean state){
        this.lockIsOpen = state;
    }


    public synchronized void changeLockState(boolean state){
        this.lockIsOpen = state;
        this.notify();
    }

    //Check if the lock is open, and sleeps the thread should that not be the case
    public synchronized void isLockOpen() throws InterruptedException{
        while(!lockIsOpen)
            wait();
    }
}
