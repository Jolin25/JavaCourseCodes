
package java0.conc0302.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 *
 * @author Joly
 */
public class Count {

    final ReentrantLock lock = new ReentrantLock();

    /**
     * 就是一个模拟获得锁，执行业务，释放锁的过程。
     *
     * @param
     * @return
     * @date 2022/12/26
     */
    public void get() {
//        final ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get begin");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " get end");
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 就是一个模拟获得锁，执行业务，释放锁的过程。
     *
     * @param
     * @return
     * @date 2022/12/26
     */
    public void put() {
//        final ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " put begin");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " put end");
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
