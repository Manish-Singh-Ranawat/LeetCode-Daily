// Find Subsequence of Length K With the Largest Sum - https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/?envType=daily-question&envId=2025-06-28

// You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

// Return any such subsequence as an integer array of length k.

// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

// Input: nums = [2,1,3,3], k = 2
// Output: [3,3]
// Explanation:
// The subsequence has the largest sum of 3 + 3 = 6.

import java.util.Arrays;

public class June28__FindSubsequenceOfLengthKWithTheLargestSum {
    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] vals = new int[n][2];
        for (int i = 0; i < n; i++) {
            vals[i][0] = i;
            vals[i][1] = nums[i];
        }
        Arrays.sort(vals, (a, b) -> Integer.compare(b[1], a[1]));
        Arrays.sort(vals, 0, k, (a, b) -> Integer.compare(a[0], b[0]));
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = vals[i][1];
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 3, 3 };
        int k = 2;
        System.out.println(Arrays.toString(maxSubsequence(nums, k)));
        // [3,3]
    }
}
