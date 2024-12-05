package com.cft.apizza.repository;

import com.cft.apizza.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailOrderRepository extends JpaRepository<OrderDetail, Integer> {

}
