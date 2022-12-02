package pl.mykitchen.mykitchen.contollers;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
    @RequestMapping("/addIngredient")
    public String addIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return "redirect:/ingredients";
    }

    @GetMapping()
    @RequestMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable String id) {
        log.debug("Deleting id: " + id);
        ingredientRepository.deleteById(Long.valueOf(id));
        return "redirect:/ingredients";
    }

    @GetMapping("/update/{id}")
    public String getAllEmployees(Model model, @PathVariable("id") Long id, Ingredient ingredient) {
        model.addAttribute("editIngredient", ingredientRepository.findById(id).get());
        return "update-ingredient-form";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@ModelAttribute("editIngredient") Ingredient ingredient, @PathVariable("id") Long ingredientId,
                                 Model model) {
        ingredientRepository.save(ingredient).setId(ingredientId);
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients";
    }
}
