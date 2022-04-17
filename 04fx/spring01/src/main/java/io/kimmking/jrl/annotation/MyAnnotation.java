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

    // 没有default的话，在使用该注解的时候就必须指定该元素的值
    String[] elementThree();

}
