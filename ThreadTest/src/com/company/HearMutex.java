package com.company;

/**
 * Created by morell on 5/1/16.
 */
public class HearMutex {
    private int whoGoes;
    private int howMany;

    public synchronized int WhoGoes()
    {
        return whoGoes;
    }

    public HearMutex(int first, int max)
    {
        this.whoGoes = first;
        this.howMany = max;
    }

    public synchronized void SwitchTurns()
    {
        whoGoes = (whoGoes + 1) % howMany;
        notifyAll();
    }

    public synchronized void WaitForMyTurn(int id) throws InterruptedException
    {
        while(id != whoGoes) wait();
    }
}
