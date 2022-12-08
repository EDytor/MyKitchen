package pl.mykitchen.mykitchen.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mykitchen.mykitchen.domain.Ingredient;
import pl.mykitchen.mykitchen.repositories.IngredientRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Set<Ingredient> getIngredients() {
        log.debug("I'm in the service");
        Set<Ingredient> ingredientSet = new HashSet<>();
        ingredientRepository.findAll().iterator().forEachRemaining(ingredientSet::add);
        return ingredientSet;
    }

    @Override
    public Ingredient findById(Long l) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(l);

        if (ingredientOptional.isEmpty()) {
            throw new RuntimeException("Ingredient Not Found!");
        }

        return ingredientOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        ingredientRepository.deleteById(idToDelete);
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }
}
