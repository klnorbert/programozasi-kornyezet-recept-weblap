package hu.controller;

import java.util.List;
import java.util.Optional;

import hu.model.Recipe;
import hu.service.RecipeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A controller class for handling recipe-related requests.
 */
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * Retrieves a recipe by its ID and populates the model with the recipe information.
     * If the recipe exists, it returns the "edit" view. Otherwise, it returns the "recipes" view.
     *
     * @param model the model object to populate with data
     * @param id    the ID of the recipe to retrieve
     * @return the view name to render
     */
    @GetMapping("/{id}")
    public String getRecipeById(final Model model, final @PathVariable Long id) {

        Optional<Recipe> optionalRecipe = recipeService.retrieveRecipeById(id);
        return optionalRecipe.map(recipe -> {
            model.addAttribute("recipe", recipe);
            return "edit";
        }).orElseGet(() -> {
            model.addAttribute("requestUri", "recipe/" + id);
            return "recipes";
        });
    }

    /**
     * Retrieves all recipes and populates the model with the recipe list.
     *
     * @param model the model object to populate with data
     * @return the view name to render
     */
    @GetMapping
    public String getAllRecipes(final Model model) {

        final List<Recipe> recipes = recipeService.retrieveAllRecipe();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    /**
     * Updates a recipe and populates the model with the updated recipe.
     *
     * @param model  the model object to populate with data
     * @param recipe the recipe to update
     * @return the view name to render
     */
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateRecipe(Model model, Recipe recipe) {

        Recipe updatedRecipe = recipeService.updateRecipe(recipe);
        model.addAttribute("recipe", updatedRecipe);
        return "edit";
    }

    /**
     * Returns the view for creating a new recipe.
     *
     * @return the view name to render
     */
    @GetMapping("/create")
    public String createRecipe() {
        return "create";
    }

    /**
     * Creates a new recipe and populates the model with the saved recipe.
     *
     * @param model  the model object to populate with data
     * @param recipe the recipe to create
     * @return the view name to render
     */
    @PostMapping("/create")
    public String createRecipe(Model model, Recipe recipe) {

        Recipe savedRecipe = recipeService.createRecipe(recipe);
        model.addAttribute("recipe", savedRecipe);
        return "edit";
    }

    /**
     * Deletes a recipe by its ID and retrieves all recipes to populate the model.
     *
     * @param model the model object to populate with data
     * @param id    the ID of the recipe to delete
     * @return the view name to render
     */
    @GetMapping("/{id}/delete")
    public String deleteRecipe(final Model model, final @PathVariable("id") Long id) {
        recipeService.deleteRecipeById(id);
        List<Recipe> recipes = recipeService.retrieveAllRecipe();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
}
