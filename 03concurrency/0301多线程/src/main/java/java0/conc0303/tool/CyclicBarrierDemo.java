package java0.conc0303.tool;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier:可以让一组线程等待满足某个条件后同时执行。
 * CyclicBarrier 默认的构造方法是 CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，每个线
 * 程调用 await() 方法告诉 CyclicBarrier 我已经到达了屏障，然后当前线程被阻塞，直到 parties 个线程
 * 到达，结束阻塞。
 * 使用场景： 任务执行到一定阶段, 等待其他任务对齐
 *
 * 2. 其实用 wait/notify 或者 condition 或者 信号量 都是可以实现的，所以这个就是工具类
 * @author jrl
 * @date 2023/1/1
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            // 这是回调之后要执行的内容
            //只有一个子线程会执行回调内容
            @Override
            public void run() {
                System.out.println("回调>>" + Thread.currentThread().getName());
                System.out.println("回调>>线程组执行结束");
                System.out.println("==>各个子线程执行结束。。。。");
            }
        });
        for (int i = 0; i < 5; i++) {
            new Thread(new ReadNum(i, cyclicBarrier)).start();
        }

        // ==>>>


        System.out.println("==>主线程执行结束。。。。");

        //CyclicBarrier 可以重复利用，
        // 这个是CountDownLatch做不到的
//        for (int i = 11; i < 16; i++) {
//            new Thread(new readNum(i,cyclicBarrier)).start();
//        }
    }

    /**
     * 任务
     *
     * @author jrl
     * @date 2023/1/1
     */
    static class ReadNum implements Runnable {
        private int id;
        private CyclicBarrier cyc;

        public ReadNum(int id, CyclicBarrier cyc) {
            this.id = id;
            this.cyc = cyc;
        }

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("id:" + id + "," + Thread.currentThread().getName());
                try {
                    // DONE_Joly:这在等什么
                    //---> 这是在回调
                    cyc.await();
                    //所有线程过了屏障之后都会接着执行
                    System.out.println("线程组任务" + id + "结束，其他任务继续");
                    //cyc.await();   // 注意跟CountDownLatch不同，这里在子线程await
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}