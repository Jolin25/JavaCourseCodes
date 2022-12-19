package java0.conc0301;

import java.util.concurrent.Callable;

/**
 * 创建线程的三种基本方式：
 * 3. 实现 Callable接口，放在 Task 里，再用 Thread 类
 *
 * @author Joly
 */
public class ThreadC implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        System.out.println("这是线程C");
        return "线程C";
    }


}
