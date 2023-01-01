package java0.conc0303.tool;

import java.util.concurrent.CountDownLatch;

/**
 * I said 123, you shot just count down !
 * CountDownLatch(闭锁)可以看作一个只能做减法的计数器，可以让一个或多个线程等待执行。
 * 场景: Master 线程等待 Worker 线程把任务执行完
 * 示例:
 * 等所有人干完手上的活，包工头宣布下班休息。
 * 吃酒席: 大家围成一桌, 等剩下的座位数归0, 服务员才上菜
 * <p>
 * 特点：
 * 1、采用减法计数，
 * 2、各个子线程内countdown，
 * 3、调用线程/主线程里await，作为聚合点，一直到计数为0
 *
 * @author Joly
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // DONE_Joly:我没懂，我以为只会被执行5次任务的，结果应该是执行了50次....那CountDownLatch拿来有什么用？
        //---> 是为了让主线程等待子线程某个可被计算的量之后继续执行
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 50; i++) {
            new Thread(new ReadNum(i, countDownLatch)).start();
        }
        //主线程等着 CountDownLatch 减到0，才继续执行
        countDownLatch.await(); // 注意跟CyclicBarrier不同，这里在主线程await
        System.out.println("==>各个子线程执行结束。。。。");
        System.out.println("==>主线程执行结束。。。。");
    }

    /**
     * 任务
     *
     * @author jrl
     * @date 2023/1/1
     */
    static class ReadNum implements Runnable {
        private int id;
        private CountDownLatch latch;

        public ReadNum(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            // latch.countDown();
            synchronized (this) {
                System.out.println("id:" + id + "," + Thread.currentThread().getName());
                System.out.println("线程组任务" + id + "结束，其他任务继续");
                latch.countDown();
            }
        }
    }
}