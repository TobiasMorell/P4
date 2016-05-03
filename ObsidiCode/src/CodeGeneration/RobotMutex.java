package CodeGeneration;

/**
 * Created by morell on 5/1/16.
 */
public class RobotMutex {
    public enum Execution { Normal(0), Hear(1);
        private int numVal;

        Execution(int num_Val)
        {
            this.numVal = num_Val;
        }

        public static Execution FromInt (int i)
        {
            switch (i)
            {
                case 0:
                    return Normal;
                case 1:
                    return Hear;
                default:
                    return null;
            }
        }

        public int GetValue()
        {
            return numVal;
        }
    };

    private Execution whoGoes;
    private int howMany = 2;

    public synchronized Execution WhoGoes()
    {
        return whoGoes;
    }

    public RobotMutex(int first, int max)
    {
        this.whoGoes = Execution.FromInt(first);
        this.howMany = max;
    }

    public synchronized void SwitchTurns()
    {
        whoGoes = Execution.FromInt(whoGoes.GetValue() + 1 % howMany);
        notifyAll();
    }

    public synchronized void WaitForMyTurn(Execution thread) throws InterruptedException
    {
        while(thread != whoGoes) wait();
    }
}
