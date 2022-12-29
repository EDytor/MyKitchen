package pl.mykitchen.mykitchen.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.mykitchen.mykitchen.domain.Category;
import pl.mykitchen.mykitchen.domain.Difficulty;
import pl.mykitchen.mykitchen.domain.Recipe;
import pl.mykitchen.mykitchen.repositories.RecipeRepository;

import javax.transaction.Transactional;
import java.util.Set;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    RecipeRepository recipeRepository;
    Set<Category> categories = null;

    public RecipeBootstrap(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Recipe recipe1 = new Recipe();
        recipe1.setDescription("Gingerbread cookies");
        recipe1.setPreparation("""
                Sift the flour onto the pastry board, pour the melted hot honey and mix (preferably with a knife).
                While still chopping, add the sugar, baking soda, cocoa and spices one by one, then the butter and one egg.
                Slowly pour in the heated milk (1 tablespoon at a time) and combine the dough ingredients into a uniform, soft ball
                (Add enough milk to make the dough easy to knead and plastic, you can not use all the milk or add a little more).
                Then knead by hand for about 10 minutes.
                On a floured board, roll out the dough into a cake, about 1/2 cm thick. Cut out the gingerbread with cookie cutters.
                Place on a baking tray lined with baking paper, spaced about 2 cm apart.
                Smear the top with a beaten egg (not necessarily if we are going to decorate gingerbread cookies) and bake in an oven preheated to 180 degrees
                (top and bottom without convection) for about 10 minutes.
                TIPS
                The thickness of the gingerbread and the baking time affect whether the gingerbread will be softer or firmer after baking.
                 However, they usually harden after baking, which is a natural phenomenon.
                Gingerbread after aging, e.g. in a can or container, matures and softens accordingly. They can be decorated at any time (after baking or after aging).
                This recipe can also be used to make thin and crispy gingerbread, depending on your needs.
                The dough can be kneaded in advance and stored in the fridge.""");
        recipe1.setPrepTime(20);
        recipe1.setCookTime(10);
        recipe1.setServings(30);
        recipe1.setDifficulty(Difficulty.MEDIUM);
        recipe1.setCategories(categories);
        recipeRepository.save(recipe1);
    }
}