package pl.mykitchen.mykitchen.services;

import pl.mykitchen.mykitchen.domain.Ingredient;
import pl.mykitchen.mykitchen.domain.ShoppingListItem;

import java.math.BigDecimal;

public interface ShoppingListItemService {

    Ingredient getIngredient(ShoppingListItem shoppingListItem);

    ShoppingListItem findById(Long id);
    ShoppingListItem addItem(ShoppingListItem shoppingListItem);

    ShoppingListItem deleteById(Long idToDelete);

    void updateItem(Long id, ShoppingListItem shoppingListItem);

    BigDecimal getAmount(ShoppingListItem shoppingListItem);

}
