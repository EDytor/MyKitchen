package pl.mykitchen.mykitchen.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mykitchen.mykitchen.domain.Ingredient;

public interface IngredientRepository extends CrudRepository <Ingredient, Long> {
}
