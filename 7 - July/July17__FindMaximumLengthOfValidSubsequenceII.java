// Find the Maximum Length of Valid Subsequence II - https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/?envType=daily-question&envId=2025-07-17

// You are given an integer array nums and a positive integer k.
// A subsequence sub of nums with length x is called valid if it satisfies:
// - (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k.

// Return the length of the longest valid subsequence of nums.

// Input: nums = [1,2,3,4,5], k = 2
// Output: 5
// Explanation: The longest valid subsequence is [1, 2, 3, 4, 5].

public class July17__FindMaximumLengthOfValidSubsequenceII {
    public static int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 2;
        System.out.println(maximumLength(nums, k));
        // 5
    }
}
