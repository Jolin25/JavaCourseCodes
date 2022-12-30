package java0.conc0303.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Future、顺便试了试子线程的异常溢出
 * 异步同步：指的是通信模式，线程A唤起了线程B去干活，线程A是否要亲自等线程B干活的结果。
 * 阻塞非阻塞：说的是线程的状态，是否放弃CPU资源
 *
 * @author Joly
 */
public class FutureDemo1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(() -> {
            // 这个是 Runnable，异常没有溢出
            int a = 1 / 0;
        });
        System.out.println("main1");
        //异步非阻塞：就是唤起一个线程B去干活，然后当前线程A非阻塞，继续执行,
        //等线程B执行完了之后，x会将结果发送给A线程。
        Future<Integer> result = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                //这个是 Callable，异常溢出了本线程，到了父线程.不过不影响父线程的执行
                //但是必须 Future#get 才会把溢出搞出来，所以其实还是父线程异常，然后顺带展示了子线程的异常
                int a = 1 / 0;
                Thread.sleep(10000);
                return new Random().nextInt();
            }
        });
        System.out.println("main2");
        executor.shutdown();
        try {
            //理论上来说，这个时候有可能是拿不到结果的吧
            //不！Java的线程池实现设置了，主线程会等着子线程执行完！
            //所以一定拿得到值！
            //一定要去 Future#get 才会子线程异常溢出！不get的话，也是自己异常自己蹦，并不会影响父线程。
            System.out.println("result:" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}