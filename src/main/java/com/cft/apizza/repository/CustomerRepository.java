package com.cft.apizza.repository;

import com.cft.apizza.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM CUSTOMER WHERE NAME LIKE %:name%")
    List<Customer> findByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "SELECT C.* FROM CUSTOMER C LEFT JOIN ORDERS O ON C.ID_CUSTOMER = O.CUSTOMER WHERE O.CUSTOMER IS NULL")
    List<Customer> findCustomerNoOrder();

}
