package io.kimmking.jrl.homework.bean0.main;

import io.kimmking.jrl.homework.bean0.pojo.SchoolTeacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jrl
 * @date Create in 17:39 2022/4/9
 */
public class main0 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4homework1.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(String.join(",", beanDefinitionNames));
    }
}
