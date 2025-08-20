// Count Square Submatrices with All Ones - https://leetcode.com/problems/count-square-submatrices-with-all-ones/?envType=daily-question&envId=2025-08-20

// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

// Input: matrix =
// [
//   [0,1,1,1],
//   [1,1,1,1],
//   [0,1,1,1]
// ]
// Output: 15
// Explanation: 
// There are 10 squares of side 1.
// There are 4 squares of side 2.
// There is  1 square of side 3.
// Total number of squares = 10 + 4 + 1 = 15.

import java.util.Arrays;

public class Aug20__CountSquareSubmatricesWithAllOnes {
    // -- Tabulation --
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int top = prev[j];
                    int left = j - 1 < 0 ? 0 : cur[j - 1];
                    int diagonal = j - 1 < 0 ? 0 : prev[j - 1];
                    cur[j] = 1 + Math.min(top, Math.min(left, diagonal));
                    ans += cur[j];
                }
            }
            prev = cur;
        }
        return ans;
    }

    // -- Memoization --
    // public static int countSquares(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     int[][] dp = new int[m][n];
    //     for (int i = 0; i < m; i++)
    //         Arrays.fill(dp[i], -1);
    //     int ans = 0;
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             ans += helper(i, j, matrix, dp);
    //         }
    //     }
    //     return ans;
    // }

    // private static int helper(int i, int j, int[][] matrix, int[][] dp) {
    //     if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 0)
    //         return 0;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int right = helper(i, j + 1, matrix, dp);
    //     int bottom = helper(i + 1, j, matrix, dp);
    //     int diagonal = helper(i + 1, j + 1, matrix, dp);
    //     return dp[i][j] = 1 + Math.min(right, Math.min(bottom, diagonal));
    // }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };
        System.out.println(countSquares(matrix));
        // 15
    }
}
