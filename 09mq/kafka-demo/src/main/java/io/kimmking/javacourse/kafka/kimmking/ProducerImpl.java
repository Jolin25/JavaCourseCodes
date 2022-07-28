package io.kimmking.javacourse.kafka.kimmking;

import io.kimmking.javacourse.kafka.Order;

import com.alibaba.fastjson.JSON;
import kafka.common.KafkaException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerImpl implements Producer {
    private Properties properties;
    private KafkaProducer<String, String> producer;
    private final String topic = "order-test1";

    /**
     * 配置参数，设置发送给哪个消息中间件的哪个destination（topic）
     *
     * @param
     * @return
     * @date 2022/7/23
     */
    public ProducerImpl() {
        properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
//        properties.put("queue.enqueue.timeout.ms", -1);
//        properties.put("enable.idempotence", true);
//        properties.put("transactional.id", "transactional_1");
//        properties.put("acks", "all");
//        properties.put("retries", "3");
//        properties.put("max.in.flight.requests.per.connection", 1);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String, String>(properties);
        //producer.initTransactions();
    }

    /**
     * 用户定义了 消息发送的事务、消息失败等情况
     *
     * @param
     * @return
     * @date 2022/7/23
     */
    @Override
    public void send(Order order) {
        try {
            // 这是消息的事务，开启
            //producer.beginTransaction();
            // 指定发送给哪个 topic （destination）
            ProducerRecord record = new ProducerRecord(topic, order.getId().toString(), JSON.toJSONString(order));
            producer.send(record, (metadata, exception) -> {
//                这里应该是异常处理，如果消息发送失败了之类的
//                if (exception != null) {
//                    producer.abortTransaction();
//                    throw new KafkaException(exception.getMessage() + " , data: " + record);
//                }
            });
            // 这是消息的事务，提交
            //producer.commitTransaction();

        } catch (Throwable e) {
            //producer.abortTransaction();
        }
        //System.out.println("************" + json + "************");
    }

    @Override
    public void close() {
        producer.close();
    }
}