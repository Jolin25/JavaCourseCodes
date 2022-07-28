package io.kimmking.javacourse.kafka.kimmking;

import io.kimmking.javacourse.kafka.Order;
// TODO_Joly: 为什么还要定义 Producer
public interface Producer {

    void send(Order order);

    void close();

    // add your interface method here

    // and then implement it

}
