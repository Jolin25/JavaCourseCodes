package java0.conc0303.future.jolyne;

import java.util.concurrent.*;

/**
 * @author jrl
 * @date Create in 19:03 2022/12/22
 */
public class Future0 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<String> submit = pool.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "hello";
            }
        });
        System.out.println(submit.get());
        pool.shutdown();
        System.out.println(pool.isShutdown());
        boolean b = pool.awaitTermination(1000, TimeUnit.MILLISECONDS);
    }
}
