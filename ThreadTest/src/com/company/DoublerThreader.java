package com.company;

/**
 * Created by morell on 4/29/16.
 */
public class DoublerThreader implements Runnable {
    private int i = 0;
    Robot r;

    public DoublerThreader (Robot r)
    {
        this.r = r;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                synchronized (this) {
                    wait(5000);
                }
            }
            catch (InterruptedException e)
            {
                System.out.println("DoubleThreader was interrupted!");
            }

            r.Signal(Integer.toString(i));
            System.out.println("Sending signal.");
            i++;
        }
    }
}
