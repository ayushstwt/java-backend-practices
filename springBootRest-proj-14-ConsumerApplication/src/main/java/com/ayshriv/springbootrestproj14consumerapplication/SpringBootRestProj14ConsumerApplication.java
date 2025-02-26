package com.ayshriv.springbootrestproj14consumerapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootRestProj14ConsumerApplication implements CommandLineRunner  {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestProj14ConsumerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/wishing-api/wish";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCodeValue());
    }
}
