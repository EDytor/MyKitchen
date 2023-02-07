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
        Set<Ingredient> ingredientSet = new HashSet<>();
        ingredientRepository.findAll().iterator().forEachRemaining(ingredientSet::add);
        return ingredientSet;
    }

    @Override
    public Ingredient findById(Long id) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);

        if (ingredientOptional.isEmpty()) {
            throw new RuntimeException("Ingredient not found!");
        }

        return ingredientOptional.get();
    }

    @Override
    public Ingredient deleteById(Long id) {
        Ingredient ingredient = findById(id);
        ingredientRepository.deleteById(id);
        return ingredient;
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return ingredient;
    }
    @Override
    public void updateIngredient(Long id, Ingredient ingredient){
        Optional<Ingredient> editIngredient = ingredientRepository.findById(id);

        if (editIngredient.isEmpty()) {
            throw new RuntimeException("Ingredient not found!");
        } else {
            editIngredient.get().setDescription(ingredient.getDescription());
            ingredientRepository.save(editIngredient.get());
        }
    }
}
