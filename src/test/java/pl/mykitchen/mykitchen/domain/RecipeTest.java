package pl.mykitchen.mykitchen.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecipeTest {
    Recipe recipe;
    Set<Ingredient> newIngredients;

    @Before
    public void setUp() {
        recipe = new Recipe();
    }

    @Test
    public void shouldSetIngredients() {
        // Given
        newIngredients = new HashSet<>();
        Ingredient milk = new Ingredient();
        milk.setDescription("milk");
        Ingredient bread = new Ingredient();
        bread.setDescription("bread");
        // When
        newIngredients.add(milk);
        newIngredients.add(bread);
        // Then
        recipe.setIngredients(newIngredients);
        assertEquals(2, recipe.getIngredients().size());
    }

    @Test
    public void shouldGetId() {
        // Given
        Long id = 2L;
        // When
        recipe.setId(id);
        // Then
        assertEquals(id, recipe.getId());
    }

    @Test
    public void shouldSetId() {
        // Given
        Long id = 2L;
        // When
        recipe.setId(3L);
        recipe.setId(id);
        // Then
        assertEquals(id, recipe.getId());
    }

    @Test
    public void shouldGetPreparation() {
        // Given
        String preparation = "Add two spoons of sugar";
        // When
        recipe.setPreparation(preparation);
        // Then
        assertEquals("Add two spoons of sugar", recipe.getPreparation());
    }

    @Test
    public void shouldSetPreparation() {
        // Given
        String preparation = "Add two spoons of sugar";
        // When
        recipe.setPreparation(preparation);
        recipe.setPreparation("Add three spoons of sugar");
        // Then
        assertEquals("Add three spoons of sugar", recipe.getPreparation());
    }

    @Test
    public void shouldGetDescription() {
        // Given
        String description = "Pancakes with honey";
        // When
        recipe.setDescription(description);
        // Then
        assertEquals("Pancakes with honey", recipe.getDescription());
    }

    @Test
    public void shouldSetDescription() {
        // Given
        String description = "Pancakes with honey";
        // When
        recipe.setDescription(description);
        recipe.setDescription("Pancakes with blueberries");
        // Then
        assertEquals("Pancakes with blueberries", recipe.getDescription());
    }

    @Test
    public void shouldGetPrepTime() {
        // Given
        Integer prepTime = 5;
        // When
        recipe.setPrepTime(prepTime);
        // Then
        Assertions.assertEquals(5, recipe.getPrepTime());
    }

    @Test
    public void shouldSetPrepTime() {
        // Given
        Integer prepTime = 5;
        // When
        recipe.setPrepTime(prepTime);
        recipe.setPrepTime(10);
        // Then
        Assertions.assertEquals(10, recipe.getPrepTime());
    }

    @Test
    public void shouldGetCookTime() {
        // Given
        Integer cookTime = 5;
        // When
        recipe.setCookTime(cookTime);
        recipe.setCookTime(10);
        // Then
        Assertions.assertEquals(10, recipe.getCookTime());
    }

    @Test
    public void shouldSetCookTime() {
        // Given
        Integer cookTime = 5;
        // When
        recipe.setCookTime(cookTime);
        recipe.setCookTime(10);
        // Then
        Assertions.assertEquals(10, recipe.getCookTime());
    }

    @Test
    public void shouldGetServings() {
        // Given
        Integer servings = 2;
        // When
        recipe.setServings(servings);
        // Then
        Assertions.assertEquals(2, recipe.getServings());
    }

    @Test
    public void shouldSetServings() {
        // Given
        Integer servings = 2;
        // When
        recipe.setServings(servings);
        recipe.setServings(3);
        // Then
        Assertions.assertEquals(3, recipe.getServings());
    }

    @Test
    public void shouldGetIngredients() {
        // Given
        Set<Ingredient> testIngredients = new HashSet<>();
        Ingredient milk = new Ingredient();
        milk.setDescription("milk");
        // When
        testIngredients.add(milk);
        recipe.setIngredients(testIngredients);
        // Then
        assertTrue(recipe.getIngredients().contains(milk));

    }

    @Test
    public void shouldGetDifficulty() {
        // Given
        // When
        recipe.setDifficulty(Difficulty.EASY);
        // Then
        assertEquals(Difficulty.EASY, recipe.getDifficulty());
    }

    @Test
    public void shouldSetDifficulty() {
        // Given
        // When
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setDifficulty(Difficulty.HARD);
        // Then
        assertEquals(Difficulty.HARD, recipe.getDifficulty());
    }

    @Test
    public void shouldGetCategories() {
        // Given
        Set<Category> testCategories = new HashSet<>();
        Category dessert = new Category();
        // When
        testCategories.add(dessert);
        recipe.setCategories(testCategories);
        // Then
        assertEquals(1, recipe.getCategories().size());
    }

    @Test
    public void shouldAddIngredient() {
        // Given
        Ingredient ingredient = new Ingredient();
        // When
        recipe.addIngredient(ingredient);
        // Then
        assertTrue(recipe.getIngredients().contains(ingredient));
    }
}