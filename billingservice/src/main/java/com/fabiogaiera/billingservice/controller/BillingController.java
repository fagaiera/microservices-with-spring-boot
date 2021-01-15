package com.fabiogaiera.billingservice.controller;

import com.fabiogaiera.billingservice.domain.BillingRequest;
import com.fabiogaiera.billingservice.domain.BillingResponse;
import com.fabiogaiera.billingservice.service.CustomerProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class BillingController {

    private CustomerProductService customerProductService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerProductService.class);


    @PostMapping("/generatebill")
    public ResponseEntity<BillingResponse> generateBill(@RequestBody @Valid @NotNull BillingRequest billingRequest) {

        logger.info(String.format("%s%s", "Start generating bill for customer identifier ", billingRequest.getCustomerIdentifier()));

        BillingResponse billingResponse = new BillingResponse();
        billingResponse.setCustomer(customerProductService.getCustomerDetails(billingRequest.getCustomerIdentifier()));
        billingResponse.setAmount(customerProductService.getBillingAmount(billingRequest.getProductIdentifierQuantityMap()));

        logger.info(String.format("%s%s", "End generating bill for customer identifier ", billingRequest.getCustomerIdentifier()));

        return new ResponseEntity<>(billingResponse, HttpStatus.CREATED);

    }

    @Autowired
    public void setPoseidonService(CustomerProductService customerProductService) {
        this.customerProductService = customerProductService;
    }

}