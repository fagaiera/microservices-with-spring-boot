package com.fabiogaiera.billingservice.domain;

import lombok.Data;

@Data
public class Product {

    private Integer productId;

    private String description;

    private float price;

}