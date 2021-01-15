package com.fabiogaiera.billingservice.service;

import com.fabiogaiera.billingservice.domain.Customer;
import com.fabiogaiera.billingservice.domain.Product;
import com.fabiogaiera.billingservice.webclient.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomerProductService {

    private WebClient webClient;

    public float getBillingAmount(Map<String, Integer> productIdentifierQuantityList) {

        float billingAmount = 0f;

        for (Map.Entry<String, Integer> entry : productIdentifierQuantityList.entrySet()) {
            Product product = getProductDetails(entry.getKey());
            billingAmount = billingAmount + (product.getPrice() * (entry.getValue()));
        }

        return billingAmount;

    }

    public Customer getCustomerDetails(Integer customerId) {
        return webClient.getCustomer(customerId);
    }

    public Product getProductDetails(String productIdentifier) {
        return webClient.getProduct(productIdentifier);
    }

    @Autowired
    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

}