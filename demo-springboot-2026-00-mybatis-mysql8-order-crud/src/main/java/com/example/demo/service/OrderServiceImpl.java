
package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public Order create(Order order) {
        orderMapper.insert(order);
        return order;
    }

    public Order update(Order order) {
        orderMapper.update(order);
        return order;
    }

    public void delete(Long id) {
        orderMapper.deleteById(id);
    }

    public Order get(Long id) {
        return orderMapper.selectById(id);
    }

    public List<Order> list() {
        return orderMapper.selectAll();
    }
}
