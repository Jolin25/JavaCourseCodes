package java0.conc0303.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

// TODO_Joly:我没看懂
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        final Map<String, AtomicInteger> count = new ConcurrentHashMap<>();
        final CountDownLatch endLatch = new CountDownLatch(2);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                AtomicInteger oldValue;
                for (int i = 0; i < 5; i++) {
                    // TODO_Joly:ConcurrentHashMap 保证的就是 存取元素的时候是串行的对吧
                    oldValue = count.get("a");
                    if (null == oldValue) {
                        AtomicInteger zeroValue = new AtomicInteger(0);
                        oldValue = count.putIfAbsent("a", zeroValue);
                        if (null == oldValue) {
                            oldValue = zeroValue;
                        }
                    }
                    oldValue.incrementAndGet();
                }
                // TODO_Joly:a 就没被 put 过
                // 因为 a 是全局唯一的，这样就也不需要 put，
                // 当场改，当场用。
                // 所以，a 本身需要是线程安全的类型，所以就用了原子类，
                // 因为如果 a 不是线程安全的类型的话，改 a 的过程就可能发生多个线程瞎几把动的情况。

                // 这里的 CountDownLatch 就单纯是个计数器，配合 主线程 中使用 await，来实现线程间的协作
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
