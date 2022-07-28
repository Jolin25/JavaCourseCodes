package io.kimmking.javacourse.kafkademo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
        KafkaProducer kafkaProducer = new KafkaProducer<>();
        kafkaProducer.flush();
    }

}
