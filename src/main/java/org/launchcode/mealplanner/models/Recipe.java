package org.launchcode.mealplanner.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Recipe {

    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @Size(min = 1, message = "Description must not be empty")
    private String description;

    @NotNull
    @Size(min = 1, message = "Ingredients must not be empty")
    private String ingredients;

    private int recipeId;
    private static int nextId = 1;

    public Recipe(String name, String description, String ingredients) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    public Recipe() {
        recipeId = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}
