// Largest Divisible Subset - https://leetcode.com/problems/largest-divisible-subset/description/?envType=daily-question&envId=2025-04-06

// Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
// answer[i] % answer[j] == 0, or answer[j] % answer[i] == 0

// If there are multiple solutions, return any of them.

// Input: nums = [1,2,3]
// Output: [1,2]
// Explanation: [1,3] is also accepted.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class April6__LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxLen = 0;
        int lastIdx = 0;
        for (int idx = 0; idx < n; idx++) {
            dp[idx] = 1;
            hash[idx] = idx;
            for (int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if (nums[idx] % nums[prevIdx] == 0 && 1 + dp[prevIdx] > dp[idx]) {
                    dp[idx] = 1 + dp[prevIdx];
                    hash[idx] = prevIdx;
                }
            }
            if (dp[idx] > maxLen) {
                maxLen = dp[idx];
                lastIdx = idx;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[lastIdx]);
        while (hash[lastIdx] != lastIdx) {
            lastIdx = hash[lastIdx];
            ans.add(nums[lastIdx]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(largestDivisibleSubset(nums));
        // [2, 1]
    }
}