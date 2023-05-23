package hu.service;

import java.util.List;
import java.util.Optional;

import hu.model.Recipe;

/**
 * Service interface for managing recipes.
 */
public interface RecipeService {

    /**
     * Retrieves all recipes.
     *
     * @return the list of recipes
     */
    List<Recipe> retrieveAllRecipe();

    /**
     * Retrieves a recipe by its ID.
     *
     * @param id the ID of the recipe
     * @return an optional containing the recipe, or an empty optional if not found
     */
    Optional<Recipe> retrieveRecipeById(Long id);

    /**
     * Creates a new recipe.
     *
     * @param match the recipe to create
     * @return the created recipe
     */
    Recipe createRecipe(Recipe match);

    /**
     * Updates an existing recipe.
     *
     * @param recipe the recipe to update
     * @return the updated recipe
     */
    Recipe updateRecipe(Recipe recipe);

    /**
     * Deletes a recipe by its ID.
     *
     * @param id the ID of the recipe to delete
     */
    void deleteRecipeById(Long id);

}
