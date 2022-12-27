
package java0.conc0302.atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 * 对 num 进行+1，或者取值
 *
 * @author Joly
 */
public class SyncCount {
    //业务
    private int num = 0;
    //技术 对象锁
    private Lock lock = new ReentrantLock(true);

    public int add() {
        lock.lock();
        try {
            return num++;
        } finally {
            lock.unlock();
        }
    }

    public int getNum() {
        return num;
    }
}
