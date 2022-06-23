package top.jrl.concurrency.part1;

/**
 * @author jrl
 * @date Create in 14:46 2022/5/2
 */
public class Calc {
    
    private static long count = 0;

    private synchronized void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        final Calc calc = new Calc();
        // 创建两个线程，执行add()操作
        Thread th1 = new Thread(() -> {
            calc.add10K();
        });
        Thread th2 = new Thread(() -> {
            calc.add10K();
        });

        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        long calcCount = calc();
        System.out.println(calcCount);
    }
}
