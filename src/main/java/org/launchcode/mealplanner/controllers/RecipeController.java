package org.launchcode.mealplanner.controllers;

import org.launchcode.mealplanner.models.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
@RequestMapping("recipe")
public class RecipeController {
    static ArrayList<Recipe> recipes = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("recipes", recipes);
        model.addAttribute("description", recipes);
        model.addAttribute("ingredients",recipes);
        model.addAttribute("title","My Recipes");
        return "recipe/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddRecipeForm(Model model) {
        model.addAttribute("title","Add Recipe");
        return "recipe/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddRecipeForm(@RequestParam String recipeName,
                                       @RequestParam String recipeDescription,
                                       @RequestParam String recipeIngredients) {

        Recipe recipe = new Recipe(recipeName, recipeDescription, recipeIngredients);
        recipes.add(recipe);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveRecipeForm(Model model) {
        model.addAttribute("recipes", recipes);
        model.addAttribute("description", recipes);
        model.addAttribute("ingredients", recipes);
        model.addAttribute("title", "Remove Cheese");
        return "recipe/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveRecipeForm(@RequestParam int[] recipeIds) {

        for (int j : recipeIds) {
            recipes.remove(j);
        }

        return "redirect:";
    }
}
