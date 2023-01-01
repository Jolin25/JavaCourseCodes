package java0.conc0302.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jrl
 * @date Create in 12:58 2022/12/26
 */
public class ConditionDemo0 {
    public static void main(String[] args) throws InterruptedException {
        ConditionDemo conditionDemo = new ConditionDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            executorService.submit(() -> {
                try {
                    conditionDemo.put(Math.random());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        for (int i = 0; i < 50; i++) {
            executorService.submit(() -> {
                try {
                    conditionDemo.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
