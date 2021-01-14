package com.fabiogaiera.billingservice.controller;

import com.fabiogaiera.billingservice.domain.BillingRequest;
import com.fabiogaiera.billingservice.domain.BillingResponse;
import com.fabiogaiera.billingservice.service.CustomerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingGeneratorController {

    private CustomerProductService customerProductService;

    @PostMapping("/generatebill")
    public ResponseEntity<BillingResponse> generateBill(@RequestBody BillingRequest billingRequest) {

        BillingResponse billingResponse = new BillingResponse();

        billingResponse.setCustomer(customerProductService.getCustomerDetails(billingRequest.getCustomerId()));
        billingResponse.setAmount(customerProductService.getBillingAmount(billingRequest.getProductIdentifierQuantityList()));

        return new ResponseEntity<>(billingResponse, HttpStatus.CREATED);

    }

    @Autowired
    public void setPoseidonService(CustomerProductService customerProductService) {
        this.customerProductService = customerProductService;
    }

}