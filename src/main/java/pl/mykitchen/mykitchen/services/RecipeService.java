package pl.mykitchen.mykitchen.services;

import pl.mykitchen.mykitchen.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    Recipe addRecipe(Recipe recipe);

    Recipe deleteById(Long idToDelete);

    void updateRecipe(Long id, Recipe recipe);

}
