package com.fabiogaiera.productservice.controller;

import com.fabiogaiera.productservice.model.Product;
import com.fabiogaiera.productservice.service.ProductCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ProductServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class);

    private ProductCatalogService productCatalogService;

    @GetMapping("/getproduct")
    public ResponseEntity<Product> getProduct(@RequestParam("identifier") String identifier) {

        Product product = productCatalogService.getProduct(identifier);
        logger.info("Product retrieved: {}", product);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PostMapping("/addproduct")
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {

        product.setIdentifier(UUID.randomUUID().toString());
        Product productToBeAdded = productCatalogService.addProduct(product);
        logger.info("Product added: {}", productToBeAdded);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Void> modifyProduct() {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct() {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    // Bean initializer
    @Autowired
    public void setProductCatalogService(ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

}