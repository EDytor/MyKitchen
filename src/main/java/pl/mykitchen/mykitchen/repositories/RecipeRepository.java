package pl.mykitchen.mykitchen.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mykitchen.mykitchen.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
