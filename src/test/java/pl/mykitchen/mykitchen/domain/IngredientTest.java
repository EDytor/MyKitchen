package pl.mykitchen.mykitchen.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient();
    }

    @Test
    public void getId() {
        // Given
        Long id = 2L;
        // When
        ingredient.setId(id);
        // Then
        assertEquals(id, ingredient.getId());
    }

    @Test
    public void setId() {
        // Given
        Long id = 2L;
        // When
        ingredient.setId(3L);
        ingredient.setId(id);
        // Then
        assertEquals(id, ingredient.getId());
    }

    @Test
    public void getDescription() {
        // Given
        String description = "milk";
        // When
        ingredient.setDescription(description);
        // Then
        assertEquals("milk", ingredient.getDescription());
    }

    @Test
    public void setDescription() {
        // Given
        String description = "milk";
        // When
        ingredient.setDescription(description);
        ingredient.setDescription("honey");
        // Then
        assertEquals("honey", ingredient.getDescription());
    }
}