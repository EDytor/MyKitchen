package pl.mykitchen.mykitchen.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mykitchen.mykitchen.domain.ShoppingList;
import pl.mykitchen.mykitchen.domain.ShoppingListItem;
import pl.mykitchen.mykitchen.repositories.ShoppingListRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    ShoppingListRepository shoppingListRepository;

    ShoppingListServiceImpl(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public Set<ShoppingList> getLists() {
        Set<ShoppingList> shoppingLists = new HashSet<>();
        shoppingListRepository.findAll().iterator().forEachRemaining(shoppingLists::add);
        return shoppingLists;
    }

    @Override
    public Set<ShoppingListItem> getItems(ShoppingList shoppingList) {
        Set<ShoppingListItem> items = new HashSet<>();
        shoppingListRepository.findById(shoppingList.getId()).get().getItems().iterator().forEachRemaining(items::add);
        return items;
    }

    @Override
    public ShoppingList findById(Long id) {
        Optional<ShoppingList> itemOptional = shoppingListRepository.findById(id);
        if (itemOptional.isEmpty()) {
            throw new RuntimeException("Item not found!");
        }
        return itemOptional.get();
    }

    @Override
    public ShoppingList addShoppingList(ShoppingList shoppingList) {
        shoppingListRepository.save(shoppingList);
        return shoppingList;
    }

    @Override
    public ShoppingList deleteShoppingList(Long id) {
        Optional<ShoppingList> itemOptional = shoppingListRepository.findById(id);
        if (itemOptional.isEmpty()) {
            throw new RuntimeException("Item not found!");
        } else {
            shoppingListRepository.deleteById(id);
        }
        return itemOptional.get();
    }
}
