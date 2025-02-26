package com.ayshriv.springbootrestproj13producerapplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishing-api")
public class WishingProducerController {

    @GetMapping("/wish")
    public ResponseEntity<String> wish() {
        return ResponseEntity.ok("Wishing you a very happy new year!");
    }

}
