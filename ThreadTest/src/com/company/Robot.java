package com.company;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Created by morell on 5/13/16.
 */
public class Robot {
    private Queue<String> signalQueue = new LinkedList<>();

    private Thread normal = new Thread(new NormalThread());
    private Thread hear = new Thread(new HearThread());
    private SignalMutex sm = new SignalMutex();

    public Robot ()
    {
        normal.start();
        hear.start();
    }

    public void Move() {  System.out.println("Robot moving"); }

    public void Start()
    {
        while (true) {
            sm.WaitForTurn();
            Move();
            try {
                synchronized (this) {
                    wait(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Failed to pause the execution of normal thread.");
            }
       }
    }

    public void Signal(String signal)
    {
        signalQueue.add(signal);
        sm.SwitchTurns(true);
    }

    private class SignalMutex {
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

    private class NormalThread implements Runnable {
        @Override
        public void run() {
            Start();
        }
    }

    private class HearThread implements Runnable {
        @Override
        public void run() {
            System.out.println();
            try {
                synchronized (sm) {
                    sm.wait();
                }
                while (true) {
                    String s = signalQueue.poll();
                    System.out.println(String.format("Now handling %s.", s));
                    int sig_no = Integer.parseInt(s);
                    for(int i = 0; i <= sig_no; i++)
                    {
                        System.out.println(i);
                        Move();
                        synchronized (this) {
                            wait(300);
                        }
                    }
                    if (signalQueue.isEmpty()) {
                        synchronized (sm) {
                            sm.SwitchTurns(false);
                            sm.wait();
                        }
                    }
                }
            } catch (InterruptedException e)
            {
                System.out.println("Something wrong in HearThread.");
            }
        }
    }
}
