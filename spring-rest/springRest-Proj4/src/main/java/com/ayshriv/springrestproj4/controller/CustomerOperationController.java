package com.ayshriv.springrestproj4.controller;

import com.ayshriv.springrestproj4.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationController {

    @GetMapping(value = "/report",produces = "application/xml")
    public ResponseEntity<Customer> getCustomerReport() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Ayshriv");
        customer.setAddress("Hyderabad");
        customer.setEmail("aB7tS@example.com");
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
