package pl.mykitchen.mykitchen.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.mykitchen.mykitchen.domain.Ingredient;
import pl.mykitchen.mykitchen.repositories.IngredientRepository;


@Component
public class IngredientBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    IngredientRepository ingredientRepository;

    public IngredientBootstrap(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Ingredient milk = new Ingredient();
        milk.setDescription("milk");
        ingredientRepository.save(milk);

        Ingredient bread = new Ingredient();
        bread.setDescription("bread");
        ingredientRepository.save(bread);

        Ingredient honey = new Ingredient();
        honey.setDescription("honey");
        ingredientRepository.save(honey);

    }
}
