package pl.mykitchen.mykitchen.services;

import pl.mykitchen.mykitchen.commands.IngredientCommand;
import pl.mykitchen.mykitchen.domain.Ingredient;

import java.util.Set;

public interface IngredientService {
    Set<Ingredient> getIngredients();
    Ingredient findById(Long l);
    IngredientCommand findCommandById(Long l);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    void deleteById(Long idToDelete);
    void addIngredient();
}
