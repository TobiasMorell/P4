package com.company;

public class Main {

    public static void main(String[] args) {
        HearMutex hm = new HearMutex(1, 2);

        HearHandler he = new HearHandler(hm, 0);
        NormalExecution ne = new NormalExecution(hm, 1);
	    DoublerThreader dt = new DoublerThreader(he);

        Thread th = new Thread(dt, "DoubleThreader");
        System.out.println("Starting 'Double Threader'.");
        th.start();

        System.out.println("Starting 'Signal Handler'.");
        he.start();
        System.out.println("Starting 'Normal Execution'.");
        ne.start();

        System.out.println("Main has finished executing.");
    }
}
