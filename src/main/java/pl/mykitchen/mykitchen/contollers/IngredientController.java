package pl.mykitchen.mykitchen.contollers;

import org.springframework.web.bind.annotation.*;
import pl.mykitchen.mykitchen.domain.Ingredient;
import pl.mykitchen.mykitchen.services.IngredientServiceImpl;

import java.util.Set;
@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientServiceImpl ingredientService;

    public IngredientController(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping()
    public Set<Ingredient> getIngredients() {
        return ingredientService.getIngredients();
    }

    @PostMapping()
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @DeleteMapping("/{id}")
    public Ingredient deleteIngredient(@PathVariable("id") String id) {
        return ingredientService.deleteById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable("id") Long id, @RequestBody Ingredient ingredient) {
        ingredientService.updateIngredient(id, ingredient);
        return ingredient;
    }
}
