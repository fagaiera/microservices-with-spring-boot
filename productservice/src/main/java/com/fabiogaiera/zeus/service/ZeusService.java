package com.fabiogaiera.zeus.service;

import com.fabiogaiera.zeus.model.Product;
import com.fabiogaiera.zeus.repository.ZeusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZeusService {

    private ZeusRepository zeusRepository;

    public Product getProduct(String identifier) {
        return zeusRepository.findByIdentifier(identifier);
    }

    public Product addProduct(Product product) {
        return zeusRepository.save(product);
    }

    // Bean initializer
    @Autowired
    public void setZeusRepository(ZeusRepository zeusRepository) {
        this.zeusRepository = zeusRepository;
    }

}
