package io.kimmking.spring02;

import io.kimmking.spring01.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * knowledge point:
 */
// TODO_Joly:这是对所有的Bean吗，所以Spring是在容器启动了之后一次性把所有的Bean都专配到了上下文中的？而注入是按需注入
// TODO_Joly:和工厂有关的，所以和Bean的生命周期无关对吗？
// TODO_Joly:这个类会在初始化之前执行吧--->对，先配置Bean，再统一进行初始化处理
@Component
public class HelloBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        /*初始化指定的bean*/
        System.out.println(" ==> postProcessBeanDefinitionRegistry: " + registry.getBeanDefinitionCount());
        System.out.println(" ==> postProcessBeanDefinitionRegistry: " + String.join(",", registry.getBeanDefinitionNames()));
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Student.class);
        rootBeanDefinition.getPropertyValues().add("id", 101);
        rootBeanDefinition.getPropertyValues().add("name", "KK101");
        /*向上下文中装配指定的bean*/
        registry.registerBeanDefinition("s101", rootBeanDefinition);
        RootBeanDefinition rootBeanDefinition2 = new RootBeanDefinition(Student.class);
        rootBeanDefinition2.getPropertyValues().add("id", 1125);
        rootBeanDefinition2.getPropertyValues().add("name", "KK1125");
        registry.registerBeanDefinition("s1125", rootBeanDefinition2);

        RootBeanDefinition rootBeanDefinition3 = new RootBeanDefinition(Student.class);
        rootBeanDefinition3.getPropertyValues().add("id", 112500);
        rootBeanDefinition3.getPropertyValues().add("name", "KK112500");
        /*xml配置文件会先加载，所以这里就可以给xml中的内容覆盖了*/
        registry.registerBeanDefinition("student100", rootBeanDefinition3);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(" ==> postProcessBeanFactory: " + beanFactory.getBeanDefinitionCount());
        System.out.println(" ==> postProcessBeanFactory: " + String.join(",", beanFactory.getBeanDefinitionNames()));
        /*配置单例*/
        // TODO_Joly:没放进去
        beanFactory.registerSingleton("s102", Student.create());
     }
}
