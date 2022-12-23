
package java0.conc0302.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * NewScheduledThreadExecutor:
 * 创建一个不限制大小的线程池，此线程池支持定时以及周期性执行任务的需求。
 *
 * @author Joly
 */
public class NewScheduledThreadExecutorDemo {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(16);

        for (int i = 0; i < 100; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("start:" + no);
                        Thread.sleep(1000L);
                        System.out.println("end:" + no);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            // 10s后执行
            // executorService.schedule(runnable, 10, TimeUnit.SECONDS);
            executorService.scheduleAtFixedRate(runnable, 5, 5, TimeUnit.SECONDS);
        }
        Thread.sleep(1000000);
        executorService.shutdown();
        System.out.println("Main Thread End!");


    }

}
