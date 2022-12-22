package java0.conc0301.jrl;

/**
 * @author jrl
 * @date Create in 19:52 2022/12/19
 */
public class TwiceStartMethod {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("hello");
        });
        thread.start();
        Thread.sleep(5000);
        thread.start();

    }
}
