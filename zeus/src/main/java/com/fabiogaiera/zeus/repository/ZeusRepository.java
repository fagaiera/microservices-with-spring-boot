package com.fabiogaiera.zeus.repository;

import com.fabiogaiera.zeus.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ZeusRepository extends MongoRepository<Product, String> {

    @Query("{identifier: '?0'}")
    Product findByIdentifier(String identifier);

}