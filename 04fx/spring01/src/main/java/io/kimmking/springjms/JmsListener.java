package io.kimmking.springjms;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * 监听器
 *
 * @author jrl
 * @date 2022/2/11
 */
@Component(value = "jmsListener")
public class JmsListener implements MessageListener {

    //收到信息时的动作
    @Override
    public void onMessage(Message m) {
        ObjectMessage message = (ObjectMessage) m;
        try {
            /* 业务处理：可以在这里调用业务处理方法*/
            System.out.println("收到的信息receive message：" + message.getObject());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}