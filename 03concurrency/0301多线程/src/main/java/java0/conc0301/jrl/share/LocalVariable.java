package java0.conc0301.jrl.share;

/**
 * 无状态:没有线程安全问题，因为都是局部变量。每个线程都只是调用了这个方法，而并没有使用临界变量。
 * @author jrl
 * @date Create in 21:43 2023/1/16
 */
public class LocalVariable implements Runnable {

    @Override
    public void run() {
        Integer ii = 0;
        for (int i = 0; i < 100000; i++) {
            ii++;
        }
        System.out.println(ii);//10000
    }
}
