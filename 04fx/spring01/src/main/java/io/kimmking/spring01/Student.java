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
 * bean 生命周期：
 * 2.Aware：
 * BeanNameAware： setBeanName（）
 * ApplicationContextAware： setApplicationContext()
 * spring 负责对beanName和applicationContext这两个属性进行赋值（在构建Student bean的时候）
 *
 * @author jrl
 * @date 2022/2/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable, BeanNameAware, ApplicationContextAware {


    private int id;
    private String name;

    // BeanNameAware
    private String beanName;
    //ApplicationContextAware
    private ApplicationContext applicationContext;

    public void init() {
        System.out.println("hello...........");
    }

    public static Student create() {
        return new Student(102, "KK102", null, null);
    }

    /**
     * 输出beanName（不确定从哪进行的赋值）
     * 输出the names of all beans defined in this factory
     * TODO defined 是什么含义，这个bean创建了没有，是声明还是创建的意思
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


}
