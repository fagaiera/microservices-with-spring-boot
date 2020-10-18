package com.fabiogaiera.athena.controller;

import com.fabiogaiera.athena.model.Customer;
import com.fabiogaiera.athena.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@RestController
@RequestMapping
public class CustomerController {

    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Customer> getCustomer(@Valid
                                                @NotNull Integer customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (Objects.isNull(customer)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> newCustomer(@RequestBody
                                            @Valid
                                            @NotNull Customer customer) {
        //TODO check if customerId exists before.
        customerService.newCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@Valid
                                               @NotNull Integer customerId) {
        //TODO pass this logic to the service.
        Customer customer = customerService.getCustomer(customerId);
        if (Objects.isNull(customer)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.deleteCustomer(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> modifyCustomer(@RequestBody
                                               @Valid
                                               @NotNull Customer customer) {
        //TODO pass this logic to the service.
        Customer customerFound = customerService.getCustomer(customer.getCustomerId());
        if (Objects.isNull(customerFound)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.modifyCustomer(customerFound);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

}