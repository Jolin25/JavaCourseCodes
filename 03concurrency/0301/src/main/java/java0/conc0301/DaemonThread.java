package java0.conc0301;

/**
 * 如果JVM判断到当前进程只剩下守护线程，那么就会直接把这个进程给停掉
 *
 * @author jrl
 * @date 2021/10/12
 */
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {

        /** knowledge point:
         * 实例化接口，其实是匿名内部类（这里用lambda来实现匿名内部类），本质上来说还是实例化类
         */
        Runnable task = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread t = Thread.currentThread();
            System.out.println("当前线程:" + t.getName());
        };
        Thread thread = new Thread(task);
        thread.setName("test-thread-1");
        /** knowledge point:
         * 设置该线程为守护线程
         * setDaemon（）需要在start()之前，否则会抛运行时异常
         */
        thread.setDaemon(true);
        thread.start();
        /** knowledge point:
         * 可以通过增加main线程的执行时间，来让守护线程被执行（因为守护线程需要大概五秒）
         */
        Thread.sleep(5500);
    }
    
    
}
