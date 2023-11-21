package com.ewa.project.controller;

import com.ewa.project.model.OrderDto;
import com.ewa.project.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
        OrderDto order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto) {
        OrderDto createdOrder = orderService.createOrder(orderDto);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    //error
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@Valid @PathVariable Long orderId, @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderService.updateOrder(orderId, orderDto);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
    	return orderService.deleteOrder(orderId);    
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
