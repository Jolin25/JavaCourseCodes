package java0.conc0303.threadlocal;

/**
 * knowledge point:
 * ThreadLocal:
 * 1. 不改方法签名，实现静默传参
 */
public class ThreadLocalDemo {
    // knowledge use:使用 ThreadLocal 来存储 Integer 类型的 seqNum
    // 序列号，从0开始，依次+1
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        // 设置默认值
        public Integer initialValue() {
            return 0;
        }
    };

    public ThreadLocal<Integer> getThreadLocal() {
        return seqNum;
    }

    //在这个方法里，去操作了 ThreadLocal
    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }


    public static void main(String[] args) {
        ThreadLocalDemo threadLocalMain = new ThreadLocalDemo();

        SnThread client1 = new SnThread(threadLocalMain);
        SnThread client2 = new SnThread(threadLocalMain);
        SnThread client3 = new SnThread(threadLocalMain);

        client1.start();
        client2.start();
        client3.start();
    }


    private static class SnThread extends Thread {
        private ThreadLocalDemo sn;

        public SnThread(ThreadLocalDemo sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + "] ---> sn [" + sn.getNextNum() + "]");
            }
            // DONE_Joly:为什么要用这个方法，为什么要从当前线程下的 ThreadLocalMap 里移除这个 key 为 ThreadLocal 的键值对
            //--->为了避免内存泄漏，因为 ThreadLocalMap 里面的 Entry 的 value 是一直在被引用的，所以只要线程不终止，value
            // 就不会被 GC，长此以往，就会内存泄漏，甚至内存溢出。
            sn.getThreadLocal().remove();
        }
    }
}
