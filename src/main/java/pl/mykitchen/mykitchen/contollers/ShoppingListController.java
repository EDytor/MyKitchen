package pl.mykitchen.mykitchen.contollers;


import org.springframework.web.bind.annotation.*;
import pl.mykitchen.mykitchen.domain.Recipe;
import pl.mykitchen.mykitchen.domain.ShoppingList;
import pl.mykitchen.mykitchen.services.RecipeServiceImpl;
import pl.mykitchen.mykitchen.services.ShoppingListServiceImpl;

import java.util.Set;

@RestController
public class ShoppingListController {
    private final ShoppingListServiceImpl shoppingListService;

    public ShoppingListController(ShoppingListServiceImpl shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("/getLists")
    public Set<ShoppingList> getLists() {
        return shoppingListService.getLists();
    }

    @PostMapping("/newRecipeForm")
    public ShoppingList addShoppingList(ShoppingList shoppingList) {
        return shoppingListService.addShoppingList(shoppingList);
    }

    @DeleteMapping("/{id}")
    public ShoppingList deleteShoppingList(@PathVariable("id") String id) {
        return shoppingListService.deleteShoppingList(Long.valueOf(id));
    }

}
