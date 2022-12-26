
package java0.conc0302.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock
 * 模拟去缓冲区获取数据，如果获取不到就进行赋值操作的功能
 * @author Joly
 */
public class ReentrantReadWriteLockDemo2 {

    //充当缓冲区
    private final Map<String, Object> map = new HashMap<>();

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public Object readWrite(String key) {
        Object value = null;
        System.out.println("1.首先开启读锁去缓存中取数据");
        rwLock.readLock().lock();
        try {
            value = map.get(key);
            if (value == null) {
                System.out.println("2.数据不存在，则释放读锁，开启写锁");
                rwLock.readLock().unlock();
                rwLock.writeLock().lock();
                try {
                    if (value == null) {// 因为释放读锁到开启写锁的过程中可能value被赋值了
                        value = "aaaa";
                    }
                } finally {
                    System.out.println("3.释放写锁");
                    rwLock.writeLock().unlock();
                }
                System.out.println("4.开启读锁");
                rwLock.readLock().lock();
            }
        } finally {
            System.out.println("5.释放读锁");
            rwLock.readLock().unlock();
        }
        return value;
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo2 demo2 = new ReentrantReadWriteLockDemo2();
        demo2.readWrite("并发编程");
    }

}
