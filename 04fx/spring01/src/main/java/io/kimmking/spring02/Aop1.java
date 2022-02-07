package io.kimmking.spring02;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 应用spring aop：
 * 方式一：XML
 * 这个方式需要在XML中说明切点和切面在哪，然后在代码里写好切面
 *
 * @author jrl
 * @date 2022/2/6
 */
public class Aop1 {

    //前置通知
    public void startTransaction() {
        System.out.println("    ====>begin ding... "); //2
    }

    //后置通知
    public void commitTransaction() {
        System.out.println("    ====>finish ding... "); //4
    }

    /**
     * knowledge point:
     * 环绕通知执行优先级高于前置通知和后置通知，
     * 在环绕通知中 joinPoint.proceed()必需要写，不然就不会调用原始类的方法了。
     */
    //环绕通知
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("    ====>around begin ding"); //1
        /** knowledge point:
         *     调用process()方法才会真正的执行实际被代理的方法
         *     如果用了环绕通知，那么就需要显示的去调用原始类的方法，否则就会不执行原始类的方法。
         *     如果没有用环绕通知，那么就会自动的去调用原始类的方法。
         */
        joinPoint.proceed();

        System.out.println("    ====>around finish ding"); //3
    }

}
