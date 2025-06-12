// Maximum Difference Between Adjacent Elements in a Circular Array - https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/?envType=daily-question&envId=2025-06-12

// Given a circular array nums, find the maximum absolute difference between adjacent elements.

// Note: In a circular array, the first and last elements are adjacent.

// Input: nums = [1,2,4]
// Output: 3
// Explanation: Because nums is circular, nums[0] and nums[2] are adjacent. They have the maximum absolute difference of |4 - 1| = 3.

public class June12__MaximumDifferenceBetweenAdjacentElementsInCircularArray {
    public static int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            max = Math.max(max, Math.abs(nums[(i + 1) % n] - nums[i]));
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4 };
        System.out.println(maxAdjacentDistance(nums));
        // 3
    }
}
