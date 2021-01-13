package com.fabiogaiera.billingservice.service;

import com.fabiogaiera.billingservice.domain.Customer;
import com.fabiogaiera.billingservice.domain.Product;
import com.fabiogaiera.billingservice.domain.ProductIdentifierQuantity;
import com.fabiogaiera.billingservice.webclient.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerProductService {

    private WebClient webClient;

    public Customer getCustomerDetails(Integer customerId) {
        return null;
    }

    public float getBillingAmount(List<ProductIdentifierQuantity> productIdentifierQuantityList) {

        float billingAmount = 0f;

        for (ProductIdentifierQuantity productIdentifierQuantity : productIdentifierQuantityList) {
            Product product = getProductDetails(productIdentifierQuantity.getProductIdentifier());
            billingAmount = billingAmount + (product.getPrice() * (productIdentifierQuantity.getQuantity()));
        }

        return billingAmount;

    }

    public Product getProductDetails(String productIdentifier) {
        return webClient.getProduct(productIdentifier);
    }

    @Autowired
    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

}