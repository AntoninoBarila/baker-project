package com.example.bakerserver.interactions;

public class VerifyOrder {
    public String apply(String orderId) {
        return "OrderVerified:" + orderId;
    }
}
