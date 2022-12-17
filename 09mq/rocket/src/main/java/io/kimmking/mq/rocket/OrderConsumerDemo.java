package io.kimmking.mq.rocket;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Component;

/**
 * @author Joly
 */
@Component
@RocketMQMessageListener(consumerGroup = "test2", topic = "test-k2")
public class OrderConsumerDemo implements RocketMQReplyListener<Order, String> { // 这里的 Order 是确认了泛型，这个泛型要和 onMessage（）的参数类型一样
    // 消费完了以后，返回个 String 【这里实现的是 RocketMQReplyListener 】
    @Override
    public String onMessage(Order order) { // request-response
        System.out.println(this.getClass().getName() + " -> " + order);
        return "Process&Return [" + order + "].";
    }
}
