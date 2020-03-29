package example.part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        try{
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" " +this);
            }
        }catch (InterruptedException e){
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonFromFactory());
        for (int i = 0;i<10;i++){
            exec.execute(new SimpleDaemons());
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
