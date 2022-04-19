package top.jrl.homework.startertest;

import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterTestApplication implements ApplicationRunner {
    @Autowired
    Lombok lombok;

    public static void main(String[] args) {
        SpringApplication.run(StarterTestApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(lombok);
    }
}
