
package java0.conc0302.lock;

/**
 * ThreadA 用于执行 Count3 中的 add 方法（num++）
 * @author Joly
 */
public class ThreadA extends Thread {
    private Count3 count3;

    public ThreadA(Count3 count3) {
        this.count3 = count3;
    }

    @Override
    public void run() {
        count3.add();
    }

}
