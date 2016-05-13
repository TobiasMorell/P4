package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by morell on 4/29/16.
 */
public class HearHandler extends Thread {
    private Queue<String> signalQueue = new LinkedList<String>();
    private HearMutex mutex;
    private final int THREAD_ID;
    Robot r;

    public HearHandler(HearMutex mut, int thread_id, Robot R)
    {
        this.mutex = mut;
        this.THREAD_ID = thread_id;
        r=R;
    }

    public void Signal(String newSignal)
    {
        signalQueue.add(newSignal);
        mutex.SwitchTurns();
    }

    @Override
    public void run() {
        while(true) {
            try {
                mutex.WaitForMyTurn(THREAD_ID);
                System.out.println(String.format("Now handling %s", signalQueue.poll()));
                r.MoveBackwards(3);
                if (signalQueue.isEmpty()) {
                    mutex.SwitchTurns();
                }
            } catch (InterruptedException e)
            {
                System.out.println("Failed to handle a signal properly.");
            }
        }
    }
}
