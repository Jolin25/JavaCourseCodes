package io.kimmking.jrl.homework.bean0.main;

import io.kimmking.jrl.homework.bean0.controller.HomeTeacherController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jrl
 * @date Create in 17:39 2022/4/9
 */

@Configuration
public class Main0 {

    static HomeTeacherController homeTeacherController;

    @Autowired
    public void setHomeTeacherController(HomeTeacherController homeTeacherController) {
        Main0.homeTeacherController = homeTeacherController;
        homeTeacherController.test();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4homework1.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(String.join(",", beanDefinitionNames));
        Main0.homeTeacherController.test();
    }


}
