
package java0.conc0303.tool;

import java.util.concurrent.Semaphore;

/**
 * Semaphore
 * 我感觉这个例子在模仿 synchronized 和 wait notify
 *
 * @author jrl
 * @date 2022/12/28
 */
public class SemaphoreDemo3 {

    public static void main(String[] args) {
        // 启动线程
        for (int i = 0; i < 10; i++) {
            // 消费者
            new Thread(new Consumer()).start();
        }
        for (int i = 0; i <= 10; i++) {
            // 生产者
            new Thread(new Producer()).start();

        }

    }


    // 仓库
    static Warehouse buffer = new Warehouse();

    static class Producer implements Runnable {

        static int num = 1;

        @Override
        public void run() {
            // DONE_Joly:++操作为什么没有发生线程不安全？
            int n = num++;
            // ---> 哈哈哈,用 num + 1 就会线程不安全。
            // 看来，num++ 是个原语操作。
            // int n = num + 1;
            while (true) {
                try {
                    buffer.put(n);
                    System.out.println(">" + n);
                    // 速度较快。休息10毫秒
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("<" + buffer.take());
                    // 速度较慢，休息1000毫秒
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Warehouse {
        // 非满锁
        final Semaphore notFull = new Semaphore(10);
        // 非空锁
        final Semaphore notEmpty = new Semaphore(0);
        // 核心锁
        final Semaphore mutex = new Semaphore(1);
        // 库存容量，每个商品就是个数字
        final Object[] items = new Object[10];

        int putptr, takeptr, count;


        /**
         * 放库存（最终的执行一定是先放库存，因为notEmpty初始量是0）
         *
         * @param obj
         * @throws InterruptedException
         */
        public void put(Object obj) throws InterruptedException {
            notFull.acquire();
            mutex.acquire();
            items[putptr] = obj;
            try {
                if (++putptr == items.length) {
                    putptr = 0;
                    ++count;
                }
            } finally {
                mutex.release();
                notEmpty.release();
            }
        }

        /**
         * 取库存
         *
         * @return
         * @throws InterruptedException
         */
        public Object take() throws InterruptedException {
            notEmpty.acquire();
            mutex.acquire();
            Object obj = items[takeptr];
            try {
                if (++takeptr == items.length) {
                    takeptr = 0;
                    --count;
                }
                return obj;
            } finally {
                mutex.release();
                notFull.release();
            }
        }
    }

}
