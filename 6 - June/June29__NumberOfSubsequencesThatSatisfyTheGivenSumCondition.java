// Number of Subsequences That Satisfy the Given Sum Condition - https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/?envType=daily-question&envId=2025-06-29

// You are given an array of integers nums and an integer target.

// Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

// Input: nums = [3,5,6,7], target = 9
// Output: 4
// Explanation: There are 4 subsequences that satisfy the condition.
// [3] -> Min value + max value <= target (3 + 3 <= 9)
// [3,5] -> (3 + 5 <= 9)
// [3,5,6] -> (3 + 6 <= 9)
// [3,6] -> (3 + 6 <= 9)

import java.util.Arrays;

public class June29__NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int mod = (int) 1e9 + 7;
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++)
            power[i] = (power[i - 1] * 2) % mod;
        int ans = 0;
        while (l <= r) {
            int min = nums[l];
            int max = nums[r];
            if (min + max <= target) {
                ans = (ans + power[r - l]) % mod;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 6, 7 };
        int target = 9;
        System.out.println(numSubseq(nums, target));
        // 4
    }
}
