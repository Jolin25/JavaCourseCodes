
package java0.conc0302.atomic;

/**
 * TODOQQQQQQ
 * 演示Lock线程不安全
 * @author Joly
 */
public class AtomicMain {

    public static void main(String[] args) {
        final SyncCount count = new SyncCount();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        count.add();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // TODO_Joly://num=338247 这用的是公平锁，用不公平锁的话，结果就是对的
        // 首先，我不明白为什么能不对，其次我不懂公不公平咋还影响了
        System.out.println("num=" + count.getNum());
    }

}
