package pl.mykitchen.mykitchen.services;


import pl.mykitchen.mykitchen.domain.Ingredient;

import java.util.Set;

public interface IngredientService {
    Set<Ingredient> getIngredients();
    Ingredient findById(Long id);
    Ingredient deleteById(Long id);
    Ingredient addIngredient(Ingredient ingredient);
    void updateIngredient(Long id, Ingredient ingredient);
}
