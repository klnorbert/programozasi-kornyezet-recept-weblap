package hu.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import hu.model.Recipe;
import hu.repository.Repository;

/**
 * Map-based in-memory implementation of the {@link Repository} interface.
 */
@org.springframework.stereotype.Repository
public class InMemoryRecipeRepository implements Repository<Recipe, Long> {

    private static final Map<Long, Recipe> STORAGE = new HashMap<>();

    /**
     * Saves a recipe in the repository.
     *
     * @param recipe the recipe to be saved
     * @return the saved recipe
     */
    @Override
    public Recipe save(Recipe recipe) {
        Long id = STORAGE.size() + 1L;
        recipe.setId(id);
        STORAGE.put(id, recipe);
        return STORAGE.get(id);
    }

    /**
     * Retrieves a recipe by its ID from the repository.
     *
     * @param id the ID of the recipe
     * @return an optional containing the retrieved recipe, or an empty optional if not found
     */
    @Override
    public Optional<Recipe> getById(Long id) {
        return Optional.ofNullable(STORAGE.get(id));
    }

    /**
     * Retrieves all recipes from the repository.
     *
     * @return a list of all recipes
     */
    @Override
    public List<Recipe> getAll() {
        return STORAGE.values().stream().toList();
    }

    /**
     * Updates a recipe in the repository.
     *
     * @param recipe the updated recipe
     * @return the updated recipe
     */
    @Override
    public Recipe update(Recipe recipe) {
        Long id = recipe.getId();
        STORAGE.put(id, recipe);
        return STORAGE.get(id);
    }

    /**
     * Deletes a recipe by its ID from the repository.
     *
     * @param id the ID of the recipe to be deleted
     */
    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }
}
