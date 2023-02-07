package pl.mykitchen.mykitchen.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mykitchen.mykitchen.domain.ShoppingListItem;

public interface ShoppingListItemRepository extends CrudRepository<ShoppingListItem, Long> {
}
