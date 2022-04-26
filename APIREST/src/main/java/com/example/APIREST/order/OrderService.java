package com.example.APIREST.order;

import com.example.APIREST.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> getOrders(List<User> users){
        return orderRepository.findAll();
    }


    public void addNewOrder(Order order) {
        System.out.println(order);
    }

    void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    void update(Order order) {
        orderRepository.save(order);
    }

    Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }
}
