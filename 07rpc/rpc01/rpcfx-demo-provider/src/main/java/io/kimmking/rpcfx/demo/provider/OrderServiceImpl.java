package io.kimmking.rpcfx.demo.provider;

import io.kimmking.rpcfx.demo.api.Order;
import io.kimmking.rpcfx.demo.api.OrderService;
/**
 * 服务提供者的服务
 * @author Joly
 * @date 2022/6/22
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "JOLY's ORDER:" + System.currentTimeMillis(), 9.9f);
    }
}
