package java0.conc0303.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore
 * @author Joly
 */
public class SemaphoreDemo2 {

    private final static int threadCount = 20;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    // DONE_Joly:permits是什么
                    //---> 是锁定的资源允许同时访问的x量，在创建的时候指定。
                    //在使用时(acquire方法)说明一个线程要使用几个x
                    //换言之,x是一个计量数,并不代表有几个线程,完全看 初始量/单次使用量
                    semaphore.acquire(3); // 获取超出一半的许可，退化成串行执行
                    test(threadNum);
                    semaphore.release(3); // 释放多个许可
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }

    /**
     * 输出指定的线程id以及其对应的线程名称
     *
     * @param threadNum 线程id
     * @date 2022/12/28
     */
    private static void test(int threadNum) throws Exception {
        System.out.println("id:" + threadNum + "," + Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}
