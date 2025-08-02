// Rearranging Fruits - https://leetcode.com/problems/rearranging-fruits/?envType=daily-question&envId=2025-08-02

// You have two fruit baskets containing n fruits each. You are given two 0-indexed integer arrays basket1 and basket2 representing the cost of fruit in each basket. You want to make both baskets equal. To do so, you can use the following operation as many times as you want:
// - Chose two indices i and j, and swap the ith fruit of basket1 with the jth fruit of basket2.
// - The cost of the swap is min(basket1[i],basket2[j]).

// Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.

// Return the minimum cost to make both the baskets equal or -1 if impossible.

// Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
// Output: 1
// Explanation: Swap index 1 of basket1 with index 0 of basket2, which has cost 1. Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both the arrays makes them equal.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aug2__RearrangingFruits {
    public static long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = basket1.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            map.put(basket1[i], map.getOrDefault(basket1[i], 0) + 1);
            map.put(basket2[i], map.getOrDefault(basket2[i], 0) - 1);
            min = Math.min(min, Math.min(basket1[i], basket2[i]));
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            int val = Math.abs(it.getValue());
            if (val % 2 == 1)
                return -1;
            for (int i = 0; i < val / 2; i++)
                list.add(it.getKey());
        }
        Collections.sort(list);
        long ans = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            ans += Math.min(list.get(i), min * 2);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] basket1 = { 4, 2, 2, 2 };
        int[] basket2 = { 1, 4, 1, 2 };
        System.out.println(minCost(basket1, basket2));
        // 1
    }
}
