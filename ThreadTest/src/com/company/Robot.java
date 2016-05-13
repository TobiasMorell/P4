package com.company;

/**
 * Created by Gedesnegl on 13-05-2016.
 */
public class Robot {
    int position = 0;
    public enum Direction{
        Forwards, Backwards
    }

    public void MoveForward(int steps) {

        for(int i = 0; i < steps; i++){
            Move(Direction.Forwards);
        }
    }

    public void MoveBackwards(int steps){
        for(int i = 0; i < steps; i++){
            Move(Direction.Backwards);
        }
    }

    public synchronized void Move(Direction d){
        System.out.println("Robot: Moving " + d);
        switch (d){
            case Forwards:
                position++;
                break;
            case Backwards:
                position--;
                break;
        }
        try {
            wait(500);
        }catch(InterruptedException e){
            System.out.println("ERROR!");
            return;
        }
    }
}
