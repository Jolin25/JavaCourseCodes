package io.kimmking.spring02;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * spring aop:
 * ��ʽ����ʹ��ע��ķ�ʽ����
 * Aspectע���������һ��aop����
 *
 * @author jrl
 * @date 2022/2/6
 */
@Aspect
public class Aop2 {

    /**
     * knowledge point:
     * ˵���е�����Щ
     */
    @Pointcut(value = "execution(* io.kimmking.*.Klass.*dong(..))")
    public void point() {

    }

    /**
     * knowledge point:
     * Ҫ˵����������Ӧ�ĸ��е�
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
         *  ���������ԭʼ���Ӧ�ķ���
         */
        joinPoint.proceed();
        System.out.println("========>around after klass dong //3");

    }

}
