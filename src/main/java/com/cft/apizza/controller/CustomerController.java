package com.cft.apizza.controller;

import com.cft.apizza.entities.Customer;
import com.cft.apizza.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        if (!customerService.existsCustomer(customer.getId())) {
            Customer newCustomer = customerService.save(customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        }
        Customer newCustomer = customerService.save(customer);
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Customer>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(customerService.findByName(name));
    }

    @GetMapping("/no-order")
    public ResponseEntity<List<Customer>> findCustomerNoOrder() {
        return ResponseEntity.ok(customerService.findCustomerNoOrder());
    }

}
