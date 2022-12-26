
package java0.conc0302.lock;

/**
 * ReentrantLock
 *
 * @author Joly
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        // DONE_Joly:这两个线程可以在使用通一把锁的情况下，同时拥有这把锁吗？（可重入锁）
        //--->不可以,毕竟是用一把锁。
        final Count count = new Count();

        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    count.put();
                }
            }.start();
        }
    }
}
