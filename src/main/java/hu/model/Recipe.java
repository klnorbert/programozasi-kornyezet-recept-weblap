package hu.model;

import java.util.Objects;

/**
 * A class representing a recipe.
 */
public class Recipe {
    private Long id;
    private RECIPETYPE recipeType;
    private String title;
    private String ingredient;
    private String description;

    /**
     * Constructs an empty Recipe object.
     */
    public Recipe() {
    }

    /**
     * Constructs a Recipe object with the specified attributes.
     *
     * @param id          the ID of the recipe
     * @param recipeType  the type of the recipe
     * @param title       the title of the recipe
     * @param ingredient  the ingredient of the recipe
     * @param description the description of the recipe
     */
    public Recipe(Long id, RECIPETYPE recipeType, String title, String ingredient, String description) {
        this.id = id;
        this.recipeType = recipeType;
        this.title = title;
        this.ingredient = ingredient;
        this.description = description;
    }

    /**
     * Returns the ID of the recipe.
     *
     * @return the ID of the recipe
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the recipe.
     *
     * @param id the ID of the recipe
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the title of the recipe.
     *
     * @return the title of the recipe
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the recipe.
     *
     * @param title the title of the recipe
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the ingredient of the recipe.
     *
     * @return the ingredient of the recipe
     */
    public String getIngredient() {
        return ingredient;
    }

    /**
     * Sets the ingredient of the recipe.
     *
     * @param ingredient the ingredient of the recipe
     */
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * Returns the description of the recipe.
     *
     * @return the description of the recipe
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the recipe.
     *
     * @param description the description of the recipe
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the recipe type.
     *
     * @return the recipe type
     */
    public RECIPETYPE getRecipeType() {
        return recipeType;
    }

    /**
     * Sets the recipe type.
     *
     * @param recipeType the recipe type
     */
    public void setRecipeType(RECIPETYPE recipeType) {
        this.recipeType = recipeType;
    }

    /**
     * Checks if the recipe is equal to another object.
     *
     * @param o the object to compare to
     * @return true if the recipe is equal to the other object, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Recipe recipe)) {
            return false;
        }
        return Objects.equals(id, recipe.id) && recipeType == recipe.recipeType && Objects.equals(title, recipe.title)
                && Objects.equals(ingredient, recipe.ingredient) && Objects.equals(description, recipe.description);
    }

    /**
     * Returns the hash code of the recipe.
     *
     * @return the hash code of the recipe
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, recipeType, title, ingredient, description);
    }

    /**
     * Returns a string representation of the recipe.
     *
     * @return a string representation of the recipe
     */
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeType=" + recipeType +
                ", title='" + title + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
