package com.fabiogaiera.billingservice.domain;

import lombok.Data;

@Data
public class BillingResponse {

    private Customer customer;

    private float amount;

}