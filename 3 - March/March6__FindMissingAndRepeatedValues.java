// Find Missing and Repeated Values - https://leetcode.com/problems/find-missing-and-repeated-values/description/?envType=daily-question&envId=2025-03-06

// You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

// Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

// Input: grid = [[1,3],[2,2]]
// Output: [2,4]
// Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].

import java.util.Arrays;

public class March6__FindMissingAndRepeatedValues {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = n * n;
        long perfectSum = (N * (N + 1)) / 2;
        long perfectSqrSum = (N * (N + 1) * (2 * N + 1)) / 6;
        long sum = 0;
        long sqrSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
                sqrSum += (long) (grid[i][j] * grid[i][j]);
            }
        }
        long eq1 = sum - perfectSum;
        long eq2 = sqrSum - perfectSqrSum;
        eq2 = eq2 / eq1;
        int repeated = (int) (eq2 + eq1) / 2;
        int missing = (int) eq2 - repeated;
        return new int[] { repeated, missing };
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3 }, { 2, 2 } };
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
        // [2, 4]
    }
}
