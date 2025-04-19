package com.example.bakerserver.service;

import com.ing.baker.recipe.javadsl.Recipe;
import com.ing.baker.recipe.javadsl.RecipeCompiler;
import com.ing.baker.runtime.common.RecipeRecord;
import com.ing.baker.runtime.javadsl.Baker;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipeLoader {

    private static final Logger log = LoggerFactory.getLogger(RecipeLoader.class);
    public static String RECIPE_ID;

    @Autowired
    private Baker baker;

    @PostConstruct
    public void loadRecipe() {
        Recipe recipe = new Recipe("OrderProcessingRecipe")
            .withSensoryEvent(com.example.shared.events.OrderReceivedEvent.class)
            .withInteraction(com.example.bakerserver.interactions.VerifyOrder.class)
            .withInteraction(com.example.bakerserver.interactions.ProcessPayment.class)
            .withInteraction(com.example.bakerserver.interactions.SendConfirmation.class);

        RECIPE_ID = baker.addRecipe(RecipeRecord.of(RecipeCompiler.compileRecipe(recipe)));
        log.info("✅ Recipe registrata con ID: {}", RECIPE_ID);
    }
}
