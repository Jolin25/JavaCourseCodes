package java0.conc0302.lock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock使用公平排序策略与否的性能差异
 * @author Joly
 */
public class TestFair {
    //互斥变量
    public static volatile int race = 0;

    //25875 true
    //80 false 300倍
    public static ReentrantLock lock = new ReentrantLock(true); // 改成false会好100倍

    public static void increase() {
        lock.lock();
        race++;    //变量自增操作
        System.out.println(Thread.currentThread().getName());
        lock.unlock();
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        //获取线程组里的活跃线程数量
        int count = Thread.activeCount();
        long now = System.currentTimeMillis();
        System.out.println(count);
        // TODO_Joly:这个原本想拿来干嘛？
        AtomicReference<Thread> sign = new AtomicReference<>();
        Thread[] threads = new Thread[THREADS_COUNT];  //定义20个线程
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        //等待所有累加线程都结束。 噢！这个方式牛逼！
        while (Thread.activeCount() > count) {
            Thread.yield();// 哈哈，让一让，我再让一让
        }
        System.out.println(count);
        System.out.println(lock.getClass().getName() + " ts = " + (System.currentTimeMillis() - now));
    }
}

