
package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Order API")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @Operation(summary = "Create order")
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @PutMapping
    @Operation(summary = "Update order")
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete order")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by id")
    public Order get(@PathVariable Long id) {
        return orderService.get(id);
    }

    @GetMapping
    @Operation(summary = "List orders")
    public List<Order> list() {
        return orderService.list();
    }
}
