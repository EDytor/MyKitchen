package pl.mykitchen.mykitchen.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import pl.mykitchen.mykitchen.domain.Ingredient;
import pl.mykitchen.mykitchen.repositories.IngredientRepository;

@Slf4j
@Controller
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping()
    public String getIngredients(Model model) {
        model.addAttribute(new Ingredient());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients";
    }

    @PostMapping()
    public String addIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return "redirect:/ingredients";
    }

    @GetMapping()
    @RequestMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable String id) {
        ingredientRepository.deleteById(Long.valueOf(id));
        return "redirect:/ingredients";
    }

    @GetMapping()
    @RequestMapping("/{id}")
    public String viewForm(Model model, @PathVariable Long id) {
        Ingredient ingredient = ingredientRepository.findById(id).get();
        model.addAttribute("ingredient", ingredient);
        return "update-ingredient-form";
    }

    @PostMapping()
    @RequestMapping("/save")
    public String updateIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return "redirect:/ingredients";
    }

}
