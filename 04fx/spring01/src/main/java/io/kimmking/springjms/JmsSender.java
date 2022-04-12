package io.kimmking.springjms;

import io.kimmking.spring01.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JmsSender {

    public static void main(String[] args) {
        Student student2 = Student.create();
        // 拉起配置文件  加不加classpath：都可以
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springjms-sender.xml");
        // 调用jmsTemplate
        SendService sendService = (SendService) context.getBean("sendService");

        sendService.send(student2);
        // DONE_Joly: http://localhost:8161/admin  8161是什么--->是activemq的访问地址
        System.out.println("send successfully, please visit http://47.115.148.27:8161/admin to see it");
    }

}
