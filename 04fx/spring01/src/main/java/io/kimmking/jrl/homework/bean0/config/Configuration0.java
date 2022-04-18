package io.kimmking.jrl.homework.bean0.config;

import io.kimmking.jrl.homework.bean0.pojo.HomeTeacher;
import io.kimmking.spring01.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ����bean��ע��
 * @author jrl
 * @date Create in 17:30 2022/4/9
 */
@Configuration
public class Configuration0 {
    /**
     * knowledge point:  beanName ����ݷ���������studentFactory
     */
    @Bean
    Student studentFactory() {
        return Student.create();
    }

    /**
     * knowledge point:  beanName  ����ָ��
     */
    @Bean(name = "homeTeacher-config")
    HomeTeacher homeTeacherFactory() {
        return new HomeTeacher();
    }
}
