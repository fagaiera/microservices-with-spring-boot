package com.fabiogaiera.productservice.service;

import com.fabiogaiera.productservice.model.Product;
import com.fabiogaiera.productservice.repository.ProductServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogService {

    private ProductServiceRepository productServiceRepository;

    public Product getProduct(String identifier) {
        return productServiceRepository.findByIdentifier(identifier);
    }

    public Product addProduct(Product product) {
        return productServiceRepository.save(product);
    }

    // Bean initializer
    @Autowired
    public void setProductServiceRepository(ProductServiceRepository productServiceRepository) {
        this.productServiceRepository = productServiceRepository;
    }

}