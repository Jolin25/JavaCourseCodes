package java0.conc0301.jrl;

/**
 * @author jrl
 * @date Create in 10:19 2023/2/7
 */
public class MultiObject {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        synchronized (object1) {
            synchronized (object2) {
                System.out.println("do something 1");
                System.out.println("业务上可以释放 object1 了");
                System.out.println("do something 2");
                System.out.println("业务上可以释放 object2 了");
            }
        }
    }
}
