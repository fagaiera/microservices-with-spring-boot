package com.fabiogaiera.poseidon.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillingResponse {

    private Customer customer;

    private BigDecimal amount;

}