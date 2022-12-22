package pl.mykitchen.mykitchen.domain;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    Recipe recipe;

    @Before
    public void setUp() {
        recipe = new Recipe();
    }

    @Test
    void setIngredients() {
    }

    @Test
    void getId() {
        // Given
        Long id = 2L;
        // When
        recipe.setId(id);
        // Then
        Assertions.assertEquals(id, recipe.getId());
    }

    @Test
    void setId() {
        // Given
        Long id = 2L;
        // When
        recipe.setId(3L);
        recipe.setId(id);
        // Then
        Assertions.assertEquals(id, recipe.getId());
    }

    @Test
    void getPreparation() {
        // Given
        String preparation = "Add two spoons of sugar";
        // When
        recipe.setPreparation(preparation);
        // Then
        Assertions.assertEquals("Add two spoons of sugar", recipe.getPreparation());
    }

    @Test
    void setPreparation() {
        // Given
        String preparation = "Add two spoons of sugar";
        // When
        recipe.setPreparation(preparation);
        recipe.setPreparation("Add three spoons of sugar");
        // Then
        Assertions.assertEquals("Add three spoons of sugar", recipe.getPreparation());
    }

    @Test
    void getDescription() {
        // Given
        String description = "Pancakes with honey";
        // When
        recipe.setDescription(description);
        // Then
        Assertions.assertEquals("Pancakes with honey", recipe.getDescription());
    }

    @Test
    void setDescription() {
        // Given
        String description = "Pancakes with honey";
        // When
        recipe.setDescription(description);
        recipe.setDescription("Pancakes with blueberries");
        // Then
        Assertions.assertEquals("Pancakes with blueberries", recipe.getDescription());
    }

    @Test
    void getPrepTime() {
        // Given
        Integer prepTime = 5;
        // When
        recipe.setPrepTime(prepTime);
        // Then
        Assertions.assertEquals(5, recipe.getPrepTime());
    }

    @Test
    void setPrepTime() {
        // Given
        Integer prepTime = 5;
        // When
        recipe.setPrepTime(prepTime);
        recipe.setPrepTime(10);
        // Then
        Assertions.assertEquals(10, recipe.getPrepTime());
    }

    @Test
    void getCookTime() {
        // Given
        Integer cookTime = 5;
        // When
        recipe.setCookTime(cookTime);
        recipe.setCookTime(10);
        // Then
        Assertions.assertEquals(10, recipe.getCookTime());
    }

    @Test
    void setCookTime() {
        // Given
        Integer cookTime = 5;
        // When
        recipe.setCookTime(cookTime);
        recipe.setCookTime(10);
        // Then
        Assertions.assertEquals(10, recipe.getCookTime());
    }

    @Test
    void getServings() {
        // Given
        Integer servings = 2;
        // When
        recipe.setServings(servings);
        // Then
        Assertions.assertEquals(2, recipe.getServings());
    }

    @Test
    void setServings() {
        // Given
        Integer servings = 2;
        // When
        recipe.setServings(servings);
        recipe.setServings(3);
        // Then
        Assertions.assertEquals(3, recipe.getServings());
    }

    @Test
    void getIngredients() {

    }

    @Test
    void getDifficulty() {
        // Given
        // When
        recipe.setDifficulty(Difficulty.ŁATWE);
        // Then
        Assertions.assertEquals(Difficulty.ŁATWE, recipe.getDifficulty());
    }

    @Test
    void setDifficulty() {
        // Given
        // When
        recipe.setDifficulty(Difficulty.ŁATWE);
        recipe.setDifficulty(Difficulty.TRUDNE);
        // Then
        Assertions.assertEquals(Difficulty.TRUDNE, recipe.getDifficulty());
    }

    @Test
    void getCategories() {
        // Given
        // When
        // Then
    }
}