package com.example.APIREST.order;

import com.example.APIREST.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController<users> {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public void newOrder(@RequestBody Order order){
        orderService.addNewOrder(order);
    }

    @GetMapping("/order/{id}")
    public Order getOrders(@PathVariable Long id){
        Optional<Order> orderOptional = orderService.findById(id);

        if(orderOptional.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );

        return orderOptional.get();

    }
  /*  @GetMapping("/orders/{idUser}")
    public List<User> users=new ArrayList<>(){
        for(User user : users){
            orderService.getOrders(users);

        }
    };*/

    @PutMapping("/order/{id}")
    public void updateOrder(@RequestBody Order order, @PathVariable Long id){
        Order orderUpdate=orderService.findById(id).get();
        orderUpdate.setAddress(order.getAddress());
      //  orderUpdate.setProducts(order.getProducts());
        orderUpdate.setDate(order.getDate());
        orderUpdate.setId(order.getId());
        orderUpdate.setValid(order.isValid());

        orderService.update(orderUpdate);
    }

    @PatchMapping("/order/{id}")

    @DeleteMapping("/order/{id}")
    public void deleteById(@PathVariable Long id){
        orderService.deleteById(id);
    }
}
