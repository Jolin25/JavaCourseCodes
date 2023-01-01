package java0.conc0303.tool;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Joly
 */
public class CountDownLatchDemo2 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws Exception {
        //os:哟，我是超级执行器！
        ExecutorService exec = Executors.newCachedThreadPool();
        // DONE_Joly:为什么总是把 CountDownLatch 的 count 和 线程数或者任务数 设置的一样？
        //---> 这里是想要等所有的任务都执行完了之后，主线程再继续执行
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        //执行 threadCount 个任务
        for (int i = 0; i < threadCount; i++) {
            // TODO_Joly:final?
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    test(threadNum);
                    //countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        // DONE_Joly:难道 CuntDownLatch 只是拿来等待任务执行完成的吗
        //--->是的
        countDownLatch.await();
        System.out.println("==>所有程序员完成任务，项目顺利上线！");
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        System.out.println(String.format("程序员[%d]完成任务。。。", threadNum));
        Thread.sleep(100);
    }
}