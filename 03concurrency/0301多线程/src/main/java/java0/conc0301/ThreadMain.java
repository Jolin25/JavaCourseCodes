package java0.conc0301;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的三种基本方式
 *
 * @author Joly
 */
public class ThreadMain {

    public static void main(String[] args) {
        //1
        ThreadA threadA = new ThreadA();
        threadA.start();
        System.out.println("这是主线程：");
        //2
        // Runnable 其实就是个任务
        ThreadB threadB = new ThreadB();
        new Thread(threadB).start();
        System.out.println("这是主线程：");
        //3
        ThreadC threadC = new ThreadC();
        //把 Callable 装进了 任务（FutureTask 实现了 Runnable）中
        FutureTask<String> futureTask = new FutureTask<>(threadC);
        new Thread(futureTask).start();

        System.out.println("这是主线程:begin!");
        try {
            System.out.println("得到的返回结果是:" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
