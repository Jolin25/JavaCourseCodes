package java0.conc0302.lock.jrl;


import java.util.concurrent.*;

/**
 * 锁相关的一些属性
 *
 * @author jrl
 * @date Create in 09:59 2021-10-27
 */
public class LockProperties {
    public static void main(String[] args) {
        MyThreadCaller myThreadCaller = new MyThreadCaller();
        Thread myThread = new Thread(myThreadCaller);
        myThread.start();

    }
}

class MyThreadCaller implements Runnable {
    @Override
    public void run() {
        Object lock = this;
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                System.out.println("this is " + i + "th");
                /** knowledge point:  用于检测该线程是否持有指定的锁*/
                System.out.println("Thread.holdsLock( lock )" + Thread.holdsLock(lock));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}