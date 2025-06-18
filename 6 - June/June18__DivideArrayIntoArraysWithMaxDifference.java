// Divide Array Into Arrays With Max Difference - https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/?envType=daily-question&envId=2025-06-18

// You are given an integer array nums of size n where n is a multiple of 3 and a positive integer k.

// Divide the array nums into n / 3 arrays of size 3 satisfying the following condition:
// - The difference between any two elements in one array is less than or equal to k.

// Return a 2D array containing the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.

// Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
// Output: [[1,1,3],[3,4,5],[7,8,9]]
// Explanation: The difference between any two elements in each array is less than or equal to 2.

import java.util.Arrays;

public class June18__DivideArrayIntoArraysWithMaxDifference {
    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[i / 3] = new int[] { nums[i], nums[i + 1], nums[i + 2] };
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 8, 7, 9, 3, 5, 1 };
        int k = 2;
        int[][] ans = divideArray(nums, k);
        for (int i = 0; i < ans.length; i++)
            System.out.println(Arrays.toString(ans[i]));
        // [[1,1,3],[3,4,5],[7,8,9]]
    }
}
