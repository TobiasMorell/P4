package com.company;

public class Main {

    public static void main(String[] args) {
        Robot R = new Robot();
	    DoublerThreader dt = new DoublerThreader(R);

        Thread th = new Thread(dt, "DoubleThreader");
        System.out.println("Starting 'Double Threader'.");
        th.start();

        System.out.println("Main has finished executing.");
    }
}
