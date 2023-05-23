package hu.service.impl;

import java.util.List;
import java.util.Optional;

import hu.model.Recipe;
import hu.repository.Repository;
import hu.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link RecipeService} interface.
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    private final Repository<Recipe, Long> data;

    /**
     * Constructs a new RecipeServiceImpl with the specified data repository.
     *
     * @param data the data repository for recipes
     */
    @Autowired
    public RecipeServiceImpl(Repository<Recipe, Long> data) {
        this.data = data;
    }

    @Override
    public List<Recipe> retrieveAllRecipe() {
        return data.getAll();
    }

    @Override
    public Optional<Recipe> retrieveRecipeById(Long id) {
        return data.getById(id);
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return data.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return data.update(recipe);
    }

    @Override
    public void deleteRecipeById(Long id) {
        data.deleteById(id);
    }
}
