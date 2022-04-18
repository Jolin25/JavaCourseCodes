package io.kimmking.jrl.homework.bean0.config;

import io.kimmking.jrl.homework.bean0.pojo.HomeTeacher;
import io.kimmking.spring01.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 进行bean的注册
 * @author jrl
 * @date Create in 17:30 2022/4/9
 */
@Configuration
public class Configuration0 {
    /**
     * knowledge point:  beanName 会根据方法名来：studentFactory
     */
    @Bean
    Student studentFactory() {
        return Student.create();
    }

    /**
     * knowledge point:  beanName  可以指定
     */
    @Bean(name = "homeTeacher-config")
    HomeTeacher homeTeacherFactory() {
        return new HomeTeacher();
    }
}
