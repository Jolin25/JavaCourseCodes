package java0.conc0303.threadlocal.jolyne;

/**
 * @author jrl
 * @date Create in 14:43 2022/12/20
 */
public class ThreadLocal0 {
    static ThreadLocal<String> tls = new ThreadLocal<>();

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
        }
    }
}
