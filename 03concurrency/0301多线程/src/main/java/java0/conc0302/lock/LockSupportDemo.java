package java0.conc0302.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * 没懂
 * LockSupport
 *
 * @author Joly
 */
public class LockSupportDemo {
    //类锁
    public static Object u = new Object();

    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    /**
     * 静态内部类：线程
     *
     * @author jrl
     * @date 2022/12/26
     */
    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
                // TODO_Joly:这应该是另一个线程了吧
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(getName() + "被中断了");
                }
                System.out.println(getName() + "继续执行");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        Thread.sleep(3000L);
        t1.interrupt();
        LockSupport.unpark(t2);
        System.out.println("0000000000000000000000000");
        t1.join();
        t2.join();
    }
}