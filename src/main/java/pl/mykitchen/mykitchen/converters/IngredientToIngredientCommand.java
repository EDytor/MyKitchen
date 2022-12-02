package pl.mykitchen.mykitchen.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.mykitchen.mykitchen.commands.IngredientCommand;
import pl.mykitchen.mykitchen.domain.Ingredient;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    public IngredientToIngredientCommand() {
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        IngredientCommand command = new IngredientCommand();
        command.setId(source.getId());
        command.setDescription(source.getDescription());

        return command;
    }
}
