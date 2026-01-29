
package com.example.demo.mapper;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int insert(Order order);
    int update(Order order);
    int deleteById(Long id);
    Order selectById(Long id);
    List<Order> selectAll();
}
