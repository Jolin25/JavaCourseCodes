package io.kimmking.jrl.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author jrl
 * @date Create in 14:49 2022/4/15
 */
@Target(ElementType.TYPE)
public @interface MyAnnotation {
    String elementOne() default "elementOneValue";

    String[] elementTwo() default {

    };

    // û��default�Ļ�����ʹ�ø�ע���ʱ��ͱ���ָ����Ԫ�ص�ֵ
    String[] elementThree();

}
