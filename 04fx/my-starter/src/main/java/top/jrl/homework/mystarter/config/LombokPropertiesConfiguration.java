package top.jrl.homework.mystarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author jrl
 * @date Create in 13:56 2022/4/19
 */
@ConfigurationProperties(prefix = "lombok.myproperties")
public class LombokPropertiesConfiguration {
    String a = "a-default";
    String b = "b-default";
    private Properties properties = new Properties();

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
