package CodeGeneration;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by morell on 5/1/16.
 */
public abstract class HearThread extends Thread {
    private Queue<Signal> signalQueue = new LinkedList<Signal>();
    private RobotMutex mutex;
    private final RobotMutex.Execution THREAD_ID = RobotMutex.Execution.Hear;

    public HearThread(RobotMutex mut)
    {
        this.mutex = mut;
    }

    public void Signal(Signal newSignal)
    {
        signalQueue.add(newSignal);
        mutex.SwitchTurns();
    }

    @Override
    public void run() {
        while(true) {
            try {
                mutex.WaitForMyTurn(THREAD_ID);
                Handle(signalQueue.poll());
                if (signalQueue.isEmpty()) {
                    mutex.SwitchTurns();
                }
            } catch (InterruptedException e)
            {
                System.out.println("Failed to handle a signal properly.");
            }
        }
    }

    public abstract void Handle(Signal sig_id);
}
