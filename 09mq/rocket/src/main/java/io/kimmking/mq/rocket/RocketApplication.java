package io.kimmking.mq.rocket;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 生产者
 *
 * @author jrl
 * @date 2022/12/9
 */
// CommandLineRunner 和 ApplicationRunner 的作用是一样的，可以运行 run （） 方法
@SpringBootApplication
public class RocketApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RocketApplication.class, args);
    }

    /*Spring Boot 直接给配好了 Template*/
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void run(String... args) throws Exception {

        String topic = "test-k1";
        // 1. 同步发送消息
        // 简单版
        SendResult sendResult = rocketMQTemplate.syncSend(topic, "Hello, World!" + System.currentTimeMillis());
        System.out.printf("syncSend1 to topic %s sendResult=%s %n", topic, sendResult);
        // 复杂版（使用 MessageBuilder 来封装消息，可以在里面设置消息头：消息的格式等）
        sendResult = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(
                new Order(System.currentTimeMillis(), "CNY2USD", 0.1501d))
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE).build());
        System.out.printf("syncSend1 to topic %s sendResult=%s %n", topic, sendResult);

        String topic1 = "test-k2";
        //2. 版本一：异步发送并且接受消息结果
        String result = rocketMQTemplate.sendAndReceive(topic1, new Order(System.currentTimeMillis(), "CNY2USD", 0.1502d), String.class);
        System.out.println(" consumer result => " + result);
        //版本二：异步发送消息，需要设置callback来处理消息发送情况的结果（回调处理）
        rocketMQTemplate.asyncSend(topic1, new Order(System.currentTimeMillis(), "CNY2USD", 0.1502d), new SendCallback() {
            @Override
            public void onSuccess(SendResult result) {
                System.out.printf("async onSucess SendResult=%s %n", result);
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.printf("async onException Throwable=%s %n", throwable);
            }

        });


    }

}
