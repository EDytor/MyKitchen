package pl.mykitchen.mykitchen.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mykitchen.mykitchen.domain.Ingredient;
import pl.mykitchen.mykitchen.domain.ShoppingListItem;
import pl.mykitchen.mykitchen.repositories.ShoppingListItemRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@Service
public class ShoppingListItemServiceImpl implements ShoppingListItemService {

    ShoppingListItemRepository shoppingListItemRepository;

    ShoppingListItemServiceImpl(ShoppingListItemRepository shoppingListItemRepository) {
        this.shoppingListItemRepository = shoppingListItemRepository;
    }

    @Override
    public Ingredient getIngredient(ShoppingListItem shoppingListItem) {
        Optional<ShoppingListItem> itemOptional = shoppingListItemRepository.findById(shoppingListItem.getId());
        if (itemOptional.isEmpty()) {
            throw new RuntimeException("Item not found!");
        }
        return itemOptional.get().getIngredient();
    }

    @Override
    public ShoppingListItem findById(Long id) {
        Optional<ShoppingListItem> itemOptional = shoppingListItemRepository.findById(id);
        if (itemOptional.isEmpty()) {
            throw new RuntimeException("Item not found!");
        }
        return itemOptional.get();
    }

    @Override
    public ShoppingListItem addItem(ShoppingListItem shoppingListItem) {
        shoppingListItemRepository.save(shoppingListItem);
        return shoppingListItem;
    }

    @Override
    public ShoppingListItem deleteById(Long idToDelete) {
        Optional<ShoppingListItem> itemOptional = shoppingListItemRepository.findById(idToDelete);
        if (itemOptional.isEmpty()) {
            throw new RuntimeException("Item not found!");
        } else {
            shoppingListItemRepository.deleteById(idToDelete);
        }
        return itemOptional.get();
    }

    @Override
    public void updateItem(Long id, ShoppingListItem shoppingListItem) {
        if (shoppingListItemRepository.findById(id).isPresent()) {
            shoppingListItemRepository.findById(id).get().setIngredient(shoppingListItem.getIngredient());
            shoppingListItemRepository.findById(id).get().setAmount(shoppingListItem.getAmount());
        } else {
            throw new RuntimeException("Item not found!");
        }
    }

    @Override
    public BigDecimal getAmount(ShoppingListItem shoppingListItem) {
        if (shoppingListItemRepository.findById(shoppingListItem.getId()).isPresent()) {
            return shoppingListItemRepository.findById(shoppingListItem.getId()).get().getAmount();
        } else {
            throw new RuntimeException("Item not found!");
        }
    }
}
