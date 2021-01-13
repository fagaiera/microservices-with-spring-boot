package com.fabiogaiera.poseidon.domain;

import lombok.Data;

import java.util.List;

@Data
public class BillingRequest {

    private Integer customerId;

    private List<ProductIdentifierQuantity> productIdentifierQuantityList;

}