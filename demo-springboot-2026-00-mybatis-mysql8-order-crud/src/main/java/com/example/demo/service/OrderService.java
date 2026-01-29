
package com.example.demo.service;

import com.example.demo.entity.Order;
import java.util.List;

public interface OrderService {
    Order create(Order order);
    Order update(Order order);
    void delete(Long id);
    Order get(Long id);
    List<Order> list();
}
