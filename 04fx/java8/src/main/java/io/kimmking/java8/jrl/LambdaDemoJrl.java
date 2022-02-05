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
     * �ڲ��ӿ�
     *
     * @author jrl
     * @date 2022/1/31
     */
    interface MathOperation<T> {
        /**
         * ��a��b����һЩ��ѧ����
         *
         * @param a 1
         * @param b 2
         * @return ������Ľ��
         * @date 2022/1/31
         */
        T operation(int a, int b); // ��������+������+�������͵��б�
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
