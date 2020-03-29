package example.part1;

import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("开始执行");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("我一定被执行吗");
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        TimeUnit.MILLISECONDS.sleep(1000000);
    }
}
