package com.example.bakerserver.interactions;

public class ProcessPayment {
    public String apply(String orderInfo) {
        return "PaymentDoneFor:" + orderInfo;
    }
}
