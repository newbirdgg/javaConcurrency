package chapter3;

import java.awt.*;
import java.util.EventListener;


public class ThisEscape {
    private Thread t;
    public ThisEscape(){
        System.out.println(this);
        t = new Thread(){
            @Override
            public void run(){
                System.out.println(ThisEscape.this);
            }
        };
        t.start();
        // do something
    }

    public static void main(String[] args){
        ThisEscape a = new ThisEscape();
    }
    }

