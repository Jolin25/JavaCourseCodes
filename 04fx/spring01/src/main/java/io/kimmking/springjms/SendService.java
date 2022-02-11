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
    /**
     * 配置文件里面注入的JMSTemplate
     *
     * @author jrl
     * @date 2022/2/11
     */
    @Autowired
    JmsTemplate jmsTemplate;

    public void send(final Student user) {
        jmsTemplate.send("test.queue", new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(JSON.toJSONString(user));
            }
        });
    }
}