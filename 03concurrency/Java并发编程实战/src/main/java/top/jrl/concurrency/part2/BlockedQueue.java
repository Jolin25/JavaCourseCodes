package top.jrl.concurrency.part2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jrl
 * @date Create in 16:31 2022/5/29
 */

public class BlockedQueue<T> {
    static Integer a = 1;
    static Integer b = 2;
    static Integer lock = 3;
    public static void main(String[] args) {
        new Thread(()->{
          synchronized (lock){
              while(a==1){
                  try {
                      lock.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
              while(b==2){
                  try {
                      b.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          }
        }).start();
        new Thread(()->{
            synchronized (lock){
                while(a==1){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while(b==2){
                    try {
                        // 这是错的，只能是lock来做条件变量
                        b.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
