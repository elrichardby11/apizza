package com.cft.apizza.controller;

import com.cft.apizza.entities.*;
import com.cft.apizza.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private DetailOrderService detailOrderService;

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Orders> createOrden(@RequestBody Orders order) {
        Orders newOrder = orderService.saveOrder(order);

        // Validar si el cliente existe
        if (!customerService.existsCustomer(order.getCustomer().getId())) {
            return ResponseEntity.badRequest().build();
        }

        int total = 0;

        for (OrderDetail detail : order.getOrderDetails()) {
            detail.setOrder(newOrder);
            Pizza pizza = pizzaService.getPizzaById(detail.getPizza().getId())
                    .orElseThrow(() -> new RuntimeException("Pizza no encontrada"));
            total += detail.getQuantity() * pizza.getPrice();
            detailOrderService.saveOrderDetails(detail);
        }

        newOrder.setTotal(total);
        newOrder = orderService.saveOrder(newOrder);

        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

}
