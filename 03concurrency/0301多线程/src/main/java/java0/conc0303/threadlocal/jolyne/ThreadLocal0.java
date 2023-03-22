package java0.conc0303.threadlocal.jolyne;

import java.util.HashMap;
import java.util.Map;

/**
 * 每一个 ThreadLocal 实例 都是一个 key-value,
 * key 默认强制设置为 ThreadLocal，value 设置为 用户值。
 *
 * 每个 thread 实例中的 threadLocals 里面可以放置多个 threadLocal。
 *
 * @author jrl
 * @date Create in 14:43 2022/12/20
 */
public class ThreadLocal0 {
    static ThreadLocal<String> tls = new ThreadLocal<>();
    static ThreadLocal<Map<String, String>> tlm = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadDemo threadDemo1 = new ThreadDemo();
        ThreadDemo threadDemo2 = new ThreadDemo();
        ThreadDemo threadDemo3 = new ThreadDemo();
        threadDemo1.start();
        threadDemo2.start();
        threadDemo3.start();
    }

    static class ThreadDemo extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("run run run--->" + Thread.currentThread().getName());
            tls.set(Thread.currentThread().getName());
            System.out.println(tls.get());
            Map<String, String> map = new HashMap<>();
            map.put("threadName", currentThread().getName());
            tlm.set(map);
            Map<String, String> map1 = tlm.get();
            System.out.printf(map1.toString());
        }
    }
}
