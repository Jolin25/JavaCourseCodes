package io.kimmking.spring02;

import io.kimmking.aop.ISchool;
import io.kimmking.spring01.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1.演示：AOP
 * 2.演示：Bean
 *  2.1 向context中放入bean
 *      方式一：xml配置文件（<bean>）
 *      方式二：注解（Component注解，Controller、Service、Repository等注解）
 *  2.2 获取bean
 *      方式一：根据xml中的bean的id获取
 *      方式二：根据xml或者注解方法注入的bean的类名获取
 * @author jrl
 * @date 2022/4/6
 */
public class SpringDemo01 {
    public static void main(String[] args) {
        /** knowledge point:
         * spring加载xml配置文件，生成context和启动相关配置
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Student student123 = context.getBean(Student.class);
        /** knowledge point:
         * spring 根据 XML配置文件中的bean的id获取bean
         */
        Student student123 = (Student) context.getBean("student123");
        System.out.println(student123.toString());

        student123.print();

        Student student100 = (Student) context.getBean("student100");
        //  println本来就要调用toString的--->对，没错，下面两行输出的内容式一样的
        System.out.println("student100.toString()====>" + student100.toString());
        System.out.println("student100           ====>" + student100);

        student100.print();
        Klass class1 = context.getBean(Klass.class);
        System.out.println(class1);
        System.out.println("Klass对象AOP代理后的实际类型：" + class1.getClass());
        System.out.println("Klass对象AOP代理后的实际类型是否是Klass子类：" + (class1 instanceof Klass));

        ISchool school = context.getBean(ISchool.class);
        System.out.println(school);
        System.out.println("ISchool接口的对象AOP代理后的实际类型：" + school.getClass());
        //  DONE_Joly:此为何意 ---> 说明这接口拿到的实现对象是同一个代理对象
        ISchool school1 = context.getBean(ISchool.class);
        System.out.println(school1);
        System.out.println("ISchool接口的对象AOP代理后的实际类型：" + school1.getClass());

        school1.ding();

        class1.dong(); 

        System.out.println("   context.getBeanDefinitionNames() ===>> " + String.join(",", context.getBeanDefinitionNames()));

        Student s101 = (Student) context.getBean("s101");
        if (s101 != null) {
            System.out.println(s101);
        }
        Student s1125 = (Student) context.getBean("s1125");
        if (s1125 != null) {
            System.out.println(s1125);
        }
        Student s102 = (Student) context.getBean("s102");
        if (s102 != null) {
            System.out.println(s102);
        }
    }
}
