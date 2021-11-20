package Exception;

/**
 * @author jrl
 * @date Create in 14:32 2021-11-20
 */
public class ExceptionLearn {
    public static void main(String[] args) {
        try {
            System.out.println("A执行");
            new ExceptionLearnB().a();
            System.out.println("B无异常则A继续执行");
        } catch (Exception e) {
            System.out.println("A检测到B抛出的异常");
        }
    }
}
