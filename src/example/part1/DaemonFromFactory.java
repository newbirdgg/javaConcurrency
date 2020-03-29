package example.part1;

import java.util.concurrent.ThreadFactory;

public class DaemonFromFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
