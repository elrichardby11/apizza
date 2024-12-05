package com.cft.apizza.service;

import com.cft.apizza.entities.OrderDetail;
import com.cft.apizza.repository.DetailOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailOrderService {

    @Autowired
    private DetailOrderRepository detailOrderRepository;

    public void saveOrderDetails(OrderDetail orderDetail) {
        detailOrderRepository.save(orderDetail);
    }

}
