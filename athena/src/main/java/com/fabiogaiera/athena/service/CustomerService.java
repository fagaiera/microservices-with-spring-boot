package com.fabiogaiera.athena.service;

import com.fabiogaiera.athena.dao.CustomerRepository;
import com.fabiogaiera.athena.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public Customer getCustomer(Long identifier) {

        Optional<Customer> optionalCustomer = customerRepository.findById(identifier);
        return optionalCustomer.orElse(null);

    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

}