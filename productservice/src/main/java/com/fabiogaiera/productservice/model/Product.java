package com.fabiogaiera.productservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {

    @Id
    private String id;

    @Indexed(unique = true)
    private String identifier;

    private String name;

    private String description;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal price;

}