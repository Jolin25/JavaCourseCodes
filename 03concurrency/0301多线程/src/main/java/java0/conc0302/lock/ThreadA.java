
package java0.conc0302.lock;

/**
 * ThreadA ����ִ�� Count3 �е� add ������num++��
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
