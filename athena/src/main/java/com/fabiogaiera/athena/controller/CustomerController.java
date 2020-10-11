package com.fabiogaiera.athena.controller;

import com.fabiogaiera.athena.model.Customer;
import com.fabiogaiera.athena.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping
public class CustomerController {

    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Customer> retrieveCustomer(Long identifier) {

        Customer customer = customerService.getCustomer(identifier);
        if (Objects.isNull(customer)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

}