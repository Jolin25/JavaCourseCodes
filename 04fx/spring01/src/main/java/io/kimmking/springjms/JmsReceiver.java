package io.kimmking.springjms;

import io.kimmking.spring01.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class JmsReceiver {

    public static void main(String[] args) throws IOException {
        /*
         * 拉起配置文件 加不加classpath：都可以 （classpath：springjms-receiver.xml）
         * */
        ApplicationContext context = new ClassPathXmlApplicationContext("springjms-receiver.xml");
        // TODO_Joly:这么写的目的只是为了不让程序挂掉，为了能够接收到消息是吗
        System.in.read();

        System.out.println("send successfully, please visit http://localhost:8161/admin to see it");
    }

}
