package pl.mykitchen.mykitchen.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.mykitchen.mykitchen.commands.IngredientCommand;
import pl.mykitchen.mykitchen.domain.Ingredient;
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    public IngredientCommandToIngredient() {}

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setDescription(source.getDescription());

        return ingredient;
    }
}
