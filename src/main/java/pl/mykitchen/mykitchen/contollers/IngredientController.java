package pl.mykitchen.mykitchen.contollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import pl.mykitchen.mykitchen.commands.IngredientCommand;
import pl.mykitchen.mykitchen.services.IngredientService;
@Slf4j
@Controller
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping({"/ingredient", "/ingredients", "/showIngredients"})
    public String getIngredients(Model model) {
        model.addAttribute("ingredients",ingredientService.getIngredients());
        return "ingredients";
    }
    @RequestMapping(name = "ingredients")
    public String saveIngredient(@ModelAttribute IngredientCommand command) {
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);
        return "redirect:/ingredients" + savedCommand.getId();
    }
}
