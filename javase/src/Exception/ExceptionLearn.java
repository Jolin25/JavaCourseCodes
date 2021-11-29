package Exception;

/**
 * @author jrl
 * @date Create in 14:32 2021-11-20
 */
public class ExceptionLearn {
    public static void main(String[] args) {
        ExceptionLearn exceptionLearn = new ExceptionLearn();
//        exceptionLearn.子方法异常未做任何处理();
        exceptionLearn.处理异常信息();
    }

    private void basic() {

        try {
            System.out.println("A执行");
            new ExceptionLearnB().a();
            System.out.println("B无异常则A继续执行");
        } catch (Exception e) {
            System.out.println("A检测到B抛出的异常");
        }
    }

    private void 子方法异常未做任何处理() {
        try {
            new ExceptionLearnB().对自身异常未做任何处理();
            System.out.println("子方法异常，执行失败，所以执行不到这行代码");
        } catch (Exception e) {
            System.out.println("捕获到子方法的异常");
        }
    }

    private void 处理异常信息() {
        try {
            new ExceptionLearnB().处理异常信息();
        } catch (Exception e) {
//            String message = e.getMessage();
//            System.out.println("message:" + message);
            e.printStackTrace();
        }
    }
}
