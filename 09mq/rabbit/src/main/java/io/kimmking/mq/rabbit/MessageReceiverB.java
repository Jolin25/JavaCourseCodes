package io.kimmking.mq.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * 消费者B
 * @author Joly
 * @date 2022/7/26
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_B) // 设定消费者要消费的队列
@Slf4j
public class MessageReceiverB {

    @RabbitHandler
    public void process(String content) {
        log.info("接收处理队列B当中的消息： " + content);
    }

}