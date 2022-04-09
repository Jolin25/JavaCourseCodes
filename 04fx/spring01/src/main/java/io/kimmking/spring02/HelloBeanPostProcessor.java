package io.kimmking.spring02;

import io.kimmking.spring01.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * knowledge point:
 * 1.用于Spring Bean 的生命周期中的初始化阶段，可以统一的在bean核心初始化的前后进行初始化处理。
 * （会对每一个bean都进行执行这个接口的实现。）
 * 2.要把实现了BeanPostProcessor的类加载到上下文中才生效（Component注解）
 */
@Component
public class HelloBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" ====> postProcessBeforeInitialization " + beanName + ":" + bean);
        // 可以加点额外处理
        // 例如
        if (bean instanceof Student) {
            Student student = (Student) bean;
            student.setName(student.getName() + "-" + System.currentTimeMillis());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" ====> postProcessAfterInitialization " + beanName + ":" + bean);
        return bean;
    }
}
