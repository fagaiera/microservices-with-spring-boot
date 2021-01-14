package com.fabiogaiera.customer.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private Integer customerId;

    private String name;

    private String surname;

}