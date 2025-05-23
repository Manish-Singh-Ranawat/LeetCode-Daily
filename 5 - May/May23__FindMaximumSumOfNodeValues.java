// Find the Maximum Sum of Node Values - https://leetcode.com/problems/find-the-maximum-sum-of-node-values/description/?envType=daily-question&envId=2025-05-23

// There exists an undirected tree with n nodes numbered 0 to n - 1. You are given a 0-indexed 2D integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the tree. You are also given a positive integer k, and a 0-indexed array of non-negative integers nums of length n, where nums[i] represents the value of the node numbered i.

// Alice wants the sum of values of tree nodes to be maximum, for which Alice can perform the following operation any number of times (including zero) on the tree:
// - Choose any edge [u, v] connecting the nodes u and v, and update their values as follows:
// nums[u] = nums[u] XOR k
// nums[v] = nums[v] XOR k

// Return the maximum possible sum of the values Alice can achieve by performing the operation any number of times.

// Input: nums = [1,2,1], k = 3, edges = [[0,1],[0,2]]
// Output: 6
// Explanation: Alice can achieve the maximum sum of 6 using a single operation:
// - Choose the edge [0,2]. nums[0] and nums[2] become: 1 XOR 3 = 2, and the array nums becomes: [1,2,1] -> [2,2,2].
// The total sum of values is 2 + 2 + 2 = 6.
// It can be shown that 6 is the maximum achievable sum of values.

public class May23__FindMaximumSumOfNodeValues {
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];
        dp[n][1] = 0;
        dp[n][0] = Integer.MIN_VALUE;
        for (int index = n - 1; index >= 0; index--) {
            for (int isEven = 0; isEven <= 1; isEven++) {
                long performOperation = dp[index + 1][isEven ^ 1] + (nums[index] ^ k);
                long dontPerformOperation = dp[index + 1][isEven] + nums[index];
                dp[index][isEven] = Math.max(performOperation, dontPerformOperation);
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        int k = 3;
        int[][] edges = { { 0, 1 }, { 0, 2 } };
        System.out.println(maximumValueSum(nums, k, edges));
        // 6
    }
}
