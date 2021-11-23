package Exception;

import java.rmi.UnexpectedException;

/**
 * @author jrl
 * @date Create in 14:33 2021-11-20
 */
public class ExceptionLearnB {
    public void a() {
        try {
            try {
                int a = 1 / 0;
                System.out.println("B内部不会继续执行");
            } catch (Exception e) {
                System.out.println("B-->a内部有异常");
            }
            System.out.println("B外部继续执行");
            int a = 1 / 0;
        } catch (ClassCastException e) {
            System.out.println("B--->a外部有异常");
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getMessage());
//            e.printStackTrace();
            throw e;
        }


    }

    public void 对自身异常未做任何处理() {
        int a = 1 / 0;
    }
}
