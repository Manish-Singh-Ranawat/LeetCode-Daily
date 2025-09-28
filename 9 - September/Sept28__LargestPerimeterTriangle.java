// Largest Perimeter Triangle - https://leetcode.com/problems/largest-perimeter-triangle/description/?envType=daily-question&envId=2025-09-28

// Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

// Input: nums = [2,1,2]
// Output: 5
// Explanation: You can form a triangle with three side lengths: 1, 2, and 2.

import java.util.Arrays;

public class Sept28__LargestPerimeterTriangle {
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i])
                return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 2 };
        System.out.println(largestPerimeter(nums));
        // 5
    }
}
