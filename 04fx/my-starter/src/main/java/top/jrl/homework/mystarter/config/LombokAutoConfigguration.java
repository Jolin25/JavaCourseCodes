package top.jrl.homework.mystarter.config;

import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jrl
 * @date Create in 14:07 2022/4/19
 */
@EnableConfigurationProperties(LombokPropertiesConfiguration.class)
@Configuration
@ConditionalOnClass(Lombok.class)
public class LombokAutoConfigguration {
    @Autowired
    LombokPropertiesConfiguration lombokPropertiesConfiguration;

    @Bean
    @ConditionalOnMissingBean(Lombok.class)
    @ConditionalOnProperty(name = "lombok.myproperties.enable", havingValue = "true", matchIfMissing = true)
    public Lombok lombok() {
        System.out.println("进行Lombok的自动配置");
        System.out.println("进行Lombok的自动配置"+lombokPropertiesConfiguration.a);
        System.out.println("进行Lombok的自动配置"+lombokPropertiesConfiguration.getProperties());
        return new Lombok();
    }
}
