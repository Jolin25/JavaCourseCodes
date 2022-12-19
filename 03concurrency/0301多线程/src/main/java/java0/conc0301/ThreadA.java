package java0.conc0301;

/**
 * 创建线程的三种基本方式：
 * 1. 继承 Thread 类
 *
 * @author Joly
 */
public class ThreadA extends Thread {

    public void run() {
        super.run();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程A");
    }
}
