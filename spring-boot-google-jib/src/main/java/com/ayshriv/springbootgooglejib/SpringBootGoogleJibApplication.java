package com.ayshriv.springbootgooglejib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootGoogleJibApplication {

    @GetMapping("/ayshriv")
    public String ayshriv() {
        return "ayshriv";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGoogleJibApplication.class, args);
    }

}
