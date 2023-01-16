package java0.conc0301.jrl.share;

/**
 * 有状态：会有线程安全问题
 *
 * @author jrl
 * @date Create in 21:50 2023/1/16
 */
public class GlobalVariable implements Runnable {

    Integer ii = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            ii++;
        }
        System.out.println(ii);//111474
    }
}
