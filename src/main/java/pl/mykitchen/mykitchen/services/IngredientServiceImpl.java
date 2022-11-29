package pl.mykitchen.mykitchen.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.mykitchen.mykitchen.commands.IngredientCommand;
import pl.mykitchen.mykitchen.converters.IngredientCommandToIngredient;
import pl.mykitchen.mykitchen.converters.IngredientToIngredientCommand;
import pl.mykitchen.mykitchen.domain.Ingredient;
import pl.mykitchen.mykitchen.repositories.IngredientRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImpl(IngredientRepository ingredientRepository,
                                 IngredientToIngredientCommand ingredientToIngredientCommand,
                                 IngredientCommandToIngredient ingredientCommandToIngredient) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
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
    @Transactional
    public IngredientCommand findCommandById(Long l) {
        return ingredientToIngredientCommand.convert(findById(l));
    }

    @Override
    @Transactional
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {
        Ingredient detachedIngredient = ingredientCommandToIngredient.convert(command);

        Ingredient savedRecipe = ingredientRepository.save(detachedIngredient);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return ingredientToIngredientCommand.convert(savedRecipe);
    }

    @Override
    public void deleteById(Long idToDelete) {
        ingredientRepository.deleteById(idToDelete);
    }
    @Override
    public void addIngredient() {

    }
}
