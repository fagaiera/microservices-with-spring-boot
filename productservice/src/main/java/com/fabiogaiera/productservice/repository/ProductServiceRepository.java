package com.fabiogaiera.productservice.repository;

import com.fabiogaiera.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductServiceRepository extends MongoRepository<Product, String> {

    @Query("{identifier: '?0'}")
    Product findByIdentifier(String identifier);

}