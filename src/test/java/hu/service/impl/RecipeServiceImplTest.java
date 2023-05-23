package hu.service.impl;

import hu.model.Recipe;
import hu.model.RECIPETYPE;
import hu.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    @Mock
    private Repository<Recipe, Long> repository;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void retrieveAllRecipe_ShouldReturnAllRecipes() {
        // Given
        Recipe recipe1 = new Recipe(1L, RECIPETYPE.DESZSZERT, "Recipe 1", "Ingredients 1", "Description 1");
        Recipe recipe2 = new Recipe(2L, RECIPETYPE.FOETEL, "Recipe 2", "Ingredients 2", "Description 2");
        List<Recipe> expectedRecipes = Arrays.asList(recipe1, recipe2);
        when(repository.getAll()).thenReturn(expectedRecipes);

        // When
        List<Recipe> actualRecipes = recipeService.retrieveAllRecipe();

        // Then
        assertEquals(expectedRecipes, actualRecipes);
    }

    @Test
    void retrieveRecipeById_ExistingId_ShouldReturnOptionalRecipe() {
        // Given
        Long id = 1L;
        Recipe expectedRecipe = new Recipe(id, RECIPETYPE.DESZSZERT, "Recipe 1", "Ingredients 1", "Description 1");
        when(repository.getById(id)).thenReturn(Optional.of(expectedRecipe));

        // When
        Optional<Recipe> actualRecipe = recipeService.retrieveRecipeById(id);

        // Assert
        assertTrue(actualRecipe.isPresent());
        assertEquals(expectedRecipe, actualRecipe.get());
    }

    @Test
    void retrieveRecipeById_NonExistingId_ShouldReturnEmptyOptional() {
        // Given
        Long id = 1L;
        when(repository.getById(id)).thenReturn(Optional.empty());

        // When
        Optional<Recipe> actualRecipe = recipeService.retrieveRecipeById(id);

        // Then
        assertFalse(actualRecipe.isPresent());
    }

    @Test
    void createRecipe_ShouldSaveRecipe() {
        // Given
        Recipe recipe = new Recipe(null, RECIPETYPE.DESZSZERT, "Recipe", "Ingredients", "Description");
        Recipe savedRecipe = new Recipe(1L, RECIPETYPE.DESZSZERT, "Recipe", "Ingredients", "Description");
        when(repository.save(recipe)).thenReturn(savedRecipe);

        // When
        Recipe actualRecipe = recipeService.createRecipe(recipe);

        // Then
        assertNotNull(actualRecipe.getId());
        assertEquals(savedRecipe, actualRecipe);
    }

    @Test
    void updateRecipe_ShouldUpdateRecipe() {
        // Given
        Recipe recipe = new Recipe(1L, RECIPETYPE.DESZSZERT, "Recipe", "Ingredients", "Description");
        Recipe updatedRecipe = new Recipe(1L, RECIPETYPE.DESZSZERT, "Updated Recipe", "Updated Ingredients", "Updated Description");
        when(repository.update(recipe)).thenReturn(updatedRecipe);

        // When
        Recipe actualRecipe = recipeService.updateRecipe(recipe);

        // Then
        assertEquals(updatedRecipe, actualRecipe);
    }

    @Test
    void deleteRecipeById_ShouldDeleteRecipe() {
        // Given
        Long id = 1L;

        // When
        recipeService.deleteRecipeById(id);

        // Then
        verify(repository, times(1)).deleteById(id);
    }
}
