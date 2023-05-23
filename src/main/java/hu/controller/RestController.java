package hu.controller;

import java.util.List;
import java.util.Optional;

import hu.model.Recipe;
import hu.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A REST controller class for handling recipe-related API requests.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1/recipe")
public class RestController {

    private RecipeService recipeService;

    public RestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * Retrieves a recipe by its ID.
     *
     * @param id the ID of the recipe to retrieve
     * @return the ResponseEntity with the recipe if found, or ResponseEntity.notFound() if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Optional<Recipe> optionalRecipe = recipeService.retrieveRecipeById(id);
        return optionalRecipe.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Retrieves all recipes.
     *
     * @return the list of all recipes
     */
    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.retrieveAllRecipe();
    }

    /**
     * Creates a new recipe.
     *
     * @param recipe the recipe to create
     * @return the created recipe
     */
    @PostMapping
    Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    /**
     * Updates a recipe.
     *
     * @param recipeUpdate the updated recipe
     * @return the updated recipe
     */
    @PutMapping("/{id}")
    Recipe updateRecipe(@RequestBody Recipe recipeUpdate) {
        return recipeService.updateRecipe(recipeUpdate);
    }

    /**
     * Deletes a recipe by its ID.
     *
     * @param id the ID of the recipe to delete
     */
    @DeleteMapping("/{id}")
    void deleteRecipeById(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
    }
}
