
package java0.conc0302.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * NewSingleThreadExecutor:创建一个单线程的线程池。
 * 这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有的任务。
 * 如果这个线程因为异常结束了，那么会有新的线程来代替它。
 * 此线程池保证所有任务的执行顺序会按照任务的提交顺序来执行。
 * @author Joly
 * @date 2022/12/23
 */
public class NewSingleThreadExecutorDemo {

    public static void main(String[] args) throws   InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 3; i++) {
            final int no = i;
            Future<?> submit = executorService.submit(() -> {
                System.out.println("start:" + no);
                try {
                    Thread.sleep(1000L);
                    int a = 1/0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end:" + no);
            });
            try {
                System.out.println(submit.get());
            } catch (ExecutionException e) {
                System.out.println("执行异常："+no);
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");
    }

}
