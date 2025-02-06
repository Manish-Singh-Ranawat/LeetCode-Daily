// Tuple with Same Product - https://leetcode.com/problems/tuple-with-same-product/description/?envType=daily-question&envId=2025-02-06

// Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.

// Input: nums = [2,3,4,6]
// Output: 8
// Explanation: There are 8 valid tuples:
// (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
// (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)

import java.util.HashMap;

public class Feb6__TupleWithSameProduct {
    public static int tupleSameProduct(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                ans += 8 * map.getOrDefault(product, 0);
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 6 };
        System.out.println(tupleSameProduct(nums));
        // 8
    }
}
