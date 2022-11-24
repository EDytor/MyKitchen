package pl.mykitchen.mykitchen.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mykitchen.mykitchen.repositories.IngredientRepository;

@Controller
public class IngredientController {
    private IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @RequestMapping({"/ingredient", "/ingredients", "/showIngredients"})
    public String getIndexPage() {
        return "ingredients";
    }
}
