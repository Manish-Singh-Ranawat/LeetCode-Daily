// Fruit Into Baskets - https://leetcode.com/problems/fruit-into-baskets/description/?envType=daily-question&envId=2025-08-04

// You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

// You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
// - You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
// - Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
// - Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

// Given the integer array fruits, return the maximum number of fruits you can pick.

// Input: fruits = [1,2,3,2,2]
// Output: 4
// Explanation: We can pick from trees [2,3,2,2].
// If we had started at the first tree, we would only pick from trees [1,2].

import java.util.HashMap;

public class Aug4__FruitIntoBaskets {
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int ans = 0;
        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2) {
                if (map.get(fruits[l]) == 1)
                    map.remove(fruits[l]);
                else
                    map.put(fruits[l], map.get(fruits[l]) - 1);
                l++;
            } else {
                ans = Math.max(ans, r - l + 1);
            }
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] fruits = { 1, 2, 3, 2, 2 };
        System.out.println(totalFruit(fruits));
        // 4
    }
}
