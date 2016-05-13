package com.company;

/**
 * Created by morell on 4/29/16.
 */
public class NormalExecution extends Thread {
    private final int THREAD_ID;
    HearMutex mutex;
    Robot r;

    public NormalExecution (HearMutex mut, int id, Robot R)
    {
        this.mutex = mut;
        this.THREAD_ID = id;
        r=R;
    }

    @Override
    public void run() {

        while(true) {
            try {
                synchronized (this) { wait(1000); }
                //Wait for my turn skal ligges ind ved alle kald til Minecraft-spillet
                mutex.WaitForMyTurn(THREAD_ID);
                System.out.println("Normal execution.");
                r.MoveForward(2);

            } catch (InterruptedException e)
            {
                System.out.println("Could not sleep the normal execution thread!");
            }
        }
    }
}
