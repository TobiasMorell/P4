package CodeGeneration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    /***
     * Add a new signal to be processed
     * @param newSignal the signal to process
     */
    public void Signal(Signal newSignal)
    {
        signalQueue.add(newSignal);
        mutex.SwitchTurns();
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

    /***
     * Abstract method that should be overriden to handle all signals
     * @param sig_id the signal to handle
     */
    public abstract void Handle(Signal sig_id);
}
