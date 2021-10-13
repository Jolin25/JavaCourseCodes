package java0.conc0301.jrl;

import jdk.nashorn.internal.ir.Block;

/**
 * 练习join
 *
 * @author jrl
 * @date Create in 12:42 2021-10-13
 */
public class ThreadJoin {
    static Integer lock = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1正在执行");
            }
        });

        t1.start();
        synchronized (lock) {
            System.out.println("main线程正在执行，lock对象被main线程占有");
            try {
                // 这个时候因为main线程占有了lock对象的锁，所以t1永远都拿不到lock对象的锁，t1就执行不动run方法里面的方法
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("main线程结束");
    }
}
