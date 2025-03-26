// Minimum Operations to Make a Uni-Value Grid - https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/?envType=daily-question&envId=2025-03-26

// You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.

// A uni-value grid is a grid where all the elements of it are equal.

// Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.

// Input: grid = [[2,4],[6,8]], x = 2
// Output: 4
// Explanation: We can make every element equal to 4 by doing the following: 
// - Add x to 2 once.
// - Subtract x from 6 once.
// - Subtract x from 8 twice.
// A total of 4 operations were used.

import java.util.ArrayList;
import java.util.Collections;

public class March26__MinimumOperationsToMakeUniValueGrid {
    public static int minOperations(int[][] grid, int x) {
        ArrayList<Integer> nums = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums.add(grid[i][j]);
            }
        }
        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);
        int ans = 0;
        for (int num : nums) {
            if (num % x != median % x) {
                return -1;
            }
            ans += Math.abs(num - median) / x;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 4 }, { 6, 8 } };
        int x = 2;
        System.out.println(minOperations(grid, x));
        // 4
    }
}
