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
import pl.mykitchen.mykitchen.domain.Ingredient;
import pl.mykitchen.mykitchen.repositories.IngredientRepository;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IngredientControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    IngredientRepository repository;

    @Test
    @Transactional
    public void shouldReturnIngredients() throws Exception {
        // When
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/ingredients"))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
        // Then
        Ingredient[] ingredients = objectMapper.readValue(result.getResponse().getContentAsString(), Ingredient[].class);
        assertThat(ingredients).isNotNull();
        assertThat(ingredients.length).isEqualTo(3);
    }

    @Test
    @Transactional
    public void shouldAddIngredient() throws Exception {
        // Given
        Ingredient ingredientToAdd = new Ingredient();
        ingredientToAdd.setDescription("bread");

        String ingredientToAddJson = objectMapper.writeValueAsString(ingredientToAdd);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/ingredients")
                .accept(MediaType.APPLICATION_JSON)
                .content(ingredientToAddJson)
                .contentType(MediaType.APPLICATION_JSON);

        // When
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        // Then
        assertEquals(4, repository.count());
    }

    @Test
    @Transactional
    public void shouldDeleteIngredient() throws Exception {
        // Given
        Ingredient ingredientToDelete = new Ingredient();
        ingredientToDelete.setDescription("test");
        ingredientToDelete = repository.save(ingredientToDelete);

        // When
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/ingredients/" + ingredientToDelete.getId())
                .accept(MediaType.APPLICATION_JSON);

        // Then
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        Optional<Ingredient> deletedObject = repository.findById(ingredientToDelete.getId());
        assertFalse(deletedObject.isPresent());
    }

    @Test
    @Transactional
    public void shouldUpdateIngredient() throws Exception {
        // Given
        Ingredient ingredientToUpdate = new Ingredient();
        ingredientToUpdate = repository.save(ingredientToUpdate);

        Ingredient updatedIngredient = new Ingredient();
        updatedIngredient.setId(ingredientToUpdate.getId());
        updatedIngredient.setDescription("new description");

        String updatedObjectJson = objectMapper.writeValueAsString(updatedIngredient);
        // When
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/ingredients/" + ingredientToUpdate.getId())
                .accept(MediaType.APPLICATION_JSON)
                .content(updatedObjectJson)
                .contentType(MediaType.APPLICATION_JSON);
        // Then
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        Optional<Ingredient> updatedDbObject = repository.findById(ingredientToUpdate.getId());
        assertTrue(updatedDbObject.isPresent());
        assertEquals("new description", updatedDbObject.get().getDescription());
    }
}