package com.ayshriv.springrestproj3.controller;

import com.ayshriv.springrestproj3.entity.Company;
import com.ayshriv.springrestproj3.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/customer-api")
public class CustomerRestController {

    @GetMapping("/getCustomer")
    public ResponseEntity<Customer> showCustomer() {
        Customer customer = new Customer();
        customer.setCno(1);
        customer.setCname("aysh");
        customer.setBillAmt(1000f);
        customer.setcAddress("bangalore");
        customer.setFriends(List.of("Abhay","Amitesh","Alok","Mayank","Abhiyuday"));
        customer.setNickNames(new String[]{"Rangbaz","chotu","lalla"});
        customer.setDob(LocalDateTime.now());
        customer.setPhoneNumbers(Set.of(1234567890L,1234567891L,1234567892L,1234567893L,1234567894L,1234567895L,1234567896L,1234567897L,1234567898L,1234567899L));
        customer.setCompany(new Company(1,"ayshriv","bangalore",10));
        customer.setIdDetails(Map.of("id1",1,"id2",2,"id3",3));
        customer.setIndian(true);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
