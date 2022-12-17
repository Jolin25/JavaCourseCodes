package java0.conc0302.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * knowledge point:
 * 1.当子线程（异步）抛出异常后会影响主线程吗？--->在同一个try里的代码会被影响，其他的不会
 * 2.Future能够拿到子线程的异常，那么具体都有什么内容呢？--->可以直接catch拿到子线程抛出来的异常
 * 3.子线程异常了以后，在主线程中shutdown子线程，会抛异常吗？--->不会，就正常执行。
 * 甚至子线程当前还有任务正在执行的话，不会强行关闭，而是等执行完了当前任务，再关闭子线程，也就是所谓的优雅停机。
 */
public class ExceptionDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        try {
            Future<Double> future = executorService.submit(() -> {
                throw new RuntimeException("executorService.submit()");
            });
           //这里是执行不到的，因为在try里，执行到这之前，获取future的时候应该就已经得知有异常了
            double b = future.get();
            System.out.println("main============"+b);

        } catch (Exception ex) {
            System.out.println("catch submit");
            ex.printStackTrace();
        }
//
//        try {
//            executorService.execute(() -> {
//                  throw new RuntimeException("executorService.execute()");
//                });
//        } catch (Exception ex) {
//            System.out.println("catch execute");
//            ex.printStackTrace();
//        }
//
        Thread.sleep(1000);
        executorService.shutdown();
        System.out.println("Main Thread End!");
    }

}
