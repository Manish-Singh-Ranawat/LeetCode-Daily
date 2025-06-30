//  Longest Harmonious Subsequence - https://leetcode.com/problems/longest-harmonious-subsequence/description/?envType=daily-question&envId=2025-06-30

// We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

// Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

// Input: nums = [1,3,2,2,5,2,3,7]
// Output: 5
// Explanation: The longest harmonious subsequence is [3,2,2,2,3]

import java.util.HashMap;

public class June30__LongestHarmoniousSubsequence {
    public static int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num + 1))
                ans = Math.max(ans, map.get(num) + map.get(num + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println(findLHS(nums));
        // 5
    }
}
