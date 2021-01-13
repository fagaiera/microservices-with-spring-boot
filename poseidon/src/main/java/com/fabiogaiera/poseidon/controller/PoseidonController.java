package com.fabiogaiera.poseidon.controller;

import com.fabiogaiera.poseidon.domain.BillingRequest;
import com.fabiogaiera.poseidon.domain.BillingResponse;
import com.fabiogaiera.poseidon.service.PoseidonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoseidonController {

    private PoseidonService poseidonService;

    @PostMapping("/generatebill")
    public ResponseEntity<BillingResponse> generateBill(@RequestBody BillingRequest billingRequest) {

        BillingResponse billingResponse = new BillingResponse();

        billingResponse.setCustomer(poseidonService.getCustomerDetails(billingRequest.getCustomerId()));
        billingResponse.setAmount(poseidonService.getBillingAmount(billingRequest.getProductIdentifierQuantityList()));

        return new ResponseEntity<>(billingResponse, HttpStatus.CREATED);

    }

    @Autowired
    public void setPoseidonService(PoseidonService poseidonService) {
        this.poseidonService = poseidonService;
    }

}