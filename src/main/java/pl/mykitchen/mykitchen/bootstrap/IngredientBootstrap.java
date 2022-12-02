package pl.mykitchen.mykitchen.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.mykitchen.mykitchen.domain.Ingredient;
import pl.mykitchen.mykitchen.repositories.IngredientRepository;


import java.util.ArrayList;
import java.util.List;

@Component
public class IngredientBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    IngredientRepository ingredientRepository;

    public IngredientBootstrap(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ingredientRepository.saveAll(getIngredients());
    }

    private List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>(5);
        Ingredient milk = new Ingredient();
        milk.setDescription("milk");
        ingredients.add(milk);

        Ingredient bread = new Ingredient();
        bread.setDescription("bread");
        ingredients.add(bread);

        Ingredient honey = new Ingredient();
        honey.setDescription("honey");
        ingredients.add(honey);

        Ingredient salt = new Ingredient();
        salt.setDescription("salt");
        ingredients.add(salt);

        Ingredient pepper = new Ingredient();
        pepper.setDescription("pepper");
        ingredients.add(pepper);

        return ingredients;
    }
}
