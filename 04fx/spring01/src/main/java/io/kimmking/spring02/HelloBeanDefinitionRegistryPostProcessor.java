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
// TODO_Joly:���Ƕ����е�Bean������Spring��������������֮��һ���԰����е�Bean��ר�䵽���������еģ���ע���ǰ���ע��
// TODO_Joly:�͹����йصģ����Ժ�Bean�����������޹ض���
// TODO_Joly:�������ڳ�ʼ��֮ǰִ�а�--->�ԣ�������Bean����ͳһ���г�ʼ������
@Component
public class HelloBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        /*��ʼ��ָ����bean*/
        System.out.println(" ==> postProcessBeanDefinitionRegistry: " + registry.getBeanDefinitionCount());
        System.out.println(" ==> postProcessBeanDefinitionRegistry: " + String.join(",", registry.getBeanDefinitionNames()));
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Student.class);
        rootBeanDefinition.getPropertyValues().add("id", 101);
        rootBeanDefinition.getPropertyValues().add("name", "KK101");
        /*����������װ��ָ����bean*/
        registry.registerBeanDefinition("s101", rootBeanDefinition);
        RootBeanDefinition rootBeanDefinition2 = new RootBeanDefinition(Student.class);
        rootBeanDefinition2.getPropertyValues().add("id", 1125);
        rootBeanDefinition2.getPropertyValues().add("name", "KK1125");
        registry.registerBeanDefinition("s1125", rootBeanDefinition2);

        RootBeanDefinition rootBeanDefinition3 = new RootBeanDefinition(Student.class);
        rootBeanDefinition3.getPropertyValues().add("id", 112500);
        rootBeanDefinition3.getPropertyValues().add("name", "KK112500");
        /*xml�����ļ����ȼ��أ���������Ϳ��Ը�xml�е����ݸ�����*/
        registry.registerBeanDefinition("student100", rootBeanDefinition3);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(" ==> postProcessBeanFactory: " + beanFactory.getBeanDefinitionCount());
        System.out.println(" ==> postProcessBeanFactory: " + String.join(",", beanFactory.getBeanDefinitionNames()));
        /*���õ���*/
        // TODO_Joly:û�Ž�ȥ
        beanFactory.registerSingleton("s102", Student.create());
     }
}
