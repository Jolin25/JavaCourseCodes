package java0.conc0301.jrl;

public class HighConcurrency {

    public static void main(String[] args) {
        try {
            Thread threadTest = new Thread() {
                public void run() {
                    System.out.println("执行线程中方法");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadTest.start();
            synchronized (threadTest) {
                /** knowledge point:
                 * 如果synchronized获得对象锁是线程的实例时，此时比较特殊，
                 * 当该线程终止的时候，会调用线程自身的notifyAll()方法，会通知所有等待在该线程对象上的线程。
                 */
                threadTest.wait();        //当线程终止的时候，会调用线程自身的notifyAll()方法
            }
            System.out.println("执行到了这里");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}