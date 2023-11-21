package com.ewa.project.serviceimpl;

import com.ewa.project.service.OrderService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewa.project.converter.OrderConverter;
import com.ewa.project.dao.OrderRepository;
import com.ewa.project.entity.Order;
import com.ewa.project.model.OrderDto;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderConverter.convertToOrderEntity(orderDto);
        order = orderRepository.save(order);
        return orderConverter.convertToOrderDto(order);
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
        return orderConverter.convertToOrderDto(order);
    }


    public OrderDto updateOrder(Long orderId, OrderDto orderDto) {
        Order existingOrder = orderRepository.findByOrderId(orderId);
        if (existingOrder == null) {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }

        Order updatedOrder = orderConverter.convertToOrderEntity(orderDto);
        updatedOrder.setOrderId(orderId);

        updatedOrder = orderRepository.save(updatedOrder);

        return orderConverter.convertToOrderDto(updatedOrder);
    }


    @Override
    public String deleteOrder(Long orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
        orderRepository.delete(order);
        return "Order with ID " + orderId + " has been deleted successfully.";
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> dtoList = new ArrayList<>();
        for (Order o : orders) {
            dtoList.add(orderConverter.convertToOrderDto(o));
        }
        return dtoList;
    }
}
