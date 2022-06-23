package top.jrl.concurrency.part2;

import java.util.Vector;

/**
 * @author jrl
 * @date Create in 14:30 2022/5/20
 */
public class Vector1 {
    static Vector v = new Vector();
    static Object o = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                // if (!v.contains(o)){
                v.add(o);
                // }

            }
            System.out.println(v.size());
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                if (!v.contains(o)) {
                    v.add(o);
                }
            }
            System.out.println(v.size());
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(v.size());
    }
}
