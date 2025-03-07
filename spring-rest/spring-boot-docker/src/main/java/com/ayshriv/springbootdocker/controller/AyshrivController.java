package com.ayshriv.springbootdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AyshrivController {
    @GetMapping("/ayshriv")
    public String home() {
        return "AYSHRIV";
    }
}
