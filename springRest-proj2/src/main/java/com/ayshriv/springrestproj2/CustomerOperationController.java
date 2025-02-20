package com.ayshriv.springrestproj2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationController {

    @GetMapping("/report")
    public ResponseEntity<String> showCustomersReport()
    {
        System.out.println("CustomerOperationController.showCustomersReport()");
        return new ResponseEntity<>("Report operation", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer()
    {
        System.out.println("CustomerOperationController.registerCustomer()");
        return new ResponseEntity<>("Registration operation", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer()
    {
        System.out.println("CustomerOperationController.updateCustomer()");
        return new ResponseEntity<>("update operation", HttpStatus.OK);
    }

    @PatchMapping("/pupdate")
    public ResponseEntity<String> updateCustomerEmail()
    {
        System.out.println("CustomerOperationController.updateCustomerEmail()");
        return new ResponseEntity<>("update email operation", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer()
    {
        System.out.println("CustomerOperationController.deleteCustomer()");
        return new ResponseEntity<>("delete operation", HttpStatus.OK);
    }



}
