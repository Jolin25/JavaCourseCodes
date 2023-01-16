package java0.conc0301.jrl.share;

/**
 * 模仿 多线程调用 Spring MVC，其中 Controller 采用了默认的单例模式。
 * 分业务有状态和业务无状态。
 *
 * @author jrl
 * @date Create in 21:45 2023/1/16
 */
public class LocalVariableMain {
    public static void main(String[] args) {
        //无状态
        LocalVariable runnable1 = new LocalVariable();
        new Thread(runnable1).start();
        new Thread(runnable1).start();

        //    有状态
        GlobalVariable runnable2 = new GlobalVariable();
        new Thread(runnable2).start();
        new Thread(runnable2).start();
    }
}
