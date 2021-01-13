package com.fabiogaiera.poseidon.service;

import com.fabiogaiera.poseidon.domain.Customer;
import com.fabiogaiera.poseidon.domain.Product;
import com.fabiogaiera.poseidon.domain.ProductIdentifierQuantity;
import com.fabiogaiera.poseidon.webclient.PoseidonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoseidonService {

    private PoseidonClient poseidonClient;

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
        return poseidonClient.getProduct(productIdentifier);
    }

    @Autowired
    public void setPoseidonClient(PoseidonClient poseidonClient) {
        this.poseidonClient = poseidonClient;
    }

}