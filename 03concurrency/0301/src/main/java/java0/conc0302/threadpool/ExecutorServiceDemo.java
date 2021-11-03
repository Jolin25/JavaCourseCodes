
package java0.conc0302.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * knowledge point:
 * Executors：线程池的工具类
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) {
        /** knowledge point:
         *  newScheduledThreadPool:支持定时以及周期性执行任务
         * */
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(16);
        try {
            String str = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "I am a task, which submited by the so called laoda, and run by those anonymous workers";
                }
            }).get();

            System.out.println("str=" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
