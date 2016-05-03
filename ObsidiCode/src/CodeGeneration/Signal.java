package CodeGeneration;

/**
 * Created by morell on 5/1/16.
 */
public class Signal {
    private final String signal_id;
    private final Object[] args;

    public Signal(String sig_id, Object[] args)
    {
        this.signal_id = sig_id;
        this.args = args;
    }

    public String GetID()
    {
        return signal_id;
    }

    public Object[] GetArguments()
    {
        return args;
    }
}
