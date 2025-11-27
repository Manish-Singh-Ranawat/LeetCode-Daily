// Maximum Subarray Sum With Length Divisible by K - https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/description/?envType=daily-question&envId=2025-11-27

// You are given an array of integers nums and an integer k.

// Return the maximum sum of a subarray of nums, such that the size of the subarray is divisible by k.

// Input: nums = [1,2], k = 1
// Output: 3
// Explanation: The subarray [1, 2] with sum 3 has length equal to 2 which is divisible by 1.

public class Nov27__MaximumSubarraySumWithLengthDivisibleByK {
    public static long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefixSum = 0;
        long maxSum = Long.MIN_VALUE;
        long[] kSum = new long[k];
        for (int i = 0; i < k; i++)
            kSum[i] = Long.MAX_VALUE / 2;
        kSum[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum - kSum[i % k]);
            kSum[i % k] = Math.min(kSum[i % k], prefixSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int k = 1;
        int[] nums = { 1, 2 };
        System.out.println(maxSubarraySum(nums, k));
        // 3
    }
}
