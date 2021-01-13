package com.fabiogaiera.athena.service;

import com.fabiogaiera.athena.dao.CustomerRepository;
import com.fabiogaiera.athena.model.Customer;
import com.fabiogaiera.athena.utility.CustomerIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public Customer getCustomer(Integer customerId) {
        //Retrieve customer by customerId
        return null;
    }

    public void newCustomer(Customer customer) {
        customer.setCustomerId(CustomerIdGenerator.generateCustomerId());
        customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public void modifyCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

}