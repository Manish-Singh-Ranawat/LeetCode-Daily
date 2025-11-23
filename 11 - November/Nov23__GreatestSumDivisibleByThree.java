// Greatest Sum Divisible by Three - https://leetcode.com/problems/greatest-sum-divisible-by-three/description/?envType=daily-question&envId=2025-11-23

// Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.

// Input: nums = [3,6,5,1,8]
// Output: 18
// Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).

public class Nov23__GreatestSumDivisibleByThree {
    public static int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[] dp = { 0, Integer.MIN_VALUE, Integer.MIN_VALUE };
        for (int i = n - 1; i >= 0; i--) {
            int[] cur = new int[3];
            for (int r = 0; r < 3; r++) {
                int newRem = (r + nums[i]) % 3;
                int take = dp[newRem] == Integer.MIN_VALUE ? Integer.MIN_VALUE : nums[i] + dp[newRem];
                int skip = dp[r];
                cur[r] = Math.max(take, skip);
            }
            dp = cur;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 6, 5, 1, 8 };
        System.out.println(maxSumDivThree(nums));
        // 18
    }
}