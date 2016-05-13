package CodeGeneration;

/**
 * Created by morell on 5/1/16.
 */
public abstract class NormalThread extends  Thread {
    private final RobotMutex.Execution THREAD_ID = RobotMutex.Execution.Normal;
    protected RobotMutex mutex;

    public NormalThread (RobotMutex mut)
    {
        this.mutex = mut;
    }
}
