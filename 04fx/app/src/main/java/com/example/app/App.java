package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    // ==== 测试自动配置 ====
    @Autowired
    WebInfo info;

    // DONE_Joly:什么都没注册，那这里的目的是什么--->为了运行一下，看看WebInfo注入了没有
    @Bean
    public void printInfo() {
        System.out.println(info.getName());
    }

}
