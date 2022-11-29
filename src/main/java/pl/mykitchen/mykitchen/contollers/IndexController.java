package pl.mykitchen.mykitchen.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mykitchen.mykitchen.services.IngredientService;

@Controller
public class IndexController {

    private IngredientService ingredientService;

    public IndexController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        return "index";
    }
}
