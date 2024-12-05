package com.cft.apizza.controller;

import com.cft.apizza.entities.OrderDetail;
import com.cft.apizza.entities.Orders;
import com.cft.apizza.entities.Pizza;
import com.cft.apizza.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orden")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private DetailOrderService detailOrderService;

    @PostMapping
    public ResponseEntity<Orders> createOrden(@RequestBody Orders order) {
        // Guardar la orden sin detalles para asignar el ID generado
        Orders newOrder = orderService.saveOrder(order);

        int total = 0;

        // Procesar los detalles de la orden
        for (OrderDetail detail : order.getOrderDetails()) {
            detail.setOrder(newOrder); // Asociar el detalle con la orden
            Pizza pizza = pizzaService.getPizzaById(detail.getPizza().getId())
                    .orElseThrow(() -> new RuntimeException("Pizza no encontrada"));
            total += detail.getQuantity() * pizza.getPrice();
            detailOrderService.saveOrderDetails(detail); // Guardar cada detalle
        }

        // Asignar el total y guardar nuevamente la orden
        newOrder.setTotal(total);
        newOrder = orderService.saveOrder(newOrder);

        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

}
