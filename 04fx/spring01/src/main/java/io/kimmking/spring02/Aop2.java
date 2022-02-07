package io.kimmking.spring02;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * spring aop:
 * 方式二：使用注解的方式配置
 * Aspect注解表明这是一个aop配置
 *
 * @author jrl
 * @date 2022/2/6
 */
@Aspect
public class Aop2 {

    /**
     * knowledge point:
     * 说明切点是哪些
     */
    @Pointcut(value = "execution(* io.kimmking.*.Klass.*dong(..))")
    public void point() {

    }

    /**
     * knowledge point:
     * 要说明这个切面对应哪个切点
     */
    @Before(value = "point()")
    public void before() {
        System.out.println("========>begin klass dong... //2");
    }

    @AfterReturning(value = "point()")
    public void after() {
        System.out.println("========>after klass dong... //4");
    }

    @Around("point()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("========>around begin klass dong //1");
        /** knowledge point:
         *  这里调用了原始类对应的方法
         */
        joinPoint.proceed();
        System.out.println("========>around after klass dong //3");

    }

}
