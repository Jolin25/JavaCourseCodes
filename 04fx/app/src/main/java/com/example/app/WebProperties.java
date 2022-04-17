package com.example.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
/** knowledge point:
 * ConfigurationProperties注解：用于根据配置文件注册应用程序的Bean
 * */
@ConfigurationProperties(prefix = "web")
public class WebProperties {

    private String a = "aaa";

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
