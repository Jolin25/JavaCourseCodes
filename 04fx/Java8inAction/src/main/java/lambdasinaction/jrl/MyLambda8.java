package lambdasinaction.jrl;

/**
 * MyLambdaInterface
 * java8 处理lambda表达式
 *
 * @author jrl
 * @date 2022/1/30
 */
public class MyLambda8 {
    public static void main(String[] args) {
        /** knowledge point:
         * 相当于实现了一个匿名内部类
         * （但之所以用匿名内部类，其实是因为想要实现匿名函数，
         * 可是java里不可能有脱离类的函数，所以就用了匿名内部类）
         */
        MyLambdaInterface myLambdaInterfaceImpl = s -> System.out.println(s);
        myLambdaInterfaceImpl.doSomeShit("you");
    }
}
