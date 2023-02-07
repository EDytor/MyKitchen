package pl.mykitchen.mykitchen.contollers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.mykitchen.mykitchen.domain.Recipe;
import pl.mykitchen.mykitchen.repositories.RecipeRepository;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerIT {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    RecipeRepository repository;

    @Test
    @Transactional
    public void getRecipes() throws Exception {
        // When
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/recipes/get"))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
        // Then
        Recipe[] recipes = objectMapper.readValue(result.getResponse().getContentAsString(), Recipe[].class);
        assertThat(recipes).isNotNull();
        assertThat(recipes.length).isEqualTo(1);
    }

    @Test
    @Transactional
    public void addRecipe() throws Exception {
        // Given
        Recipe recipeToAdd = new Recipe();
        recipeToAdd.setDescription("Pancakes with jam");
        String recipeToAddJson = objectMapper.writeValueAsString(recipeToAdd);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/recipes/newRecipeForm")
                .accept(MediaType.APPLICATION_JSON)
                .content(recipeToAddJson)
                .contentType(MediaType.APPLICATION_JSON);
        // When
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        // Then
        assertEquals(2, repository.count());
    }

    @Test
    @Transactional
    public void deleteRecipe() throws Exception {
        // Given
        Recipe recipeToDelete = new Recipe();
        recipeToDelete.setDescription("Test");
        recipeToDelete = repository.save(recipeToDelete);
        long recipeId = recipeToDelete.getId();
        // When
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/recipes/" + recipeId);
        // Then
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        Optional<Recipe> deletedObject = repository.findById(recipeToDelete.getId());
        assertFalse(deletedObject.isPresent());
    }

    @Test
    @Transactional
    public void updateRecipe() throws Exception {
        // Given
        Recipe recipeToUpdate = new Recipe();
        recipeToUpdate = repository.save(recipeToUpdate);
        Recipe updatedRecipe = new Recipe();
        updatedRecipe.setId(recipeToUpdate.getId());
        updatedRecipe.setDescription("Pancakes with jam");
        String updatedObjectJson = objectMapper.writeValueAsString(updatedRecipe);
        // When
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/recipes/" + recipeToUpdate.getId())
                .accept(MediaType.APPLICATION_JSON)
                .content(updatedObjectJson)
                .contentType(MediaType.APPLICATION_JSON);
        // Then
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        Optional<Recipe> updatedDbObject = repository.findById(recipeToUpdate.getId());
        assertTrue(updatedDbObject.isPresent());
        assertEquals("Pancakes with jam", updatedDbObject.get().getDescription());
    }
}