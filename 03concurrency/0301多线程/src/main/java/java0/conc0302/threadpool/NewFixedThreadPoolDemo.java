
package java0.conc0302.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NewFixedTreadPool:创建固定大小的线程池。
 * 每次提交一个任务就创建一个线程，直到线程数到达最大线程数。
 * 线程池的大小一旦到达最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新的线程。
 * @author Joly
 */
public class NewFixedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 20; i++) {
            final int no = i;
            executorService.execute(() -> {
                try {
                    System.out.println("start:" + no);
                    // DONE_Joly:线程抛异常之后，这个线程会被干掉还是接着接下一个任务？
                    //---> 被干掉。
                    int a = 1/0;
                    Thread.sleep(1000L);
                    System.out.println("end:" + no);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");
    }

}
