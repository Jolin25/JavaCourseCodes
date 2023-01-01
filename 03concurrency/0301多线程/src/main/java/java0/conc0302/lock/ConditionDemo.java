package java0.conc0302.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 * Condition
 *
 * @author Joly
 */
public class ConditionDemo {
    /**
     * @author jrl
     * @date 2022/12/26
     */
    final Lock lock = new ReentrantLock();

    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    //被操作的数组
    final Object[] items = new Object[20];

    //数组已有元素的下一个位置，数组已有元素的最后一个位置，数组的已有元素的数量
    int putptr, takeptr, count;

    /**
     * 在数组不满的时候，向数组内放置一个元素
     *
     * @param
     * @return
     * @date 2022/12/26
     */
    public void put(Object x) throws InterruptedException {
        //手动上锁
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"----------"+x+"开始执行任务");
            // 当count等于数组的大小时，当前线程等待，直到notFull通知，再进行生产
            //也就是说要等到满足了 notFull 这个 Condition 的时候，才开始继续执行
            while (count == items.length) {
                System.out.println(Thread.currentThread().getName()+"----------"+x+"进入等待");
                //相当于 wait
                notFull.await();
            }
            System.out.println(Thread.currentThread().getName()+"----------"+x+"继续执行任务");
            //朝数组放置一个元素
            items[putptr] = x;
            if (++putptr == items.length) {
                putptr = 0;
            }
            ++count;
            //相当于 notify
            notEmpty.signal();
        } finally {
            //手动解锁
            lock.unlock();
        }
    }

    /**
     * 在数组不为空时，从数组中取出一个元素
     *
     * @param
     * @return
     * @date 2022/12/26
     */
    public Object take() throws InterruptedException {
        lock.lock();
        try {
            // 当count为0，进入等待，直到notEmpty通知，进行消费。
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) {
                takeptr = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}