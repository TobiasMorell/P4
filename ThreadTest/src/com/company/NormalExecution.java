package com.company;

/**
 * Created by morell on 4/29/16.
 */
public class NormalExecution extends Thread {
    private final int THREAD_ID;
    HearMutex mutex;

    public NormalExecution (HearMutex mut, int id)
    {
        this.mutex = mut;
        this.THREAD_ID = id;
    }

    @Override
    public void run() {

        while(true) {

            try {
                synchronized (this) { wait(1000); }
                mutex.WaitForMyTurn(THREAD_ID);
                System.out.println("Normal execution.");
            } catch (InterruptedException e)
            {
                System.out.println("Could not sleep the normal execution thread!");
            }
        }
    }
}
