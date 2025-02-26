// Maximum Absolute Sum of Any Subarray - https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/description/?envType=daily-question&envId=2025-02-26

// You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

// Return the maximum absolute sum of any (possibly empty) subarray of nums.

// Note that abs(x) is defined as follows:
// If x is a negative integer, then abs(x) = -x.
// If x is a non-negative integer, then abs(x) = x.

// Input: nums = [2,-5,1,-4,3,-2]
// Output: 8
// Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.

public class Feb26__MaximumAbsoluteSumOfAnySubarray {
    public static int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int posSum = 0;
        int negSum = 0;
        int maxSum = 0;
        int minSum = 0;
        for (int i = 0; i < n; i++) {
            posSum = Math.max(posSum + nums[i], nums[i]);
            maxSum = Math.max(posSum, maxSum);
            negSum = Math.min(negSum + nums[i], nums[i]);
            minSum = Math.min(negSum, minSum);
        }
        return Math.max(maxSum, -minSum);
    }

    public static void main(String[] args) {
        int[] nums = { 2, -5, 1, -4, 3, -2 };
        System.out.println(maxAbsoluteSum(nums));
        // 8
    }
}
