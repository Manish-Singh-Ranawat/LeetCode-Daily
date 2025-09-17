// Design a Food Rating System - https://leetcode.com/problems/design-a-food-rating-system/description/?envType=daily-question&envId=2025-09-17

// Design a food rating system that can do the following:
// - Modify the rating of a food item listed in the system.
// - Return the highest-rated food item for a type of cuisine in the system.

// Implement the FoodRatings class:
// - FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
//  -- foods[i] is the name of the ith food,
//  -- cuisines[i] is the type of cuisine of the ith food, and
//  -- ratings[i] is the initial rating of the ith food.
// - void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
// - String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.

// Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.

// Input :
// ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
// [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]

// Output :  [null, "kimchi", "ramen", null, "sushi", null, "ramen"]

// Explanation : 
// FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
// foodRatings.highestRated("korean"); // return "kimchi"
//                                     // "kimchi" is the highest rated korean food with a rating of 9.
// foodRatings.highestRated("japanese"); // return "ramen"
//                                       // "ramen" is the highest rated japanese food with a rating of 14.
// foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
// foodRatings.highestRated("japanese"); // return "sushi"
//                                       // "sushi" is the highest rated japanese food with a rating of 16.
// foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
// foodRatings.highestRated("japanese"); // return "ramen"
//                                       // Both "sushi" and "ramen" have a rating of 16.
//                                       // However, "ramen" is lexicographically smaller than "sushi".

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class FoodRatings {
    private Map<String, String> foodToCuisine = new HashMap<>();
    private Map<String, Integer> foodToRating = new HashMap<>();
    private Map<String, TreeSet<String>> cuisineFoods = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
            String cuisine = cuisines[i];
            cuisineFoods.putIfAbsent(cuisine, new TreeSet<>((a, b) -> {
                int r1 = foodToRating.get(a);
                int r2 = foodToRating.get(b);
                if (r1 != r2) return r2 - r1; 
                return a.compareTo(b);
            }));
            cuisineFoods.get(cuisine).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> set = cuisineFoods.get(cuisine);
        set.remove(food);
        foodToRating.put(food, newRating);
        set.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first();
    }
}

public class Sept17__DesignFoodRatingSystem {
    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        System.out.println(foodRatings.highestRated("korean"));   // kimchi
        System.out.println(foodRatings.highestRated("japanese")); // ramen
        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese")); // sushi
        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese")); // ramen
    }
}
