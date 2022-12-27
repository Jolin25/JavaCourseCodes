package java0.conc0302.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 演示原子类做++线程安全
 * @author Joly
 */
public class LongDemo {
    
    public static void main(String[] args) {
    
        final AtomicLong atomicLong = new AtomicLong();
        final LongAdder longAdder = new LongAdder();
        
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        atomicLong.getAndIncrement();
                        longAdder.increment();
                    }
                }
            }).start();
        }
        
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //atomicLong=1000000
        // longAdder =1000000
        System.out.println("atomicLong=" + atomicLong.get());
        System.out.println("longAdder =" + longAdder.sum());
        
    }
}
