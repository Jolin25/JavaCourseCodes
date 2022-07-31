package io.kimmking.mq.rocket;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
/**
 * 消费者
 * @author Joly
 * @date 2022/7/29
 */
@Component
@RocketMQMessageListener(consumerGroup = "test1", topic = "test-k1") // 制定了消费者组和要接受的topic
public class StringConsumerDemo implements RocketMQListener<String> { // 这里的 String 是确认了泛型，这个泛型要和onMessage（）的参数类型一样
    // 没有返回值，所以这个消息是消费掉了就结束了  【这里实现的是RocketMQListener】
    @Override
    public void onMessage(String message) { // one way
        System.out.println(this.getClass().getName() + " -> " + message);
    }
}
