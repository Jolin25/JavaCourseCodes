package io.kimmking.springjms;

import com.alibaba.fastjson.JSON;
import io.kimmking.spring01.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 使用JMSTemplate来发送消息
 *
 * @author jrl
 * @date 2022/2/11
 */
@Component
public class SendService {

    @Autowired
    JmsTemplate jmsTemplate;
    // TODO_Joly:final？
    public void send(final Student user) {
        jmsTemplate.send("test.queue", new MessageCreator() {
            // TODO_Joly:为什么这里要限定Session（Java程序和JMS服务间的Session）
            public Message createMessage(Session session) throws JMSException {
                // 把user序列化成json格式
                return session.createObjectMessage(JSON.toJSONString(user));
            }
        });
    }
}