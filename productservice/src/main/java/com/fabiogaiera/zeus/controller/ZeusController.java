package com.fabiogaiera.zeus.controller;

import com.fabiogaiera.zeus.model.Product;
import com.fabiogaiera.zeus.service.ZeusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ZeusController {

    private static final Logger logger = LoggerFactory.getLogger(ZeusController.class);

    private ZeusService zeusService;

    @GetMapping("/getproduct")
    public ResponseEntity<Product> getProduct(@RequestParam("identifier") String identifier) {

        Product product = zeusService.getProduct(identifier);
        logger.info("Product retrieved: {}", product);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PostMapping("/addproduct")
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {

        product.setIdentifier(UUID.randomUUID().toString());
        Product productToBeAdded = zeusService.addProduct(product);
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
    public void setZeusService(ZeusService zeusService) {
        this.zeusService = zeusService;
    }

}