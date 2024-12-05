package com.cft.apizza.repository;

import com.cft.apizza.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

    @Query(nativeQuery = true, value = "SELECT * FROM ORDERS WHERE CUSTOMER = :id")
    List<Orders> findByCustomerId (@Param("id") Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM ORDERS ORDER BY TOTAL DESC;")
    List<Orders> totalDesc();

    @Query(nativeQuery = true, value = "SELECT * FROM ORDERS WHERE TOTAL = :date;")
    List<Orders> findByDate(@Param("date") String date);

    @Query(nativeQuery = true, value = "SELECT * FROM ORDERS ORDER BY TOTAL;")
    List<Orders> findByTotal(@Param("total") Integer total);




}