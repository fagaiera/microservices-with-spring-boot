package com.fabiogaiera.billingservice.domain;

import lombok.Data;

import java.util.List;

@Data
public class BillingRequest {

    private Integer customerIdentifier;

    private List<ProductIdentifierQuantity> productIdentifierQuantityList;

}