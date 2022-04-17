package io.kimmking.jrl.annotation;

import java.lang.annotation.Annotation;

/**
 * @author jrl
 * @date Create in 15:29 2022/4/15
 */
public class MyAnnotationImpl implements MyAnnotation {
    @Override
    public String elementOne() {
        return null;
    }

    @Override
    public String[] elementTwo() {
        return new String[0];
    }

    @Override
    public String[] elementThree() {
        return new String[0];
    }

    /*这个方法是Annotation接口里的*/
    @Override
    public Class<? extends Annotation> annotationType() {
        return this.getClass();
    }
}
