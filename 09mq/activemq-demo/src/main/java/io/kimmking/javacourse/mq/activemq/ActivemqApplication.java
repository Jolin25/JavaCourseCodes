package io.kimmking.javacourse.mq.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;


//@SpringBootApplication
public class ActivemqApplication {

    public static void main(String[] args) {

        // 定义Destination ,topic（destination里面有topic和queue）
        Destination destination = new ActiveMQTopic("test.topic");
        // queue
        Destination destinationQueue = new ActiveMQQueue("test.queue");

        testDestination(destination);
        testDestinationQueue(destinationQueue);
        //SpringApplication.run(ActivemqApplication.class, args);
    }

    /**
     * 对于queue的消息生产和消费
     *
     * @param
     * @return
     * @date 2022/7/21
     */
    private static void testDestinationQueue(Destination destinationQueue) {
        try {
            //创建连接
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://47.115.148.27:61616");
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();
            //创建会话
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建消费者
            MessageConsumer consumer = session.createConsumer(destinationQueue);
            MessageListener messageListener = new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        // 打印所有的消息内容
                        // Thread.sleep();
                        System.out.println(" => receive from " + destinationQueue.toString() + ": " + message);
                        // message.acknowledge(); // 前面所有未被确认的消息全部都确认。

                    } catch (Exception e) {
                        e.printStackTrace(); // 不要吞任何这里的异常，
                    }
                }
            };
            // 其实就是设置消费者收到消息之后要做什么（监听器）
            consumer.setMessageListener(messageListener);
            //创建生产者
            MessageProducer producer = session.createProducer(destinationQueue);
            Message message = session.createTextMessage("hello");
            producer.send(message);

            //关闭资源
            session.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void testDestination(Destination destination) {
        try {
            // 创建连接和会话
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://47.115.148.27:61616");
            ActiveMQConnection conn = (ActiveMQConnection) factory.createConnection();
            conn.start();
            // Session.AUTO_ACKNOWLEDGE 自动确认
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // 创建消费者
            MessageConsumer consumer = session.createConsumer(destination);
            final AtomicInteger count = new AtomicInteger(0);
            // JMS 监听器
            MessageListener listener = new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        // 打印所有的消息内容
                        // Thread.sleep();
                        System.out.println(count.incrementAndGet() + " => receive from " + destination.toString() + ": " + message);
                        // message.acknowledge(); // 前面所有未被确认的消息全部都确认。

                    } catch (Exception e) {
                        e.printStackTrace(); // 不要吞任何这里的异常，
                    }
                }
            };
            // 绑定消息监听器
            consumer.setMessageListener(listener);

            //consumer.receive()

            // 创建生产者，生产100个消息
            MessageProducer producer = session.createProducer(destination);
            int index = 0;
            while (index++ < 100) {
                TextMessage message = session.createTextMessage(index + " message.");
                producer.send(message);
            }
            // TODO_Joly: 是为了等消费者可以把所有消息都消费完吗
            Thread.sleep(20000);
            session.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
