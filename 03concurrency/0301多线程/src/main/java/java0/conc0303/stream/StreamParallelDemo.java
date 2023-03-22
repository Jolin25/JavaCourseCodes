package java0.conc0303.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * knowledge point:  stream 可以支持并发，使用 parallel（）即可，底层是 Java 默默实现了的。
 */
public class StreamParallelDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(1, 10000).forEach(i -> list.add(i));
        // TODO_Joly:BlockingQueue 什么特点？
        //  --->
        BlockingQueue<Long> blockingQueue = new LinkedBlockingQueue(10000);
        // DONE_Joly:Returns an equivalent stream that is parallel。什么意思？
        //  ---> 意思就是，接下来的操作是利用了线程池实现了并发操作。默认会采用 CPU核心数 * 2 个线程数。
        List<Long> longList = list.stream().parallel()
                .map(i -> i.longValue())
                .sorted()
                .collect(Collectors.toList());
//      // 串行，单线程
//      longList.stream().forEach(
        // 并行，默认使用CPU * 2个线程
        longList.stream().parallel().forEach(
                i -> {
                    try {
                        // blockingQueue 线程安全
                        blockingQueue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        List<Long> collect = blockingQueue.stream().sorted().collect(Collectors.toList());
        System.out.println("blockingQueue:" + blockingQueue.toString());
        System.out.println("collect:" + collect.toString());
    }


}
