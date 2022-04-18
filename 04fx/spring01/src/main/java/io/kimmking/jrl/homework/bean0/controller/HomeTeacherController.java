package io.kimmking.jrl.homework.bean0.controller;

import io.kimmking.jrl.homework.bean0.pojo.HomeTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jrl
 * @date Create in 14:22 2022/4/17
 */
@Component
public class HomeTeacherController {
    @Autowired
    HomeTeacher homeTeacher;

    public void test() {
        System.out.println(homeTeacher);
    }
}
