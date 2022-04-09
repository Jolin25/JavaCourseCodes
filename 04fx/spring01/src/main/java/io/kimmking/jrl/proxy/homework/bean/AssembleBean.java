package io.kimmking.jrl.proxy.homework.bean;

import io.kimmking.spring01.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * д����ʵ�� Spring Bean ��װ�䣬��ʽԽ��Խ�ã�XML��Annotation �����ԣ�, �ύ�� GitHub��
 *
 * @author jrl
 * @date Create in 14:08 2022/4/9
 */
@ComponentScan("io.kimmking.jrl.proxy.homework.bean")
public class AssembleBean {
    @Bean
    Student studentFactory(){
        return Student.create();
    }
    @Autowired
    Teacher teacher;

    public static void main(String[] args) {
        ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext4homework1.xml");
        // context.getBean("1");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(String.join(",",beanDefinitionNames));
        Student student = new AssembleBean().teacher.student;
        System.out.println(student);
    }
}
