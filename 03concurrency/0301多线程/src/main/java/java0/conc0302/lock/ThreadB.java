
package java0.conc0302.lock;

/**
 * ThreadA 用于执行 Count3 中的 lockMethod 方法（num++）
 * @author Joly
 */
public class ThreadB extends Thread {
    private Count3 count3;

    public ThreadB(Count3 count3) {
        this.count3 = count3;
    }

    @Override
    public void run() {
        count3.lockMethod();
    }

}
