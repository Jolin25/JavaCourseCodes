package jrl;

/**
 * @author jrl
 * @date Create in 16:27 2022-2-25
 */
public class AnonymityClazz {
    public static void main(String[] args) {
        // 以匿名类的方式实现A接口
        AInterface aImpl = new AInterface() {
            @Override
            public void a1(Object o) {
                System.out.println("匿名类的实现");
            }
        };
        aImpl.a1("o");
        AInterface aLambdaImpl = (o) -> System.out.println("lambda实现");
        AInterface aLambdaImpl2 = v -> System.out.println(v);
        aLambdaImpl.a1("lambda");
        aLambdaImpl2.a1("o");
    }
}
