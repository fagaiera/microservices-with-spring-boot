package com.fabiogaiera.poseidon.controller;

import com.fabiogaiera.poseidon.service.Customer;
import lombok.Data;

@Data
public class BillingResponse {

    private Customer customer;

}