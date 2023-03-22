package java0.conc0303.collection.joly;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHashMapDemo0 {

    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        final Map<String, Integer> count = new ConcurrentHashMap<>();
        final CountDownLatch endLatch = new CountDownLatch(2);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Integer oldValue;
                for (int i = 0; i < 5; i++) {
                    oldValue = count.get("a");
                    if (null == oldValue) {
                        // AtomicInteger zeroValue = new AtomicInteger(0);
                        oldValue = count.putIfAbsent("a", 0);
                        oldValue = 0;
                    }
                    oldValue++;
                }
                endLatch.countDown();
            }
        };
        new Thread(task).start();
        new Thread(task).start();

        try {
            endLatch.await();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
