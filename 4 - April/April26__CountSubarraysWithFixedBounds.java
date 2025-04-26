// Count Subarrays With Fixed Bounds - https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/?envType=daily-question&envId=2025-04-26

// You are given an integer array nums and two integers minK and maxK.

// A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
// - The minimum value in the subarray is equal to minK.
// - The maximum value in the subarray is equal to maxK.

// Return the number of fixed-bound subarrays.

// A subarray is a contiguous part of an array.

// Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
// Output: 2
// Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].

public class April26__CountSubarraysWithFixedBounds {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minIdx = -1;
        int maxIdx = -1;
        int startIdx = -1;
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK)
                startIdx = i;
            if (nums[i] == maxK)
                maxIdx = i;
            if (nums[i] == minK)
                minIdx = i;
            count += Math.max(0,Math.min(minIdx, maxIdx) - startIdx);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 2, 7, 5 };
        int minK = 1;
        int maxK = 5;
        System.out.println(countSubarrays(nums, minK, maxK));
        // 2
    }
}
