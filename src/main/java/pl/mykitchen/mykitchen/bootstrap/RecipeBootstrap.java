package pl.mykitchen.mykitchen.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import pl.mykitchen.mykitchen.domain.Difficulty;
import pl.mykitchen.mykitchen.domain.Ingredient;
import pl.mykitchen.mykitchen.domain.Recipe;
import pl.mykitchen.mykitchen.repositories.IngredientRepository;
import pl.mykitchen.mykitchen.repositories.RecipeRepository;

public class RecipeBootstrap  implements ApplicationListener<ContextRefreshedEvent> {

    RecipeRepository recipeRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Recipe recipe1 = new Recipe();
        recipe1.setDescription("Pierniczki");
        recipe1.setPreparation("Mąkę przesiać na stolnicę, wlać rozpuszczony gorący miód i wymieszać (najlepiej nożem).\n" +
                "Ciągle siekając, dodawać kolejno cukier, sodę, kakao i przyprawy, a następnie masło i jedno jajko.\n" +
                "Dolewać stopniowo (po 1 łyżce) podgrzanego mleka i łączyć składniki ciasta w jednolitą, miękką kulę\n" +
                "(dolewamy tyle mleka aby ciasto łatwo się wyrabiało i było plastyczne, można nie wykorzystać całego mleka albo dodać troszkę więcej).\n" +
                "Następnie wyrabiać ręką przez około 10 minut.\n" +
                "Na posypanej mąką stolnicy rozwałkować ciasto na placek o grubości ok. 1/2 cm. Foremkami wykrajać pierniczki. Układać na blasze wyłożonej papierem do pieczenia w odstępach około 2 cm od siebie.\n" +
                "Wierzch posmarować roztrzepanym jajkiem (niekoniecznie jeśli pierniczki będziemy dekorować) i piec w piekarniku nagrzanym do 180 stopni (góra i dół bez termoobiegu) przez ok. 10 minut.\n" +
                "WSKAZÓWKI\n" +
                "Grubość pierników i czas pieczenia wpływa na to czy pierniki będą po upieczeniu bardziej miękkie czy twarde.\n" +
                " Zazwyczaj jednak twardnieją po upieczeniu, co jest zjawiskiem naturalnym.\n" +
                "Pierniki po leżakowaniu np. w puszce czy pojemniku odpowiednio dojrzewają i miękną. Można je dekorować w dowolnym czasie (po upieczeniu czy po leżakowaniu).\n" +
                "Z tego przepisu można też otrzymać cienkie i chrupiące pierniki, w zależności od naszych potrzeb.\n" +
                "Ciasto możemy zagnieść z wyprzedzeniem i przechowywać w lodówce.");
        recipe1.setPrepTime(20);
        recipe1.setCookTime(10);
        recipe1.setServings(30);
        recipe1.setDifficulty(Difficulty.ŁATWE);

        recipeRepository.save(recipe1);
    }
    }