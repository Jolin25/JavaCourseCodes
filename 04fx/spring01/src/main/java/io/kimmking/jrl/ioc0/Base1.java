package io.kimmking.jrl.ioc0;

import io.kimmking.jrl.ioc0.bean0.Home;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 验证内部bean是原型--->不。是单例。
 *
 * @author jrl
 * @date Create in 14:37 2023/1/24
 */

public class Base1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4jrlioc0.xml");
        Home home_friend = (Home) context.getBean("home_friend");
        Home home_friend2 = (Home) context.getBean("home_friend");
        //io.kimmking.jrl.ioc0.bean0.Relative@5f282abb
        // io.kimmking.jrl.ioc0.bean0.Relative@5f282abb
        // io.kimmking.jrl.ioc0.bean0.Home@167fdd33
        // io.kimmking.jrl.ioc0.bean0.Home@167fdd33
        System.out.println(home_friend.getRelativeOne());
        System.out.println(home_friend2.getRelativeOne());
        System.out.println(home_friend);
        System.out.println(home_friend2);

    }
}
