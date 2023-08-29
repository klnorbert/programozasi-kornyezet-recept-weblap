package hu.repository.impl;

import hu.model.Recipe;
import hu.model.RECIPETYPE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InMemoryRecipeRepositoryTest {

    private InMemoryRecipeRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryRecipeRepository();
    }
    @Test
    @Order(6)
    void save_ShouldSaveSongWithGeneratedId() {
        // Given
        Recipe recipe = new Recipe(1L, RECIPETYPE.DESZSZERT, "Recipe 1", "Ingredients 1", "Description 1");

        // When
        Recipe savedRecipe = repository.save(recipe);

        // Then
        assertEquals(recipe, savedRecipe);
        assertNotNull(savedRecipe.getId());
    }

    @Test
    @Order(5)
    public void getById_NonExistingId_ShouldReturnEmptyOptional() {
        // Given
        Long nonExistingId = 999L;

        // When
        Optional<Recipe> result = repository.getById(nonExistingId);

        // Then
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    @Order(4)
    void update_ShouldUpdateSong() {
        // Given
        Recipe recipe = new Recipe(1L, RECIPETYPE.DESZSZERT, "Recipe 1", "Ingredients 1", "Description 1");
        repository.save(recipe);

        // Update song data
        recipe.setTitle("Updated Recipe");
        recipe.setIngredient("Updated Ingredients");
        recipe.setDescription("Updated Description");

        // When
        Recipe updatedRecipe = repository.update(recipe);

        // Then
        assertEquals(recipe, updatedRecipe);
    }

    @Test
    @Order(3)
    void deleteById_ShouldDeleteSong() {
        // Given
        Long id = 1L;
        Recipe recipe = new Recipe(id, RECIPETYPE.DESZSZERT, "Recipe 1", "Ingredients 1", "Description 1");
        repository.save(recipe);

        // When
        repository.deleteById(id);
        Optional<Recipe> optionalRecipe = repository.getById(id);

        // Then
        assertFalse(optionalRecipe.isPresent());
    }
    @Test
    @Order(2)
    void getById_ExistingId_ShouldReturnOptionalSong() {
        repository = new InMemoryRecipeRepository();
        // Given
        Long id = 3L;
        Recipe recipe = new Recipe(id, RECIPETYPE.DESZSZERT, "Recipe 1", "Ingredients 1", "Description 1");
        repository.save(recipe);

        // When
        Optional<Recipe> optionalRecipe = repository.getById(id);

        // Then
        assertTrue(optionalRecipe.isPresent());
        assertEquals(recipe, optionalRecipe.get());
    }
    @Test
    @Order(1)
    void getAll_ShouldReturnAllSongs() {
        // Given
        Recipe recipe1 = new Recipe(1L, RECIPETYPE.DESZSZERT, "Recipe 1", "Ingredients 1", "Description 1");
        Recipe recipe2 = new Recipe(2L, RECIPETYPE.FOETEL, "Recipe 2", "Ingredients 2", "Description 2");
        repository.save(recipe1);
        repository.save(recipe2);
        List<Recipe> expectedRecipes = Arrays.asList(recipe1, recipe2);

        // When
        List<Recipe> actualRecipes = repository.getAll();

        // Then
        assertEquals(expectedRecipes, actualRecipes);
    }
}
