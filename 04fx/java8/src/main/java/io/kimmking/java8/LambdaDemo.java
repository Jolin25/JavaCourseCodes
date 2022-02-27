package io.kimmking.java8;

import com.google.common.base.Function;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/**
 * 泛型TextendsA&B&C的话，传进来的T就必需把ABC的接口都实现了。
 * extends在这里表示的是一种层级关系，同时&的作用就是接口的多实现
 *
 * @author Joly
 */
public class LambdaDemo<T extends Serializable & Comparable & Collection> {

    public static void main(String[] args) {
        LambdaDemo demo = new LambdaDemo();
        // java7及以前用匿名类的方式来实现接口里的方法
        MathOperation op = new MathOperation<Integer>() {
            @Override
            public Integer operation(int a, int b) {
                return 1;
            }
        };
        Integer operation = (Integer) op.operation(1, 2);
        System.out.println(operation);

        // java 8 及以后用lambda来实现接口里的方法
        MathOperation op1 = (a, b) -> 1;
        Integer operation1 = (Integer) op1.operation(1, 1);
        System.out.println(operation1);


        MathOperation op2 = new MathOperation<Integer>() {
            @Override
            public Integer operation(int a, int b) {
                return a + b;
            }
        };

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (int a, int b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            //int c = 1000;
            return a * b;// + c;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + demo.operate(10, 5, addition));
        System.out.println("10 - 5 = " + demo.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + demo.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + demo.operate(10, 5, division));

        //System.out.println("10 ^ 5 = " + demo.operate(10, 5, (a, b) -> new Double(Math.pow(a,b)).intValue()));

        System.out.println("10 ^ 5 = " + demo.operate(10, 5, (a, b) -> Math.pow(a, b)));

        Runnable task = () -> System.out.println(1111);

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) -> {
            System.out.println(message);
        };
        // 类似函数指令的用法
        // 因为sayMessage的参数是String，println的参数也是String，所以在写println的时候就直接可以不写参数了
        // 这样就进一步简化了
        GreetingService greetService3 = System.out::println;


        // 构造器也可以简化
        Function<String, Double> doubleDoubleFunction = Double::new;

        Arrays.asList(1, 2, 3).forEach(x -> System.out.println(x + 3));
        Arrays.asList(1, 2, 3).forEach(LambdaDemo::println);
        greetService1.sayMessage("kimmking");
        greetService2.sayMessage("Java");
        greetService3.sayMessage("CuiCuilaoshi");
    }

    private static void println(int x) {
        System.out.println(x + 3);
    }

    /**
     * 有参数，有返回值（泛型）
     *
     * @author jrl
     * @date 2022/2/26
     */
    interface MathOperation<T> {
        T operation(int a, int b); // 返回类型+函数名+参数类型的列表
    }

    /**
     * 有参数，没有返回值
     *
     * @author jrl
     * @date 2022/2/26
     */
    interface GreetingService {
        void sayMessage(String message);
    }


    /**
     * A方法实现执行：参数abc和要使用abc参数的B方法
     * 这样使得用B方法更加的简单，相当于结合了实现B方法和调用B方法
     *
     * @author jrl
     * @date 2022/2/26
     */
    private <T> T operate(int a, int b, MathOperation<T> mathOperation) {
        return mathOperation.operation(a, b);
    }

}
