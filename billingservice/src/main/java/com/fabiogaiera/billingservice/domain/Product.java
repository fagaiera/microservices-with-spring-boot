package com.fabiogaiera.billingservice.domain;

import lombok.Data;

@Data
public class Product {

    private Integer productIdentifier;

    private String description;

    private float price;

}