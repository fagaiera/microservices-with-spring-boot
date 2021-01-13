package com.fabiogaiera.poseidon.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private Integer productId;

    private String description;

    private BigDecimal price;

}