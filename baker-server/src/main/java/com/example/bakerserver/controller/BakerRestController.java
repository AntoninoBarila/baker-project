package com.example.bakerserver.controller;

import com.example.shared.events.OrderReceivedEvent;
import com.ing.baker.runtime.javadsl.Baker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/baker")
public class BakerRestController {

    private static final Logger log = LoggerFactory.getLogger(BakerRestController.class);

    @Autowired
    private Baker baker;

    @PostMapping("/trigger")
    public ResponseEntity<String> triggerRecipe(@RequestBody OrderReceivedEvent event) {
        String recipeInstanceId = UUID.randomUUID().toString();
        try {
            baker.bake(recipeInstanceId);
            log.info("🍳 Istanza avviata: {}", recipeInstanceId);
            baker.fireEvent(recipeInstanceId, event);
            log.info("📩 Evento ricevuto per {}: {}", recipeInstanceId, event);
            return ResponseEntity.ok("Recipe started with ID: " + recipeInstanceId);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
