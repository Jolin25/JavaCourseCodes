package java0.conc0302.lock;

/**
 * @author jrl
 * @date Create in 12:58 2022/12/26
 */
public class ConditionDemo0 {
    public static void main(String[] args) throws InterruptedException {
        ConditionDemo conditionDemo = new ConditionDemo();
        conditionDemo.put("a");
        Object take = conditionDemo.take();
        Object tak2e = conditionDemo.take();
        conditionDemo.take();
        conditionDemo.take();
        System.out.println(take);
        System.out.println(tak2e);
    }
}
