package com.fabiogaiera.poseidon.service;

import com.fabiogaiera.poseidon.domain.Customer;
import com.fabiogaiera.poseidon.domain.ProductQuantity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PoseidonService {

    public Customer getCustomerDetails(Integer customerId) {
        return null;
    }

    public BigDecimal getBillingAmount(List<ProductQuantity> productQuantityList) {
        return null;
    }

}