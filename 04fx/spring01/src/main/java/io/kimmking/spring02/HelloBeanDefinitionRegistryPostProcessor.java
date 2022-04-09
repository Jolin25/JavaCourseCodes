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
        /*向上下文中放入指定的bean*/
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
