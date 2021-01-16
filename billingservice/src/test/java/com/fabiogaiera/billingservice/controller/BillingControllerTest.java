package com.fabiogaiera.billingservice.controller;

import com.fabiogaiera.billingservice.domain.BillingRequest;
import com.fabiogaiera.billingservice.domain.BillingResponse;
import com.fabiogaiera.billingservice.domain.Customer;
import com.fabiogaiera.billingservice.service.CustomerProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BillingControllerTest {

    @InjectMocks
    private BillingController billingController;

    @Mock
    private CustomerProductService customerProductService;

    @Test
    public void testGenerateBill() {

        BillingRequest billingRequest = new BillingRequest();
        billingRequest.setCustomerIdentifier(123456);
        billingRequest.setProductIdentifierQuantityMap(new HashMap<>());

        Customer customer = new Customer();
        customer.setName("Fabio");
        customer.setSurname("Rossi");

        float amount = 123.45f;

        // Mocks
        when(customerProductService.getCustomerDetails(billingRequest.getCustomerIdentifier())).thenReturn(customer);
        when(customerProductService.getBillingAmount(billingRequest.getProductIdentifierQuantityMap())).thenReturn(amount);

        // Call to service
        ResponseEntity<BillingResponse> responseEntity = billingController.generateBill(billingRequest);

        // Assertions
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(customer, Objects.requireNonNull(responseEntity.getBody()).getCustomer());
        assertEquals(amount, responseEntity.getBody().getAmount(), 0.0005);

    }

}