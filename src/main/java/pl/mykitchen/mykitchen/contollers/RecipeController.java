package pl.mykitchen.mykitchen.contollers;

import org.springframework.web.bind.annotation.*;
import pl.mykitchen.mykitchen.domain.Recipe;
import pl.mykitchen.mykitchen.services.RecipeServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeServiceImpl recipeService;

    public RecipeController(RecipeServiceImpl recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping("/get")
    public Set<Recipe> getRecipes() {
        return recipeService.getRecipes();
    }

    @PostMapping("/newRecipeForm")
    public Recipe addRecipe(Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @DeleteMapping("/{id}")
    public Recipe deleteRecipe(@PathVariable("id") String id) {
        return recipeService.deleteById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable("id") Long id, @RequestBody Recipe recipe) {
        recipeService.updateRecipe(id, recipe);
        return recipe;
    }
}
