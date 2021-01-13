package com.fabiogaiera.poseidon.service;

import com.fabiogaiera.poseidon.domain.Customer;
import com.fabiogaiera.poseidon.domain.Product;
import com.fabiogaiera.poseidon.domain.ProductQuantity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoseidonService {

    public Customer getCustomerDetails(Integer customerId) {
        return null;
    }

    public float getBillingAmount(List<ProductQuantity> productQuantityList) {

        float billingAmount = 0f;

        for (ProductQuantity productQuantity : productQuantityList) {
            Product product = getProduct(productQuantity.getProductIdentifier());
            billingAmount = billingAmount + (product.getPrice() * (productQuantity.getQuantity()));
        }

        return billingAmount;

    }

    public Product getProduct(String productIdentifier) {
        return null;
    }

}