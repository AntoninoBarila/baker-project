package com.example.microservice3.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interaction")
public class EmailController {

    @PostMapping("/send-confirmation")
    public String sendEmail(@RequestParam String orderId) {
        return "Email inviata per ordine: " + orderId;
    }
}
