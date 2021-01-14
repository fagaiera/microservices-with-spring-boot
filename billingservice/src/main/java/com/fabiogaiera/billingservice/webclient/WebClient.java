package com.fabiogaiera.billingservice.webclient;

import com.fabiogaiera.billingservice.domain.Customer;
import com.fabiogaiera.billingservice.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebClient {

    private RestTemplate restTemplate;

    public Product getProduct(String productIdentifier) {
        return restTemplate.getForObject("URL", Product.class);
    }

    public Customer getCustomer(Integer customerId) {
        return restTemplate.getForObject("URL", Customer.class);
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}