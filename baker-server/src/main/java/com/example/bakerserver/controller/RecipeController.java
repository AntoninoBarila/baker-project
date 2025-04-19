package com.example.bakerserver.controller;

import com.example.bakerserver.service.RecipeLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baker")
public class RecipeController {

    @GetMapping("/recipe-id")
    public String getRecipeId() {
        return RecipeLoader.RECIPE_ID;
    }
}
