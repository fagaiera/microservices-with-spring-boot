package com.fabiogaiera.billingservice.domain;

import lombok.Data;

import java.util.List;

@Data
public class BillingRequest {

    private Integer customerId;

    private List<ProductIdentifierQuantity> productIdentifierQuantityList;

}