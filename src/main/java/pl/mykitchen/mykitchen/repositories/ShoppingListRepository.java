package pl.mykitchen.mykitchen.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mykitchen.mykitchen.domain.ShoppingList;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {
}
