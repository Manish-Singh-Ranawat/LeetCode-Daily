// Zero Array Transformation I - https://leetcode.com/problems/zero-array-transformation-i/description/?envType=daily-question&envId=2025-05-20

// You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].

// For each queries[i]:
// - Select a subset of indices within the range [li, ri] in nums.
// - Decrement the values at the selected indices by 1.

// A Zero Array is an array where all elements are equal to 0.

// Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.

// Input: nums = [1,0,1], queries = [[0,2]]
// Output: true
// Explanation: For i = 0, Select the subset of indices as [0, 2] and decrement the values at these indices by 1.
// The array will become [0, 0, 0], which is a Zero Array.

public class May20__ZeroArrayTransformationI {
    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            diff[q[0]] += 1;
            diff[q[1] + 1] -= 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (nums[i] > sum)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1 };
        int[][] queries = { { 0, 2 } };
        System.out.println(isZeroArray(nums, queries));
        // true
    }
}
