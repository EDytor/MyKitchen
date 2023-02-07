package pl.mykitchen.mykitchen.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mykitchen.mykitchen.domain.Recipe;
import pl.mykitchen.mykitchen.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{
    RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (recipeOptional.isEmpty()) {
            throw new RuntimeException("Recipe not found!");
        }

        return recipeOptional.get();
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return recipe;
    }

    @Override
    public Recipe deleteById(Long id) {
        Recipe recipe = findById(id);
        recipeRepository.deleteById(id);
        return recipe;
    }
    @Override
    public void updateRecipe(Long id, Recipe recipe){
        Optional<Recipe> editRecipe = recipeRepository.findById(id);

        if (editRecipe.isEmpty()) {
            throw new RuntimeException("Recipe not found!");
        } else {
            editRecipe.get().setDescription(recipe.getDescription());
            editRecipe.get().setDifficulty(recipe.getDifficulty());
            editRecipe.get().setCookTime(recipe.getCookTime());
            editRecipe.get().setPrepTime(recipe.getPrepTime());
            editRecipe.get().setPreparation(recipe.getPreparation());
            editRecipe.get().setServings(recipe.getServings());
            editRecipe.get().setIngredients(recipe.getIngredients());
            editRecipe.get().setCategories(recipe.getCategories());
            recipeRepository.save(editRecipe.get());
        }
    }
}
