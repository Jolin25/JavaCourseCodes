package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * knowledge point:
 * Import注解：和 Spring 的 xml 配置文件中的<import></import>一样
 * EnableConfigurationProperties注解：
 */
@Configuration
@Import(WebConfiguration.class)
@EnableConfigurationProperties(WebProperties.class)
public class WebAutoConfiguration {

    @Autowired
    WebProperties properties;
    // TODO_Joly:这里就算不import也可以注入的吧
    @Autowired
    WebConfiguration configuration;

    @Bean
    public WebInfo creatInfo() {
        return new WebInfo(configuration.name + "-" + properties.getA());
    }

}
