package io.kimmking.mq.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
/**
 * 消息生产者
 * @author Joly
 * @date 2022/7/26
 */
@Component
@Slf4j
public class MessageProducer implements RabbitTemplate.ConfirmCallback {

    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    // 因为 向单例的MessageProducer 中注入原型RabbitTemplate的话，就不会是原型了，因为只注入一次，所以RabbitTemplate也只会有一个
    private RabbitTemplate rabbitTemplate;
    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    public void sendMessage(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        // mq 自动把 EXCHANGE A 给创建了
        //把消息放入ROUTINGKEY_B对应的队列当中去，对应的是队列B【看的是ROUTINGKEY】
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_B, content, correlationId);
    }
    /**
     * 回调（消息发送出去后，会回调生产者，来通知生产者，消费情况）
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调id:" + correlationData);
        if (ack) {
            log.info("消息成功消费!!!!!" + correlationData);
        } else {
            log.info("消息消费失败:" + cause + correlationData);
        }
    }
}