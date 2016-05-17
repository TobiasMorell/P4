package com.obsidiskrivemaskine;

/**
 * Created by esben on 02/05/16.
 */
public class RobotLock {
    private boolean lockIsOpen;

    public RobotLock(boolean state){
        this.lockIsOpen = state;
    }

    public synchronized void changeLockState(boolean state){
        this.lockIsOpen = state;
        this.notify();
    }

    public synchronized void isLockOpen() throws InterruptedException{
        while(!lockIsOpen)
            wait();
    }
}
