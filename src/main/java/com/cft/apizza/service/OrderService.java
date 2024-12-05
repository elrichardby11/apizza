package com.cft.apizza.service;

import com.cft.apizza.entities.Orders;
import com.cft.apizza.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService{

    @Autowired
    private OrderRepository orderRepository;

    public Orders saveOrder(Orders order) {
        if (order.getTotal() == null) {
            order.setTotal(0);
        }
        return orderRepository.save(order);
    }

}
