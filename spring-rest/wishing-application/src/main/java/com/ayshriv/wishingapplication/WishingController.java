package com.ayshriv.wishingapplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/wishing-api")
public class WishingController {

    @GetMapping("/wish")
    public ResponseEntity<String> getWish() {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        String msg=null;
        if (hour < 12) {
            msg="Good Morning...";
        } else if (hour <16) {
            msg="Good Afternoon...";
        } else if (hour<20) {
            msg="Good Evening...";
        }
        else{
            msg="Good Night";
        }
        return ResponseEntity.ok(msg);
    }
}
