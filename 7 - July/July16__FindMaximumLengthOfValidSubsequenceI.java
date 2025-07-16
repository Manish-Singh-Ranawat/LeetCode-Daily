// Find the Maximum Length of Valid Subsequence I - https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/?envType=daily-question&envId=2025-07-16

// You are given an integer array nums.

// A subsequence sub of nums with length x is called valid if it satisfies:
// - (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.

// Return the length of the longest valid subsequence of nums.

// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

// Input: nums = [1,2,3,4]
// Output: 4
// Explanation: The longest valid subsequence is [1, 2, 3, 4].

public class July16__FindMaximumLengthOfValidSubsequenceI {
    public static int maximumLength(int[] nums) {
        int res = 0;
        int[][] patterns = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
        for (int[] it : patterns) {
            int len = 0;
            for (int num : nums) {
                if (num % 2 == it[len % 2])
                    len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(maximumLength(nums));
        // 4
    }
}
