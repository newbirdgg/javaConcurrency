package chapter3;

/**
 * @Author: liyuzhan
 * @classDesp： 在没有同步情况下共享变量
 * @Date: 2020/3/11 11:24
 * @Email: 1031759184@qq.com
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
