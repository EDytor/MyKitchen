package pl.mykitchen.mykitchen.services;

import pl.mykitchen.mykitchen.domain.Ingredient;

import java.util.Set;

public interface IngredientService {
    Set<Ingredient> getIngredients();
    Ingredient findById(Long l);
//    RecipeCommand findCommandById(Long l);
//
//    RecipeCommand saveIngredientCommand(IngredientCommand command);
    void deleteById(Long idToDelete);
    void addIngredient();
}
