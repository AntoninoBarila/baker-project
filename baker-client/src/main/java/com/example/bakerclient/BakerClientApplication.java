package com.example.bakerclient;

import com.example.shared.events.OrderReceivedEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@SpringBootApplication
public class BakerClientApplication implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(BakerClientApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String recipeInstanceId = UUID.randomUUID().toString();
        String bakerUrl = "http://localhost:8080/baker/instances/" + recipeInstanceId + "/events";

        OrderReceivedEvent event = new OrderReceivedEvent("ORD-001", "Cliente Test");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrderReceivedEvent> request = new HttpEntity<>(event, headers);

        restTemplate.postForObject(bakerUrl, request, String.class);
        System.out.println("Evento inviato a Baker con recipeId: " + recipeInstanceId);
    }
}
