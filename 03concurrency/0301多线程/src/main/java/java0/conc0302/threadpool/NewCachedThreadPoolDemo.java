
package java0.conc0302.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NewCachedThreadPool：创建一个可缓存的线程池。
 * 如果线程池的大小超过了处理任务所需的线程，那么就会回收这部分线程（60s 不执行任务的）。
 * 当任务增加时，此线程池又会增加线程数。最大线程数完全依赖于操作系统能够创建的线程数。
 * @author Joly
 */
public class NewCachedThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10000; i++) {
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
            executorService.execute(runnable);
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");


    }

}
