package com.example.microservice1.controller;

import com.example.shared.ingredients.OrderInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interaction")
public class OrderVerificationController {

    @PostMapping("/verify-order")
    public OrderInfo verifyOrder(@RequestBody String orderId) {
        return new OrderInfo("Notebook", 1);
    }
}
