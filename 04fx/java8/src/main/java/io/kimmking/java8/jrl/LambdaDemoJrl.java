package io.kimmking.java8.jrl;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author jrl
 * @date 2022/1/31
 */
public class LambdaDemoJrl<T extends Serializable & Comparable & Collection> {
    public static void main(String[] args) {
        MathOperation<Long> mathOperation = (a, b) -> Long.valueOf(a + b);
        Long operation = mathOperation.operation(1, 2);
        System.out.println(operation);
        GreetingService greetingService = s -> System.out.println(s);
        greetingService.sayMessage("hello");
    }

    /**
     * 内部接口
     *
     * @author jrl
     * @date 2022/1/31
     */
    interface MathOperation<T> {
        /**
         * 对a和b进行一些数学操作
         *
         * @param a 1
         * @param b 2
         * @return 操作后的结果
         * @date 2022/1/31
         */
        T operation(int a, int b); // 返回类型+函数名+参数类型的列表
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
