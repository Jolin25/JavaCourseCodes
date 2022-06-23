package top.jrl.concurrency.part2;

/**
 * Happens-Before
 *
 * @author jrl
 * @date Create in 17:35 2022/5/13
 */
public class Abc3 {
    static int abc2;
    static volatile int v = 1;

    public static void main(String[] args) throws InterruptedException {
        Abc3 abc3 = new Abc3();
        // abc3.one();
        // abc3.two();
        Thread b3 = new Thread(new Runnable() {
            @Override
            public void run() {
                abc2 = 123;
                v = 2;
            }
        });
        Thread b33 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (v == 2) {
                    System.out.println(abc2);
                }
            }
        });
        b33.start();
        b3.start();
    }


    private void two() throws InterruptedException {
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                abc2 = 123;
            }
        });
        b.start();
        b.join();
        System.out.println(abc2);
    }

    private void one() {
        int abc = 123;
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 这拿到的居然是同一个abc
                System.out.println(abc);
            }
        }).start();
    }
}
