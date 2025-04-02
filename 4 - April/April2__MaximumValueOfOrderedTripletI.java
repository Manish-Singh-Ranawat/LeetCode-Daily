// Maximum Value of an Ordered Triplet I - https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/?envType=daily-question&envId=2025-04-02

// You are given a 0-indexed integer array nums.

// Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.

// The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].

// Input: nums = [12,6,1,2,7]
// Output: 77
// Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
// It can be shown that there are no ordered triplets of indices with a value greater than 77. 

public class April2__MaximumValueOfOrderedTripletI {
    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        long maxElement = 0;
        long maxDiff = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, maxDiff * nums[k]);
            maxDiff = Math.max(maxDiff, maxElement - nums[k]);
            maxElement = Math.max(maxElement, nums[k]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 12, 6, 1, 2, 7 };
        System.out.println(maximumTripletValue(nums));
        // 77
    }
}
