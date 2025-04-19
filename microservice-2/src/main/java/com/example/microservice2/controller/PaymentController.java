package com.example.microservice2.controller;

import com.example.shared.ingredients.OrderInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interaction")
public class PaymentController {

    @PostMapping("/process-payment")
    public String processPayment(@RequestBody OrderInfo order) {
        return "Pagamento completato per " + order.getProduct();
    }
}
