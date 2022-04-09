package io.kimmking.spring01;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;


/**
 * pojo:
 * 1.aop使用
 * <p>
 * 2.bean 生命周期：
 * Aware：
 * BeanNameAware
 * ApplicationContextAware
 * spring 负责对beanName和applicationContext这两个属性进行赋值（在构建Student bean的时候）
 *
 * @author jrl
 * @date 2022/2/7
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable, BeanNameAware, ApplicationContextAware {

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;
    /**
     * knowledge point:  BeanNameAware 用于在初始化Bean时将BeanName信息提供给该Bean应该是用反射实现的）
     */
    private String beanName;
    /**
     * knowledge point:  ApplicationContextAware 用于在初始化Bean的时候将ApplicationContext提供给该Bean
     */
    private ApplicationContext applicationContext;

    /*初始化之前就调用了。应该是属性赋值的阶段做的。*/
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * knowledge point:  Bean 生命周期中的 初始化 中的 自定义init-method
     */
    // TODO_Joly:
    public void init() {
        System.out.println("hello...........");
    }


    public static Student create() {
        return new Student(101, "KK101", null, null);
    }

    /**
     * 输出beanName（是BeanNameAware给set进来的）
     * 输出the names of all beans defined in this factory
     *
     * @param
     * @return
     * @date 2022/2/7
     */
    public void print() {
        System.out.println(this.name + "print()====>");
        System.out.println(this.beanName);
        System.out.println("   context.getBeanDefinitionNames() ===>> "
                + String.join(",", applicationContext.getBeanDefinitionNames()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeanName() {
        return beanName;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
