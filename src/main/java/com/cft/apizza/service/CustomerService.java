package com.cft.apizza.service;

import com.cft.apizza.entities.Customer;
import com.cft.apizza.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        this.customerRepository.save(customer);
        return customer;
    }

    public Boolean existsCustomer(Integer id) {
        if (id == null) {
            return false; // O manejar el caso de otra manera
        }
        return this.customerRepository.existsById(id);
    }

    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    public List<Customer> findCustomerNoOrder() {
        return customerRepository.findCustomerNoOrder();
    }


}
