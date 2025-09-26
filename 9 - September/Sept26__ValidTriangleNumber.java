// Valid Triangle Number - https://leetcode.com/problems/valid-triangle-number/?envType=daily-question&envId=2025-09-26

// Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

// Input: nums = [2,2,3,4]
// Output: 3
// Explanation: Valid combinations are: 
// 2,3,4 (using the first 2)
// 2,3,4 (using the second 2)
// 2,2,3

import java.util.Arrays;

public class Sept26__ValidTriangleNumber {
    public static int triangleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for (int k = n - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    ans += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 4 };
        System.out.println(triangleNumber(nums));
        // 3
    }
}
