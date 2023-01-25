package pl.mykitchen.mykitchen.services;

import pl.mykitchen.mykitchen.domain.ShoppingList;
import pl.mykitchen.mykitchen.domain.ShoppingListItem;


import java.util.Set;

public interface ShoppingListService {

    Set<ShoppingList> getLists();

    ShoppingList addShoppingList(ShoppingList shoppingList);

    ShoppingList deleteShoppingList(Long id);

    Set<ShoppingListItem> getItems(ShoppingList shoppingList);

    ShoppingList findById(Long id);
}
