// Find All Possible Recipes from Given Supplies - https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/?envType=daily-question&envId=2025-03-21

// You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.

// You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

// Return a list of all the recipes that you can create. You may return the answer in any order.

// Note that two recipes may contain each other in their ingredients.

// Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
// Output: ["bread","sandwich"]
// Explanation: We can create "bread" since we have the ingredients "yeast" and "flour".
// We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class March21__FindAllPossibleRecipesFromGivenSupplies {
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Boolean> canMake = new HashMap<>();
        for (String supply : supplies)
            canMake.put(supply, true);
        Map<String, Integer> recipeToIdx = new HashMap<>();
        for (int i = 0; i < recipes.length; i++)
            recipeToIdx.put(recipes[i], i);
        List<String> ans = new ArrayList<>();
        for (String recipe : recipes) {
            if (dfs(recipe, ingredients, canMake, recipeToIdx)) {
                ans.add(recipe);
            }
        }
        return ans;
    }

    private static boolean dfs(String recipe, List<List<String>> ingredients,
            Map<String, Boolean> canMake, Map<String, Integer> recipeToIdx) {
        if (canMake.containsKey(recipe)) {
            return canMake.get(recipe);
        }
        if (!recipeToIdx.containsKey(recipe)) {
            return false;
        }
        canMake.put(recipe, false);
        List<String> neededIngredients = ingredients.get(recipeToIdx.get(recipe));
        for (String ingredient : neededIngredients) {
            if (!dfs(ingredient, ingredients, canMake, recipeToIdx))
                return false;
        }
        canMake.put(recipe, true);
        return canMake.get(recipe);
    }

    public static void main(String[] args) {
        String[] recipes = { "bread", "sandwich" };
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(new ArrayList<>(List.of("yeast", "flour")));
        ingredients.add(new ArrayList<>(List.of("bread", "meat")));
        String[] supplies = { "yeast", "flour", "meat" };
        System.out.println(findAllRecipes(recipes, ingredients, supplies));
        // ["bread","sandwich"]
    }
}
