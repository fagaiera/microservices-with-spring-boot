package com.fabiogaiera.billingservice.webclient;

import com.fabiogaiera.billingservice.domain.Customer;
import com.fabiogaiera.billingservice.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebClient {

    private RestTemplate restTemplate;

    @Value("${url.productservice}")
    private String urlProductService;

    @Value("${url.customerservice}")
    private String urlCustomerService;

    public Product getProduct(String productIdentifier) {
        return restTemplate.getForObject(urlProductService, Product.class);
    }

    public Customer getCustomer(Integer customerId) {
        return restTemplate.getForObject(urlCustomerService, Customer.class);
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}