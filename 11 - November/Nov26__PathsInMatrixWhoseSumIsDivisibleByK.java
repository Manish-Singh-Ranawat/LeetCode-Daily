// Paths in Matrix Whose Sum Is Divisible by K - https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/description/?envType=daily-question&envId=2025-11-26

// You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0) and you want to reach position (m - 1, n - 1) moving only down or right.

// Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be very large, return it modulo 109 + 7.

// Input: grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
// Output: 2
// Explanation: There are two paths where the sum of the elements on the path is divisible by k.
// The first path highlighted in red has a sum of 5 + 2 + 4 + 5 + 2 = 18 which is divisible by 3.
// The second path highlighted in blue has a sum of 5 + 3 + 0 + 5 + 2 = 15 which is divisible by 3.

public class Nov26__PathsInMatrixWhoseSumIsDivisibleByK {
    private static int MOD = (int) 1e9 + 7;
    private static int m;
    private static int n;

    // -- Tabulation --
    public static int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][k];
        for (int r = 0; r < k; r++)
            dp[m - 1][n - 1][r] = (r + grid[m - 1][n - 1]) % k == 0 ? 1 : 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int r = 0; r < k; r++) {
                    if (i == m - 1 && j == n - 1)
                        continue;
                    int newRem = (r + grid[i][j]) % k;
                    int down = dp[i + 1][j][newRem];
                    int right = dp[i][j + 1][newRem];
                    dp[i][j][r] = (down + right) % MOD;
                }
            }
        }
        return dp[0][0][0];
    }

    // -- Memoization --
    // public static int numberOfPaths(int[][] grid, int k) {
    //     m = grid.length;
    //     n = grid[0].length;
    //     int[][][] dp = new int[m][n][k];
    //     for (int i = 0; i < m; i++)
    //         for (int j = 0; j < n; j++)
    //             for (int r = 0; r < k; r++)
    //                 dp[i][j][r] = -1;
    //     return helper(0, 0, 0, k, grid, dp);
    // }

    // private static int helper(int i, int j, int rem, int k, int[][] grid, int[][][] dp) {
    //     if (i >= m || j >= n)
    //         return 0;
    //     int newRem = (rem + grid[i][j]) % k;
    //     if (i == m - 1 && j == n - 1)
    //         return newRem == 0 ? 1 : 0;
    //     if (dp[i][j][newRem] != -1)
    //         return dp[i][j][newRem];
    //     int down = helper(i + 1, j, newRem, k, grid, dp);
    //     int right = helper(i, j + 1, newRem, k, grid, dp);
    //     return dp[i][j][newRem] = (down + right) % MOD;
    // }

    public static void main(String[] args) {
        int k = 3;
        int[][] grid = { { 5, 2, 4 }, { 3, 0, 5 }, { 0, 7, 2 } };
        System.out.println(numberOfPaths(grid, k));
        // 2
    }
}
